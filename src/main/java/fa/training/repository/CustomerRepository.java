package fa.training.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.time.LocalDate;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import fa.training.DTO.CustomerDTO;
import fa.training.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, String> {

	 
	/**
	 * Project:FPT-Cinema
	 * Team 1
	 * @author TraNLC 
	 * Phương thức/ Mục đích: Cập nhật mật khẩu của người dùng.
	 */
	@Transactional
	@Modifying
	@Query("UPDATE Users u SET u.password = ?2 WHERE u.account = ?1")
	void updatePass(String account, String password);
	
	/**
	 * Project:FPT-Cinema
	 * Team 1
	 * @author TraNLC 
	 * Phương thức/ Mục đích: Lấy danh sách các đơn đặt vé của một khách hàng trong một khoảng thời gian cụ thể.
	 */
	@Query("SELECT new fa.training.DTO.CustomerDTO(O.orderDate, O.orderId, TI.ticketId, T.theaterName, M.movieName, O.totalPrice, TI.QRCode) " +
		       "FROM TicketInfo TI " +
		       "JOIN TI.showtimeTicket ST " +
		       "JOIN ST.room R " +
		       "JOIN R.theater T " +
		       "JOIN TI.order O " +
		       "JOIN ST.movie M " +
		       "JOIN TI.customer C " +
		       "WHERE C.cccd = :cccd " +
		       "AND O.orderDate BETWEEN :startDate AND :endDate " +
		       "ORDER BY O.orderId")
		Page<CustomerDTO> getRecordsForCurrentPage(@Param("cccd") String cccd, @Param("startDate") LocalDate startDate, 
		        @Param("endDate") LocalDate endDate, Pageable pageable);

	/**
	 * Project:FPT-Cinema
	 * Team 1
	 * @author TraNLC 
	 * Phương thức/ Mục đích: Tìm kiếm khách hàng theo số điện thoại.
	 */
	Customer findByPhone(String phone);

	/**
	 * Project:FPT-Cinema
	 * Team 1
	 * @author TraNLC 
	 * Phương thức/ Mục đích: Tìm kiếm khách hàng theo địa chỉ email.
	 */
	Customer findByEmail(String email);
}
