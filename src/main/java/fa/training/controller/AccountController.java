package fa.training.controller;

import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import fa.training.DTO.InsertRegister;
import fa.training.DTO.ResetPassword;
import fa.training.model.Customer;
import fa.training.model.Users;
import fa.training.service.CustomerService;
import fa.training.service.EmailService;
import fa.training.service.UserService;

@Controller
@RequestMapping("/account")
public class AccountController {

	@Autowired
	private UserService userService;

	@Autowired
	private CustomerService customerService;

	@Autowired
	EmailService emailService;

	@Autowired
	PasswordEncoder passEncode;

	/**
	 * Project: FPT-Cinema Team: 1 Author : TraNLC Function/Class/JSP : thêm tài
	 * khoản
	 */
	@GetMapping("/add")
	public String showAddForm(Model model) {
		model.addAttribute("UserForm", new Users());
		return "/home/registerModal";
	}

	/**
	 * Project: FPT-Cinema Team: 1 Author : TraNLC Function/Class/JSP : lưu tài
	 * khoản
	 */
	@PostMapping("/save")
	public String saveNewAccount(@ModelAttribute("UserForm") @Valid Users users, BindingResult result) {
		if (result.hasErrors()) {
			return "/home/registerModal";
		}
		users.setPassword(passEncode.encode(users.getPassword()));
		userService.save(users);
		return "redirect:home/loginModal";
	}

	@RequestMapping("/update/{cccd}")
	public String update(@PathVariable(name = "cccd") String TaiKhoanId, Model model) {
		Users users = userService.findById(TaiKhoanId);
		model.addAttribute("UserForm", users);
		return "/home/registerModal";
	}

	/**
	 * Project: FPT-Cinema 
	 * Team: 1 
	 * Author : TraNLC Function/Class/JSP : Reset mật khẩu
	 */
	@GetMapping("/resetpass")
	public String getChangePass(HttpSession session, Model model) {
		if (checkSession(session) == true) {
			return "/home/resetPasswordModal";
		} else {
			model.addAttribute("messageAccount", "Bạn Đã Đăng Xuất, Vui Lòng Đăng Nhập Lại Để Đổi Mật Khẩu!");
			return "/home/loginModal";
		}
	}

	/**
	 * Project: FPT-Cinema Author : TraNLC Team: 1 Function/Class/JSP : Đổi mật khẩu
	 */
	@PostMapping("/resetpass")
	public String postChangePass(@ModelAttribute("Resetpass") ResetPassword rs, HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session = request.getSession();
		Users user = userService.findByAccountAndPassword(rs.getAccount(), rs.getOldpassword());

		if (user != null) {
			if (rs.getOldpassword().equals(rs.getPassword())) {
				request.setAttribute("loggedInUser", session.getAttribute("loggedInUser"));
				request.setAttribute("messagePassword", "Mật Khẩu Mới Không Được Trùng Với Mật Khẩu Cũ !");
				return "/home/resetPasswordModal";
			}
			if (!checkRequest(request)) {
				request.setAttribute("messageAccount", "Bạn Đã Đăng Xuất, Vui Lòng Đăng Nhập Lại Để Đổi Mật Khẩu!");
				return "/home/login";
			}
			userService.updatePass(rs.getAccount(), rs.getPassword());
			return "redirect:/#";
		} else {
			request.setAttribute("loggedInUser", session.getAttribute("loggedInUser"));
			request.setAttribute("messageAccount", "Thông Tin Tài Khoản Hoặc Mật Khẩu Không Chính Xác!");
			return "/home/resetPasswordModal";
		}
	}

	/**
	 * Project: FPT-Cinema 
	 * Team: 1 
	 * Author : TraNLC 
	 * Function/Class/JSP : Quên mật khẩu
	 */
	@GetMapping("/forgotPass")
	public String getForgotPass(Model model) {
		return "/home/forgotPasswordModal";
	}
	
	/**
	 * Project: FPT-Cinema 
	 * Team: 1 
	 * Author : TraNLC 
	 * Function/Class/JSP : Đăng ký
	 */
	@GetMapping("/register")
	public ModelAndView register() {
		ModelAndView view = new ModelAndView();
		view.setViewName("/home/registerModal");
		return view;
	}
	
	@PostMapping("/register")
	public String postRegister(@ModelAttribute("customer") @Valid InsertRegister ir, BindingResult result,
			HttpServletRequest request, HttpServletResponse response,Model model,RedirectAttributes redirectAttributes) {
		if (result.hasErrors()) {
			return "/home/registerModal";
		}
		Users user = new Users();
		Customer customer = new Customer();
		if ((userService.searchCustomer(ir.getEmail()) == null) && (userService.findByAccount(ir.getAccount()) == null)) {
		    customer.setCustomerName(ir.getCustomerName());
		    customer.setPhone(ir.getPhone());
		    customer.setEmail(ir.getEmail());
		    customer.setGender(ir.getGender());
		    customer.setAddress(ir.getAddress());
		    customer.setBirthDate(ir.getBirthDate());
		    customerService.save(customer);
		    
		    user.setAccount(ir.getAccount());
		    user.setPassword(passEncode.encode(ir.getPassword()));
		    user.setCustomer(customer);
		    user.setUserRole("USER");
		    user.setStatus("active");
		    userService.save(user);
		    redirectAttributes.addFlashAttribute("accountSuccess", "Đăng kí thành công!! vui lòng đăng nhập để tiếp tục");
		    return "redirect:/dangnhap";
		} else {
			if ((userService.searchCustomer(ir.getEmail()) != null)) {
				request.setAttribute("messageEmail", "Email Này Đã Được Đăng Ký!");
			} else {
				request.setAttribute("messageEmail", "");
			}

			if (userService.findByAccount(ir.getAccount()) != null) {
				request.setAttribute("messageAccount", "User Đã Tồn Tại Trong Hệ Thống");
			} else {
				request.setAttribute("messageAccount", "");
			}
			request.setAttribute("messageAccount", "Đã xảy ra lỗi");
			return "/home/registerModal";
		}
	}
	
	/**
	 * Project: FPT-Cinema 
	 * Team: 1 
	 * Author : TraNLC 
	 * Function/Class/JSP : Quên mật khẩu
	 */
	@PostMapping("/otp")
	public String quenPass(@ModelAttribute("emailtk") String email, HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession sessionOTP = request.getSession();
		Users user = userService.searchCustomer(email); 
		if (user == null) {
			request.setAttribute("messageEmail", "Email chưa đăng ký cho tài khoản nào!");
			return "/home/forgotPasswordModal";
		} else {
			System.out.println(user.getAccount());
			sessionOTP.setAttribute("account", user.getAccount());
			boolean flag = emailService.sendOtpEmail(email, sessionOTP);
			if (flag) {
				sessionOTP.setMaxInactiveInterval(300);
				return "/home/otp";
			} else {
				request.setAttribute("messageEmailcorrect", "Hệ Thống Đang Lỗi, Vui lòng Chờ Ít Phút !");
				return "/home/forgotPasswordModal";
			}
		}
	}
	
	/**
	 * Project:FPT-Cinema
	 * 
	 * @author TraNLC Check Session
	 */
	public boolean checkSession(HttpSession session) {
		if (session.getAttribute("account") == null) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * Project:FPT-Cinema
	 * 
	 * @author TraNLC Check Session
	 */
	public boolean checkRequest(HttpServletRequest request) {
		if (request.getSession().getAttribute("account") == null) {
			return false;
		} else {
			return true;
		}
	}
}