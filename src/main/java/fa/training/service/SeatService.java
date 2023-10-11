package fa.training.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import fa.training.model.Seat;
import fa.training.model.SeatId;
import fa.training.repository.SeatRepository;

@Service
public class SeatService {

	@Autowired
	SeatRepository repo;

	public List<Seat> getAll() {
		return repo.findAll();
	}

	public List<Seat> getAllByRoomId(String roomId ) {
		return repo.getAllByRoom(roomId);
	}
	

	public Seat findById(SeatId seatId) {
		return repo.findById(seatId).orElseThrow(() -> new IllegalArgumentException("Invalid seat Id: " + seatId));
	}

	public boolean existsById(SeatId seatId) {
		return repo.existsById(seatId);
	}

	public Page<Seat> findAll(Pageable pageable) {
		return repo.findAll(pageable);
	}

	public void save(Seat seat) {
		repo.save(seat);
	}

	public void deleteById(SeatId seatId) {
		repo.deleteById(seatId);
	}
	
	public void updateSeatStatus(String seatId) {
		repo.updateSeatStatus(seatId);
    }
	
	public void updateSeatCancel(String seatId) {
		repo.updateSeatCancel(seatId);
    }
	

}
