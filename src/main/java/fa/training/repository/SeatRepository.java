package fa.training.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fa.training.model.Seat;
import fa.training.model.SeatId;

@Repository
public interface SeatRepository extends JpaRepository<Seat, SeatId> {

}
