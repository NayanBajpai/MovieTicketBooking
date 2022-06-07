package MovieTicket.MovieTicket.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "tickets")
public class Ticket {
	//object of screen
	
	@Id
	@Column(name="Id")
	@GeneratedValue
	private int Id;
	
	@OneToOne
	@JoinColumn(name="ShowId")
	private Show show;
	
	
	@Column(name="seats")	
	
	private String[] seats ;
	
	

	public String[] getSeats() {
		return seats;
	}

	public void setSeats(String[] seats) {
		this.seats = seats;
	}

	public Ticket() {}

	public int getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public Show getShow() {
		return show;
	}

	public void setShow(Show show) {
		this.show = show;
	}
	
	
}