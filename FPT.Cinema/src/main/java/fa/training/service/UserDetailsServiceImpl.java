package fa.training.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import fa.training.model.Users;
import fa.training.repository.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;
    
    @Override
    public UserDetails loadUserByUsername(String account) throws UsernameNotFoundException {
        Users user = userRepository.findByAccount(account);
        if (user == null) {
            throw new UsernameNotFoundException("Could not find user");
        }
        return new org.springframework.security.core.userdetails.User(user.getAccount(), user.getPassword(),
                getAuthorities(user));
    }

    private static Collection<? extends GrantedAuthority> getAuthorities(Users users) {
        //Prefix "ROLE_" được thêm vào trước tên vai trò để tạo ra tên của GrantedAuthority.
        String userRole = "ROLE_" + users.getUserRole();
        Collection<GrantedAuthority> authorities = AuthorityUtils.createAuthorityList(userRole);
        return authorities;
    }
}