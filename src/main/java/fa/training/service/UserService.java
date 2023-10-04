package fa.training.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import fa.training.model.Users;
import fa.training.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository repo;

	/**
	 * Project: FPT Cinema 
	 * Team: 1 
	 * Author : TraNLC Function/Class/JSP : tìm kiếm tài khoản
	 */
	public List<Users> findAll() {
		return repo.findAll();
	}

	public void saveOrUpdate(Users users) {
		users.setUserRole("ROLE_USER");
		users.setStatus("active");
		repo.save(users);
	}

	/**
	 * Project: FPT Cinema 
	 * Team: 1 
	 * Author : TraNLC Function/Class/JSP : tìm kiếm tài khoản theo cccd
	 */
	public Users findById(String cccd) {
		return repo.findById(cccd).orElseThrow(() -> new IllegalArgumentException("Invalid Customer Id: " + cccd));
	}


	/**
	 * Project: FPT Cinema 
	 * Team: 1 
	 * Author : TraNLC Function/Class/JSP : check tồn tại của tài khoản
	 */
	public boolean existsById(String cccd) {
		return repo.existsById(cccd);
	}

	/**
	 * Project: FPT Cinema 
	 * Team: 1 Author : 
	 * TraNLC Function/Class/JSP : phân trang
	 */
	public Page<Users> findAll(Pageable pageable) {
		return repo.findAll(pageable);
	}

	/**
	 * Project: FPT Cinema 
	 * Team: 1 
	 * Author : TraNLC 
	 * Function/Class/JSP : phân trang
	 * @param password
	 */
	public Users findByAccount(String account) {
		return repo.findByAccount(account);
	}

	public Users findByAccountAndPassword(String account, String password) {
		return repo.findByAccountAndPassword(account, password);
	}

	/**
	 * Project: FPT Cinema 
	 * Team: 1 
	 * Author : TraNLC 
	 * Function/Class/JSP : Insert tài khoản vào DataBase
	 */
	public void save(Users users) {
		repo.save(users);
	}

	/**
	 * Project: FPT Cinema 
	 * Team: 1 
	 * Author : TraNLC 
	 * Function/Class/JSP : Xóa tài khoản theo ID
	 */
	public void deleteById(String cccd) {
		repo.deleteById(cccd);
	}

	/**
	 * Project: FPT Cinema 
	 * Team: 1 
	 * Author : TraNLC 
	 * Function/Class/JSP : Update password
	 */
	public void updatePass(String account, String password) {
		repo.updatePass(account, password);
	}

	/**
	 * Project: FPT Cinema 
	 * Team: 1 
	 * Author : TraNLC 
	 * Function/Class/JSP : tìm kiếm thông tin customer theo cccd
	 */
	public Users findUserByCustomerCccd(String cccd) {
	    return repo.findUserByCustomerCccd(cccd);
	}

	/**
	 * Project: FPT Cinema 
	 * Team: 1 
	 * Author : TraNLC 
	 * Function/Class/JSP : update mật khẩu trong modal resetPassword
	 */
	public void updateUser(String passwordUpdate, String cccd) {
	    repo.updatePassword(passwordUpdate, cccd);
	}




}
