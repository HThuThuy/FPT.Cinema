package fa.training.DTO;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Project:Cinema WebApp
 * @author TuNC8
 * Team 2
 * Dùng để lấy dữ liệu từ form Đăng Ký insert vào 2 bảng Tài Khoản Và Khách Hàng
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class InsertRegister {

	@Pattern(regexp = "^[a-zA-ZÀ-ỹỲ-ỹĐđ]+(\\s[a-zA-ZÀ-ỹỲ-ỹĐđ]+)+{3,50}$", message = "Họ tên ít nhất phải có 2 từ và dài từ 3-50 kí tự")
	@NotBlank(message = "Xin hãy nhập thông tin vào trường này")
	String customerName;

	@Pattern(regexp = "0[0-9]{9}", message = "Số điện thoại phải bắt đầu bằng 0 và có 10 số")
	@NotBlank(message = "Xin hãy nhập thông tin vào trường này")
	String phone;

	@Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$", message = "Địa chỉ email không đúng định dạng")
	@NotBlank(message = "Xin hãy nhập thông tin vào trường này")
	String email;

	@Pattern(regexp = "^[a-zA-Z][a-zA-Z0-9_]{2,15}$", message = "Account từ 3-16 kí tự, chỉ chứa dấu gạch dưới và không có kí tự đặc biệt")
	@NotBlank(message = "Xin hãy nhập thông tin vào trường này")
	String account;

	@Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[!@#$%^&*])[a-zA-Z\\d!@#$%^&*]{8,300}$", message = "xxxx")
	@NotBlank(message = "Xin hãy nhập thông tin vào trường này")
	String password;

	String repassword;

	String gender;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Past(message = "Ngày sinh phải nhỏ hơn ngày hiện tại")
	LocalDate birthDate;

	String address;

}
