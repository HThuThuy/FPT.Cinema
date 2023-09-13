package fa.training.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import fa.training.model.Showtime;
import fa.training.repository.ShowtimeRepository;

@Service
public class ShowtimeService {

	@Autowired
	ShowtimeRepository repo;

	public List<Showtime> getAll() {
		return repo.findAll();
	}

	public Showtime findById(Integer showtimeId) {
		return repo.findById(showtimeId).orElseThrow(() -> new IllegalArgumentException("Invalid Showtime Id: " + showtimeId));
	}

	public boolean existsById(Integer showtimeId) {
		return repo.existsById(showtimeId);
	}

	public Page<Showtime> findAll(Pageable pageable) {
		return repo.findAll(pageable);
	}

	public void save(Showtime showtime) {
		repo.save(showtime);
	}

	public void deleteById(Integer showtimeId) {
		repo.deleteById(showtimeId);
	}
	
	

}
