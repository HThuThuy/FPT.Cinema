package fa.training.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fa.training.model.Room;

@Repository
public interface RoomRepository extends JpaRepository<Room, String> {

}
