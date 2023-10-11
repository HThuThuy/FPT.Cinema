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

	/**
	 * Project: FPT Cinema 
	 * Team: 1 
	 * Author : ThuyHTT14 
	 * Method: Lấy thông tin suất
	 * chiếu, rạp và xử lý lưu dữ liệu vào database
	 */
	@GetMapping(value = { "/showtime/{movieID}" })
	public String ticket(Model model, @PathVariable("movieID") String movieID, HttpSession session) {
        // Rạp 
		List<Theater> listaList = theater.getAll();
		for (Theater theaters : listaList) {
			System.out.println(theaters);
		}

		model.addAttribute("listTheater", theater.getAll());
		model.addAttribute("theaterAdd", new Theater());
		// String movieID = request.getParameter("movieID");
		System.out.println("MovieID:-----------" + movieID);
		Movie movieChoose = movie.findById(movieID);
		System.out.println("Movie:-----------" + movieChoose);
		model.addAttribute("movieChoose", movieChoose);
		// Movie
		String decription = movieChoose.getMovieDescription();
		System.out.println("decription:-----------" + decription);
		String actor = decription.substring(decription.indexOf("1.") + 2, decription.indexOf("2."));
		model.addAttribute("dienVien", actor);
		String genre = decription.substring(decription.indexOf("2.") + 2, decription.indexOf("3."));
		model.addAttribute("genre", genre);
		System.out.println("decription:-----------" + genre);
		String nation = decription.substring(decription.indexOf("3.") + 2, decription.indexOf("4."));
		model.addAttribute("nation", nation);

		String decript = decription.substring(decription.indexOf("4.") + 2, decription.indexOf("5."));
		model.addAttribute("mota2", decript);
		session.setAttribute("movieChoose", movieChoose);
		Customer loginCustomer = (Customer) session.getAttribute("customerLogin");

		System.out.println("customerLogin" + loginCustomer);

		return "ticket/detailMovie";
	}

	@ResponseBody
	@GetMapping(value = { "/theaterId" })
	public ResponseEntity<List<Showtime>> showTheater(Model model, @RequestParam("movieId") String selectedMovieId,
			@RequestParam("theaterId") String selectedTheater) {
		// Lấy suất chiếu theo pram nhận đc
		List<Showtime> shotimeList = showtime.getByMovieId(selectedMovieId, selectedTheater);

		for (Showtime showtime : shotimeList) {
			System.out.println(showtime);
		}
		return new ResponseEntity<>(shotimeList, HttpStatus.OK);
	}

	@GetMapping(value = { "/bill" })
	public String bill(Model model, HttpSession session) {
		System.out.println("bill");
		Movie movieChoose = (Movie) session.getAttribute("movieChoose");
		Showtime theaterSel = (Showtime) session.getAttribute("selectedShowtime");
		System.out.println("abcdef---------" + theaterSel);
		System.out.println("abc" + movieChoose);
		model.addAttribute("movieChoose", movieChoose);
		model.addAttribute("theaterSel", theaterSel);
		return "ticket/bill";
	}

}
