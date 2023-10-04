package fa.training.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import fa.training.model.Movie;
import fa.training.model.Room;
import fa.training.model.Showtime;

@Repository
public interface RoomRepository extends JpaRepository<Room, String> {
	
     //LamNH23
	@Query(value = "select * from ROOM where theaterId like :theaterId order by roomId;", nativeQuery = true)
	List<Room> getAllByTheater(@Param("theaterId") String theaterId);


}
