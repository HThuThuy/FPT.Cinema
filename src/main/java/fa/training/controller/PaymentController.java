/*
 * Project: Cinema WebApp
 * Team: 2
 * Author : Ducnm74
 * Controller: xử lý thanh toán VNPay
 */
package fa.training.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import fa.training.config.VNPayConfig;
import fa.training.model.Customer;
import fa.training.model.Order;
import fa.training.model.Showtime;
import fa.training.model.TicketInfo;
import fa.training.service.CustomerService;
import fa.training.service.OrderService;
import fa.training.service.SeatService;
import fa.training.service.SerService;
import fa.training.service.ShowtimeService;
import fa.training.service.TicketService;

@Controller
@RequestMapping(value = "/payment")
public class PaymentController {
	@Autowired
	private SeatService seat;

	@Autowired
	private SerService SerService;

	@Autowired
	private CustomerService customers;

	@Autowired
	private ShowtimeService showtimes;

	@Autowired
	private OrderService orders;

	@Autowired
	private TicketService tickets;

	/*
	 * Project: FPT Cinema Team: 2 Author :ThuyHtt14 Method: Tạo đơn thanh toán
	 */
	@GetMapping("/create")
	public String createPayment(@RequestParam("param1") String soTien, @RequestParam("param2") String orderInfo)
			throws UnsupportedEncodingException {
		long amount = Long.parseLong(soTien) * 100;
		String vnp_TxnRef = VNPayConfig.getRandomNumber(8);
		Map<String, String> vnp_Params = new HashMap<>();
		vnp_Params.put("vnp_Version", VNPayConfig.vnp_Version);
		vnp_Params.put("vnp_Command", VNPayConfig.vnp_Command);
		vnp_Params.put("vnp_TmnCode", VNPayConfig.vnp_TmnCode);
		vnp_Params.put("vnp_Amount", String.valueOf(amount));
		vnp_Params.put("vnp_CurrCode", "VND");
		vnp_Params.put("vnp_BankCode", "NCB");
		vnp_Params.put("vnp_TxnRef", vnp_TxnRef);
		vnp_Params.put("vnp_OrderInfo", orderInfo);
		vnp_Params.put("vnp_OrderType", "other");
		vnp_Params.put("vnp_Locale", "vn");
		vnp_Params.put("vnp_ReturnUrl", VNPayConfig.vnp_Returnurl);
		vnp_Params.put("vnp_IpAddr", VNPayConfig.vnp_IpAddr);
		try {
			// Tạo một ObjectMapper
			ObjectMapper objectMapper = new ObjectMapper();

			// Đọc chuỗi JSON thành JsonNode
			JsonNode jsonNode = objectMapper.readTree(orderInfo);

			// Lấy giá trị từ JsonNode
//			String[] maGhe = objectMapper.convertValue(jsonNode.get("maGhe"), String[].class);
//			int maSuatChieu = jsonNode.get("maSuatChieu").asInt();
//			int maKhachHang = jsonNode.get("maKhachHang").asInt();
			LocalDate ngaySuDung = LocalDate.now();
//				for (String string : maGhe) {
//					veService.updateDatVe(string, maSuatChieu,ngaySuDung,maKhachHang);
//				}
		} catch (Exception e) {
			e.printStackTrace();
		}
		Calendar cld = Calendar.getInstance(TimeZone.getTimeZone("Etc/GMT+7"));
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
		String vnp_CreateDate = formatter.format(cld.getTime());
		vnp_Params.put("vnp_CreateDate", vnp_CreateDate);

		cld.add(Calendar.MINUTE, 15);
		String vnp_ExpireDate = formatter.format(cld.getTime());
		vnp_Params.put("vnp_ExpireDate", vnp_ExpireDate);

		List fieldNames = new ArrayList(vnp_Params.keySet());
		Collections.sort(fieldNames);
		StringBuilder hashData = new StringBuilder();
		StringBuilder query = new StringBuilder();
		Iterator itr = fieldNames.iterator();
		while (itr.hasNext()) {
			String fieldName = (String) itr.next();
			String fieldValue = (String) vnp_Params.get(fieldName);
			if ((fieldValue != null) && (fieldValue.length() > 0)) {
				// Build hash data
				hashData.append(fieldName);
				hashData.append('=');
				hashData.append(URLEncoder.encode(fieldValue, StandardCharsets.US_ASCII.toString()));
				// Build query
				query.append(URLEncoder.encode(fieldName, StandardCharsets.US_ASCII.toString()));
				query.append('=');
				query.append(URLEncoder.encode(fieldValue, StandardCharsets.US_ASCII.toString()));
				if (itr.hasNext()) {
					query.append('&');
					hashData.append('&');
				}
			}
		}
		String queryUrl = query.toString();
		String vnp_SecureHash = VNPayConfig.hmacSHA512(VNPayConfig.vnp_HashSecret, hashData.toString());
		queryUrl += "&vnp_SecureHash=" + vnp_SecureHash;
		vnp_Params.put("vnp_SecureHash", vnp_SecureHash);
		String paymentUrl = VNPayConfig.vnp_PayUrl + "?" + queryUrl;

		return "redirect:" + paymentUrl;
	}

	/*
	 * Project: FPT Cinema Team: 2 Author : ThuyHTT14 Method: Lấy thông tin thanh
	 * toán và xử lý lưu dữ liệu vào database
	 */
	@GetMapping("/return")
	public String getPaymentInfo(@RequestParam(value = "vnp_Amount") String amount,
			@RequestParam(value = "vnp_ResponseCode") String status,
			@RequestParam(value = "vnp_OrderInfo") String orderInfo, Model model, HttpSession session) {
		int maSuatChieu = 0;
		String ghe = "";
		try {
			// Tạo một ObjectMapper
			ObjectMapper objectMapper = new ObjectMapper();

			// Đọc chuỗi JSON thành JsonNode
			JsonNode jsonNode = objectMapper.readTree(orderInfo);

			// Lấy giá trị từ JsonNode
//			maSuatChieu = jsonNode.get("maSuatChieu").asInt();
			LocalDate ngaySuDung = LocalDate.now();
			LocalTime gioSuDung = LocalTime.now();

//			String[] maGhe = objectMapper.convertValue(jsonNode.get("maGhe"), String[].class);
//			JsonNode danhSachDichVu = jsonNode.get("danhSachDichVu");

			
			
			// int ticketId = jsonNode.get("ticketId").asInt();
			String statusTicket = jsonNode.get("status").asText();
			
			//String serviceTicket = jsonNode.get("service").asText();
			
			/*
			 * lấy list serviceShow từ serviceTicket
			 * chạy vòng lặp tính tổng số lượng nước A, số lượng bắp B số lượng snack C, số lượng tiền D
			 * Service service = new Service(A,B,C,D)
			 * service.setServiceId(UIUD.random())
			 * servicesService.save(service)
			 * 
			 * 
			 * */

			// String showtimeGet = jsonNode.get("showtimeTicket").asText();

			Showtime showtimeGets = (Showtime) session.getAttribute("selectedShowtime");
			System.out.println("abc-------------------------" + showtimeGets);
			String customer = jsonNode.get("customer").asText();
			int order = jsonNode.get("order").asInt();

			System.out.println("ticketId" + "2 ," + statusTicket + ", 3" + showtimeGets + ", 4" + customer + 5 + order);

			if (status.equals("00")) {
				//Order
			 Order getOrder= new Order();
//				 getOrder.setOrderDate(ngaySuDung);
//				 getOrder.setOrderTime(gioSuDung)
//			 	getOrder.setServices(null);			 
				// getOrder.setTotalPrice(amount);
			 
			 
				 
				
				Customer customerTicket = customers.findById(customer);
				
				Order orderTicket = orders.findById(order);

				TicketInfo buyTicketInfo = new TicketInfo();
				buyTicketInfo.setCustomer(customerTicket);
				buyTicketInfo.setShowtimeTicket(showtimeGets);
				buyTicketInfo.setOrder(orderTicket);
				buyTicketInfo.setStatus(statusTicket);

				System.out.println(buyTicketInfo + "djhfjksdj");

				tickets.save(buyTicketInfo);

			} else {
//				for (String string : maGhe) {
//					veService.updateHuyVe(string, maSuatChieu,ngaySuDung,maKhachHang);
//				}
//				model.addAttribute("tinhTrang", "thanh toan khong thanh cong");
//				return "/ve/" + maSuatChieu;
				System.out.println("Thanh toan khong thanh cong");

				return "ticket/payment";
//			}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "/ticket/bill";
	}
}
