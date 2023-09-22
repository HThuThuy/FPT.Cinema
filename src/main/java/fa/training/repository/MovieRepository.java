package fa.training.repository;

<<<<<<< HEAD
import java.util.Date;
=======
>>>>>>> a5fff66dae6a5d522d77b661585f134d96533e82
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import fa.training.model.Movie;
<<<<<<< HEAD
import fa.training.model.Showtime;
=======
import fa.training.model.Theater;
>>>>>>> a5fff66dae6a5d522d77b661585f134d96533e82

@Repository
public interface MovieRepository extends JpaRepository<Movie, String> {
	
	@Query(value = "select * from MOVIE where endDate > :now order by movieId;", nativeQuery = true)
	List<Movie> getAllEnable(@Param("now") Date now);

	
	//ThuyHTT14
		@Query(value = "select * from Movie m WHERE m.movieStatus='Dang chieu'", nativeQuery = true)
		List<Movie> findDangChieu();
		
		@Query(value = "select * from Movie m WHERE m.movieStatus='Sap chieu'", nativeQuery = true)
		List<Movie> findSapChieu();
}
