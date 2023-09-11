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
	@Column(columnDefinition = "Varchar(10)")
	String theaterId;

	@Column(columnDefinition = "Nvarchar(20)")
//	@NotBlank(message = "Xin hãy nhập thông tin vào trường này")
	String theaterName;

	@Column(columnDefinition = "Nvarchar(10)")
//	@NotBlank(message = "Xin hãy nhập thông tin vào trường này")
	String city;

	@OneToMany(mappedBy = "theater", cascade = CascadeType.ALL)
	Set<Room> roomList;
	
	@OneToMany(mappedBy = "theater",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	Set<Showtime> showtimeTheater;
	
}
