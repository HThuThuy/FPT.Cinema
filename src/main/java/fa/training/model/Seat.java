package fa.training.model;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "SEAT")
public class Seat {

	@EmbeddedId
	SeatId seatId;

	@ManyToOne
	@JoinColumn(name = "roomId", insertable = false, updatable = false)
	Room room;

	@Column(columnDefinition = "varchar(3)")
//	@Pattern(regexp = "^[A-Z]{1}$", message = "hàng ghế không đúng định dạng [A-Z]")
//	@NotBlank(message = "Xin hãy nhập thông tin vào trường này")
	String seatPositon;

	String seatType;

}
