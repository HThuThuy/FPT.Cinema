package fa.training.controller;

import java.time.LocalDate;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fa.training.DTO.CustomerDTO;
import fa.training.DTO.RegisterDTO;
import fa.training.model.Customer;
import fa.training.model.Users;
import fa.training.service.CustomerService;
import fa.training.service.EmailService;
import fa.training.service.UserService;

@Controller
@RequestMapping("/")
public class AccountController {

	@Autowired
	private UserService userService;

	@Autowired
	private CustomerService customerService;

	@Autowired
	EmailService emailService;

	@Autowired
	PasswordEncoder passEncode;

	
//	/**
//	 * Project: FPT-Cinema Team: 1 Author : TraNLC Function/Class/JSP : thêm tài
//	 * khoản
//	 */
//	@GetMapping("/add")
//	public String showAddForm(Model model) {
//		model.addAttribute("registerForm", new Users());
//		return "/#";
//	}

	/**
	 * Project: FPT-Cinema Team: 1 Author : TraNLC Function/Class/JSP : lưu tài
	 * khoản
	 */
//	@PostMapping("/save")
//	public String saveNewAccount(@ModelAttribute("registerForm") @Valid Users users, BindingResult result) {
//		if (result.hasErrors()) {
//			return "/home/registerModal";
//		}
//		users.setPassword(passEncode.encode(users.getPassword()));
//		userService.save(users);
//		return "redirect:/#";
//	}

//	@RequestMapping("/update/{cccd}")
//	public String update(@PathVariable(name = "cccd") String cccd, Model model) {
//		Users users = userService.findById(cccd);
//		model.addAttribute("UserForm", users);
//		return "/home/registerModal";
//	}

	/**
	 * Project: FPT-Cinema Team: 1 Author : TraNLC Function/Class/JSP : Reset mật
	 * khẩu
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
//	@PostMapping("/resetpass")
//	public String postChangePass(@ModelAttribute("Resetpass") ResetPassword rs, HttpServletRequest request,
//			HttpServletResponse response) {
//		HttpSession session = request.getSession();
//		Users user = userService.findByAccountAndPassword(rs.getAccount(), rs.getOldpassword());
//
//		if (user != null) {
//			if (rs.getOldpassword().equals(rs.getPassword())) {
//				request.setAttribute("loggedInUser", session.getAttribute("loggedInUser"));
//				request.setAttribute("messagePassword", "Mật Khẩu Mới Không Được Trùng Với Mật Khẩu Cũ !");
//				return "/home/resetPasswordModal";
//			}
//			if (!checkRequest(request)) {
//				request.setAttribute("messageAccount", "Bạn Đã Đăng Xuất, Vui Lòng Đăng Nhập Lại Để Đổi Mật Khẩu!");
//				return "/home/login";
//			}
//			userService.updatePass(rs.getAccount(), rs.getPassword());
//			return "redirect:/#";
//		} else {
//			request.setAttribute("loggedInUser", session.getAttribute("loggedInUser"));
//			request.setAttribute("messageAccount", "Thông Tin Tài Khoản Hoặc Mật Khẩu Không Chính Xác!");
//			return "/home/resetPasswordModal";
//		}
//	}

	/**
	 * Project: FPT-Cinema Team: 1 Author : TraNLC Function/Class/JSP : Quên mật
	 * khẩu
	 */
	@GetMapping("/forgotPass")
	public String getForgotPass(Model model) {
		return "/home/forgotPasswordModal";
	}

	
	/**
	 * Project: FPT-Cinema Team: 1 Author : TraNLC Function/Class/JSP : Đăng ký
	 */
	@PostMapping("/register")
	public ResponseEntity<?> registerUser(@RequestBody RegisterDTO registerDTO) {
	    // Tạo và lưu Customer
	    Customer customer = new Customer();
	    customer.setCccd(registerDTO.getCccd());
	    customer.setCustomerName(registerDTO.getCustomerName());
	    customer.setBirthDate(registerDTO.getBirthDate());
	    customer.setEmail(registerDTO.getEmail());
	    customer.setPhone(registerDTO.getPhone());
	    customer.setGender(registerDTO.getGender());
	    customer.setUserType("Thường");

	    System.out.println("abc-----------" + registerDTO);
	    customerService.save(customer);
	    
	    // Tạo và lưu User
	    Users newUser = new Users();
	    newUser.setAccount(registerDTO.getAccount());
	    newUser.setPassword(passEncode.encode(registerDTO.getPassword())); // Mã hóa mật khẩu
	    newUser.setUserRole("USER");
	    newUser.setStatus("active");
	    newUser.setCustomer(customer);

	    // mã hóa password 
	    // check exist hoặc validate
	    System.out.println("bcd---------" + newUser);
	    userService.save(newUser);
	    System.out.println("Đã lưu thành công!");
	    return ResponseEntity.ok("User registered successfully");
	}

	/**
	 * Project: FPT-Cinema Team: 1 Author : TraNLC Function/Class/JSP : Quên mật
	 * khẩu
	 */
//	@PostMapping("/otp")
//	public String quenPass(@ModelAttribute("emailtk") String email, HttpServletRequest request,
//			HttpServletResponse response) {
//		HttpSession sessionOTP = request.getSession();
//		Users user = userService.searchCustomer(email);
//		if (user == null) {
//			request.setAttribute("messageEmail", "Email chưa đăng ký cho tài khoản nào!");
//			return "/home/forgotPasswordModal";
//		} else {
//			System.out.println(user.getAccount());
//			sessionOTP.setAttribute("account", user.getAccount());
//			boolean flag = emailService.sendOtpEmail(email, sessionOTP);
//			if (flag) {
//				sessionOTP.setMaxInactiveInterval(300);
//				return "/home/otp";
//			} else {
//				request.setAttribute("messageEmailcorrect", "Hệ Thống Đang Lỗi, Vui lòng Chờ Ít Phút !");
//				return "/home/forgotPasswordModal";
//			}
//		}
//	}
	
//	@PostMapping("/forgotPassword")
//	public String handleForgotPassword(@RequestBody Map<String, String> request, HttpSession session, Model model) {
//	    String email = request.get("email");
//
//	    // Kiểm tra xem email có tồn tại trong hệ thống hay không
//	    // Nếu không tồn tại, bạn có thể trả về một trang lỗi hoặc thông báo
//
//	    // Gửi email với OTP và lưu OTP vào session
//	    boolean emailSent = emailService.sendOtpEmail(email, session);
//
//	    if (emailSent) {
//	        return "redirect:/resetPassword"; // Chuyển hướng đến trang reset mật khẩu
//	    } else {
//	        model.addAttribute("error", "Gửi email không thành công. Vui lòng thử lại sau.");
//	        return "errorPage"; // Trang thông báo lỗi
//	    }
//	}
//	
//	@PostMapping("/forgotPassword")
//	public String quenPass(@ModelAttribute("emailtk") String email, HttpServletRequest request,
//	        HttpServletResponse response) {
//	    HttpSession sessionOTP = request.getSession();
//	    
//	    // Kiểm tra xem email đã được đăng ký hay chưa
//	    Customer customer = userService.searchCustomer(email);
//	    if (customer == null) {
//	        request.setAttribute("messageEmail", "Email chưa đăng ký cho tài khoản nào!");
//	        return "/taikhoan/quenpass";
//	    } 
//	    
//	    // Lấy thông tin tài khoản người dùng
//	    Users user = userService.findByAccount(account);
//	    sessionOTP.setAttribute("taikhoan", user);
//	    
//	    // Tạo mã OTP ngẫu nhiên
//	    Random random = new Random();
//	    int otp = 100000 + random.nextInt(900000);
//	    String OTP = String.valueOf(otp);
//	    
//	    // Tạo email
//	    String subject = "OTP From T2Cinema";
//	    String message = "OTP is " + otp;
//	    String to = email;
//	    
//	    // Gửi email
//	    boolean flag = this.emailService.sendEmail(subject, message, to);
//	    
//	    if (flag) {
//	        sessionOTP.setAttribute("myOtp", OTP);
//	        sessionOTP.setMaxInactiveInterval(300);
//	        return "/taikhoan/otp";
//	    } else {
//	        request.setAttribute("messageEmailcorrect", "Hệ Thống Đang Lỗi, Vui lòng Chờ Ít Phút !");
//	        return "/taikhoan/quenpass";
//	    }
//	}
	


    @PostMapping("/verifyOtp")
    public String verifyOtp(@RequestParam String otp, HttpSession session, Model model) {
        // Lấy OTP đã lưu trong session
        String sessionOtp = (String) session.getAttribute("OTP");

        // Kiểm tra xem OTP người dùng nhập vào có khớp không
        if (sessionOtp != null && sessionOtp.equals(otp)) {
            // Nếu OTP khớp, chuyển hướng đến trang đổi mật khẩu
            return "redirect:/changePassword";
        } else {
            model.addAttribute("error", "Mã OTP không hợp lệ. Vui lòng thử lại.");
            return "errorPage"; // Trang thông báo lỗi
        }
    }

    @PostMapping("/changePassword")
    public String changePassword(@RequestParam String newPassword, HttpSession session, Model model) {
        // Lấy thông tin tài khoản của người dùng (bạn cần implement phần này)

        // Đổi mật khẩu cho tài khoản
        // ...

        // Đăng xuất người dùng sau khi đổi mật khẩu (nếu cần)
        session.invalidate();

        return "redirect:/login"; // Chuyển hướng đến trang đăng nhập
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