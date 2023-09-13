package fa.training.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = { "/admin" })
public class AdminPhimController {
	@GetMapping(value = { "/quanLyPhim" })
	public String admin() {
		return "admin/quanLyPhim";
	}
}

