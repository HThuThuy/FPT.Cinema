package fa.training.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = { "/admin" })
public class AdminSuatChieuController {
	@GetMapping(value = { "/quanLySuatChieu" })
	public String admin() {
		return "admin/quanLySuatChieu";
	}
}

