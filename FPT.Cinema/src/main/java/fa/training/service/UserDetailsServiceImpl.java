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
	
	
	/**
	 * Project:FPT-Cinema
	 * Team 1
	 * @author TraNLC 
	 * Ngày sinh: 13/07/1992
	 * Phương thức loadUserByUsername được sử dụng để tìm kiếm người dùng dựa trên tên tài khoản (account).
	 * UserDetails này sẽ được sử dụng bởi Spring Security để xác thực và cấp quyền cho người dùng.
	 */
	@Override
	public UserDetails loadUserByUsername(String account) throws UsernameNotFoundException {
		Users user = userRepository.findByAccount(account);
		System.out.println(userRepository.findByAccount(account));
		if (user == null) {
			throw new UsernameNotFoundException("Could not find user");
		}

		return new org.springframework.security.core.userdetails.User(user.getAccount(), user.getPassword(),
				getAuthorities(user));

	}

	/**
	 * Project:FPT-Cinema
	 * Team 1
	 * @author TraNLC 
	 * Ngày sinh: 13/07/1992
	 * Phương thức getAuthorities được sử dụng để lấy danh sách các GrantedAuthority từ một đối tượng Users.
	 * UserDetails này sẽ được sử dụng bởi Spring Security để xác thực và cấp quyền cho người dùng.
	 * Một GrantedAuthority đại diện cho một quyền hoặc một vai trò (role) của người dùng.
	 */
	private static Collection<? extends GrantedAuthority> getAuthorities(Users users) {
		//Prefix "ROLE_" được thêm vào trước tên vai trò để tạo ra tên của GrantedAuthority.
		String userRole = "ROLE_" + users.getUserRole();
		Collection<GrantedAuthority> authorities = AuthorityUtils.createAuthorityList(userRole);
		return authorities;
	}
}