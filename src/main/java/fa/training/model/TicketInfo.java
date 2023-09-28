package fa.training.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "TICKET_INFO")
public class TicketInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int ticketId;

	@Column(columnDefinition = "Nvarchar(50)")
//	@NotBlank(message = "Xin hãy nhập thông tin vào trường này")
	String status;

	@ManyToOne
	@JoinColumn(name = "showtimeId")
	Showtime showtimeTicket;

	@ManyToOne
	@JoinColumn(name = "cccd")
	Customer customer;

	@ManyToOne
	@JoinColumn(name = "orderId")
	Order order;

	String QRCode;
	
	
	@Override
	public String toString() {
		return "TicketInfo [ticketId=" + ticketId + ", status=" + status + ", showtimeTicket=" + showtimeTicket.getShowtimeId()
				+ ", customer=" + customer.getCccd() + ", order=" + order.getOrderId() + "]";
	}
	
	
}
