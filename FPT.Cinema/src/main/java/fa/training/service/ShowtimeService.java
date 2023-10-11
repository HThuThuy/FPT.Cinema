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

	/**
	 * hiện tất cả suất chiếu trong DB - LamNH23
	 * @param start
	 * @param recordsPerPage
	 * @return
	 */
	public List<Showtime> getRecordsForCurrentPage(int start, int recordsPerPage) {
		List<Showtime> list = repo.getRecordsForCurrentPage(start, recordsPerPage);
		return list;		
	}	

	/**
	 * hiện danh sách giờ chiếu khi chọn room - LamNH23
	 * @param roomId
	 * @return
	 */
	public List<String> getTimeByRoom(String roomId) {			
		return repo.getTimeByRoom(roomId);
	}			

	/**
	 * xóa suất chiếu đã chọn - LamNH23
	 * @param ids
	 */
	public void deleteST2(Iterable<String> ids) {		
		repo.deleteAllByIdInBatch(ids);
	}

	
	//ThuyHtt14
	public List<Showtime> getByMovieId(String movieId, String theaterId) {
		return repo.findByMovieId(movieId, theaterId);
	}
}
