package fa.training.controller;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.validation.Valid;

import org.apache.tiles.autotag.core.runtime.annotation.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
import org.springframework.web.bind.annotation.ResponseBody;
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

/**
 * AdminShowTimeController
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
public class AdminShowTimeController {

	@Autowired
	private ShowtimeService showtimeService;

	@Autowired
	private MovieService movieService;

	@Autowired
	private RoomService roomService;

	@Autowired
	private TheaterService theaterService;

	/**
	 * hiện tất cả suất chiếu trong DB - LamNH23
	 * @param model
	 * @param page
	 * @return
	 */
	@GetMapping(value = { "/quanLySuatChieu" })
	public String getListShowtime(Model model, @RequestParam(name = "page", defaultValue = "0") int page) {
		// setup phân trang
		int noOfRecords = showtimeService.getAll().size();
		int recordsPerPage = 5;
		int noOfPages = (int) Math.ceil(noOfRecords * 1.0 / recordsPerPage);
		if (page < 1) {
			page = 1;
		} else if (page > noOfRecords) {
			page = noOfRecords;
		}
		int start = page > 0 ? page - 1 : 0;
		// get data theo phân trang
		List<Showtime> list = showtimeService.getRecordsForCurrentPage((start) * recordsPerPage, recordsPerPage);
		model.addAttribute("noOfPages", noOfPages);
		model.addAttribute("currentPage", page);
		model.addAttribute("suatchieuList", list);
		return "admin/quanLySuatChieu";
	}

	/**
	 * mở trang jsp thêm mới suất chiếu - LamNH23 
	 * @param model
	 * @return
	 */
	@GetMapping(value = { "/addSuatChieu" })
	public String addShowtimeJsp(Model model) {
		List<Movie> list = movieService.getAllEnable();
		model.addAttribute("movies", list);
		List<Theater> list2 = theaterService.getAll();
		model.addAttribute("theaters", list2);
		model.addAttribute("suatChieu", new QLShowTimeDTO());
		model.addAttribute("text", "Thêm mới");
		model.addAttribute("text2", false);
		return "admin/addSuatChieu";
	}

	/**
	 * thêm mới suất chiếu vào DB - LamNH23
	 * @param qlShowTimeDTO
	 * @param bindingResult
	 * @param model
	 * @return
	 */
	@PostMapping(value = { "/addSuatChieu" })
	public String addShowtime(@Valid @ModelAttribute("suatChieu") QLShowTimeDTO qlShowTimeDTO,
			BindingResult bindingResult, Model model) {
		// check valid
		if (bindingResult.hasErrors()) {
			List<Movie> list = movieService.getAllEnable();
			model.addAttribute("movies", list);
			List<Theater> list2 = theaterService.getAll();
			model.addAttribute("theaters", list2);
			model.addAttribute("suatChieu", qlShowTimeDTO);
			model.addAttribute("text", "Thêm mới ");
			model.addAttribute("text2", false);
			return "admin/addSuatChieu";
		}
		// thêm mới hoặc updtate data
		Movie movie = movieService.findById(qlShowTimeDTO.getMovieId());
		Room room = roomService.findById(qlShowTimeDTO.getRoomId());
		if (qlShowTimeDTO.getShowtimeId().equals("123456")) {
			qlShowTimeDTO.setShowtimeId(UUID.randomUUID().toString());
		}
		Showtime showtime = new Showtime(qlShowTimeDTO.getShowtimeId(), movie, room, qlShowTimeDTO.getStartTime());
		showtimeService.save(showtime);
		return "redirect:/admin/quanLySuatChieu";
	}

	/**
	 * mở trang jsp edit suất chiếu - LamNH23
	 * @param model
	 * @param id
	 * @return
	 */
	@GetMapping("/{id}")
	public String editShowtime(Model model, @PathVariable("id") String id) {
		// lấy data
		Showtime showtime = showtimeService.findById(id);
		// gán data cho DTO
		QLShowTimeDTO qlShowTimeDTO = new QLShowTimeDTO();
		qlShowTimeDTO.setShowtimeId(showtime.getShowtimeId());
		Room room = showtime.getRoom();
		Movie movie = showtime.getMovie();
		qlShowTimeDTO.setTheaterId(room.getTheater().getTheaterId());
		qlShowTimeDTO.setRoomId(room.getRoomId());
		qlShowTimeDTO.setStartTime(showtime.getStartTime());
		qlShowTimeDTO.setMovieId(showtime.getMovie().getMovieId());
		model.addAttribute("suatChieu", qlShowTimeDTO);
		model.addAttribute("theaterName", room.getTheater().getTheaterName());
		model.addAttribute("roomName", room.getRoomName());
		model.addAttribute("startTime", showtime.getStartTime());
		List<Movie> list = movieService.getAllEnable();
		model.addAttribute("movies", list);
		model.addAttribute("selectedMovie", movie.getMovieId());
		return "admin/editSuatChieu";
	}

	/**
	 * xóa suất chiếu đã chọn - LamNH23
	 * @param showtimeId
	 * @param model
	 * @param redirectAttributes
	 * @return
	 */
	@PostMapping("/delete")
	public String deleteShowtime(@RequestParam String showtimeId, Model model, RedirectAttributes redirectAttributes) {
		try {
			showtimeService.deleteST2(Arrays.asList(showtimeId));
			redirectAttributes.addFlashAttribute("message", "Xóa suất chiếu thành công");
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("message", "Thất bại! Suất chiếu hiện đã được đặt vé");
		}
		return "redirect:/admin/quanLySuatChieu";
	}

	/**
	 * hiện danh sách room khi chọn rạp - LamNH23
	 * @param model
	 * @param theaterId
	 * @return
	 */
	@ResponseBody
	@GetMapping(value = { "/theater" })
	public ResponseEntity<List<Room>> showRoom(Model model, @RequestParam("theater") String theaterId) {
		List<Room> list = roomService.getAllByTheater(theaterId);
		return new ResponseEntity<List<Room>>(list, HttpStatus.OK);
	}

	/**
	 * hiện danh sách giờ chiếu khi chọn room - LamNH23
	 * @param model
	 * @param roomId
	 * @return
	 */
	@ResponseBody
	@GetMapping(value = { "/room" })
	public ResponseEntity<List<String>> showTime(Model model, @RequestParam("room") String roomId) {
		List<String> list1 = new ArrayList<>(Arrays.asList("09:00", "12:00", "15:00", "18:00", "21:00"));
		List<String> list = showtimeService.getTimeByRoom(roomId);
		list1.removeAll(list);
		return new ResponseEntity<List<String>>(list1, HttpStatus.OK);
	}
}
