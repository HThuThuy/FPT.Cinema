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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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

	@GetMapping(value = { "/history" })
	public String checkHistory(Model model,
			@RequestParam(value = "startDate", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
			@RequestParam(value = "endDate", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate,
			@RequestParam(name = "page", defaultValue = "1") int page, HttpSession session) {

		Customer customer = (Customer) session.getAttribute("customerLogin");
		String cccd = customer.getCccd();

		Page<CustomerDTO> customerDTOPage = customerService.getRecordsForCurrentPage(cccd, startDate, endDate,
				PageRequest.of(page - 1, 5));

		model.addAttribute("historyList", customerDTOPage.getContent());
		model.addAttribute("noOfPages", customerDTOPage.getTotalPages());
		model.addAttribute("currentPage", page);

		return "customer/history";
	}

	@GetMapping("/info")
	public String showCustomerInfo(Model model, HttpSession session) {
		Customer customer2 = (Customer) session.getAttribute("customerLogin");
		String cccd2 = customer2.getCccd();
		System.out.println("cccd là" + cccd2);

		Customer customer1 = customerService.findById(cccd2);

		if (customer1 != null) {
			model.addAttribute("customer", customer1);
		} else {
			System.out.println("Không tìm thấy khách hàng");
		}

		return "customer/info";
	}

	@GetMapping("/update")
	public String showCustomerInfo2(Model model, HttpSession session) {
		Customer customer = (Customer) session.getAttribute("customerLogin");
		String cccd = customer.getCccd();
		System.out.println("cccd là" + cccd);

		Customer customer1 = customerService.findById(cccd);

		if (customer1 != null) {
			model.addAttribute("customer", customer1);
		} else {
			System.out.println("Không tìm thấy khách hàng");
		}

		return "customer/update";
	}

	@GetMapping("/faq")
	public String showFaq(Model model) {

		return "customer/faq";
	}

	/**
	 * Project: FPT-Cinema Team: 1 Author : Tranlc update thông tin khách hàng,
	 * check validate
	 */

	@PostMapping("/update")
	public String updateCustomerInfo(@RequestParam("cccd") String cccd, @RequestParam("phone") String phone,
			@RequestParam("address") String address, @RequestParam("email") String email, Model model,
			@Valid @ModelAttribute("customer") Customer customer, BindingResult result, RedirectAttributes redirectAttr,
			HttpSession session) {

		Customer customerupdate = (Customer) session.getAttribute("customerLogin");
		String cccdUpdate = customerupdate.getCccd();
		LocalDate birthDate = customerupdate.getBirthDate();
		String customerName = customerupdate.getCustomerName();
		String gender = customerupdate.getGender();

		session.setAttribute("cccd", cccdUpdate);
		session.setAttribute("birthDate", birthDate);
		session.setAttribute("customerName", customerName);
		session.setAttribute("gender", gender);

		Customer existingCustomerByPhone = customerService.findByPhone(phone);
		Customer existingCustomerByEmail = customerService.findByEmail(email);

		if (existingCustomerByPhone != null && !existingCustomerByPhone.getCccd().equals(cccd)) {
			result.rejectValue("phone", "exist",
					"Số điện thoại đã tồn tại trong hệ thống, vui lòng kiểm tra lại hoặc chọn lại số khác!");
			return "customer/update";
		}

		if (existingCustomerByEmail != null && !existingCustomerByEmail.getCccd().equals(cccd)) {
			result.rejectValue("email", "exist",
					"Email đã tồn tại trong hệ thống, vui lòng kiểm tra lại hoặc chọn lại email khác!");
			return "customer/update";
		}
		Customer updatedCustomer = customerService.updateCustomerInfo(cccd, phone, address, email);

		if (updatedCustomer != null) {
			System.out.println("Lưu thành công thông tin khách hàng");
		} else {
			System.out.println("Lưu Không thành công thông tin khách hàng");
		}
		return "redirect:/customer/info";
	}
}

//
//	@RequestMapping("/khuyenmaiinfo")
//	public String myHandler(Model model) {
//		model.addAttribute("allKM", khuyenMaiService.findAll());
//		return "/khachhang/KM00001"; // Trả về tên của tệp JSP mà bạn muốn hiển thị
//	}
//}
