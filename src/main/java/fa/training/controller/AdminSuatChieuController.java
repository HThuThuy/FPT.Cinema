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
import fa.training.model.Showtime;
import fa.training.service.ShowtimeService;
import fa.training.service.TicketService;

@Controller
@RequestMapping(value = { "/admin" })
public class AdminSuatChieuController {
	
	@Autowired
	private ShowtimeService showtimeService;
	
	@GetMapping(value = { "/quanLySuatChieu" })
	public String admin(Model model, @RequestParam(name = "page", defaultValue = "0") int page) {
		
		int noOfRecords = 20; //showtimeService.getAll().size();
		int recordsPerPage = 5;
		int noOfPages = (int) Math.ceil(noOfRecords * 1.0 / recordsPerPage);
		if (page < 1) {
			page = 1;
		} else if (page > noOfRecords) {
			page = noOfRecords;
		}
		int start = page > 0 ? page - 1 : 0;
		
		List<Showtime> list = showtimeService.getRecordsForCurrentPage((start) * recordsPerPage, recordsPerPage);
		
		model.addAttribute("noOfPages", noOfPages);
		model.addAttribute("currentPage", page);
		model.addAttribute("suatchieuList", list);
		return "admin/quanLySuatChieu";
	}
	
	@GetMapping(value = { "/addSuatChieu" })
	public String admin2() {
		return "admin/addSuatChieu";
	}
	
	@PostMapping(value = { "/addSuatChieu" })
	public String admin4() {
		
		return "redirect:/admin/quanLySuatChieu";
	}
	
	@GetMapping(value = { "/searchSuatChieu" })
	public String admin3() {
		return "admin/addSuatChieu";
	}
}

