package fa.training.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = { "/admin" })
public class AdminSuatChieuController {
	
	@GetMapping(value = { "/quanLySuatChieu" })
	public String admin() {
		return "admin/quanLySuatChieu";
	}
	
	@GetMapping(value = { "/addSuatChieu" })
	public String admin2() {
		return "admin/addSuatChieu";
	}
	
	@PostMapping(value = { "/addSuatChieu" })
	public String admin4() {
		
		return "redirect:/admin/quanLySuatChieu";
	}
	
	@GetMapping(value = { "/searchSuatChieu" })
	public String admin3() {
		return "admin/addSuatChieu";
	}
}

