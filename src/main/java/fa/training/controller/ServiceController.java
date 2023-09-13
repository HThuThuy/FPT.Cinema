package fa.training.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value= {"/service"})
public class ServiceController {
	@GetMapping(value= {"/orderservice"})
	public String orderService() {
		return "services/orderService";
	}

}
