package fa.training.DTO;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * CustomerDTO
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
public class CustomerDTO {

	LocalDate orderDate;

	int orderId;
	
	int ticketId;

	String theaterName;

	String movieName;

	int totalPrice;

	String QRCode;

	@Override
	public String toString() {
		return "CustomerDTO [orderDate=" + orderDate + ", orderId=" + orderId + ", ticketId=" + ticketId
				+ ", theaterName=" + theaterName + ", movieName=" + movieName + ", totalPrice=" + totalPrice
				+ ", QRCode=" + QRCode + "]";
	}

	
}
