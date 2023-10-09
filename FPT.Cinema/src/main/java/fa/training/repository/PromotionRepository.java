package fa.training.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fa.training.model.Promotion;

@Repository
public interface PromotionRepository extends JpaRepository<Promotion, String> {

}
