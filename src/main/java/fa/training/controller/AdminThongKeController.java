package fa.training.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fa.training.DTO.MovieDTO;
import fa.training.DTO.ShowTimeDTO;
import fa.training.DTO.TheaterDTO;
import fa.training.model.Movie;
import fa.training.service.TicketService;

@Controller
@RequestMapping(value = { "/admin" })
public class AdminThongKeController {
	
	@Autowired
	private TicketService ticketService;
	
	@GetMapping(value = { "/thongKe" })
	public String admin(Model model, @RequestParam(name = "page", defaultValue = "0") int page) {
		int noOfRecords = ticketService.getNoOfShowTimes();
		int recordsPerPage = 5;
		int noOfPages = (int) Math.ceil(noOfRecords * 1.0 / recordsPerPage);
		if (page < 1) {
			page = 1;
		} else if (page > noOfRecords) {
			page = noOfRecords;
		}
		int start = page > 0 ? page - 1 : 0;
		
		List<ShowTimeDTO> list = ticketService.getRecordsForCurrentPage((start) * recordsPerPage, recordsPerPage);
		model.addAttribute("noOfPages", noOfPages);
		model.addAttribute("currentPage", page);
		model.addAttribute("suatchieuList", list);		
		
		return "admin/thongKe";
	}
	
	@GetMapping(value = { "/thongKe2" })
	public String admin2(Model model, @RequestParam(name = "page", defaultValue = "0") int page) {
		int noOfRecords = ticketService.getNoOfMovie();
		int recordsPerPage = 5;
		int noOfPages = (int) Math.ceil(noOfRecords * 1.0 / recordsPerPage);
		if (page < 1) {
			page = 1;
		} else if (page > noOfRecords) {
			page = noOfRecords;
		}
		int start = page > 0 ? page - 1 : 0;
		
		List<MovieDTO> list = ticketService.getRecordsForCurrentPage2((start) * recordsPerPage, recordsPerPage);
		model.addAttribute("noOfPages", noOfPages);
		model.addAttribute("currentPage", page);
		model.addAttribute("phimList", list);		
		
		return "admin/thongKe2";
	}
	
	@GetMapping("/thongKe2/search")
	public String admin2(
			@RequestParam(value = "searchName", required = true) String searchName,
			@RequestParam(name = "page", defaultValue = "0") int page, Model model
	) {
		
		int noOfRecords = ticketService.getNoOfMovieForName(searchName);
		int recordsPerPage = 5;
		int noOfPages = (int) Math.ceil(noOfRecords * 1.0 / recordsPerPage);
		if (page < 1) {
			page = 1;
		} else if (page > noOfRecords) {
			page = noOfRecords;
		}
		int start = page > 0 ? page - 1 : 0;
		
		List<MovieDTO> list = ticketService.getRecordsForCurrentPage2ForName(searchName,(start) * recordsPerPage, recordsPerPage);
		model.addAttribute("searchName", searchName);
		model.addAttribute("noOfPages", noOfPages);
		model.addAttribute("currentPage", page);
		model.addAttribute("phimList", list);		
		
		return "admin/thongKe2";		
	}
	
	@GetMapping(value = { "/thongKe3" })
	public String admin3(Model model, @RequestParam(name = "page", defaultValue = "0") int page) {

		List<TheaterDTO> list = ticketService.getRecordsForCurrentPage3();
		model.addAttribute("rapList", list);
		return "admin/thongKe3";
	}
	
	@GetMapping("/thongKe3/search")
	public String admin23(
			@RequestParam(value = "searchDate", required = true) String searchDate,
			@RequestParam(value = "searchDate2", required = true) String searchDate2,
			Model model
	) {
		

		List<TheaterDTO> list = ticketService.getRecordsForCurrentPage4(searchDate, searchDate2);
		model.addAttribute("rapList", list);
		model.addAttribute("searchDate", searchDate);
		model.addAttribute("searchDate2", searchDate2);
		return "admin/thongKe3";
		
	}
}

