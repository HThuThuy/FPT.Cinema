package fa.training.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fa.training.model.Movie;
import fa.training.model.Theater;
import fa.training.service.TheaterService;

@Controller
@RequestMapping(value = { "/admin" })
public class AdminRapController {
	
	@Autowired
	TheaterService theaterService;
	
	@GetMapping(value = { "/quanLyRap" })
	public String admin(Model model, @RequestParam(name = "page", defaultValue = "0") int page) {
		int noOfRecords = theaterService.getAll().size();
		int recordsPerPage = 5;
		int noOfPages = (int) Math.ceil(noOfRecords * 1.0 / recordsPerPage);
		if (page < 1) {
			page = 1;
		} else if (page > noOfRecords) {
			page = noOfRecords;
		}
		int start = page > 0 ? page - 1 : 0;
		
		List<Theater> list = theaterService.getRecordsForCurrentPage((start) * recordsPerPage, recordsPerPage);
//		model.addAttribute("noOfPages", noOfPages);
//		model.addAttribute("currentPage", page);
		model.addAttribute("rapList", list);
		return "admin/quanLyRap";
	}
	
	@GetMapping(value = { "/addRap" })
	public String admin2() {
		return "admin/addRap";
	}
	
	@PostMapping(value = { "/addRap" })
	public String admin4() {
		
		return "redirect:/admin/quanLyRap";
	}
}

