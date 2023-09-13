package fa.training.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import fa.training.model.Customer;
import fa.training.repository.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	CustomerRepository repo;

	public List<Customer> getAll() {
		return repo.findAll();
	}

	public Customer findById(String cccd) {
		return repo.findById(cccd).orElseThrow(() -> new IllegalArgumentException("Invalid Customer Id: " + cccd));
	}

	public boolean existsById(String cccd) {
		return repo.existsById(cccd);
	}

	public Page<Customer> findAll(Pageable pageable) {
		return repo.findAll(pageable);
	}

	public void save(Customer customer) {
		repo.save(customer);
	}

	public void deleteById(String cccd) {
		repo.deleteById(cccd);
	}
	
	

}
