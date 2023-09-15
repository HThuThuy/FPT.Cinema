package fa.training.model;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "CUSTOMER")
public class Customer {

	@Id
	@Column(columnDefinition = "varchar(12)")
	String cccd;

	@Column(columnDefinition = "Nvarchar(50)")
//	@Pattern(regexp = "^[a-zA-ZÀ-ỹỲ-ỹĐđ]+(\\s[a-zA-ZÀ-ỹỲ-ỹĐđ]+)+{3,50}$", message = "Họ tên ít nhất phải có 2 từ và dài từ 3-50 kí tự")
//	@NotBlank(message = "Xin hãy nhập thông tin vào trường này")
	String customerName;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
//	@Past(message = "Ngày sinh phải nhỏ hơn ngày hiện tại")
	LocalDate birthDate;

	@Column(columnDefinition = "varchar(50)")
//	@Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$", message = "Địa chỉ email không đúng định dạng")
//	@NotBlank(message = "Xin hãy nhập thông tin vào trường này")
	String email;

	@Column(columnDefinition = "varchar(11)")
//	@Pattern(regexp = "0[0-9]{9}", message = "Số điện thoại phải bắt đầu bằng 0 và có 10 số")
//	@NotBlank(message = "Xin hãy nhập thông tin vào trường này")
	String phone;

	@Column(columnDefinition = "Nvarchar(5)")
	String gender;

	@Column(columnDefinition = "Nvarchar(255)")
	String address;

	@Column(columnDefinition = "Nvarchar(10)")
	String userType;

	@OneToMany(mappedBy = "customer", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	Set<TicketInfo> ticketCustomer;

	@OneToMany(mappedBy = "customer", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	Set<Users> user;
}
