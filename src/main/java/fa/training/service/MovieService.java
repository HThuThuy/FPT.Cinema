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

import fa.training.DTO.ShowTimeDTO;
import fa.training.model.Movie;
import fa.training.model.Showtime;
import fa.training.model.Theater;
import fa.training.repository.MovieRepository;

@Service
public class MovieService {

	@Autowired
	MovieRepository repo;

	public List<Movie> getAll() {
		return repo.findAll();
	}
	public List<Movie> getMovieDangChieu() {
		return repo.findDangChieu();
	}
	public List<Movie> getMovieSapChieu() {
		return repo.findSapChieu();
	}

	public Movie findById(String movie) {
		return repo.findById(movie).orElseThrow(() -> new IllegalArgumentException("Invalid Movie Id: " + movie));
	}

	public boolean existsById(String movie) {
		return repo.existsById(movie);
	}

	public Page<Movie> findAll(Pageable pageable) {
		return repo.findAll(pageable);
	}

	public void save(Movie movie) {
		repo.save(movie);
	}

	public void deleteById(String movie) {
		repo.deleteById(movie);
	}
	
	//LamNH23
	public List<Movie> getRecordsForCurrentPage(int start, int recordsPerPage) {
		List<Movie> list = new ArrayList<>();
		for(int i = start+1;i<(start+recordsPerPage+1);i++) {
			list.add(new Movie("Movie "+i, "Tên phim", "Mô tả", "Đạo diễn", LocalDate.of(2023, 9, 14), LocalDate.of(2023, 9, 24), LocalTime.of(02, 30),"Url poster",new HashSet<Showtime>()));
		}			
		return list;
	}
	
	

}
