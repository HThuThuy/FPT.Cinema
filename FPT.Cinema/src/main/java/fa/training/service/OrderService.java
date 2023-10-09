package fa.training.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import fa.training.model.Order;
import fa.training.repository.OrderRepository;

@Service
public class OrderService {

	@Autowired
	OrderRepository repo;

	public List<Order> getAll() {
		return repo.findAll();
	}

	public Order findById(Integer orderId) {
		return repo.findById(orderId).orElseThrow(() -> new IllegalArgumentException("Invalid Order Id: " + orderId));
	}

	public boolean existsById(Integer orderId) {
		return repo.existsById(orderId);
	}

	public Page<Order> findAll(Pageable pageable) {
		return repo.findAll(pageable);
	}

	public void save(Order order) {
		repo.save(order);
	}

	public void deleteById(Integer orderId) {
		repo.deleteById(orderId);
	}
	
	

}
