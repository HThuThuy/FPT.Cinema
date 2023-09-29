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

}
