/**
 * SpringSecurityConfig
 *
 * Version 1.0
 *
 * Date: 09-10-2023
 *
 * Copyright
 * 
 * Modification Logs:
 * DATE                 AUTHOR            DESCRIPTION
 * -----------------------------------------------------------------------
 * 09-10-2023           TraNLC            Config Spring security
 */

package fa.training.config;

import java.util.concurrent.TimeUnit;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;

    /**
     * Cấu hình các quyền truy cập và các chức năng liên quan đến bảo mật như login, logout, remember me.
     * @param http Đối tượng HttpSecurity dùng để cấu hình bảo mật.
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .formLogin().disable()
            .httpBasic().disable()
            //CSRF - Cross-Site Request Forgery là một dạng tấn công bảo mật trong đó kẻ tấn công lợi dụng quyền của người dùng đối với một website. 
            //CSRF cho phép kẻ tấn công thực hiện các yêu cầu từ phía client mà không cần sự đồng ý của người dùng.
            .csrf().disable()
            .authorizeRequests()
                // Cho phép tất cả mọi người truy cập vào "/home", "/", "/ticket/**"
                .antMatchers("/home", "/", "/ticket/**").permitAll()
                // Chỉ người dùng có vai trò "ADMIN" mới được truy cập vào "/admin/**"
                .antMatchers("/home", "/", "/ticket/**").permitAll()
                // Cho phép tất cả mọi người truy cập vào "/home", "/", "/ticket/**"
                .antMatchers("/home", "/", "/ticket/**").permitAll()
                // Chỉ người dùng có vai trò "ADMIN" mới được truy cập vào "/admin/**"
                .antMatchers("/admin/**").hasRole("ADMIN")
                // Người dùng có vai trò "ADMIN" hoặc "USER" đều có thể truy cập vào "/customer/**"
                .antMatchers("/customer/**").hasAnyRole("ADMIN", "USER")
            .and()
            // Xử lý exception liên quan đến quyền truy cập
            .exceptionHandling().accessDeniedPage("/dang-nhap?error=403")
                .authenticationEntryPoint((request, response, authException) -> {
                    // Trả về mã lỗi 401 khi xác thực thất bại
                    response.setStatus(HttpServletResponse.SC_UNAUTHORIZED); 
                })
            .and()
            // Cấu hình form login
            .formLogin()
                .usernameParameter("account")
                .passwordParameter("password")
                .defaultSuccessUrl("/role", true)
            .and()
            // Cấu hình chức năng remember me
            .rememberMe()
                .tokenValiditySeconds((int) TimeUnit.DAYS.toSeconds(21))
                .key("FADN2023")
                .rememberMeParameter("remember-me")
            .and()
            // Cấu hình chức năng logout
            .logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/");
    }

    /**
     * Tạo bean cho PasswordEncoder, sử dụng để mã hóa mật khẩu.
     * @return Đối tượng PasswordEncoder.
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * Tạo bean cho DaoAuthenticationProvider, sử dụng để xác thực thông tin người dùng.
     * @return Đối tượng DaoAuthenticationProvider.
     */
    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
     // Thiết lập UserDetailsService và PasswordEncoder cho DaoAuthenticationProvider
        authProvider.setUserDetailsService(userDetailsService);
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }

    /**
     * Cấu hình AuthenticationManagerBuilder, sử dụng để xây dựng AuthenticationManager.
     * @param auth Đối tượng AuthenticationManagerBuilder.
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
    }

    /**
     * Tạo bean cho AuthenticationManager, sử dụng để quản lý quá trình xác thực người dùng.
     * @return Đối tượng AuthenticationManager.
     */
    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
}