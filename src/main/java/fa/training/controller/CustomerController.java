package fa.training.controller;

import java.time.LocalDate;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import fa.training.DTO.CustomerDTO;
import fa.training.model.Customer;
import fa.training.service.CustomerService;
import fa.training.service.MovieService;
import fa.training.service.OrderService;
import fa.training.service.PromotionService;
import fa.training.service.ShowtimeService;
import fa.training.service.TicketService;

@Controller
@RequestMapping(value = "/customer")
public class CustomerController {
	@Autowired
	MovieService movieService;

	@Autowired
	CustomerService customerService;

	@Autowired
	OrderService orderService;

	@Autowired
	TicketService ticketService;

	@Autowired
	ShowtimeService showtimeService;

	@Autowired
	PromotionService promotionService;

	/**
	 * Project:FPT-Cinema
	 * Team 1
	 * @author TraNLC 
	 * Phương thức get thông tin Customer từ session
	 */
	private Customer getCustomerFromSession(HttpSession session) {
		Customer customer = (Customer) session.getAttribute("customerLogin");
		if (customer == null) {
			throw new RuntimeException("Không tìm thấy khách hàng");
		}
		return customer;
	}

	/**
	 * Project:FPT-Cinema
	 * Team 1
	 * @author TraNLC 
	 * Phương thức hiển thông tin đặt vé của khách hàng
	 * Mục đích: Hiển thị lịch sử đặt vé của khách hàng trong một khoảng thời gian cụ thể.
	 */
	@GetMapping(value = { "/history" })
	public String checkHistory(Model model,
			@RequestParam(value = "startDate", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
			@RequestParam(value = "endDate", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate,
			@RequestParam(name = "page", defaultValue = "1") int page, HttpSession session) {

		Customer customer = getCustomerFromSession(session);
		String cccd = customer.getCccd();

		Page<CustomerDTO> customerDTOPage = customerService.getRecordsForCurrentPage(cccd, startDate, endDate,
				PageRequest.of(page - 1, 5));

		model.addAttribute("historyList", customerDTOPage.getContent());
		model.addAttribute("noOfPages", customerDTOPage.getTotalPages());
		model.addAttribute("currentPage", page);

		return "customer/history";
	}

	/**
	 * Project:FPT-Cinema
	 * Team 1
	 * @author TraNLC 
	 * Phương thức cập nhật thông tin khách hàng
	 * Mục đích: Hiển thị thông tin của khách hàng hoặc cho phép khách hàng cập nhật thông tin cá nhân.
	 */
	@GetMapping("/{page:(?:info|update)}")
	public String showCustomerInfo(Model model, HttpSession session, @PathVariable String page) {
		Customer customer = getCustomerFromSession(session);
		String cccd = customer.getCccd();
		Customer customerFromDb = customerService.findById(cccd);

		if (customerFromDb != null) {
			model.addAttribute("customer", customerFromDb);
		} else {
			System.out.println("Không tìm thấy khách hàng"); // Consider using a logger here
		}
		return "customer/" + page;
	}

	/**
	 * Project:FPT-Cinema
	 * Team 1
	 * @author TraNLC 
	 * Phương thức hiện thị trang FAQ
	 * Mục đích: Hiển thị trang FAQ (Câu hỏi thường gặp).
	 */
	@GetMapping("/faq")
	public String showFaq(Model model) {

		return "customer/faq";
	}

	/**
	 * Project:FPT-Cinema
	 * Team 1
	 * @author TraNLC 
	 * Mục đích: Hiển thị trang cập nhật thông tin của khách hàng.
	 */
	@GetMapping("/update/{cccd}")
	public String updateCustomerInfo(Model model, @PathVariable("cccd") String cccd, HttpSession session) {
		session.setAttribute("cccd", cccd);
	    Customer customerUpdate = customerService.findById(cccd);              
	    System.out.println("customerUpdate"+customerUpdate);
	    
	    model.addAttribute("customerForm", customerUpdate);
	    return "customer/update"; 
	}

	/**
	 * Project:FPT-Cinema
	 * Team 1
	 * @author TraNLC 
	 * Phương thức cập nhật thông tin khách hàng
	 * Mục đích: Xử lý thông tin được cập nhật của khách hàng và lưu vào cơ sở dữ liệu.
	 */
	@PostMapping("/update")
	public String doPostUpdate(@Valid @ModelAttribute("customerForm") Customer customer, BindingResult result, RedirectAttributes redirectAttr) {
	    if (result.hasErrors()) {
	        for (ObjectError objectError : result.getAllErrors()) {
	            System.out.println(objectError);
	            System.out.println(objectError.getCode());
	        }
	        return "customer/update"; 
	    }
	    customerService.save(customer);
	    return "redirect:/customer/info";
	}

}