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

	/**
	 * Project: FPT Cinema Team: 2 Author :LamNH23 Method: Lấy số lượng suất chiếu từ DB
	 */
	public int getNoOfShowTimes() {
		return repo.getNumberShowtime().size();
	}

	/**
	 * Project: FPT Cinema Team: 2 Author :LamNH23 Method: Hiện tất cả suất chiếu trong DB kèm doanh thu
	 */
	public List<ShowTimeDTO> getRecordsForCurrentPage(int start, int recordsPerPage) {		
		
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

	/**
	 * Project: FPT Cinema Team: 2 Author :LamNH23 Method: Lấy số lượng phim từ DB
	 */
	public int getNoOfMovie() {
		return repo.getNumberMovie().size();
	}

	/**
	 * Project: FPT Cinema Team: 2 Author :LamNH23 Method: Hiện tất cả phim trong DB kèm doanh thu
	 */
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
	
	/**
	 * Project: FPT Cinema Team: 2 Author :LamNH23 Method: Lấy số lượng phim từ DB theo tên
	 */
	public int getNoOfMovieForName(String searchName) {
		return repo.getNumberMovieForName("%" + searchName + "%").size();
	}

	/**
	 * Project: FPT Cinema Team: 2 Author :LamNH23 Method: Hiện phim trong DB kèm doanh thu theo tên
	 */
	public List<MovieDTO> getRecordsForCurrentPage2ForName(String searchName, int start, int recordsPerPage) {
		List<Tuple> list2 = repo.getRecordsForCurrentPage2ForName("%" + searchName + "%", start, recordsPerPage);
		List<MovieDTO> list = list2.stream().map(t -> new MovieDTO(
				t.get(0, String.class), // movieName
				t.get(1, Date.class), // startDate
				t.get(2, Date.class), // endDate
				t.get(3, String.class), // posterUrl
				t.get(4, Integer.class))) // doanhThu
				.collect(Collectors.toList());

		return list;
	}


	/**
	 * Project: FPT Cinema Team: 2 Author :LamNH23 Method: Hiện tất cả rạp trong DB kèm doanh thu
	 */
	public List<TheaterDTO> getRecordsForCurrentPage3() {
		
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
	
	/**
	 * Project: FPT Cinema Team: 2 Author :LamNH23 Method: Hiện tất cả rạp trong DB kèm doanh thu theo khoản thời gian
	 */
	public List<TheaterDTO> getRecordsForCurrentPage4(String searchDate, String searchDate2) {
		
		List<Tuple> list2 = repo.getRecordsForCurrentPage4(searchDate, searchDate2);
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
