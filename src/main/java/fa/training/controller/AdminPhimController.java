package fa.training.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = { "/admin" })
public class AdminPhimController {
	
	@GetMapping(value = { "/quanLyPhim" })
	public String admin() {
		return "admin/quanLyPhim";
	}
	
	@GetMapping(value = { "/addPhim" })
	public String admin2() {
		return "admin/addPhim";
	}
	
	@PostMapping(value = { "/addPhim" })
	public String admin4() {
		
		return "redirect:/admin/quanLyPhim";
	}
	
	
	@GetMapping(value = { "/searchPhim" })
	public String admin3() {
		return "admin/addPhim";
	}
	
	
}

