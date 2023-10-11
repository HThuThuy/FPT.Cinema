package fa.training.repository;

import java.util.List;

import javax.persistence.Tuple;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fa.training.DTO.ShowTimeDTO;
import fa.training.model.TicketInfo;

@Repository
@Transactional
public interface TicketRepository extends JpaRepository<TicketInfo, Integer> {
	
	/**
	 * Project: FPT Cinema Team: 2 Author :LamNH23 Method: Hiện tất cả suất chiếu trong DB kèm doanh thu
	 */
	@Query(value = "SELECT tt.theaterName, r.roomName, s.startTime, m.movieName, m.startDate, m.endDate, SUM(o.totalPrice) FROM TICKET_INFO t JOIN ORDERS o ON o.orderId = t.orderId JOIN SHOWTIME s ON s.showtimeId = t.showtimeId JOIN ROOM r ON r.roomId = s.roomId JOIN THEATER tt ON tt.theaterId = r.theaterId JOIN MOVIE m ON m.movieId = s.movieId GROUP BY tt.theaterName, r.roomName, s.startTime,m.movieName, m.startDate, m.endDate ORDER BY tt.theaterName, r.roomName, s.startTime OFFSET :start ROWS FETCH FIRST :recordsPerPage ROWS ONLY", nativeQuery = true)
	List<Tuple> getRecordsForCurrentPage(@Param("start") int start, @Param("recordsPerPage") int recordsPerPage);

	/**
	 * Project: FPT Cinema Team: 2 Author :LamNH23 Method: Lấy số lượng suất chiếu từ DB
	 */
	@Query(value = "SELECT tt.theaterName, r.roomName, s.startTime, m.movieName, m.startDate, m.endDate, SUM(o.totalPrice) FROM TICKET_INFO t JOIN ORDERS o ON o.orderId = t.orderId JOIN SHOWTIME s ON s.showtimeId = t.showtimeId JOIN ROOM r ON r.roomId = s.roomId JOIN THEATER tt ON tt.theaterId = r.theaterId JOIN MOVIE m ON m.movieId = s.movieId GROUP BY tt.theaterName, r.roomName, s.startTime,m.movieName, m.startDate, m.endDate ORDER BY tt.theaterName, r.roomName, s.startTime", nativeQuery = true)
	List<Tuple> getNumberShowtime();
	
	/**
	 * Project: FPT Cinema Team: 2 Author :LamNH23 Method: Hiện tất cả phim trong DB kèm doanh thu
	 */
	@Query(value = "SELECT m.movieName, m.startDate, m.endDate, m.posterUrl, SUM(o.totalPrice) FROM TICKET_INFO t JOIN ORDERS o ON o.orderId = t.orderId JOIN SHOWTIME s ON s.showtimeId = t.showtimeId JOIN MOVIE m ON m.movieId = s.movieId GROUP BY m.movieName, m.startDate, m.endDate, m.posterUrl ORDER BY m.movieName OFFSET :start ROWS FETCH FIRST :recordsPerPage ROWS ONLY", nativeQuery = true)
	List<Tuple> getRecordsForCurrentPage2(@Param("start") int start, @Param("recordsPerPage") int recordsPerPage);

	/**
	 * Project: FPT Cinema Team: 2 Author :LamNH23 Method: Lấy số lượng phim từ DB
	 */
	@Query(value = "SELECT m.movieName, m.startDate, m.endDate, m.posterUrl, SUM(o.totalPrice) FROM TICKET_INFO t JOIN ORDERS o ON o.orderId = t.orderId JOIN SHOWTIME s ON s.showtimeId = t.showtimeId JOIN MOVIE m ON m.movieId = s.movieId GROUP BY m.movieName, m.startDate, m.endDate, m.posterUrl ORDER BY m.movieName", nativeQuery = true)
	List<Tuple> getNumberMovie();
	
	/**
	 * Project: FPT Cinema Team: 2 Author :LamNH23 Method: Hiện phim trong DB kèm doanh thu theo tên
	 */
	@Query(value = "SELECT m.movieName, m.startDate, m.endDate, m.posterUrl, SUM(o.totalPrice) FROM TICKET_INFO t JOIN ORDERS o ON o.orderId = t.orderId JOIN SHOWTIME s ON s.showtimeId = t.showtimeId JOIN MOVIE m ON m.movieId = s.movieId where m.movieName like :searchName GROUP BY m.movieName, m.startDate, m.endDate, m.posterUrl ORDER BY m.movieName OFFSET :start ROWS FETCH FIRST :recordsPerPage ROWS ONLY", nativeQuery = true)
	List<Tuple> getRecordsForCurrentPage2ForName(@Param("searchName") String searchName, @Param("start") int start, @Param("recordsPerPage") int recordsPerPage);

	/**
	 * Project: FPT Cinema Team: 2 Author :LamNH23 Method: Lấy số lượng phim từ DB theo tên
	 */
	@Query(value = "SELECT m.movieName, m.startDate, m.endDate, m.posterUrl, SUM(o.totalPrice) FROM TICKET_INFO t JOIN ORDERS o ON o.orderId = t.orderId JOIN SHOWTIME s ON s.showtimeId = t.showtimeId JOIN MOVIE m ON m.movieId = s.movieId where m.movieName like :searchName GROUP BY m.movieName, m.startDate, m.endDate, m.posterUrl ORDER BY m.movieName", nativeQuery = true)
	List<Tuple> getNumberMovieForName(@Param("searchName") String searchName);
	
	/**
	 * Project: FPT Cinema Team: 2 Author :LamNH23 Method: Hiện tất cả rạp trong DB kèm doanh thu
	 */
	@Query(value = "SELECT tt.theaterName, tt.city, tt.address, tt.phone, sum(o.totalPrice) from TICKET_INFO t join ORDERS o on o.orderId = t.orderId join SHOWTIME s on s.showtimeId = t.showtimeId join ROOM r on r.roomId = s.roomId join THEATER tt on tt.theaterId = r.theaterId group by tt.theaterName, tt.city, tt.address, tt.phone order by tt.theaterName", nativeQuery = true)
	List<Tuple> getRecordsForCurrentPage3();
	
	/**
	 * Project: FPT Cinema Team: 2 Author :LamNH23 Method: Hiện tất cả rạp trong DB kèm doanh thu theo khoản thời gian
	 */
	@Query(value = "SELECT tt.theaterName, tt.city, tt.address, tt.phone, sum(o.totalPrice) from TICKET_INFO t join ORDERS o on o.orderId = t.orderId join SHOWTIME s on s.showtimeId = t.showtimeId join ROOM r on r.roomId = s.roomId join THEATER tt on tt.theaterId = r.theaterId where o.orderDate > :searchDate and o.orderDate < :searchDate2 group by tt.theaterName, tt.city, tt.address, tt.phone order by tt.theaterName", nativeQuery = true)
	List<Tuple> getRecordsForCurrentPage4(@Param("searchDate") String searchDate, @Param("searchDate2") String searchDate2);


}
