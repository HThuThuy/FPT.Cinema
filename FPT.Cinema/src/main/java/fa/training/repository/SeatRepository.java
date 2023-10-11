package fa.training.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fa.training.model.Room;
import fa.training.model.Seat;
import fa.training.model.SeatId;

@Repository
public interface SeatRepository extends JpaRepository<Seat, SeatId> {
	
	 //ThuyHTT14
	@Modifying
	@Query(value = "UPDATE Seat SET seatStatus = 'Da dat' WHERE seatId = :seatId", nativeQuery = true)
	@Transactional
	void updateSeatStatus(@Param("seatId") String seatId);
	
	@Modifying
	@Query(value = "UPDATE Seat SET seatStatus = 'Trong' WHERE seatId = :seatId", nativeQuery = true)
	@Transactional
	void updateSeatCancel(@Param("seatId") String seatId);
	
	
	@Query(value = "select * from seat where roomId= :roomId ", nativeQuery = true)
	List<Seat> getAllByRoom(@Param("roomId") String roomId);

}
