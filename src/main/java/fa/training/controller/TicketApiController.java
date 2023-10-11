package fa.training.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fa.training.model.Theater;
import fa.training.response.TicketResponse;
import fa.training.service.TheaterService;

@RestController
@RequestMapping("api")
/**
 * Project: FPT Cinema 
 * Team: 1 
 * Author : ThuyHTT14 
 * Method: Lấy thông tin suất
 * chiếu, rạp và xử lý lưu dữ liệu vào database
 */
public class TicketApiController {
	@Autowired
	private TheaterService theater;

	@PostMapping(value = "show-rap", produces = MediaType.APPLICATION_FORM_URLENCODED_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<TicketResponse> showRap(@Valid String city) {
		List<Theater> listaList = theater.getAll();
		for (Theater theaters : listaList) {
			System.out.println(theaters);
		}

		List<Theater> listCity = theater.findByCity(city);
		for (Theater theater : listCity) {
			System.out.println("abc" + theater);
		}

		TicketResponse response = new TicketResponse();
		response.setCityList(listCity);

		// model.addAttribute("listTheater", listCity); // Thay đổi thành listCity để
		// hiển thị danh sách rạp chiếu phim
//														// theo thành phố đã chọn
//		model.addAttribute("listCity", listaList); // Thay đổi thành listaList để hiển thị danh sách thành phố trong
//													// dropdown
//		model.addAttribute("theaterAdd", new Theater());
		return new ResponseEntity<TicketResponse>(response, HttpStatus.OK);
	}
	
	@GetMapping(value = { "/city" })
	public ResponseEntity<List<Theater>> showCity(Model model, @RequestParam("city") String selectedCity) {
		List<Theater> listCity = theater.findByCity(selectedCity);
		for (Theater theater : listCity) {
			System.out.println("abc" + theater);
		}
		return new ResponseEntity<>(listCity, HttpStatus.OK);
	}
}
