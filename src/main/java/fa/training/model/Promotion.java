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
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;
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
@Table(name = "PROMOTION")
public class Promotion {
	@Id
	@Column(columnDefinition = "varchar(7)")
//	@Pattern(regexp = "^KM[0-9]{5}$", message = "Mã khuyến mãi không đúng định dạng KMxxxxx")
//	@NotBlank(message = "Xin hãy nhập thông tin vào trường này")
	String promotionId;

	@Column(columnDefinition = "Nvarchar(50)")
//	@NotBlank(message = "Xin hãy nhập thông tin vào trường này")
//	@Length(min = 3, max = 50, message = "Vui lòng nhập tên khuyến mãi từ 3 - 50 kí tự!")
	String promotionName;

	@Column(columnDefinition = "Ntext")
	String promotionDescription;

	@Column(columnDefinition = "date")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
//	@NotNull(message = "Vui lòng nhập ngày bắt đầu khuyến mãi!")
	LocalDate startDate;

	@Column(columnDefinition = "date")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
//	@NotNull(message = "Vui lòng nhập ngày kết thúc khuyến mãi!")
	LocalDate endDate;

//	@Range(min = 0, max = 100, message = "Vui lòng nhập tỉ lệ khuyến mãi nằm trong khoảng từ 0 tới 100!")
//	@NotNull(message = "VUi lòng nhập tỉ lệ khuyến mãi!")
	int discountPercent;
	
	@Column(columnDefinition = "text")
	String url;
	
	@OneToMany(mappedBy = "promotion", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	Set<Order> orderList;
	
	String url;
//

}
