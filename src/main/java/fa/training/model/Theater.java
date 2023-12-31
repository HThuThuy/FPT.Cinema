package fa.training.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Range;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "THEATER")
public class Theater {
	@Id
//	@Column(columnDefinition = "varchar(7)")
//	@Pattern(regexp = "^PC[0-9]{5}$", message = "mã phòng chiếu không đúng định dạng PCxxxxx")
//	@NotBlank(message = "Xin hãy nhập thông tin vào trường này")
	@Column(columnDefinition = "Varchar(255)")
	String theaterId;

	@Column(columnDefinition = "Nvarchar(30)")
	@NotBlank(message = "Chưa nhập dữ liệu")
	String theaterName;

	@Column(columnDefinition = "Nvarchar(30)")
	@NotBlank(message = "Chưa nhập dữ liệu")
	String city;
	
	@NotBlank(message = "Chưa nhập dữ liệu")
	@Column(columnDefinition = "Nvarchar(255)")
	String address;
	
//	@NotBlank(message = "Chưa nhập dữ liệu")
	@Pattern(regexp = "^[0]{1}[0-9]{9,10}$", message = "Dữ liệu chưa chính xác")
	@Column(columnDefinition = "Varchar(11)")
	String phone;

	@JsonBackReference
	@OneToMany(mappedBy = "theater",fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	Set<Room> roomList;			

	@Override
	public String toString() {
		return "Theater [theaterId=" + theaterId + ", theaterName=" + theaterName + ", city=" + city + "]";
	}

	public Theater(String theaterId, String theaterName, String city) {
		super();
		this.theaterId = theaterId;
		this.theaterName = theaterName;
		this.city = city;
	}
	
	
	
}
