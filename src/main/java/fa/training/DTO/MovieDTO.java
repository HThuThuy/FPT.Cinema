package fa.training.DTO;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MovieDTO {

	String movieName;	
	Date startDate;	
	Date endDate;	
	String posterUrl;	
	Integer doanhThu;	
}
