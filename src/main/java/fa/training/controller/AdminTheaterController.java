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

import fa.training.model.Room;
import fa.training.model.Theater;
import fa.training.service.RoomService;
import fa.training.service.TheaterService;

@Controller
@RequestMapping(value = { "/admin" })
public class AdminTheaterController {
	
	@Autowired
	TheaterService theaterService;
	
	@Autowired
	RoomService roomService;
	
	/**
	 * Project: FPT Cinema Team: 2 Author :LamNH23 Method: Hiện tất cả rạp trong DB
	 */
	@GetMapping(value = { "/quanLyRap" })
	public String admin(Model model, @RequestParam(name = "page", defaultValue = "0") int page) {
		//setup phân trang
		int noOfRecords = theaterService.getAll().size();
		int recordsPerPage = 5;
		int noOfPages = (int) Math.ceil(noOfRecords * 1.0 / recordsPerPage);
		if (page < 1) {
			page = 1;
		} else if (page > noOfRecords) {
			page = noOfRecords;
		}
		int start = page > 0 ? page - 1 : 0;
		//get data theo phân trang
		List<Theater> list = theaterService.getAll();
		model.addAttribute("rapList", list);
		return "admin/quanLyRap";
	}
	
	/**
	 * Project: FPT Cinema Team: 2 Author :LamNH23 Method: Mở trang jsp thêm mới rạp
	 */
	@GetMapping(value = { "/addRap" })
	public String admin2(Model model) {
		Theater theater = new Theater();
		theater.setTheaterId("123456");
		model.addAttribute("rap",theater );
		model.addAttribute("text", "Thêm mới");
		return "admin/addRap";
	}
	
	/**
	 * Project: FPT Cinema Team: 2 Author :LamNH23 Method: Thêm mới/update rạp vào DB
	 */
	@PostMapping(value = { "/addRap" })
	public String admin4(@Valid @ModelAttribute("rap") Theater theater,
			BindingResult bindingResult, Model model) {
		
		//check valid
		if(bindingResult.hasErrors()) {			
			model.addAttribute("rap", theater);
			if(theater.getTheaterId().equals("123456"))
			model.addAttribute("text", "Thêm mới ");
			else model.addAttribute("text", "Thay đổi");
			return "admin/addRap";
		}
		
		//thêm mới hoặc updtate data		
		if(theater.getTheaterId().equals("123456")) {
			theater.setTheaterId(UUID.randomUUID().toString());
			
			theaterService.save(theater);
			
			Room room = new Room();
			room.setRoomId(theater.getTheaterId()+"A");
			room.setRoomName("Phòng nhỏ");
			room.setSeatNumber(60);
			room.setTheater(theater);
			roomService.save(room);
			
			Room room2 = new Room();
			room2.setRoomId(theater.getTheaterId()+"B");
			room2.setRoomName("Phòng lớn");
			room2.setSeatNumber(80);
			room2.setTheater(theater);
			roomService.save(room2);
		} else {			
			theaterService.save(theater);
		}
		
		return "redirect:/admin/quanLyRap";
	}
	
	/**
	 * Project: FPT Cinema Team: 2 Author :LamNH23 Method: Mở trang jsp edit rạp
	 */
	@GetMapping("/theater/{id}")
	public String admin5(Model model, @PathVariable("id") String id) {
		Theater theater = theaterService.findById(id);
		model.addAttribute("rap", theater);		
		model.addAttribute("text", "Thay đổi");
		model.addAttribute("selectedCity", theater.getCity());
		return "admin/addRap";
	}	
	
	/**
	 * Project: FPT Cinema Team: 2 Author :LamNH23 Method: Xóa rạp đã chọn
	 */
	@PostMapping("/deleteRap")
	public String admin6(@RequestParam String theaterId,  Model model, RedirectAttributes redirectAttributes) {
		
		try {
			roomService.deleteRoom(Arrays.asList(theaterId+"A",theaterId+"B"));
			theaterService.deleteTT(Arrays.asList(theaterId));
			redirectAttributes.addFlashAttribute("message", "Xóa rạp thành công");
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("message", "Thất bại! Xóa suất chiếu có rạp trước");
		}
		
		return "redirect:/admin/quanLyRap";
	}	
}

