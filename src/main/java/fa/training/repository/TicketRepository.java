package fa.training.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fa.training.model.TicketInfo;

@Repository
public interface TicketRepository extends JpaRepository<TicketInfo, Integer> {

}
