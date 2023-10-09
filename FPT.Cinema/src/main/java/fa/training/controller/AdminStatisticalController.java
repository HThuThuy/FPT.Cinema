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

/**
 * AdminStatisticalController
 * 
 * Version 1.0
 * 
 * Date: 09-10-2023
 * 
 * Copyright
 * 
 * Modification Logs:
 * DATE			AUTHOR		DESCRIPTION
 * --------------------------------
 * 09-10-2023	LamNH23		Create
 */
@Controller
@RequestMapping(value = { "/admin" })
public class AdminStatisticalController {
	
	@Autowired
	private TicketService ticketService;
	
	/**
	 * hiện tất cả suất chiếu trong DB kèm doanh thu - LamNH23
	 * @param model
	 * @param page
	 * @return
	 */
	@GetMapping(value = { "/thongKe" })
	public String getListShowtimeWithMoney(Model model, @RequestParam(name = "page", defaultValue = "0") int page) {
		//setup phân trang
		int noOfRecords = ticketService.getNoOfShowTimes();
		int recordsPerPage = 5;
		int noOfPages = (int) Math.ceil(noOfRecords * 1.0 / recordsPerPage);
		if (page < 1) {
			page = 1;
		} else if (page > noOfRecords) {
			page = noOfRecords;
		}
		int start = page > 0 ? page - 1 : 0;
		//get data theo phân trang
		List<ShowTimeDTO> list = ticketService.getRecordsForCurrentPage((start) * recordsPerPage, recordsPerPage);
		model.addAttribute("noOfPages", noOfPages);
		model.addAttribute("currentPage", page);
		model.addAttribute("suatchieuList", list);		
		
		return "admin/thongKe";
	}

	/**
	 * hiện tất cả phim trong DB kèm doanh thu - LamNH23
	 * @param model
	 * @param page
	 * @return
	 */
	@GetMapping(value = { "/thongKe2" })
	public String getListMovieWithMoney(Model model, @RequestParam(name = "page", defaultValue = "0") int page) {
		//setup phân trang
		int noOfRecords = ticketService.getNoOfMovie();
		int recordsPerPage = 5;
		int noOfPages = (int) Math.ceil(noOfRecords * 1.0 / recordsPerPage);
		if (page < 1) {
			page = 1;
		} else if (page > noOfRecords) {
			page = noOfRecords;
		}
		int start = page > 0 ? page - 1 : 0;
		//get data theo phân trang
		List<MovieDTO> list = ticketService.getRecordsForCurrentPage2((start) * recordsPerPage, recordsPerPage);
		model.addAttribute("noOfPages", noOfPages);
		model.addAttribute("currentPage", page);
		model.addAttribute("phimList", list);		
		
		return "admin/thongKe2";
	}

	/**
	 * hiện phim trong DB kèm doanh thu theo tên - LamNH23
	 * @param searchName
	 * @param page
	 * @param model
	 * @return
	 */
	@GetMapping("/thongKe2/search")
	public String getListMovieWithMoneyByName(
			@RequestParam(value = "searchName", required = true) String searchName,
			@RequestParam(name = "page", defaultValue = "0") int page, Model model
	) {
		//setup phân trang
		int noOfRecords = ticketService.getNoOfMovieForName(searchName);
		int recordsPerPage = 5;
		int noOfPages = (int) Math.ceil(noOfRecords * 1.0 / recordsPerPage);
		if (page < 1) {
			page = 1;
		} else if (page > noOfRecords) {
			page = noOfRecords;
		}
		int start = page > 0 ? page - 1 : 0;
		//get data theo phân trang
		List<MovieDTO> list = ticketService.getRecordsForCurrentPage2ForName(searchName,(start) * recordsPerPage, recordsPerPage);
		model.addAttribute("searchName", searchName);
		model.addAttribute("noOfPages", noOfPages);
		model.addAttribute("currentPage", page);
		model.addAttribute("phimList", list);		
		
		return "admin/thongKe2";		
	}

	/**
	 * hiện tất cả rạp trong DB kèm doanh thu - LamNH23
	 * @param model
	 * @param page
	 * @return
	 */
	@GetMapping(value = { "/thongKe3" })
	public String getListTheaterWithMoney(Model model, @RequestParam(name = "page", defaultValue = "0") int page) {
		List<TheaterDTO> list = ticketService.getRecordsForCurrentPage3();
		model.addAttribute("rapList", list);
		return "admin/thongKe3";
	}

	/**
	 * hiện tất cả rạp trong DB kèm doanh thu theo khoản thời gian - LamNH23 
	 * @param searchDate
	 * @param searchDate2
	 * @param model
	 * @return
	 */
	@GetMapping("/thongKe3/search")
	public String getListTheaterWithMoneyByTime(
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

