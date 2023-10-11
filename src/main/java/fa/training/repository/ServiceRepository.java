package fa.training.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fa.training.model.Services;

@Repository
public interface ServiceRepository extends JpaRepository<Services, Integer> {

}
