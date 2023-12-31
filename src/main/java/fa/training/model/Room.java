package fa.training.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Range;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ROOM")
public class Room {
	@Id
	@Column(columnDefinition = "Nvarchar(255)")
//	@Pattern(regexp = "^PC[0-9]{5}$", message = "mã phòng chiếu không đúng định dạng PCxxxxx")
//	@NotBlank(message = "Xin hãy nhập thông tin vào trường này")
	String roomId;

	@Column(columnDefinition = "Nvarchar(255)")
//	@NotBlank(message = "Xin hãy nhập thông tin vào trường này")
	String roomName;

	@Column(columnDefinition = "Nvarchar(10)")
//	@NotBlank(message = "Xin hãy nhập thông tin vào trường này")
	String roomType;

	@Range(min = 0, message = "Số lượng ghế không được nhỏ hơn 0")
	int seatNumber;

	@JsonBackReference //cho AJAX
	@OneToMany(mappedBy = "room",fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	Set<Seat> seatList;
	
	@JsonBackReference
	@ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	@JoinColumn(name = "theaterId")
	Theater theater;	
	
	@JsonBackReference
	@OneToMany(mappedBy = "room",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	Set<Showtime> showtimeTheater;

	public Room(String roomName) {
		super();
		this.roomName = roomName;
	}
	
	
	
	
}
