package fa.training.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import fa.training.DTO.ShowTimeDTO;
import fa.training.model.TicketInfo;
import fa.training.repository.TicketRepository;

@Service
public class TicketService {

	@Autowired
	TicketRepository repo;

	public List<TicketInfo> getAll() {
		return repo.findAll();
	}

	public TicketInfo findById(Integer ticketId) {
		return repo.findById(ticketId).orElseThrow(() -> new IllegalArgumentException("Invalid TicketInfo Id: " + ticketId));
	}

	public boolean existsById(Integer ticketId) {
		return repo.existsById(ticketId);
	}

	public Page<TicketInfo> findAll(Pageable pageable) {
		return repo.findAll(pageable);
	}

	public void save(TicketInfo ticket) {
		repo.save(ticket);
	}

	public void deleteById(Integer ticketId) {
		repo.deleteById(ticketId);
	}
	
	//LamNH23
	public int getNoOfShowTimes() {
		return 20;
	}
	
	//LamNH23
	public List<ShowTimeDTO> getRecordsForCurrentPage(int start, int recordsPerPage) {
		List<ShowTimeDTO> list = new ArrayList<>();
		list.add(new ShowTimeDTO("ST008", "Tên phim", "Tên rạp", "13:00 - 22/09/2023", "15:00 - 22/09/2023", 12, 25,350000));
		list.add(new ShowTimeDTO("ST009", "Tên phim", "Tên rạp", "13:00 - 22/09/2023", "15:00 - 22/09/2023", 12, 25, 550000));
		return list;
	}

}
