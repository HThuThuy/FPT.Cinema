package fa.training.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import fa.training.model.Promotion;
import fa.training.repository.PromotionRepository;

@Service
public class PromotionService {

	@Autowired
	PromotionRepository repo;

	public List<Promotion> getAll() {
		return repo.findAll();
	}

	public Promotion findById(String promotionId) {
		return repo.findById(promotionId).orElseThrow(() -> new IllegalArgumentException("Invalid Promotion Id: " + promotionId));
	}

	public boolean existsById(String promotionId) {
		return repo.existsById(promotionId);
	}

	public Page<Promotion> findAll(Pageable pageable) {
		return repo.findAll(pageable);
	}

	public void save(Promotion promotion) {
		repo.save(promotion);
	}

	public void deleteById(String promotionId) {
		repo.deleteById(promotionId);
	}
	
	

}
