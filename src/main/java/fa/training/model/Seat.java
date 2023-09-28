package fa.training.model;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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
	String seatPosition;

	String seatType;
	
	String seatStatus;

	@Override
	public String toString() {
		return "Seat [seatId=" + seatId + ", room=" + room + ", seatPositon=" + seatPosition + ", seatType=" + seatType
				+ ", seatStatus=" + seatStatus + "]";
	}
	
	

}
