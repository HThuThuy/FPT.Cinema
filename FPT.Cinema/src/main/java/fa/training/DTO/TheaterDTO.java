package fa.training.DTO;

import fa.training.model.Room;
import fa.training.model.SeatId;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * TheaterDTO
 * 
 * Version 1.0
 * 
 * Date: 09-10-2023
 * 
 * Copyright
 * 
 * Modification Logs:
 * DATE			AUTHOR		DESCRIPTION
 * --------------------------------
 * 09-10-2023	LamNH23		Create
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TheaterDTO {

	String theaterName;	
	String city;
	String address;
	String phone;
	Integer doanhThu;
}
