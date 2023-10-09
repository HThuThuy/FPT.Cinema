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
 * 09-10-2023           TraNLC            Định nghĩa các chức năng của khách hàng
 */

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
     * Lấy thông tin khách hàng từ session
     * @param session: HttpSession
     * @return Customer: thông tin khách hàng
     * @throws RuntimeException khi không tìm thấy khách hàng
     */
    private Customer getCustomerFromSession(HttpSession session) {
        Customer customer = (Customer) session.getAttribute("customerLogin");
        if (customer == null) {
            throw new RuntimeException("Không tìm thấy khách hàng");
        }
        return customer;
    }

    /**
     * Hiển thị lịch sử đặt vé của khách hàng trong một khoảng thời gian cụ thể
     * @param model
     * @param startDate: Ngày bắt đầu trong ô search
     * @param endDate: Ngày kết thúc trong ô search
     * @param page: Phân trang
     * @param session
     * @return Trang 'history' trong thư mục 'customer' sẽ được hiển thị
     */
    @GetMapping(value = { "/history" })
    public String checkHistory(Model model,
            @RequestParam(value = "startDate", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam(value = "endDate", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate,
            @RequestParam(name = "page", defaultValue = "1") int page, HttpSession session) {
        Customer customer = getCustomerFromSession(session);
        String cccd = customer.getCccd();
        Page<CustomerDTO> customerDTOPage = customerService.getRecordsForCurrentPage(cccd, startDate, endDate, PageRequest.of(page - 1, 5));
        model.addAttribute("historyList", customerDTOPage.getContent());
        model.addAttribute("noOfPages", customerDTOPage.getTotalPages());
        model.addAttribute("currentPage", page);
        return "customer/history";
    }

    /**
     * Hiển thị thông tin của khách hàng hoặc cho phép khách hàng cập nhật thông tin cá nhân
     * @param model
     * @param session
     * @param page
     * @return Trang 'info' hoặc 'update' trong thư mục 'customer' sẽ được hiển thị
     */
    @GetMapping("/{page:(?:info|update)}")
    public String showCustomerInfo(Model model, HttpSession session, @PathVariable String page) {
        Customer customer = getCustomerFromSession(session);
        String cccd = customer.getCccd();
        Customer customerFromDb = customerService.findById(cccd);
        model.addAttribute("customer", customerFromDb);
        return "customer/" + page;
    }

    /**
     * Hiển thị trang FAQ cho khách hàng.
     * @param model mô hình dùng để truyền dữ liệu từ controller đến view.
     * @return Trang view FAQ cho khách hàng.
     */
    @GetMapping("/faq")
    public String showFaq(Model model) {
        return "customer/faq";
    }

    /**
     * Hiển thị form cập nhật thông tin khách hàng.
     * @param model mô hình dùng để truyền dữ liệu từ controller đến view.
     * @param cccd chuỗi đại diện cho mã khách hàng.
     * @param session phiên làm việc hiện tại.
     * @return Trả về view 'update' trong thư mục 'customer' hiển thị form cập nhật thông tin khách hàng.
     */
    @GetMapping("/update/{cccd}")
    public String updateCustomerInfo(Model model, @PathVariable("cccd") String cccd, HttpSession session) {
        session.setAttribute("cccd", cccd);
        Customer customerUpdate = customerService.findById(cccd);        
        model.addAttribute("customerForm", customerUpdate);
        return "customer/update"; 
    }

    /**
     * Cập nhật thông tin khách hàng.
     * @param customer đối tượng chứa thông tin khách hàng cần cập nhật.
     * @param result kết quả kiểm tra dữ liệu nhập vào.
     * @param redirectAttr đối tượng dùng để thêm thông báo vào request sau khi redirect.
     * @return Trả về view 'info' trong thư mục 'customer' hiển thị thông tin khách hàng sau khi cập nhật. 
     *         Nếu có lỗi, trả về view 'update' trong thư mục 'customer' để hiển thị lại form cập nhật.
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