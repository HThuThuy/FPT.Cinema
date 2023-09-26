package fa.training.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import fa.training.model.Customer;
import fa.training.model.Movie;
import fa.training.model.Showtime;
import fa.training.model.Theater;
import fa.training.service.MovieService;
import fa.training.service.ShowtimeService;
import fa.training.service.TheaterService;

@Controller
@RequestMapping(value = { "/ticket" })
public class TicketController {
	@Autowired
	private TheaterService theater;

	@Autowired
	private MovieService movie;
	
	@Autowired
	private ShowtimeService showtime;

	@GetMapping(value = { "/showtime/{movieID}" })
	public String ticket(Model model, @PathVariable("movieID") String movieID, HttpSession session) {

		List<Theater> listaList = theater.getAll();
		for (Theater theaters : listaList) {
			System.out.println(theaters);
		}

		model.addAttribute("listTheater", theater.getAll());
		model.addAttribute("theaterAdd", new Theater());
	//	String movieID = request.getParameter("movieID");
		System.out.println("MovieID:-----------" + movieID);
		Movie movieChoose = movie.findById(movieID);
		 System.out.println("Movie:-----------"+ movieChoose);
		model.addAttribute("movieChoose", movieChoose);
		
		
		Customer loginCustomer = (Customer)session.getAttribute("custerLogin");

		System.out.println("custerLogin"+loginCustomer);
		
		//List<Showtime> shotimeList= showtime.getByMovieId(movieID, theaterId);
		
		
		return "ticket/detailMovie";
	}

	@ResponseBody	
	@GetMapping(value = { "/theaterId" })
	public ResponseEntity<List<Showtime>> showTheater(Model model,@RequestParam("movieId") String selectedMovieId, @RequestParam("theaterId") String selectedTheater) {
		
		List<Showtime> shotimeList= showtime.getByMovieId(selectedMovieId, selectedTheater);
		
		for (Showtime showtime : shotimeList) {
			System.out.println(showtime);
		}
		return new ResponseEntity<>(shotimeList, HttpStatus.OK);
	}

	@GetMapping(value = { "/bill" })
	public String bill() {
		return "ticket/bill";
	}

}
