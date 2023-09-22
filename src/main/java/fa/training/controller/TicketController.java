package fa.training.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import fa.training.model.Theater;
import fa.training.service.MovieService;
import fa.training.service.TheaterService;

@Controller
@RequestMapping(value = { "/ticket" })
public class TicketController {
	@Autowired
	private TheaterService theater;
	
	@Autowired
	private MovieService movie;

	@GetMapping(value = { "/showtime" })
	public String ticket(Model model) {
		System.out.println("anđnjkadmmk");
		List<Theater> listaList = theater.getAll();
		for (Theater theaters : listaList) {
			//System.out.println(theaters);
		}

		model.addAttribute("listTheater", theater.getAll());
		model.addAttribute("theaterAdd", new Theater());
		return "ticket/detailMovie";
	}
	
	@PostMapping(value = "/showtime")
	public String handleRequest(HttpServletRequest request) {
	  // Lấy giá trị movieID từ yêu cầu
	  String movieID = request.getParameter("movieID");
	  System.out.println("abjhdjdsdk"+ movieID);
	return "ticket/detailMovie";

	  
	}
	
	@ResponseBody	
	@GetMapping(value = { "/city" })
	public ResponseEntity<List<Theater>> showCity(Model model, @RequestParam("city") String selectedCity) {
		try {
			List<Theater> listCity = theater.findByCity(selectedCity);
			for (Theater theater : listCity) {
				System.out.println("abc" + theater);
			}
			return new ResponseEntity<>(listCity, HttpStatus.OK);
		} catch(Exception ex) {
			  return ResponseEntity.status(500).build();
			}
	}

	@GetMapping(value = { "/bill" })
	public String bill() {
		return "ticket/bill";
	}

}
