package fa.training.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fa.training.DTO.ShowTimeDTO;
import fa.training.model.Movie;
import fa.training.service.MovieService;

@Controller
@RequestMapping(value = { "/admin" })
public class AdminPhimController {
	
	@Autowired
	MovieService movieService;
	
	@GetMapping(value = { "/quanLyPhim" })
	public String admin(Model model, @RequestParam(name = "page", defaultValue = "0") int page) {
		int noOfRecords = 30; //movieService.getAll().size();
		int recordsPerPage = 5;
		int noOfPages = (int) Math.ceil(noOfRecords * 1.0 / recordsPerPage);
		if (page < 1) {
			page = 1;
		} else if (page > noOfRecords) {
			page = noOfRecords;
		}
		int start = page > 0 ? page - 1 : 0;
		
		List<Movie> list = movieService.getRecordsForCurrentPage((start) * recordsPerPage, recordsPerPage);
		model.addAttribute("noOfPages", noOfPages);
		model.addAttribute("currentPage", page);
		model.addAttribute("phimList", list);
		
		return "admin/quanLyPhim";
	}
	
	@GetMapping(value = { "/addPhim" })
	public String admin2() {
		return "admin/addPhim";
	}
	
	@PostMapping(value = { "/addPhim" })
	public String admin4() {
		
		return "redirect:/admin/quanLyPhim";
	}
	
	
	@GetMapping(value = { "/searchPhim" })
	public String admin3() {
		return "admin/addPhim";
	}
	
	
}

