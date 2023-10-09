/**
 * CustomerController
 *
 * Version 1.0
 *
 * Date: 09-10-2023
 *
 * Copyright
 * 
 * Modification Logs:
 * DATE                 AUTHOR            DESCRIPTION
 * -----------------------------------------------------------------------
 * 09-10-2023           TraNLC            Định nghĩa các chức năng Login/LogOut/ResetPass
 */

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
     * Kiểm tra tài khoản người dùng
     * @param accountLogin: Tên đăng nhập người dùng
     * @param passwordLogin: Mật khẩu của người dùng
     * @return ResponseEntity<Boolean>: Trả về trạng thái của tài khoản (hợp lệ / không hợp lệ)
     */
    @GetMapping(value = { "/api/checkAccount" })
    public ResponseEntity<Boolean> checkAccount(@RequestParam("accountLogin") String accountLogin,
            @RequestParam("passwordLogin") String passwordLogin) {
        Users user = userService.findByAccount(accountLogin);
        boolean isAccountValid = (user != null) && passwordEncoder.matches(passwordLogin, user.getPassword());
        return new ResponseEntity<>(isAccountValid, HttpStatus.OK);
    }

    /**
     * Kiểm tra sự tồn tại của email trong cơ sở dữ liệu
     * @param emailForgot: Email cần kiểm tra
     * @param session: HttpSession
     * @return ResponseEntity<Boolean>: Trả về trạng thái của email (tồn tại / không tồn tại)
     */
    @GetMapping(value = { "/api/checkExistEmail" })
    public ResponseEntity<Boolean> checkExistEmail(@RequestParam("emailForgot") String emailForgot,
            HttpSession session) {
        Customer customer = customerService.findByEmail(emailForgot);
        session.setAttribute("customer", customer);
        boolean isEmailValid = (customer != null) ? true : false;
        System.out.println("isEmailValid" + isEmailValid);
        return new ResponseEntity<>(isEmailValid, HttpStatus.OK);
    }

    /**
     * Đổi mật khẩu của người dùng
     * @param passwordUpdate: Mật khẩu mới
     * @param session: HttpSession
     * @return String: Đường dẫn chuyển hướng (trang chủ / trang lỗi)
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
                // Return về trang chủ nếu đổi thành công
                return "redirect:/";
            }
        }
        // Return về trang error nếu lỗi
        return "errorPage";
    }

    /**
     * Hiển thị trang tương ứng với vai trò người dùng
     * @param principal: Principal
     * @param session: HttpSession
     * @return String: Đường dẫn chuyển hướng (trang quản lý cho admin / trang chủ cho người dùng thường)
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
     * Đăng xuất người dùng
     * @param request: HttpServletRequest
     * @param response: HttpServletResponse
     * @return String: Đường dẫn chuyển hướng (trang chủ)
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
     * Đăng ký tài khoản mới
     * @param registerDTO: Đối tượng chứa thông tin đăng ký
     * @return ResponseEntity: Trả về thông báo lỗi hoặc thành công
     */
    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody RegisterDTO registerDTO) {
        // Kiểm tra trùng lặp cccd
        Customer existingCustomer = customerService.findById(registerDTO.getCccd());
        if (existingCustomer != null) {
            return ResponseEntity.badRequest().body("Error: Căn cước công dân đã tồn tại!");
        }
        // Kiểm tra trùng lặp email
        Customer existingCustomerEmail = customerService.findByEmail(registerDTO.getEmail());
        if (existingCustomerEmail != null) {
            return ResponseEntity.badRequest().body("Error: Email đã tồn tại!");
        }
        // Kiểm tra trùng lặp tên đăng nhập
        Users existingUser = userService.findByAccount(registerDTO.getAccount());
        if (existingUser != null) {
            return ResponseEntity.badRequest().body("Error: Tên đăng nhập đã tồn tại!");
        }
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
        userService.save(newUser);
        return ResponseEntity.ok("User registered successfully");
    }

    /**
     * Hiển thị modal quên mật khẩu
     * @param model: Model
     * @return String: Đường dẫn tới modal quên mật khẩu
     */
    @GetMapping("/forgotPass")
    public String getForgotPass(Model model) {
        return "/home/forgotPasswordModal";
    }

    /**
     * Kiểm tra sự tồn tại của session
     * @param session: HttpSession
     * @return boolean: Trạng thái của session (tồn tại / không tồn tại)
     */
    public boolean checkSession(HttpSession session) {
        if (session.getAttribute("account") == null) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * Kiểm tra sự tồn tại của request
     * @param request: HttpServletRequest
     * @return boolean: Trạng thái của request (tồn tại / không tồn tại)
     */
    public boolean checkRequest(HttpServletRequest request) {
        if (request.getSession().getAttribute("account") == null) {
            return false;
        } else {
            return true;
        }
    }
}