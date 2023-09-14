package fa.training.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import fa.training.model.Theater;
import fa.training.service.TheaterService;

@Controller
@RequestMapping(value= {"/ticket"})
public class TicketController {
	@Autowired
	private TheaterService theater;
	
	@GetMapping(value= {"/showtime"})
	public String ticket(Model model) {
		List<Theater> listaList= theater.getAll();
		for (Theater theaters : listaList) {
			System.out.println(theaters);
		}
		model.addAttribute("listTheater", theater.getAll());
		model.addAttribute("theaterAdd", new Theater());
		return "ticket/detailMovie";
	}
	@GetMapping(value= {"/bill"})
	public String bill() {
		return "ticket/bill";
	}
}

