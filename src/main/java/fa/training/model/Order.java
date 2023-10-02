package fa.training.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

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
@Table(name = "ORDERS")
public class Order {

	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	int orderId;

	
	@OneToMany(mappedBy = "orders", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	Set<OrderServied> orderServiceIds;
	
	@ManyToOne
	@JoinColumn(name = "promotionId")
	Promotion promotion;
	
	@OneToMany(mappedBy = "order", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	Set<TicketInfo> ticketInfoList;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	LocalDate orderDate;
	
	@DateTimeFormat(pattern = "HH:mm")
	@Column(columnDefinition = "Time")
	LocalTime orderTime;
	
//	@Range(min = 0, message = "Số lượng không được nhỏ hơn 0")
	int totalPrice;

}
