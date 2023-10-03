package fa.training.controller;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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

	@GetMapping(value = { "/api/checkAccount" })
	public ResponseEntity<Boolean> checkAccount(@RequestParam("accountLogin") String accountLogin, @RequestParam("passwordLogin") String passwordLogin) {
	    boolean isAccountValid = false;
	    Users user = userService.findByAccount(accountLogin);
	    if (user != null) {
	        isAccountValid = passwordEncoder.matches(passwordLogin, user.getPassword());
	    }

	    if (isAccountValid) {
	        return new ResponseEntity<>(true, HttpStatus.OK);
	    } else {
	        return new ResponseEntity<>(false, HttpStatus.OK);
	    }
	}

//	@ResponseBody	
//	@GetMapping(value = { "/api/checkAccount" })
//	public ResponseEntity<Boolean> checkAccount(@RequestParam("accountLogin") String accountLogin, @RequestParam("passwordLogin") String passwordLogin) {
//	    // Đoạn này cần thực hiện kiểm tra tài khoản trong cơ sở dữ liệu
//	    boolean isAccountValid = true;
//	    List<Users> listCheck = userService.findAll();
//	    for (Users usersabc : listCheck) {
//			if (usersabc.getAccount().equals(accountLogin)) {
//				isAccountValid = true;
//			} else {
//				isAccountValid = false;
//			}
//		}
//	    System.out.println("id"+accountLogin);
//	    System.out.println("pass"+passwordLogin);
//	    System.out.println("isAccountValid"+isAccountValid);
//	    
//	    if (isAccountValid) {
//	        return new ResponseEntity<>(true, HttpStatus.OK);
//	    } else {
//	        return new ResponseEntity<>(false, HttpStatus.OK);
//	    }
//	}



	

	@GetMapping(value = "/role")
	public String showByRole(Principal principal, HttpSession session) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String accountName = principal.getName();
		Users account = userService.findByAccount(accountName);
		boolean isAdmin = authentication.getAuthorities().stream().map(GrantedAuthority::getAuthority)
				.anyMatch(role -> role.equals("ROLE_ADMIN"));
		if (isAdmin) {
			session.setAttribute("account1", accountName);
			// Get customer name from CustomerService
			String customerName = customerService.getCustomerName(account.getCustomer().getCccd());
			session.setAttribute("customerName", customerName);
			session.setAttribute("loggedInUser", customerService.findById(account.getCustomer().getCccd()));
			return "redirect:/admin/quanLySuatChieu"; // Chuyển hướng admin đến trang quản lý suất chiếu
		} else {
			session.setAttribute("account1", accountName);
			// Get customer name from CustomerService
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

//	@GetMapping("/checkLogin")
//	public Map<String, Boolean> kiemTraDangNhap() {
//	    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//	    boolean checkLogin = authentication != null && !(authentication instanceof AnonymousAuthenticationToken) && authentication.isAuthenticated();
//
//	    return Collections.singletonMap("checkLogin", checkLogin);
//	}

	// Chức năng đăng xuất khi người dùng có đăng nhập và điều hướng về màn hình
	// đăng nhập ban đầu
	@GetMapping(value = "/logout")
	public String dangXuat(HttpServletRequest request, HttpServletResponse response) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (authentication != null) {
			new SecurityContextLogoutHandler().logout(request, response, authentication);
		}
		return "redirect:/";
	}
}