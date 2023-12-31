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
	
	
	/**
	 * Project: FPT Cinema Team: 2 Author :LamNH23 Method: Hiện tất cả suất chiếu trong DB
	 */
	@Query(value = sql1, nativeQuery = true)
	List<Showtime> getRecordsForCurrentPage(@Param("start") int start, @Param("recordsPerPage") int recordsPerPage);
	
	/**
	 * Project: FPT Cinema Team: 2 Author :LamNH23 Method: Hiện danh sách giờ chiếu khi chọn room
	 */
	@Query(value = "select CONVERT(varchar(5), startTime, 120) from SHOWTIME where roomId like :roomId", nativeQuery = true)
	List<String> getTimeByRoom(@Param("roomId") String roomId);

	//ThuyHtt14
	@Query(value = "select * from Showtime st Join Room r On r.roomId= st.roomId where st.movieId like %:movieId% AND r.theaterId like %:theaterId% ", nativeQuery = true)
	List<Showtime> findByMovieId(@Param("movieId") String movieId, @Param("theaterId") String theaterId);
	
	
}
