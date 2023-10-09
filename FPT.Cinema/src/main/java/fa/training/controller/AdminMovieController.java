package fa.training.controller;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import fa.training.model.Movie;
import fa.training.service.MovieService;

/**
 * AdminMovieController
 * 
 * Version 1.0
 * 
 * Date: 09-10-2023
 * 
 * Copyright
 * 
 * Modification Logs: DATE AUTHOR DESCRIPTION
 * --------------------------------
 * 09-10-2023 LamNH23 Create
 */
@Controller
@RequestMapping(value = { "/admin" })
public class AdminMovieController {

	@Autowired
	MovieService movieService;

	/**
	 * hiện tất cả phim trong DB - LamNH23 
	 * @param model
	 * @param page
	 * @return
	 */
	@GetMapping(value = { "/quanLyPhim" })
	public String getListMovie(Model model, @RequestParam(name = "page", defaultValue = "0") int page) {
		// setup phân trang
		int noOfRecords = movieService.getAll().size();
		int recordsPerPage = 5;
		int noOfPages = (int) Math.ceil(noOfRecords * 1.0 / recordsPerPage);
		if (page < 1) {
			page = 1;
		} else if (page > noOfRecords) {
			page = noOfRecords;
		}
		int start = page > 0 ? page - 1 : 0;
		// get data theo phân trang
		List<Movie> list = movieService.getRecordsForCurrentPage((start) * recordsPerPage, recordsPerPage);
		model.addAttribute("noOfPages", noOfPages);
		model.addAttribute("currentPage", page);
		model.addAttribute("phimList", list);
		return "admin/quanLyPhim";
	}

	/**
	 * tìm kiếm phim trong DB theo tên - LamNH23
	 * @param searchName
	 * @param page
	 * @param model
	 * @return
	 */
	@GetMapping("/search")
	public String searchMovieByName(@RequestParam(value = "searchName", required = true) String searchName,
			@RequestParam(name = "page", defaultValue = "0") int page, Model model) {
		// setup phân trang
		int noOfRecords = movieService.searchMovie(searchName).size();
		int recordsPerPage = 5;
		int noOfPages = (int) Math.ceil(noOfRecords * 1.0 / recordsPerPage);
		if (page < 1) {
			page = 1;
		} else if (page > noOfRecords) {
			page = noOfRecords;
		}
		int start = page > 0 ? page - 1 : 0;
		// get data theo phân trang
		List<Movie> list = movieService.getRecordsForCurrentPage2(searchName, (start) * recordsPerPage, recordsPerPage);
		model.addAttribute("searchName", searchName);
		model.addAttribute("noOfPages", noOfPages);
		model.addAttribute("currentPage", page);
		model.addAttribute("phimList", list);
		return "admin/quanLyPhim";
	}

	/**
	 * mở trang jsp thêm mới phim - LamNH23
	 * @param model
	 * @return
	 */
	@GetMapping(value = { "/addPhim" })
	public String addMovieJsp(Model model) {
		Movie movie = new Movie();
		movie.setMovieId("123456");
		model.addAttribute("phim", movie);
		model.addAttribute("text", "Thêm mới");
		model.addAttribute("text2", "Thêm mới");
		return "admin/addPhim";
	}

	/**
	 * thêm mới/update phim vào DB - LamNH23
	 * @param movie
	 * @param bindingResult
	 * @param model
	 * @return
	 */
	@PostMapping(value = { "/addPhim" })
	public String addMovie(@Valid @ModelAttribute("phim") Movie movie, BindingResult bindingResult, Model model) {
		// check valid
		try {
			if (movie.getEndDate().isBefore(movie.getStartDate()))
				bindingResult.rejectValue("endDate", "xxx", "Ngày kết thúc phải lớn hơn ngày khởi chiếu");
		} catch (Exception e) {

		}
		if (bindingResult.hasErrors()) {
			model.addAttribute("phim", movie);
			if (movie.getMovieId().equals("123456")) {
				model.addAttribute("text", "Thêm mới ");
				model.addAttribute("text2", "Thêm mới");
			} else {
				model.addAttribute("text", "Chi tiết");
				model.addAttribute("text2", "Thay đổi");
			}
			return "admin/addPhim";
		}
		// thêm mới hoặc updtate data
		if (movie.getMovieId().equals("123456")) {
			movie.setMovieId(UUID.randomUUID().toString());
		}
		movieService.save(movie);
		return "redirect:/admin/quanLyPhim";
	}

	/**
	 * mở trang jsp edit phim - LamNH23
	 * @param model
	 * @param id
	 * @return
	 */
	@GetMapping("/movie/{id}")
	public String editMovieJsp(Model model, @PathVariable("id") String id) {
		Movie movie = movieService.findById(id);
		model.addAttribute("phim", movie);
		model.addAttribute("text", "Chi tiết");
		model.addAttribute("text2", "Thay đổi");
		return "admin/addPhim";
	}

	/**
	 * xóa phim đã chọn - LamNH23
	 * @param movieId
	 * @param model
	 * @param redirectAttributes
	 * @return
	 */
	@PostMapping("/deletePhim")
	public String deleteMovie(@RequestParam String movieId, Model model, RedirectAttributes redirectAttributes) {
		try {
			movieService.deleteMV(Arrays.asList(movieId));
			redirectAttributes.addFlashAttribute("message", "Xóa phim thành công");
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("message", "Thất bại! Xóa suất chiếu có phim trước");
		}
		return "redirect:/admin/quanLyPhim";
	}
}
