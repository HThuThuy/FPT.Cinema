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
public class MovieDTO {
	
	String movieId;

	String movieName;
	
	String startDate;
	
	String endDate;	
	
	int doanhThu;	

}
