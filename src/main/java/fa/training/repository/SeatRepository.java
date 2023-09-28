package fa.training.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fa.training.model.Seat;
import fa.training.model.SeatId;

@Repository
public interface SeatRepository extends JpaRepository<Seat, SeatId> {
	
	 //ThuyHTT14
	@Modifying
	@Query(value = "UPDATE Seat SET seatStatus = 'Da dat' WHERE seatId = :seatId", nativeQuery = true)
	@Transactional
	void updateSeatStatus(@Param("seatId") String seatId);

}
