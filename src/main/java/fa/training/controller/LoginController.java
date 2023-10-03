package fa.training.controller;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

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

    @GetMapping(value = "/role")
    public String hienThiTheoPhanQuyen(Principal principal, HttpSession session) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String accountName = principal.getName();
        Users account = userService.findByAccount(accountName);
        boolean isAdmin = authentication.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
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
            Customer customerLogin = customerService.findById(account.getCustomer().getCccd());
            
            System.out.println("custerLogin"+customerLogin);
            
            session.setAttribute("customerLogin", customerLogin);
            
            session.setAttribute("customerName", customerName);
            session.setAttribute("loggedInUser", customerService.findById(account.getCustomer().getCccd()));
            return "redirect:/#"; // Chuyển hướng user thường về trang chủ
        }
    }
    
 // Chức năng đăng xuất khi người dùng có đăng nhập và điều hướng về màn hình đăng nhập ban đầu
 		@GetMapping(value = "/logout")
 		public String dangXuat (HttpServletRequest request, HttpServletResponse response) {
 			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
 			if (authentication != null) {
 				new SecurityContextLogoutHandler().logout(request, response, authentication);
 			}
 			return "redirect:/#";
 		}
}