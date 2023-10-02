package fa.training.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fa.training.model.Seat;
import fa.training.model.Services;
import fa.training.model.Showtime;
import fa.training.service.SeatService;
import fa.training.service.SerService;
import fa.training.service.ShowtimeService;

@Controller
@RequestMapping(value= {"/ticket"})
public class BookingController {
	
	@Autowired
	private SeatService seat;
	
	@Autowired
	private SerService SerService;
	
	@Autowired
	private ShowtimeService showtime;
	
	@GetMapping(value= {"/booking"})
	public String booking(Model model,@RequestParam("showtimeId") String selectedShowtime,HttpSession session) {
		List<Seat> listaList= seat.getAll();
//		for (Seat seats : listaList) {
//			System.out.println(seats.getSeatPositon());
//		}
		model.addAttribute("listSeat", seat.getAll());
		model.addAttribute("seatAdd", new Seat());
		
		List<Services> list = SerService.getAll();
		System.out.println(list);
		for (Services services : list) {
			System.out.println(services.getServiceName());
		}
		model.addAttribute("lists", list);
		System.out.println("Id--------"+selectedShowtime);
		//Showtime
        Showtime getShowtime = showtime.findById(selectedShowtime);
         System.out.println("Showtime---------------------"+ getShowtime);
         session.setAttribute("selectedShowtime", getShowtime);
		return "ticket/payment";
	}
	
	
}

