package fa.training.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import fa.training.service.SerService;
import fa.training.model.Services;

@Controller
@RequestMapping(value= {"/service"})
public class ServiceController {
	private static final int PAGE_SIZE = 5;
	
	@Autowired
	private SerService SerService;
	
	@GetMapping("/orderservice")
	public String display(Model model, @RequestParam(defaultValue = "0") int page) {
		List<Services> list = SerService.getAll();
		System.out.println(list);
		for (Services services : list) {
			System.out.println(services.getServiceName());
		}
		model.addAttribute("lists", list);

		return "services/orderService";
	}

}
