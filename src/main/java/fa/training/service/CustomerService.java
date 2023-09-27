package fa.training.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import fa.training.DTO.CustomerDTO;
import fa.training.model.Customer;
import fa.training.repository.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	CustomerRepository repo;

	public String getCustomerName(String cccd) {
		// Find the customer by cccd
		Customer customer = repo.findById(cccd).get();
		// Return the name of the customer
		return customer != null ? customer.getCustomerName() : null;
	}

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
	
	public List<CustomerDTO> getRecordsForCurrentPage(String cccd) {
		List<CustomerDTO> list = repo.getRecordsForCurrentPage(cccd);
		return list;
	}
}
