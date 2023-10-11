package fa.training.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import fa.training.model.OrderServiceId;
import fa.training.model.OrderServied;
import fa.training.repository.OrderServiceRepository;

@Service
public class OrderSer {

	@Autowired
	OrderServiceRepository repo;

	public List<OrderServied> getAll() {
		return repo.findAll();
	}

	public OrderServied findById(OrderServiceId orderServiceId) {
		return repo.findById(orderServiceId).orElseThrow(() -> new IllegalArgumentException("Invalid seat Id: " + orderServiceId));
	}

	public boolean existsById(OrderServiceId orderServiceId) {
		return repo.existsById(orderServiceId);
	}

	public Page<OrderServied> findAll(Pageable pageable) {
		return repo.findAll(pageable);
	}

	public void save(OrderServied orderService) {
		repo.save(orderService);
	}

	public void deleteById(OrderServiceId orderServiceId) {
		repo.deleteById(orderServiceId);
	}
	
	

}
