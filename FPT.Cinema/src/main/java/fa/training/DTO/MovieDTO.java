package fa.training.DTO;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * MovieDTO
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
public class MovieDTO {

	String movieName;	
	Date startDate;	
	Date endDate;	
	String posterUrl;	
	Integer doanhThu;	
}
