package fa.training.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import fa.training.model.Users;


public interface UserRepository extends JpaRepository<Users, String> {
	
	/**
	 * Project: FPT-Cinema
	 * Team: 1
	 * Author: TraNLC
	 * Phương thức/ Mục đích: Tìm người dùng theo tài khoản.
	 */
	Users findByAccount(String account);

	/**
	 * Project: FPT-Cinema
	 * Team: 1
	 * Author: TraNLC
	 * Phương thức/ Mục đích: Tìm người dùng theo tài khoản và mật khẩu.
	 */
	Users findByAccountAndPassword(String account, String password);
	
	/**
	 * Project: FPT-Cinema
	 * Team: 1
	 * Author: TraNLC
	 * Phương thức/ Mục đích: Cập nhật mật khẩu của người dùng.
	 */
	@Transactional
	@Modifying
	@Query(value = "UPDATE USERS SET password = ?2 WHERE account = ?1", nativeQuery = true)
	void updatePass(String account, String password);
	
	/**
	 * Project: FPT-Cinema
	 * Team: 1
	 * Author: TraNLC
	 * Phương thức/ Mục đích: Tìm người dùng dựa trên số CCCD của khách hàng.
	 */
	@Query(value = "SELECT * FROM Users u WHERE u.cccd = :cccd",  nativeQuery = true)
    Users findUserByCustomerCccd(String cccd);
	
	/**
	 * Project: FPT-Cinema
	 * Team: 1
	 * Author: TraNLC
	 * Phương thức/ Mục đích: Cập nhật mật khẩu của người dùng.
	 */
	@Transactional
	@Modifying
	@Query(value = "UPDATE USERS Set password = :passwordUpdate WHERE cccd = :cccd",  nativeQuery = true)
	void updatePassword(@Param("passwordUpdate") String passwordUpdate, @Param("cccd") String cccd);

}