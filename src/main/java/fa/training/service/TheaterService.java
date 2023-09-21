package fa.training.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import fa.training.model.Movie;
import fa.training.model.Showtime;
import fa.training.model.Theater;
import fa.training.repository.TheaterRepository;

@Service
public class TheaterService {

	@Autowired
	TheaterRepository repo;

	public List<Theater> getAll() {
		return repo.findAll();
	}

	public Theater findById(String theaterId) {
		return repo.findById(theaterId).orElseThrow(() -> new IllegalArgumentException("Invalid Theater Id: " + theaterId));
	}

	public boolean existsById(String theaterId) {
		return repo.existsById(theaterId);
	}

	public Page<Theater> findAll(Pageable pageable) {
		return repo.findAll(pageable);
	}

	public void save(Theater theater) {
		repo.save(theater);
	}

	public void deleteById(String theaterId) {
		repo.deleteById(theaterId);
	}
	
	
	//LamNH23
	public List<Theater> getRecordsForCurrentPage(int start, int recordsPerPage) {
		List<Theater> list = new ArrayList<>();
		list.add(new Theater("TT004", "Tên rạp 1", "Thành phố"));
		list.add(new Theater("TT004", "Tên rạp 2", "Thành phố"));
		return list;
	}
}
