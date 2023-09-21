package fa.training.service;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import fa.training.DTO.MovieDTO;
import fa.training.DTO.ShowTimeDTO;
import fa.training.DTO.TheaterDTO;
import fa.training.model.Movie;
import fa.training.model.Showtime;
import fa.training.model.Theater;
import fa.training.model.TicketInfo;
import fa.training.repository.TicketRepository;

@Service
public class TicketService {

	@Autowired
	TicketRepository repo;

	public List<TicketInfo> getAll() {
		return repo.findAll();
	}

	public TicketInfo findById(Integer ticketId) {
		return repo.findById(ticketId)
				.orElseThrow(() -> new IllegalArgumentException("Invalid TicketInfo Id: " + ticketId));
	}

	public boolean existsById(Integer ticketId) {
		return repo.existsById(ticketId);
	}

	public Page<TicketInfo> findAll(Pageable pageable) {
		return repo.findAll(pageable);
	}

	public void save(TicketInfo ticket) {
		repo.save(ticket);
	}

	public void deleteById(Integer ticketId) {
		repo.deleteById(ticketId);
	}

	// LamNH23
	public int getNoOfShowTimes() {
		return 35;
	}

	// LamNH23
	public List<ShowTimeDTO> getRecordsForCurrentPage(int start, int recordsPerPage) {
		List<ShowTimeDTO> list = new ArrayList<>();
		for (int i = start + 1; i < (start + recordsPerPage + 1); i++) {
			list.add(new ShowTimeDTO("ST" + i, "Tên phim", "Tên rạp", "13:00 - 22/09/2023", "15:00 - 22/09/2023", 12,
					25, 350000));
		}
		return list;
	}

	// LamNH23
	public int getNoOfShowTimes2() {
		return 45;
	}

	// LamNH23
	public List<MovieDTO> getRecordsForCurrentPage2(int start, int recordsPerPage) {
		List<MovieDTO> list = new ArrayList<>();
		for (int i = start + 1; i < (start + recordsPerPage + 1); i++) {
			list.add(new MovieDTO("MV" + i, "Tên phim", "22/09/2023", "22/09/2023", 350000));
		}
		return list;
	}


	// LamNH23
	public List<TheaterDTO> getRecordsForCurrentPage3() {
		List<TheaterDTO> list = new ArrayList<>();
		for (int i = 1; i < 6; i++) {
			list.add(new TheaterDTO("Theater" + i, "Tên rạp", "Thành phố", 350000));
		}
		return list;
	}

}
