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

import org.hibernate.validator.constraints.Length;
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
@Table(name = "MOVIE")
public class Movie {

	@Id
	@Column(columnDefinition = "varchar(7)")
//	@Pattern(regexp = "^PH[0-9]{5}$", message = "mã phim không đúng định dạng PHxxxxx")
//	@NotBlank(message = "Xin hãy nhập thông tin vào trường này")
	String movieId;
	
	@Column(columnDefinition = "Nvarchar(50)")
//	@NotBlank(message = "Xin hãy nhập thông tin vào trường này")
//	@Length(min = 3,max = 50,message = "Tên phim từ 3 kí tự và không quá 50 kí tự")
	String movieName;
	
	@Column(columnDefinition = "Ntext")
//	@NotBlank(message = "Xin hãy nhập thông tin vào trường này")
	String movieDescription;
	
	@Column(columnDefinition = "Nvarchar(50)")
//	@NotBlank(message = "Xin hãy nhập thông tin vào trường này")
//	@Length(min = 3,max = 50,message = "Tên phim từ 3 kí tự và không quá 50 kí tự")
	String director;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	LocalDate startDate;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	LocalDate endDate;
	
	@DateTimeFormat(pattern = "HH:mm")
	@Column(columnDefinition = "Time")
	LocalTime duration;
	
	String posterUrl;
	
	@OneToMany(mappedBy = "movie",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	Set<Showtime> showtimeList;

}
