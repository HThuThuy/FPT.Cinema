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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

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
	
	@ManyToOne
	Room room;
	
	@OneToMany(mappedBy = "showtimeTicket", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	Set<TicketInfo> ticketShowTime;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	LocalDate startDate;

	@DateTimeFormat(pattern = "HH:mm")
	@Column(columnDefinition = "Time")
	LocalTime startTime;

	public Showtime(int showtimeId, Movie movie, Theater theater, Room room, LocalDate startDate, LocalTime startTime) {
		super();
		this.showtimeId = showtimeId;
		this.movie = movie;
		this.theater = theater;
		this.room = room;
		this.startDate = startDate;
		this.startTime = startTime;
	}

	@Override
	public String toString() {
		return "Showtime [showtimeId=" + showtimeId + ", movie=" + movie.movieId + ", theater=" + theater.theaterId + ", room=" + room.roomId
				+ ", startDate=" + startDate + ", startTime=" + startTime + "]";
	}

	

	
	
	

}
