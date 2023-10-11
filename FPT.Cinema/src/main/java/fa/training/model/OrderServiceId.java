package fa.training.model;




import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor


public class OrderServiceId implements Serializable  {/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

//	@ManyToOne
//	@JoinColumn(name = "serviceId")
//	Services services;
//	
//	@ManyToOne
//	@JoinColumn(name = "orderId")
//	Order orders;
	
	int orderId;
	
	String serviceId;
	
	
}
