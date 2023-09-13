package fa.training.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fa.training.model.Theater;

@Repository
public interface TheaterRepository extends JpaRepository<Theater, String> {

}
