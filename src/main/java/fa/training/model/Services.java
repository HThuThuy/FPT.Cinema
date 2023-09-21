package fa.training.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "SERVICE")
public class Services {
	@Id
//	@Pattern(regexp = "^DV[0-9]{5}$",message ="Mã dịch vụ không đúng định dạng (DVxxxxx)")
//	@NotBlank(message = "Xin hãy nhập thông tin vào trường này sever")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int serviceId;

	@Column(columnDefinition = "Nvarchar(50)")
//	@Pattern(regexp = "^.{3,50}$", message = "Vui lòng nhập từ 3 - 50 kí tự sever")
//	@NotBlank(message = "Xin hãy nhập thông tin vào trường này")
	String serviceName;

	@Column(columnDefinition = "Ntext")
//	@Length(max  = 255, message = "Vui lòng nhập mô tả trong khoảng 3 đến 255 kí tự!")
	String serviceDescription;

//	@Min(value = 1, message = "Đơn giá không được nhỏ hơn hoặc bằng 0")
//	@NotNull(message = "Xin hãy nhập thông tin vào trường này")
	@Column(columnDefinition = "int")
	int servicePrice;
	
	@Column(columnDefinition = "Ntext")
	String url;
//	
	@OneToMany(mappedBy = "services", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	Set<Order> order;
	@Override
	public String toString() {
		return "Services [serviceId=" + serviceId + ", serviceName=" + serviceName + ", serviceDescription="
				+ serviceDescription + ", servicePrice=" + servicePrice + ", order=" + order + "]";
	}
	
	

}
