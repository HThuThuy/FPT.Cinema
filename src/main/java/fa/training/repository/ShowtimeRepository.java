package fa.training.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import fa.training.model.Showtime;

@Repository
public interface ShowtimeRepository extends JpaRepository<Showtime, String> {
	
	String sql1 = "select s.showtimeId, s.roomId, s.startTime, s.movieId from SHOWTIME s join ROOM r on s.roomId = r.roomId join THEATER t  on t.theaterId = r.theaterId order by t.theaterName, r.roomName, s.startTime offset :start ROWS FETCH FIRST :recordsPerPage ROWS ONLY";
	String oldsql = "select * from SHOWTIME order by showtimeId offset :start ROWS FETCH FIRST :recordsPerPage ROWS ONLY;";
	
	@Query(value = sql1, nativeQuery = true)
	List<Showtime> getRecordsForCurrentPage(@Param("start") int start, @Param("recordsPerPage") int recordsPerPage);
	
	@Query(value = "select CONVERT(varchar(5), startTime, 120) from SHOWTIME where roomId like :roomId", nativeQuery = true)
	List<String> getTimeByRoom(@Param("roomId") String roomId);
	
	
}
