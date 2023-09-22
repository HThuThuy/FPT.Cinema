package fa.training.controller;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.apache.tiles.autotag.core.runtime.annotation.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
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
import fa.training.service.RoomService;
import fa.training.service.ShowtimeService;
import fa.training.service.TheaterService;
import fa.training.service.TicketService;

@Controller
@RequestMapping(value = { "/admin" })
public class AdminSuatChieuController {
	
	@Autowired
	private ShowtimeService showtimeService;
	
	@Autowired
	private MovieService movieService;
	
	@Autowired
	private RoomService roomService;
	
	@Autowired
	private TheaterService theaterService;
	
	@GetMapping(value = { "/quanLySuatChieu" })
	public String admin(Model model, @RequestParam(name = "page", defaultValue = "0") int page) {
		
//		int noOfRecords = 20; 
		int noOfRecords =showtimeService.getAll().size();
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
	
	@GetMapping("/search")
	public String admin2(
			@RequestParam(value = "searchName", required = true) String searchName,
			@RequestParam(name = "page", defaultValue = "0") int page, Model model
	) {
		
		int noOfRecords = showtimeService.getRecordsForSearch("searchName");
		int recordsPerPage = 5;
		int noOfPages = (int) Math.ceil(noOfRecords * 1.0 / recordsPerPage);
		if (page < 1) {
			page = 1;
		} else if (page > noOfRecords) {
			page = noOfRecords;
		}
		int start = page > 0 ? page - 1 : 0;
		
		List<Showtime> list = showtimeService.getRecordsForCurrentPage2((start) * recordsPerPage, recordsPerPage);
		
		model.addAttribute("noOfPages", noOfPages);
		model.addAttribute("currentPage", page);
		model.addAttribute("suatchieuList", list);
		return "admin/quanLySuatChieu";
	}
	
	@GetMapping(value = { "/addSuatChieu" })
	public String admin3(Model model) {
		List<Movie> list = movieService.getAllEnable();
		model.addAttribute("movies", list);
		List<Room> list2 = roomService.getAll();
		model.addAttribute("rooms", list2);
		model.addAttribute("suatChieu", new QLShowTimeDTO());
		model.addAttribute("text", "Thêm mới: ");
		model.addAttribute("text2", false);
		return "admin/addSuatChieu";
	}
	
	@PostMapping(value = { "/addSuatChieu" })
	public String admin4(@Valid @ModelAttribute("suatChieu") QLShowTimeDTO qlShowTimeDTO,
			BindingResult bindingResult, Model model) {
		System.out.print("Suất chiếu: " + qlShowTimeDTO);
		
		//check valid
		if(bindingResult.hasErrors()) {
			List<Movie> list = movieService.getAllEnable();
			model.addAttribute("movies", list);
			List<Room> list2 = roomService.getAll();
			model.addAttribute("rooms", list2);
			model.addAttribute("suatChieu", qlShowTimeDTO);
			model.addAttribute("text", "Thêm mới: ");
			model.addAttribute("text2", false);
			return "admin/addSuatChieu";
		}
		
		//thêm mới hoặc updtate data
		Movie movie = movieService.findById(qlShowTimeDTO.getMovieId());
		Room room = roomService.findById(qlShowTimeDTO.getRoomId());		
		Showtime showtime = new Showtime(qlShowTimeDTO.getShowtimeId(),movie,room, qlShowTimeDTO.getStartTime());
		showtimeService.save(showtime);
		
		return "redirect:/admin/quanLySuatChieu";
	}
	
	@GetMapping("/{id}")
	public String admin5(Model model, @PathVariable("id") String id) {
		//lấy data
//		Showtime showtime = showtimeService.findById(id);
		QLShowTimeDTO qlShowTimeDTO = new QLShowTimeDTO(id,"MV001", "R003",LocalDate.of(2023, 10, 5),LocalTime.of(12, 02));
//		qlShowTimeDTO.setShowtimeId(showtime.getShowtimeId());
//		qlShowTimeDTO.setMovieId(showtime.getMovie().getMovieId());
//		qlShowTimeDTO.setTheaterId(showtime.getTheater().getTheaterId());
//		qlShowTimeDTO.setRoomId(showtime.getRoom().getRoomId());
//		qlShowTimeDTO.setStartTime(showtime.getStartTime());
		
		List<Theater> list = theaterService.getRecordsForCurrentPage(0, 0);
		model.addAttribute("theaters", list);
		model.addAttribute("suatChieu", qlShowTimeDTO);
		model.addAttribute("text", "Thay đổi: ");
		model.addAttribute("text2", true);
		return "admin/addSuatChieu";
	}	
	
	@PostMapping("/delete")
	public String admin6(@RequestParam String showtimeId,  Model model, RedirectAttributes redirectAttributes) {
		System.out.print("Xóa Suất chiếu: " + showtimeId);
		showtimeService.deleteById(showtimeId);
		redirectAttributes.addFlashAttribute("message", "Xóa thành công !");
		return "redirect:/admin/quanLySuatChieu";
	}	
}

