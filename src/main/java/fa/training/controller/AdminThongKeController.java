package fa.training.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fa.training.DTO.ShowTimeDTO;
import fa.training.service.TicketService;

@Controller
@RequestMapping(value = { "/admin" })
public class AdminThongKeController {
	
	@Autowired
	private TicketService ticketService;
	
	@GetMapping(value = { "/thongKe" })
	public String admin(Model model, @RequestParam(name = "page", defaultValue = "0") int page) {
		int noOfRecords = ticketService.getNoOfShowTimes();
		int recordsPerPage = 5;
		int noOfPages = (int) Math.ceil(noOfRecords * 1.0 / recordsPerPage);
		if (page < 1) {
			page = 1;
		} else if (page > noOfRecords) {
			page = noOfRecords;
		}
		int start = page > 0 ? page - 1 : 0;
		
		List<ShowTimeDTO> list = ticketService.getRecordsForCurrentPage((start) * recordsPerPage, recordsPerPage);
//		model.addAttribute("noOfPages", noOfPages);
//		model.addAttribute("currentPage", page);
		model.addAttribute("suatchieuList", list);		
		
		return "admin/thongKe";
	}
	
	@GetMapping(value = { "/thongKe2" })
	public String admin2(Model model, @RequestParam(name = "page", defaultValue = "0") int page) {
		int noOfRecords = ticketService.getNoOfShowTimes();
		int recordsPerPage = 5;
		int noOfPages = (int) Math.ceil(noOfRecords * 1.0 / recordsPerPage);
		if (page < 1) {
			page = 1;
		} else if (page > noOfRecords) {
			page = noOfRecords;
		}
		int start = page > 0 ? page - 1 : 0;
		
		List<ShowTimeDTO> list = ticketService.getRecordsForCurrentPage((start) * recordsPerPage, recordsPerPage);
//		model.addAttribute("noOfPages", noOfPages);
//		model.addAttribute("currentPage", page);
//		model.addAttribute("suatchieuList", list);		
		
		return "admin/thongKe2";
	}
	
	@GetMapping(value = { "/thongKe3" })
	public String admin3(Model model, @RequestParam(name = "page", defaultValue = "0") int page) {
		int noOfRecords = ticketService.getNoOfShowTimes();
		int recordsPerPage = 5;
		int noOfPages = (int) Math.ceil(noOfRecords * 1.0 / recordsPerPage);
		if (page < 1) {
			page = 1;
		} else if (page > noOfRecords) {
			page = noOfRecords;
		}
		int start = page > 0 ? page - 1 : 0;
		
		List<ShowTimeDTO> list = ticketService.getRecordsForCurrentPage((start) * recordsPerPage, recordsPerPage);
//		model.addAttribute("noOfPages", noOfPages);
//		model.addAttribute("currentPage", page);
//		model.addAttribute("suatchieuList", list);		
		
		return "admin/thongKe3";
	}
	
	@GetMapping(value = { "/thongKeDuLieu" })
	public String admin10() {
		/*
		 * THỐNG KÊ THEO SUẤT CHIẾU
		 * TICKET_INFO -> group by theo showtimeId (Mã suất, Giờ bắt đầu, Giờ kết thúc, Tên phim, Tên rạp)
		 *  -> tính tổng totalPrice (Tổng tiền)
		 */
		
		/*
		 * TICKET_INFO -> group by theo movieId (Tên phim, Giờ bắt đầu, Giờ kết thúc)
		 *  -> tính tổng totalPrice (Tổng tiền)
		 */
		
		/*
		 * TICKET_INFO -> group by theo theaterId (Tên rạp, thành phố)
		 *  -> tính tổng totalPrice (Tổng tiền)
		 */
		return "admin/addSuatChieu";
	}
}

