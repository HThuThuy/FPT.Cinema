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
public class RegisterDTO {

	String customerName;

	String phone;

	String email;

	String account;

	String passwordRegister;

	String repasswordRegister;

	String gender;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Past(message = "Ngày sinh phải nhỏ hơn ngày hiện tại")
	LocalDate birthDate;

	String cccd;

	@Override
	public String toString() {
		return "RegisterDTO [customerName=" + customerName + ", phone=" + phone + ", email=" + email + ", account="
				+ account + ", password=" + passwordRegister + ", repassword=" + repasswordRegister + ", gender=" + gender
				+ ", birthDate=" + birthDate + ", cccd=" + cccd + "]";
	}
	
	

}
