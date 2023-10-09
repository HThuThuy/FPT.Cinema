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
/**
 * TicketApiController
 * 
 * Version 1.0
 * 
 * Date: 09-10-2023
 * 
 * Copyright
 * 
 * Modification Logs:
 * DATE         AUTHOR      DESCRIPTION
 * --------------------------------
 * 09-10-2023   THUYHTT14     Create
 */
@RestController
@RequestMapping("api")
public class TicketApiController {
	@Autowired
	private TheaterService theater;

	/**
	 * Project: FPT Cinema Team: 1 Author : ThuyHTT14 Method: Lấy thông tin suất
	 * chiếu, rạp và xử lý lưu dữ liệu vào database
	 * 
	 * @param city
	 * @return
	 */
	@PostMapping(value = "show-rap", produces = MediaType.APPLICATION_FORM_URLENCODED_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<TicketResponse> showRap(@Valid String city) {
		List<Theater> listaList = theater.getAll();
		List<Theater> listCity = theater.findByCity(city);
		TicketResponse response = new TicketResponse();
		response.setCityList(listCity);
		return new ResponseEntity<TicketResponse>(response, HttpStatus.OK);
	}

	/**
	 * Project: FPT Cinema Team: 1 Author : ThuyHTT14 Method: Lấy thông tin suất
	 * chiếu, rạp và xử lý lưu dữ liệu vào database
	 * 
	 * @param model
	 * @param selectedCity
	 * @return
	 */
	@GetMapping(value = { "/city" })
	public ResponseEntity<List<Theater>> showCity(Model model, @RequestParam("city") String selectedCity) {
		List<Theater> listCity = theater.findByCity(selectedCity);
		for (Theater theater : listCity) {
			System.out.println("abc" + theater);
		}
		return new ResponseEntity<>(listCity, HttpStatus.OK);
	}
}
