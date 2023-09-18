package fa.training.DTO;

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
public class ShowTimeDTO {
	
	String showtimeId;

	String movieName;
	
	String theaterName;	
	
	String startTime;
	
	String endTime;	
	
	int soGheDat;
	
	int soGheTrong;
	
	int doanhThu;	

}
