package fa.training.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import fa.training.model.Showtime;

@Repository
public interface ShowtimeRepository extends JpaRepository<Showtime, String> {
	
	@Query(value = "select * from SHOWTIME order by showtimeId offset :start ROWS FETCH FIRST :recordsPerPage ROWS ONLY;", nativeQuery = true)
	List<Showtime> getRecordsForCurrentPage(@Param("start") int start, @Param("recordsPerPage") int recordsPerPage);
}
