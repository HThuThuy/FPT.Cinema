package fa.training.service;

import java.math.BigInteger;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.Tuple;

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
		return repo.getNumberShowtime().size();
	}

	// LamNH23
	public List<ShowTimeDTO> getRecordsForCurrentPage(int start, int recordsPerPage) {
//		List<ShowTimeDTO> list = new ArrayList<>();
//		for (int i = start + 1; i < (start + recordsPerPage + 1); i++) {
//			list.add(new ShowTimeDTO("Rạp" + i, "Phòng "+i, "09:00","Phim "+i, "22/09/2023", "25/09/2023", 350000));
//		}
		
		
		List<Tuple> list2 = repo.getRecordsForCurrentPage(start, recordsPerPage);
		List<ShowTimeDTO> list = list2.stream().map(t -> new ShowTimeDTO(
				t.get(0,String.class), //theaterName
				t.get(1,String.class), //roomName
				t.get(2,Time.class), //startTime
				t.get(3,String.class), //movieName
				t.get(4,Date.class), //startDate
				t.get(5,Date.class), //endDate
				t.get(6,Integer.class))) //doanhThu
				.collect(Collectors.toList());
		
		return list;
	}

	// LamNH23
	public int getNoOfMovie() {
		return repo.getNumberMovie().size();
	}

	// LamNH23
	public List<MovieDTO> getRecordsForCurrentPage2(int start, int recordsPerPage) {		
		List<Tuple> list2 = repo.getRecordsForCurrentPage2(start, recordsPerPage);
		List<MovieDTO> list = list2.stream().map(t -> new MovieDTO(
				t.get(0,String.class), //movieName
				t.get(1,Date.class), //startDate
				t.get(2,Date.class), //endDate
				t.get(3,String.class), //posterUrl
				t.get(4,Integer.class))) //doanhThu
				.collect(Collectors.toList());
		
		return list;
	}
	
	// LamNH23
	public int getNoOfMovieForName(String searchName) {
		return repo.getNumberMovieForName("%" + searchName + "%").size();
	}

	// LamNH23
	public List<MovieDTO> getRecordsForCurrentPage2ForName(String searchName, int start, int recordsPerPage) {
		List<Tuple> list2 = repo.getRecordsForCurrentPage2ForName("%" + searchName + "%", start, recordsPerPage);
		List<MovieDTO> list = list2.stream().map(t -> new MovieDTO(t.get(0, String.class), // movieName
				t.get(1, Date.class), // startDate
				t.get(2, Date.class), // endDate
				t.get(3, String.class), // posterUrl
				t.get(4, Integer.class))) // doanhThu
				.collect(Collectors.toList());

		return list;
	}


	// LamNH23
	public List<TheaterDTO> getRecordsForCurrentPage3() {
//		List<TheaterDTO> list = new ArrayList<>();
//		for (int i = 1; i < 6; i++) {
//			list.add(new TheaterDTO("Theater" + i, "Tên rạp", "Thành phố", 350000));
//		}
		
		List<Tuple> list2 = repo.getRecordsForCurrentPage3();
		List<TheaterDTO> list = list2.stream().map(t -> new TheaterDTO(
				t.get(0,String.class), //theaterName
				t.get(1,String.class), //city
				t.get(2,String.class), //address
				t.get(3,String.class), //phone
				t.get(4,Integer.class))) //doanhThu
				.collect(Collectors.toList());
		
		return list;
	}

}
