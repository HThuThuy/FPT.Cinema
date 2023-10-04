package fa.training.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import fa.training.model.Theater;

@Repository
public interface TheaterRepository extends JpaRepository<Theater, String> {
    //ThuyHTT14
	@Query(value = "select * from THEATER t WHERE t.city= :'N'selectedCity ", nativeQuery = true)
	List<Theater> findCity(@Param("selectedCity") String selectedCity);
    //ThuyHTT14
	List<Theater> findAllByCity(String city);
}
