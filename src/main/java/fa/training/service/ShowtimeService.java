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
	
	//LamNH23
		public List<Showtime> getRecordsForCurrentPage(int start, int recordsPerPage) {
			List<Showtime> list = new ArrayList<>();
			for(int i = start+1;i<(start+recordsPerPage+1);i++) {
				list.add(new Showtime(i, new Movie("tên phim"), new Theater("abc","Tên rạp","TP"), LocalTime.of(02, 30),LocalTime.of(02, 30)));
			}			
			return list;
		}

}
