package fa.training.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fa.training.model.Showtime;

@Repository
public interface ShowtimeRepository extends JpaRepository<Showtime, Integer> {

}
