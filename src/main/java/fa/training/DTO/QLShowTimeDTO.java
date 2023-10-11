package fa.training.DTO;

import java.time.LocalTime;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class QLShowTimeDTO {
	
//	@NotBlank(message = "Chưa nhập dữ liệu")
	String showtimeId;	
	
	@NotBlank(message = "Chưa chọn dữ liệu")
	String theaterId;
	
	@NotBlank(message = "Chưa chọn dữ liệu")
	String roomId;
	
	@NotNull(message = "Chưa chọn dữ liệu")
//	@NotNull(message = "Invalid - anInt - phải not null")
//	@DateTimeFormat(pattern = "HH:mm")
	LocalTime startTime;
	
	@NotBlank(message = "Chưa chọn dữ liệu")
	String movieId;

	@Override
	public String toString() {
		return "QLShowTimeDTO [showtimeId=" + showtimeId + ", movieId=" + movieId + ", theaterId=" + theaterId
				+ ", roomId=" + roomId + ", startTime=" + startTime + "]";
	}
	
	

	
	
	

}
