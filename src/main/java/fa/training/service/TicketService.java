package fa.training.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

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
	
	

}
