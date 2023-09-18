package fa.training.controller;

import java.util.List;
import java.util.Scanner;

import org.apache.taglibs.standard.tag.common.xml.IfTag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import fa.training.model.Seat;
import fa.training.model.Services;
import fa.training.service.SeatService;
import fa.training.service.SerService;

@Controller
@RequestMapping(value= {"/ticket"})
public class BookingController {
	
	@Autowired
	private SeatService seat;
	
	@Autowired
	private SerService SerService;
	
	@GetMapping(value= {"/booking"})
	public String booking(Model model) {
		List<Seat> listaList= seat.getAll();
		for (Seat seats : listaList) {
			System.out.println(seats.getSeatPositon());
		}
		model.addAttribute("listSeat", seat.getAll());
		model.addAttribute("seatAdd", new Seat());
		
		List<Services> list = SerService.getAll();
		System.out.println(list);
		for (Services services : list) {
			System.out.println(services.getServiceName());
		}
		model.addAttribute("lists", list);
		return "ticket/payment";
	}
	
	
}

