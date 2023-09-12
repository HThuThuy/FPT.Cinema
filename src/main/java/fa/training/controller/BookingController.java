package fa.training.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value= {"/ticket"})
public class BookingController {
	@GetMapping(value= {"/booking"})
	public String ticket() {
		return "ticket/booking";
	}
}

