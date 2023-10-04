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
	 * Project:FPT-Cinema
	 * Team 1
	 * @author TraNLC 
	 * Config security
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
<<<<<<< Updated upstream
            	// Cho phép tất cả mọi người truy cập vào "/home", "/", "/ticket/**"
                .antMatchers("/home", "/", "/ticket/**").permitAll()
                // Chỉ người dùng có vai trò "ADMIN" mới được truy cập vào "/admin/**"
=======
<<<<<<< HEAD
                .antMatchers("/home", "/", "/ticket/**").permitAll()
=======
            	// Cho phép tất cả mọi người truy cập vào "/home", "/", "/ticket/**"
                .antMatchers("/home", "/", "/ticket/**").permitAll()
                // Chỉ người dùng có vai trò "ADMIN" mới được truy cập vào "/admin/**"
>>>>>>> 28b0def15ec3512f9fc364f0c0e8ec30536abafe
>>>>>>> Stashed changes
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
	 * Project:FPT-Cinema
	 * Team 1
	 * @author TraNLC 
	 * Tạo bean cho PasswordEncoder
     * Mục đích: PasswordEncoder là một interface cung cấp cơ chế để mã hóa mật khẩu.
     * Trong trường hợp này, chúng ta sử dụng BCryptPasswordEncoder, một implementation của PasswordEncoder.
	 */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
  	 * Project:FPT-Cinema
  	 * Team 1
  	 * @author TraNLC 
  	 * Tạo bean cho DaoAuthenticationProvider:
     * - Mục đích: DaoAuthenticationProvider là một implementation của AuthenticationProvider trong Spring Security.
     * - Nó sử dụng UserDetailsService và PasswordEncoder đã được cấu hình để xác thực thông tin người dùng.
     * - Khi một yêu cầu xác thực đến, DaoAuthenticationProvider sẽ sử dụng UserDetailsService để lấy thông tin về người dùng dựa trên username,
     * - sau đó nó sẽ sử dụng PasswordEncoder để so sánh mật khẩu đã nhập với mật khẩu được mã hóa trong thông tin người dùng.
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
  	 * Project:FPT-Cinema
  	 * Team 1
  	 * @author TraNLC 
  	 * Tạo bean cho AuthenticationManager từ WebSecurityConfigurerAdapter
     * - Mục đích: AuthenticationManagerBuilder được sử dụng để tạo ra một AuthenticationManager.
     * - AuthenticationManager là thành phần quan trọng trong Spring Security, nó xử lý quá trình xác thực người dùng.
  	 */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
    }

    /**
  	 * Project:FPT-Cinema
  	 * Team 1
  	 * @author TraNLC 
  	 * Tạo bean cho AuthenticationManager từ WebSecurityConfigurerAdapter
     * - Mục đích: AuthenticationManager là thành phần quan trọng trong Spring Security, nó xử lý quá trình xác thực người dùng.
     * - Phương thức này trả về một bean AuthenticationManager để nó có thể được tiêm vào bất kỳ đâu trong ứng dụng.
  	 */
    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
}