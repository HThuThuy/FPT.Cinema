package fa.training.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import fa.training.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, String> {

	
	@Transactional
	@Modifying
	@Query("UPDATE Users u SET u.password = ?2 WHERE u.account = ?1")
	void updatePass(String account, String password);
	
}
