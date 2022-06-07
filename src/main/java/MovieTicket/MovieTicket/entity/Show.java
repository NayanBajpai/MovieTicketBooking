package MovieTicket.MovieTicket.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name="showTiming")
public class Show {
	
	@Id
	@Column(name="showId")
	@GeneratedValue
	private Integer showId;
	
	@OneToOne
	 @JoinColumn(name="movieId")
	private Movie movie;
	
	@OneToOne
	 @JoinColumn(name="InoxId")
	private Inox inox;
	
	@OneToOne
	 @JoinColumn(name="ScreenId")
	private Screen screen;
	 
	@Column(name="time")	
	
	private String time;

	



	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public Show() {};
	public Screen getScreen() {
		return screen;
	}



	public void setScreen(Screen screen) {
		this.screen = screen;
	}
	

	public Integer getShowId() {
		return showId;
	}

	public void setShowId(Integer showId) {
		this.showId = showId;
	}

	
	 public Inox getInox() {
			return inox;
		}

		public void setInox(Inox inox) {
			this.inox = inox;
		}
		
	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	
	 
}
