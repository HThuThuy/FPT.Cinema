package fa.training.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fa.training.model.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, String> {

}
