package fa.training.controller;

import java.util.List;

import org.springframework.ui.Model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import fa.training.model.Movie;
import fa.training.model.Promotion;
import fa.training.service.MovieService;
import fa.training.service.PromotionService;

@Controller
public class IndexController {
	@Autowired
	private MovieService movie;
	
	@Autowired
	private PromotionService promotion;
	
	@RequestMapping(value= {"/"})
	public String index(Model model) {
		List<Movie> listDangChieu = movie.getMovieDangChieu();
		for (Movie movies : listDangChieu) {
			System.out.println("Dang chieu---------------"+ movies.getMovieId());
		}
		model.addAttribute("listMovieDangChieu", listDangChieu);
		
		List<Movie> listSapChieu = movie.getMovieSapChieu();
		for (Movie movies2 : listSapChieu) {
			System.out.println("Sap chieu---------------"+ movies2.getMovieId());
		}
		model.addAttribute("listMovieSapChieu", listSapChieu);
		
		List<Promotion> listPromotion = promotion.getAll();
		for (Promotion movies3 : listPromotion) {
			System.out.println("Promotion---------------"+ movies3.getPromotionId());
		}
		model.addAttribute("listPromotion", listPromotion);
		
		return "home/movie";
	}
	
}

