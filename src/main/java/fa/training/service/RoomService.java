package fa.training.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import fa.training.model.Room;
import fa.training.model.Theater;
import fa.training.repository.RoomRepository;

@Service
public class RoomService {

	@Autowired
	RoomRepository repo;

	public List<Room> getAll() {
		return repo.findAll();
	}

	public Room findById(String roomId) {
		return repo.findById(roomId).orElseThrow(() -> new IllegalArgumentException("Invalid Room Id: " + roomId));
	}

	public boolean existsById(String roomId) {
		return repo.existsById(roomId);
	}

	public Page<Room> findAll(Pageable pageable) {
		return repo.findAll(pageable);
	}

	public void save(Room room) {
		repo.save(room);
	}

	public void deleteById(String roomId) {
		repo.deleteById(roomId);
	}
	
	//LamNH23
	public List<Room> getAllByTheater(String theaterId) {
		return repo.getAllByTheater(theaterId);
	}
	
	// LamNH23
	public void deleteRoom(Iterable<String> ids) {		
		repo.deleteAllByIdInBatch(ids);
	}
	
	

}
