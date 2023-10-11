package fa.training.DTO;

import java.time.LocalTime;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * QLShowTimeDTO
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
public class QLShowTimeDTO {
	
	String showtimeId;	
	
	@NotBlank(message = "Chưa chọn dữ liệu")
	String theaterId;
	
	@NotBlank(message = "Chưa chọn dữ liệu")
	String roomId;
	
	@NotNull(message = "Chưa chọn dữ liệu")
	LocalTime startTime;
	
	@NotBlank(message = "Chưa chọn dữ liệu")
	String movieId;

	@Override
	public String toString() {
		return "QLShowTimeDTO [showtimeId=" + showtimeId + ", movieId=" + movieId + ", theaterId=" + theaterId
				+ ", roomId=" + roomId + ", startTime=" + startTime + "]";
	}

}
