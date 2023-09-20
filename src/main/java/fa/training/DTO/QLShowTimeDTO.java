package fa.training.DTO;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import org.springframework.format.annotation.DateTimeFormat;

import fa.training.model.Room;
import fa.training.model.SeatId;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class QLShowTimeDTO {
	
	@Positive(message = "Invalid - anInt - phải > 0")
	int showtimeId;

	@NotBlank(message = "Invalid - string - không empty hoặc chứa toàn khoảng trắng")
	String movieId;
	
	@NotBlank(message = "Invalid - string - không empty hoặc chứa toàn khoảng trắng")
	String theaterId;	
	
	@NotBlank(message = "Invalid - string - không empty hoặc chứa toàn khoảng trắng")
	String roomId;
	
	@NotNull(message = "Invalid - anInt - phải not null")
	@Future(message = "Invalid - date - ngày > ngày hiện tại")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	LocalDate startDate;
	
	@NotNull(message = "Invalid - anInt - phải not null")
	@DateTimeFormat(pattern = "HH:mm")
	LocalTime startTime;
	
	

	@Override
	public String toString() {
		return "QLShowTimeDTO [showtimeId=" + showtimeId + ", movieId=" + movieId + ", theaterId=" + theaterId
				+ ", roomId=" + roomId + ", startDate=" + startDate + ", startTime=" + startTime + "]";
	}	
	
	

}
