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
	
	//LamNH23
	@Query(value = "SELECT tt.theaterName, r.roomName, s.startTime, m.movieName, m.startDate, m.endDate, SUM(o.totalPrice) FROM TICKET_INFO t JOIN ORDERS o ON o.orderId = t.orderId JOIN SHOWTIME s ON s.showtimeId = t.showtimeId JOIN ROOM r ON r.roomId = s.roomId JOIN THEATER tt ON tt.theaterId = r.theaterId JOIN MOVIE m ON m.movieId = s.movieId GROUP BY tt.theaterName, r.roomName, s.startTime,m.movieName, m.startDate, m.endDate ORDER BY tt.theaterName, r.roomName, s.startTime OFFSET :start ROWS FETCH FIRST :recordsPerPage ROWS ONLY", nativeQuery = true)
	List<Tuple> getRecordsForCurrentPage(@Param("start") int start, @Param("recordsPerPage") int recordsPerPage);

	//LamNH23
	@Query(value = "SELECT tt.theaterName, r.roomName, s.startTime, m.movieName, m.startDate, m.endDate, SUM(o.totalPrice) FROM TICKET_INFO t JOIN ORDERS o ON o.orderId = t.orderId JOIN SHOWTIME s ON s.showtimeId = t.showtimeId JOIN ROOM r ON r.roomId = s.roomId JOIN THEATER tt ON tt.theaterId = r.theaterId JOIN MOVIE m ON m.movieId = s.movieId GROUP BY tt.theaterName, r.roomName, s.startTime,m.movieName, m.startDate, m.endDate ORDER BY tt.theaterName, r.roomName, s.startTime", nativeQuery = true)
	List<Tuple> getNumberShowtime();
	
	//LamNH23
	@Query(value = "SELECT m.movieName, m.startDate, m.endDate, m.posterUrl, SUM(o.totalPrice) FROM TICKET_INFO t JOIN ORDERS o ON o.orderId = t.orderId JOIN SHOWTIME s ON s.showtimeId = t.showtimeId JOIN MOVIE m ON m.movieId = s.movieId GROUP BY m.movieName, m.startDate, m.endDate, m.posterUrl ORDER BY m.movieName OFFSET :start ROWS FETCH FIRST :recordsPerPage ROWS ONLY", nativeQuery = true)
	List<Tuple> getRecordsForCurrentPage2(@Param("start") int start, @Param("recordsPerPage") int recordsPerPage);

	//LamNH23
	@Query(value = "SELECT m.movieName, m.startDate, m.endDate, m.posterUrl, SUM(o.totalPrice) FROM TICKET_INFO t JOIN ORDERS o ON o.orderId = t.orderId JOIN SHOWTIME s ON s.showtimeId = t.showtimeId JOIN MOVIE m ON m.movieId = s.movieId GROUP BY m.movieName, m.startDate, m.endDate, m.posterUrl ORDER BY m.movieName", nativeQuery = true)
	List<Tuple> getNumberMovie();
	
	//LamNH23
	@Query(value = "SELECT m.movieName, m.startDate, m.endDate, m.posterUrl, SUM(o.totalPrice) FROM TICKET_INFO t JOIN ORDERS o ON o.orderId = t.orderId JOIN SHOWTIME s ON s.showtimeId = t.showtimeId JOIN MOVIE m ON m.movieId = s.movieId where m.movieName like :searchName GROUP BY m.movieName, m.startDate, m.endDate, m.posterUrl ORDER BY m.movieName OFFSET :start ROWS FETCH FIRST :recordsPerPage ROWS ONLY", nativeQuery = true)
	List<Tuple> getRecordsForCurrentPage2ForName(@Param("searchName") String searchName, @Param("start") int start, @Param("recordsPerPage") int recordsPerPage);

	//LamNH23
	@Query(value = "SELECT m.movieName, m.startDate, m.endDate, m.posterUrl, SUM(o.totalPrice) FROM TICKET_INFO t JOIN ORDERS o ON o.orderId = t.orderId JOIN SHOWTIME s ON s.showtimeId = t.showtimeId JOIN MOVIE m ON m.movieId = s.movieId where m.movieName like :searchName GROUP BY m.movieName, m.startDate, m.endDate, m.posterUrl ORDER BY m.movieName", nativeQuery = true)
	List<Tuple> getNumberMovieForName(@Param("searchName") String searchName);
	
	//LamNH23
	@Query(value = "SELECT tt.theaterName, tt.city, tt.address, tt.phone, sum(o.totalPrice) from TICKET_INFO t join ORDERS o on o.orderId = t.orderId join SHOWTIME s on s.showtimeId = t.showtimeId join ROOM r on r.roomId = s.roomId join THEATER tt on tt.theaterId = r.theaterId group by tt.theaterName, tt.city, tt.address, tt.phone order by tt.theaterName", nativeQuery = true)
	List<Tuple> getRecordsForCurrentPage3();


}
