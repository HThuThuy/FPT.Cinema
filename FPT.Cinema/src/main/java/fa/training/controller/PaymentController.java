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
import java.util.Random;
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
import fa.training.model.Movie;
import fa.training.model.Order;
import fa.training.model.OrderServiceId;
import fa.training.model.OrderServied;
import fa.training.model.Promotion;
import fa.training.model.Showtime;
import fa.training.model.TicketInfo;
import fa.training.service.CustomerService;
import fa.training.service.OrderSer;
import fa.training.service.OrderService;
import fa.training.service.PromotionService;
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
	private OrderSer orderSer;

	@Autowired
	private TicketService tickets;

	@Autowired
	private PromotionService promotions;

	/**
	 * Project: FPT Cinema 
	 * Team: 1 
	 * Author :ThuyHtt14 
	 * Method: Tạo đơn thanh toán
	 */
	@GetMapping("/create")
	public String createPayment(@RequestParam("param1") String soTien, @RequestParam("param2") String orderInfo)
			throws UnsupportedEncodingException {
		System.out.println(">>>so tien : " + soTien);
		System.out.println(orderInfo);
		
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
			JsonNode seatNode = jsonNode.get("seat");
            System.out.println("seatNode: " + seatNode.toString());
          
			String[] seatList = new String[seatNode.size()];
			for (int i = 0; i < seatNode.size(); i++) {
				seatList[i] = seatNode.get(i).asText();
			}
            //Update trang thai seat khi da dat
			for (String seatUpdate : seatList) {
				System.out.println("ghe-------"+seatUpdate);
				seat.updateSeatStatus(seatUpdate);
				System.out.println("Update thanh cong seat");

			}

			LocalDate ngaySuDung = LocalDate.now();
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

	/**
	 * Project: FPT Cinema 
	 * Team: 1 
	 * Author : ThuyHTT14 
	 * Method: Lấy thông tin thanh
	 * toán và xử lý lưu dữ liệu vào database
	 */
	@GetMapping("/return")
	public String getPaymentInfo(@RequestParam(value = "vnp_Amount") String amount,
			@RequestParam(value = "vnp_ResponseCode") String status,
			@RequestParam(value = "vnp_OrderInfo") String orderInfo, Model model, HttpSession session) {
		int maSuatChieu = 0;
		String ghe = "";
		TicketInfo buyTicketInfo = new TicketInfo();
		try {
			// Tạo một ObjectMapper
			ObjectMapper objectMapper = new ObjectMapper();

			// Đọc chuỗi JSON thành JsonNode
			JsonNode jsonNode = objectMapper.readTree(orderInfo);

			// Lấy giá trị từ JsonNode

			LocalDate ngaySuDung = LocalDate.now();
			LocalTime gioSuDung = LocalTime.now();

			String statusTicket = jsonNode.get("status").asText();

			Showtime showtimeGets = (Showtime) session.getAttribute("selectedShowtime");
			System.out.println("abc-------------------------" + showtimeGets);
			
			if (status.equals("00")) {
				JsonNode seatNode = jsonNode.get("seat");
				JsonNode serviceNode = jsonNode.get("service");
	            System.out.println("seatNode: " + seatNode.toString());
	            System.out.println("serviceNode: " + serviceNode.toString());
				String[] seatList = new String[seatNode.size()];
				for (int i = 0; i < seatNode.size(); i++) {
					seatList[i] = seatNode.get(i).asText();
				}

				String[] serviceList = new String[serviceNode.size()];
				for (int i = 0; i < serviceNode.size(); i++) {
					serviceList[i] = serviceNode.get(i).asText();
				}

				// Order
				Order getOrder = new Order();
				Random random = new Random();
				int randomNumber = random.nextInt(900) + 100;
				getOrder.setOrderDate(ngaySuDung);
				getOrder.setOrderTime(gioSuDung);
				getOrder.setOrderId(randomNumber);
				String promotion = jsonNode.get("promotion").asText();
				System.out.println("promotion"+promotion);
			//	String pro = "P001";
				if (promotion.equals("")) {
					getOrder.setPromotion(null);
				}else {
					Promotion proTicket = promotions.findById(promotion);
					getOrder.setPromotion(proTicket);
				}
				
				int intValue = Integer.parseInt(amount);
				getOrder.setTotalPrice(intValue);
				orders.save(getOrder);
				//insert tab orderService
				for (String serviceOrder : serviceList) {
					System.out.println("dv------" + serviceOrder);
					OrderServied ordService = new OrderServied();
					OrderServiceId ordServiceId= new OrderServiceId();
					ordServiceId.setOrderId(randomNumber);
					ordServiceId.setServiceId(serviceOrder);
					ordService.setOrderServiceId(ordServiceId);
					orderSer.save(ordService);
					
					System.out.println("insert thanh cong ordService");
					
				}
				
                //Customer
				Customer loginCustomer = (Customer) session.getAttribute("customerLogin");
				System.out.println("custerLogin------------" + loginCustomer);

                // ticket
				
				buyTicketInfo.setCustomer(loginCustomer);
				buyTicketInfo.setShowtimeTicket(showtimeGets);
				buyTicketInfo.setOrder(getOrder);
				buyTicketInfo.setStatus(statusTicket);
				buyTicketInfo.setQRCode("https://external-preview.redd.it/cg8k976AV52mDvDb5jDVJABPrSZ3tpi1aXhPjgcDTbw.png?auto=webp&s=1c205ba303c1fa0370b813ea83b9e1bddb7215eb");
				System.out.println(buyTicketInfo + "ticketInfor");
				tickets.save(buyTicketInfo);

			} else {

				model.addAttribute("tinhTrang", "thanh toan khong thanh cong");
				System.out.println("Thanh toan khong thanh cong");
				JsonNode seatNode = jsonNode.get("seat");
	            System.out.println("seatNode: " + seatNode.toString());
	          
				String[] seatList = new String[seatNode.size()];
				for (int i = 0; i < seatNode.size(); i++) {
					seatList[i] = seatNode.get(i).asText();
				}
	            //Update trang thai seat khi da  huy
				for (String seatUpdate : seatList) {
					System.out.println("ghe-------"+seatUpdate);
					seat.updateSeatCancel(seatUpdate);
					System.out.println("Thanh toán không thành công, hủy seat");

				}

				return "redirect:/";
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		//lấy data cho bill
		Movie movieChoose= (Movie)session.getAttribute("movieChoose");
        Showtime theaterSel=(Showtime)session.getAttribute("selectedShowtime");
        System.out.println("abcdef---------"+theaterSel);
        System.out.println("abc"+movieChoose);
        model.addAttribute("movieChoose", movieChoose);
        model.addAttribute("theaterSel", theaterSel);
        model.addAttribute("order", buyTicketInfo);
		return "ticket/bill";
	}
}
