package fa.training.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Embeddable
public class SeatId implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(columnDefinition = "varchar(7)")
//	@Pattern(regexp = "^[A-Z]{1}[0-9]{1,2}$", message = "mã ghế không đúng định dạng [A-Z]xx")
//	@NotBlank(message = "Xin hãy nhập thông tin vào trường này")
	String seatId;
	
	@Column(columnDefinition = "varchar(7)")
//	@Pattern(regexp = "^PC[0-9]{5}$", message = "mã phòng chiếu không đúng định dạng PCxxxxx")
//	@NotBlank(message = "Xin hãy nhập thông tin vào trường này")
	String roomId;

}
