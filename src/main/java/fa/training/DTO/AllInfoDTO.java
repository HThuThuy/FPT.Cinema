package fa.training.DTO;

import java.time.LocalDate;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AllInfoDTO {
	private String cccd;
	private String hoTen;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate ngaySinh;
	private String gioiTinh;
	
	@Pattern(regexp = "^0\\d{9,10}$", message = "SDT phải đúng định dạng , có 10 hoặc 11 số và bắt đầu bằng số 0  ")
	private String sdt;
	
	private String trangThaiTiem;
	
	@NotEmpty(message = "Please enter your ketQuaXetNghiem.")
	private String ketQuaXetNghiem;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	
	
	private LocalDate ngayXetNghiem; 
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate ngayDatVe;
	
	@Pattern(regexp = "\\d{2}[A-Z]-\\d{3}\\.\\d{2}", message = "Biển số xe phải đúng định dạng 'xxY-xxx.xx'")
	private String bienSoXe;
	private String diaDiemXuatPhat;
	
	private int maDV;
	
	private String diaDiemDen;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate ngayXuatPhat;
	@Override
	public String toString() {
		return "AllInfoDTO [cccd=" + cccd + ", hoTen=" + hoTen + ", ngaySinh=" + ngaySinh + ", gioiTinh=" + gioiTinh
				+ ", sdt=" + sdt + ", trangThaiTiem=" + trangThaiTiem + ", ketQuaXetNghiem=" + ketQuaXetNghiem
				+ ", ngayXetNghiem=" + ngayXetNghiem + ", ngayDatVe=" + ngayDatVe + ", bienSoXe=" + bienSoXe
				+ ", diaDiemXuatPhat=" + diaDiemXuatPhat + ", maDV=" + maDV + ", diaDiemDen=" + diaDiemDen
				+ ", ngayXuatPhat=" + ngayXuatPhat + "]";
	}
	
	
	
	
	
}
