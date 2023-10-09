package fa.training.repository;


import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import fa.training.model.Movie;

import fa.training.model.Showtime;

import fa.training.model.Theater;


@Repository
public interface MovieRepository extends JpaRepository<Movie, String> {
	
	String sql1 = "select * from MOVIE order by movieName offset :start ROWS FETCH FIRST :recordsPerPage ROWS ONLY";
	String sql2 = "select * from MOVIE where movieName like :searchName order by movieName offset :start ROWS FETCH FIRST :recordsPerPage ROWS ONLY";
	String sql3 = "select * from MOVIE where movieName like :searchName";
	
	/**
	 * lấy tất cả phim trong DB có ngày kết thúc lớn hơn ngày hiện tại - LamNH23
	 * @param now
	 * @return
	 */
	@Query(value = "select * from MOVIE where endDate > :now order by movieId;", nativeQuery = true)
	List<Movie> getAllEnable(@Param("now") Date now);

	
	//ThuyHTT14
    @Query(value = "select * from Movie m WHERE m.startDate  < GETDATE() AND m.endDate  > GETDATE();", nativeQuery = true)
    List<Movie> findDangChieu();
    
    //ThuyHTT14 
    @Query(value = "select * from Movie m WHERE m.startDate  > GETDATE() ", nativeQuery = true)
    List<Movie> findSapChieu();
    
    //ThuyHTT14 
    List<Movie> findByMovieName(String movieName);
		
    /**
     * lấy tất cả phim trong DB - LamNH23
     * @param start
     * @param recordsPerPage
     * @return
     */
	@Query(value = sql1, nativeQuery = true)
	List<Movie> getRecordsForCurrentPage(@Param("start") int start, @Param("recordsPerPage") int recordsPerPage);

	/**
	 * tìm phim trong DB theo tên - LamNH23
	 * @param searchName
	 * @return
	 */
	@Query(value = sql3, nativeQuery = true)
	List<Movie> searchMovie(@Param("searchName") String searchName);
	
	/**
	 * hiện tất cả phim trong DB - LamNH23
	 * @param searchName
	 * @param start
	 * @param recordsPerPage
	 * @return
	 */
	@Query(value = sql2, nativeQuery = true)
	List<Movie> getRecordsForCurrentPage2(@Param("searchName") String searchName, @Param("start") int start, @Param("recordsPerPage") int recordsPerPage);

}
