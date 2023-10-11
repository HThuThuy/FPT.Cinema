package fa.training.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import fa.training.model.Services;
import fa.training.repository.ServiceRepository;

@Service
public class SerService {
	

	@Autowired
	ServiceRepository repo;

	public List<Services> getAll() {
		return repo.findAll();
	}

	public Services findById(Integer serviceId) {
		return repo.findById(serviceId).orElseThrow(() -> new IllegalArgumentException("Invalid Services Id: " + serviceId));
	}

	public boolean existsById(Integer serviceId) {
		return repo.existsById(serviceId);
	}

	public Page<Services> findAll(Pageable pageable) {
		return repo.findAll(pageable);
	}

	public void save(Services services) {
		repo.save(services);
	}

	public void deleteById(Integer serviceId) {
		repo.deleteById(serviceId);
	}
	
	
	
	

}
