package fa.training.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import fa.training.model.Movie;
import fa.training.repository.MovieRepository;

@Service
public class MovieService {

	@Autowired
	MovieRepository repo;

	public List<Movie> getAll() {
		return repo.findAll();
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
	
	

}
