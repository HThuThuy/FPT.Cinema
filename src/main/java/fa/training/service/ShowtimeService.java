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
import fa.training.model.Room;
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

	public Showtime findById(String showtimeId) {
		return repo.findById(showtimeId).orElseThrow(() -> new IllegalArgumentException("Invalid Showtime Id: " + showtimeId));
	}

	public boolean existsById(String showtimeId) {
		return repo.existsById(showtimeId);
	}

	public Page<Showtime> findAll(Pageable pageable) {
		return repo.findAll(pageable);
	}

	public void save(Showtime showtime) {
		repo.save(showtime);
	}

	public void deleteById(String showtimeId) {
		repo.deleteById(showtimeId);
	}

	// LamNH23
	public List<Showtime> getRecordsForCurrentPage(int start, int recordsPerPage) {
//		List<Showtime> list = new ArrayList<>();
//		for (int i = start + 1; i < (start + recordsPerPage + 1); i++) {
//			list.add(new Showtime("ST"+i, new Movie("tên phim"), new Theater("abc", "Tên rạp", "TP"), new Room("Tên room"),
//					LocalDate.of(2023, 9, 15), LocalTime.of(02, 30)));
//		}
		List<Showtime> list = repo.getRecordsForCurrentPage(start, recordsPerPage);
		return list;
		
		
	}

	// LamNH23
	public List<Showtime> getRecordsForCurrentPage2(int start, int recordsPerPage) {
		List<Showtime> list = new ArrayList<>();
//		for (int i = start + 1; i < (start + recordsPerPage + 1); i++) {
//			list.add(new Showtime("ST"+i, new Movie("tên phim search"), new Theater("abc", "Tên rạp", "TP"),
//					new Room("Tên room"), LocalDate.of(2023, 9, 15), LocalTime.of(02, 30)));
//		}
		return list;
	}

	// LamNH23
	public int getRecordsForSearch(String id) {

		return 25;
	}
	
	// LamNH23
		public List<String> getTimeByRoom(String roomId) {			
			return repo.getTimeByRoom(roomId);
		}
		
		
		
		// LamNH23
		public void deleteST2(Iterable<String> ids) {
			
			repo.deleteAllByIdInBatch(ids);
		}

	
	//ThuyHtt14
	public List<Showtime> getByMovieId(String movieId, String theaterId) {
		return repo.findByMovieId(movieId, theaterId);
	}
}
