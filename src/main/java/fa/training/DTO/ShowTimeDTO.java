package fa.training.DTO;

import java.math.BigInteger;
import java.sql.Date;
import java.sql.Time;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ShowTimeDTO {

	String theaterName;		
	String roomName;	
	Time startTime;
	String movieName;
	Date startDate;
	Date endDate;		
	Integer doanhThu;
	
	@Override
	public String toString() {
		return "ShowTimeDTO [theaterName=" + theaterName + ", roomName=" + roomName + ", startTime=" + startTime
				+ ", movieName=" + movieName + ", startDate=" + startDate + ", endDate=" + endDate + ", doanhThu="
				+ doanhThu + "]";
	}
	
	
	
}
