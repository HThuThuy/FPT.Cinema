package fa.training.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import fa.training.model.Users;

public interface UserRepository extends JpaRepository<Users, String> {
	Users findByAccount(String account);

	Users findByAccountAndPassword(String account, String password);

	@Transactional
	@Modifying
	@Query(value = "UPDATE USERS SET password = ?2 WHERE account = ?1", nativeQuery = true)
	void updatePass(String account, String password);

	@Query(value = "SELECT u.* FROM USERS u JOIN CUSTOMER c ON u.cccd = c.cccd WHERE c.email = ?1", nativeQuery = true)
	Users findByEmail(String email);

}