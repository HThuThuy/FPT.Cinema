package fa.training.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fa.training.model.OrderServiceId;
import fa.training.model.OrderServied;

@Repository
public interface OrderServiceRepository extends JpaRepository<OrderServied, OrderServiceId> {
	
	

}
