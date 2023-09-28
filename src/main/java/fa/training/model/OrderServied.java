package fa.training.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderServied {
	@EmbeddedId
    OrderServiceId orderServiceId;

	@ManyToOne
	@JoinColumn(name = "serviceId",insertable = false,updatable = false)
	Services services;
	
	@ManyToOne
	@JoinColumn(name = "orderId",insertable = false,updatable = false)
	Order orders;
}
