package fa.training.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import fa.training.model.Movie;
import fa.training.model.Room;

@Repository
public interface RoomRepository extends JpaRepository<Room, String> {
	
	

}
