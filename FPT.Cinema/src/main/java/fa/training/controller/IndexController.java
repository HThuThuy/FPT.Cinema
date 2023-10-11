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
		model.addAttribute("listMovieDangChieu", listDangChieu);
		
		List<Movie> listSapChieu = movie.getMovieSapChieu();
		model.addAttribute("listMovieSapChieu", listSapChieu);
		
		List<Promotion> listPromotion = promotion.getAll();
		model.addAttribute("listPromotion", listPromotion);
		
		return "home/movie";
	}
	
}

