package fa.training.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fa.training.model.Movie;
import fa.training.model.Seat;
import fa.training.model.Services;
import fa.training.model.Showtime;
import fa.training.service.SeatService;
import fa.training.service.SerService;
import fa.training.service.ShowtimeService;

/**
 * BookingController
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
@Controller
@RequestMapping(value = { "/ticket" })
public class BookingController {

	@Autowired
	private SeatService seat;

	@Autowired
	private SerService SerService;

	@Autowired
	private ShowtimeService showtime;

	/**
	 * Project: FPT Cinema Team: 1 Author : ThuyHTT14 Method: Lấy thông tin suất
	 * chiếu, rạp và xử lý lưu dữ liệu vào database
	 * @param model
	 * @param selectedShowtime
	 * @param session
	 * @return
	 */
	@GetMapping(value = { "/booking" })
	public String booking(Model model, @RequestParam("showtimeId") String selectedShowtime, HttpSession session) {

		model.addAttribute("seatAdd", new Seat());
		List<Services> list = SerService.getAll();
		System.out.println(list);
		for (Services services : list) {
			System.out.println(services.getServiceName());
		}
		model.addAttribute("lists", list);
		// Showtime
		Showtime getShowtime = showtime.findById(selectedShowtime);
		List<Seat> listaList = seat.getAllByRoomId(getShowtime.getRoom().getRoomId());
		model.addAttribute("listSeat", listaList);
		session.setAttribute("selectedShowtime", getShowtime);
		Movie movieChoose = (Movie) session.getAttribute("movieChoose");
		Showtime theaterSel = (Showtime) session.getAttribute("selectedShowtime");
		model.addAttribute("movieChoose", movieChoose);
		model.addAttribute("theaterSel", theaterSel);
		return "ticket/payment";
	}

}
