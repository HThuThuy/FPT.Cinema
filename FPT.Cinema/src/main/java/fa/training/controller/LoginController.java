package fa.training.controller;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import fa.training.DTO.RegisterDTO;
import fa.training.model.Customer;
import fa.training.model.Users;
import fa.training.service.CustomerService;
import fa.training.service.UserService;

@Controller
public class LoginController {

	@Autowired
	private UserService userService;

	@Autowired
	private CustomerService customerService;

	@Autowired
	private PasswordEncoder passwordEncoder;

	/**
	 * Project:FPT-Cinema
	 * Team 1
	 * @author TraNLC 
	 * Phương thức kiểm tra id và mật khẩu tài khoản trong Database
	 * Mục đích: Kiểm tra sự hợp lệ của tài khoản và mật khẩu.
	 */
	@GetMapping(value = { "/api/checkAccount" })
	public ResponseEntity<Boolean> checkAccount(@RequestParam("accountLogin") String accountLogin,
	        @RequestParam("passwordLogin") String passwordLogin) {
	    Users user = userService.findByAccount(accountLogin);
	    boolean isAccountValid = (user != null) && passwordEncoder.matches(passwordLogin, user.getPassword());
	    return new ResponseEntity<>(isAccountValid, HttpStatus.OK);
	}

	/**
	 * Project:FPT-Cinema
	 * Team 1
	 * @author TraNLC 
	 * Phương thức kiểm tra tồn tại của email trong Database
	 * Mục đích: Kiểm tra sự tồn tại của địa chỉ email trong cơ sở dữ liệu.
	 */
	@GetMapping(value = { "/api/checkExistEmail" })
	public ResponseEntity<Boolean> checkExistEmail(@RequestParam("emailForgot") String emailForgot, HttpSession session) {
		Customer customer = customerService.findByEmail(emailForgot);
		session.setAttribute("customer", customer);
		boolean isEmailValid = (customer != null) ? true : false;
		System.out.println("isEmailValid" + isEmailValid);
		return new ResponseEntity<>(isEmailValid, HttpStatus.OK);
	}

	/**
	 * Project:FPT-Cinema
	 * Team 1
	 * @author TraNLC 
	 * Phương thức đổi mật khẩu
	 * Mục đích: Cập nhật mật khẩu cho người dùng sau khi quên mật khẩu.
	 */
	@PostMapping(value = { "/resetPassword" })
	public String resetPassword(@RequestParam("passwordUpdate") String passwordUpdate, HttpSession session) {
	    Customer customer = (Customer) session.getAttribute("customer");

	    if (customer != null) {
	        String cccdUpdate = customer.getCccd();

	        // Tìm người dùng trong bảng Users dựa trên cccd
	        Users userUpdate = userService.findUserByCustomerCccd(cccdUpdate);
	        if (userUpdate != null) {
	            // Mã hóa mật khẩu trước khi cập nhật
	            String encodedPassword = passwordEncoder.encode(passwordUpdate);
	            
	            // Cập nhật mật khẩu
	            userService.updateUser(encodedPassword, cccdUpdate);
	            
	            //Return về trang chủ nếu đổi thành công
	            return "redirect:/";
	        }
	    }
	    
	    //Return về trang error nếu lỗi
	    return "error"; 
	}

	/**
	 * Project:FPT-Cinema
	 * Team 1
	 * @author TraNLC 
	 * Phương thức hiển thị theo role(ADMIN/USER) khi đăng nhập thành công 
	 * Mục đích: Xác định vai trò của người dùng và chuyển hướng tới trang tương ứng.
	 */
	@GetMapping(value = "/role")
	public String showByRole(Principal principal, HttpSession session) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String accountName = principal.getName();
		Users account = userService.findByAccount(accountName);
		boolean isAdmin = authentication.getAuthorities().stream().map(GrantedAuthority::getAuthority)
				.anyMatch(role -> role.equals("ROLE_ADMIN"));
		if (isAdmin) {
			session.setAttribute("account1", accountName);
			String customerName = customerService.getCustomerName(account.getCustomer().getCccd());
			session.setAttribute("customerName", customerName);
			session.setAttribute("loggedInUser", customerService.findById(account.getCustomer().getCccd()));
			return "redirect:/admin/quanLySuatChieu"; // Chuyển hướng admin về trang quản lý
		} else {
			session.setAttribute("account1", accountName);
			String customerName = customerService.getCustomerName(account.getCustomer().getCccd());
			Customer custerLogin = customerService.findById(account.getCustomer().getCccd());

			// Lấy cccd trong session
			String getCccd = account.getCustomer().getCccd();
			session.setAttribute("getCccd", getCccd);
			session.setAttribute("customerLogin", custerLogin);
			session.setAttribute("customerName", customerName);
			session.setAttribute("loggedInUser", customerService.findById(account.getCustomer().getCccd()));
			return "redirect:/"; // Chuyển hướng user thường về trang chủ
		}
	}

	/**
	 * Project:FPT-Cinema
	 * Team 1
	 * @author TraNLC 
	 * Phương thức đăng xuất
	 * Mục đích: Thực hiện đăng xuất người dùng.
	 */
	@GetMapping(value = "/logout")
	public String logOut(HttpServletRequest request, HttpServletResponse response) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (authentication != null) {
			new SecurityContextLogoutHandler().logout(request, response, authentication);
		}
		return "redirect:/";
	}
	
	/**
	 * Project:FPT-Cinema
	 * Team 1
	 * @author TraNLC 
	 * Phương thức đăng kí tài khoản mới
	 * Mục đích: Đăng kí tài khoản mới.
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

	    customerService.save(customer);
	    
	    // Tạo và lưu User
	    Users newUser = new Users();
	    newUser.setAccount(registerDTO.getAccount());
	    newUser.setPassword(passwordEncoder.encode(registerDTO.getPassword())); // Mã hóa mật khẩu
	    newUser.setUserRole("USER");
	    newUser.setStatus("active");
	    newUser.setCustomer(customer);

	    // mã hóa password 
	    userService.save(newUser);
	    return ResponseEntity.ok("User registered successfully");
	}
	
	/**
	 * Project: FPT-Cinema 
	 * Team: 1 
	 * Author : TraNLC 
	 * Function/Class/JSP : Quên mật khẩu
	 * Mục đích: Hiển thị modal để thực hiện quên mật khẩu.
	 */
	@GetMapping("/forgotPass")
	public String getForgotPass(Model model) {
		return "/home/forgotPasswordModal";
	}
	
	/**
	 * Project:FPT-Cinema
	 * Team 1
	 * @author TraNLC 
	 * Phương thức kiểm tra session
	 * Mục đích: Kiểm tra xem session có tồn tại không.
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
	 * Team 1
	 * @author TraNLC 
	 * Phương thức kiểm tra Request 
	 * Mục đích: Kiểm tra request có tồn tại không.
	 */
	public boolean checkRequest(HttpServletRequest request) {
		if (request.getSession().getAttribute("account") == null) {
			return false;
		} else {
			return true;
		}
	}
}