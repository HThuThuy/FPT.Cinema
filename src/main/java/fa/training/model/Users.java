package fa.training.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "USERS")
public class Users {
	@Id
	@Column(columnDefinition = "varchar(16)")
//	@Pattern(regexp = "^[a-zA-Z][a-zA-Z0-9_]{2,15}$", message = "Account từ 3-16 kí tự, chỉ chứa dấu gạch dưới và không có kí tự đặc biệt")
//	@NotBlank(message = "Xin hãy nhập thông tin vào trường này")
	String account;

	@Column(columnDefinition = "text")
//	@NotBlank(message = "Xin hãy nhập thông tin vào trường này")
	String password;

	@Column(columnDefinition = "varchar(20)")
	String userRole;

	@Column(columnDefinition = "varchar(20)")
	String status;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "cccd")
	Customer customer;

}
