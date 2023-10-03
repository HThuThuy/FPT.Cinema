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

import fa.training.DTO.QLShowTimeDTO;
import fa.training.DTO.ShowTimeDTO;
import fa.training.model.Movie;
import fa.training.model.Room;
import fa.training.model.Showtime;
import fa.training.model.Theater;
import fa.training.service.MovieService;

@Controller
@RequestMapping(value = { "/admin" })
public class AdminPhimController {
	
	@Autowired
	MovieService movieService;
	
	/**
	 * Project: FPT Cinema Team: 2 Author :LamNH23 Method: Hiện tất cả phim trong DB
	 */
	@GetMapping(value = { "/quanLyPhim" })
	public String admin(Model model, @RequestParam(name = "page", defaultValue = "0") int page) {
		//setup phân trang
		int noOfRecords = movieService.getAll().size();
		int recordsPerPage = 5;
		int noOfPages = (int) Math.ceil(noOfRecords * 1.0 / recordsPerPage);
		if (page < 1) {
			page = 1;
		} else if (page > noOfRecords) {
			page = noOfRecords;
		}
		int start = page > 0 ? page - 1 : 0;
		//get data theo phân trang
		List<Movie> list = movieService.getRecordsForCurrentPage((start) * recordsPerPage, recordsPerPage);
		model.addAttribute("noOfPages", noOfPages);
		model.addAttribute("currentPage", page);
		model.addAttribute("phimList", list);
		
		return "admin/quanLyPhim";
	}
	
	/**
	 * Project: FPT Cinema Team: 2 Author :LamNH23 Method: Tìm kiếm phim trong DB theo tên
	 */
	@GetMapping("/search")
	public String admin2(
			@RequestParam(value = "searchName", required = true) String searchName,
			@RequestParam(name = "page", defaultValue = "0") int page, Model model
	) {
		//setup phân trang
		int noOfRecords = movieService.searchMovie(searchName).size();
		int recordsPerPage = 5;
		int noOfPages = (int) Math.ceil(noOfRecords * 1.0 / recordsPerPage);
		if (page < 1) {
			page = 1;
		} else if (page > noOfRecords) {
			page = noOfRecords;
		}
		int start = page > 0 ? page - 1 : 0;
		//get data theo phân trang
		List<Movie> list = movieService.getRecordsForCurrentPage2(searchName,(start) * recordsPerPage, recordsPerPage);
		model.addAttribute("searchName", searchName);
		model.addAttribute("noOfPages", noOfPages);
		model.addAttribute("currentPage", page);
		model.addAttribute("phimList", list);
		return "admin/quanLyPhim";
	}
	
	/**
	 * Project: FPT Cinema Team: 2 Author :LamNH23 Method: Mở trang jsp thêm mới phim
	 */
	@GetMapping(value = { "/addPhim" })
	public String admin2(Model model) {
		Movie movie = new Movie();
		movie.setMovieId("123456");
		model.addAttribute("phim",movie );
		model.addAttribute("text", "Thêm mới");
		model.addAttribute("text2", "Thêm mới");
		return "admin/addPhim";
	}
	
	/**
	 * Project: FPT Cinema Team: 2 Author :LamNH23 Method: Thêm mới/update phim vào DB
	 */
	@PostMapping(value = { "/addPhim" })
	public String admin4(@Valid @ModelAttribute("phim") Movie movie,
			BindingResult bindingResult, Model model) {
		
		//check valid
		try {
			if(movie.getEndDate().isBefore(movie.getStartDate()))
			bindingResult.rejectValue("endDate", "xxx", "Ngày kết thúc phải lớn hơn ngày khởi chiếu");
		} catch (Exception e) {
			
		}		
		
		if(bindingResult.hasErrors()) {			
			model.addAttribute("phim", movie);
			if(movie.getMovieId().equals("123456")) {
				model.addAttribute("text", "Thêm mới ");
				model.addAttribute("text2", "Thêm mới");
			} else {
				model.addAttribute("text", "Chi tiết");
				model.addAttribute("text2", "Thay đổi");
			}
			
			return "admin/addPhim";
		}		
		
		//thêm mới hoặc updtate data		
		if (movie.getMovieId().equals("123456")) {
			movie.setMovieId(UUID.randomUUID().toString());
		}			
		movieService.save(movie);
		
		return "redirect:/admin/quanLyPhim";
	}
	
	/**
	 * Project: FPT Cinema Team: 2 Author :LamNH23 Method: Mở trang jsp edit phim
	 */
	@GetMapping("/movie/{id}")
	public String admin5(Model model, @PathVariable("id") String id) {
		Movie movie = movieService.findById(id);
		model.addAttribute("phim", movie);		
		model.addAttribute("text", "Chi tiết");	
		model.addAttribute("text2", "Thay đổi");	
		return "admin/addPhim";
	}	
	
	/**
	 * Project: FPT Cinema Team: 2 Author :LamNH23 Method: Xóa phim đã chọn
	 */
	@PostMapping("/deletePhim")
	public String admin6(@RequestParam String movieId,  Model model, RedirectAttributes redirectAttributes) {

		try {
			movieService.deleteMV(Arrays.asList(movieId));
			redirectAttributes.addFlashAttribute("message", "Xóa phim thành công");
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("message", "Thất bại! Xóa suất chiếu có phim trước");
		}
		
		return "redirect:/admin/quanLyPhim";
	}	
}

