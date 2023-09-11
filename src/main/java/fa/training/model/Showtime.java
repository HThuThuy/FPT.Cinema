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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "SHOWTIME")
public class Showtime {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int showtimeId;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "movieId")
	Movie movie;
//	
	@ManyToOne
	@JoinColumn(name = "theaterId")
	Theater theater;
	
	@OneToMany(mappedBy = "showtimeTicket", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	Set<TicketInfo> ticketShowTime;

	@DateTimeFormat(pattern = "HH:mm")
	@Column(columnDefinition = "Time")
	LocalTime startTime;

	@DateTimeFormat(pattern = "HH:mm")
	@Column(columnDefinition = "Time")
	LocalTime endTime;

}
