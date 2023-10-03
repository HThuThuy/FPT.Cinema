package fa.training.service;

import java.time.LocalDate;
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
		Customer customer = repo.findById(cccd).get();
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
	
	public Customer findByPhone(String phone) {
		return repo.findByPhone(phone);
	}
	
	public Customer findByEmail(String email) {
		return repo.findByEmail(email);
	}
	

	public void save(Customer customer) {
		repo.save(customer);
	}

	public void deleteById(String cccd) {
		repo.deleteById(cccd);
	}
	
	public Page<CustomerDTO> getRecordsForCurrentPage(String cccd, LocalDate startDate, LocalDate endDate, Pageable pageable) {
	    return repo.getRecordsForCurrentPage(cccd, startDate, endDate, pageable);
	}

	public Customer updateCustomerInfo(String cccd, String phone, String address, String email) {
        Customer customer = repo.findById(cccd).get();

        if (customer != null) {
            customer.setPhone(phone);
            customer.setAddress(address);
            customer.setEmail(email);

            return repo.save(customer);
        }

        return null;
    }

}
