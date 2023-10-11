package fa.training.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
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
	public List<Movie> findByMovieName(String movieName) {
        return repo.findByMovieName(movieName);
    }

	/**
	 * lấy tất cả phim trong DB - LamNH23
	 * @param start
	 * @param recordsPerPage
	 * @return
	 */
	public List<Movie> getRecordsForCurrentPage(int start, int recordsPerPage) {
		List<Movie> list = repo.getRecordsForCurrentPage(start, recordsPerPage);
		return list;
	}

	/**
	 * lấy tất cả phim trong DB có ngày kết thúc lớn hơn ngày hiện tại - LamNH23
	 * @return
	 */
	public List<Movie> getAllEnable() {
		List<Movie> list = repo.getAllEnable(new Date (System.currentTimeMillis() ));		
		return list;
	}

	/**
	 * lấy tất cả phim trong DB theo tên - LamNH23
	 * @param searchName
	 * @return
	 */
	public List<Movie> searchMovie(String searchName) {
		return repo.searchMovie ("%" + searchName + "%");		
	}

	/**
	 * tìm kiếm phim trong DB theo tên - LamNH23
	 * @param searchName
	 * @param start
	 * @param recordsPerPage
	 * @return
	 */
	public List<Movie> getRecordsForCurrentPage2(String searchName, int start, int recordsPerPage) {
		List<Movie> list = repo.getRecordsForCurrentPage2("%" + searchName + "%",start, recordsPerPage);
		return list;
	}

	/**
	 * xóa phim đã chọn - LamNH23
	 * @param ids
	 */
	public void deleteMV(Iterable<String> ids) {		
		repo.deleteAllByIdInBatch(ids);
	}
}
