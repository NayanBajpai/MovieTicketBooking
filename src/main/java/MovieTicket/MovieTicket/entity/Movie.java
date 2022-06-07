package MovieTicket.MovieTicket.entity;
import java.io.Serializable;
import java.util.LinkedHashMap;

import javax.annotation.processing.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import javax.validation.constraints.*;

import org.springframework.web.multipart.commons.CommonsMultipartFile;


@Entity
@Table(name="Movies")
public class Movie implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int Id;
	
	@Column(name="title")	
	@NotEmpty(message="required")
	private String title;
	
	
	
	@Column (name = "releaseDate")
	//@Pattern(regexp="/^\\d{4}-(0[1-9]|1[0-2])-(0[1-9]|[12][0-9]|3[01])/",message="Date should only contain numeric values") 
	@NotNull(message="required")
	private String releaseDate;
	
	@Column (name = "movieLength")
	//@Pattern(regexp="^(?=.*[0-9])$",message="Movie Length should only contain numeric values") 
	@NotNull(message="required")
	private String movieLength;
	
	@Column (name = "movieGenre")
	@NotEmpty(message="required")
	
	private String movieGenre;
	
	@Column (name = "movieLanguage")
	//@Pattern(regexp="(?=.*[a-z])(?=.*[A-Z])",message="Language  should only contain alphabetic values") 
	@NotEmpty(message="required")
	private String movieLanguage;
	
	@Column (name = "movieDescription")
	@NotEmpty(message="required")
	private String movieDescription;
	
	@Column (name = "movieStatus")
	@NotEmpty(message="required")
	private String movieStatus;
	
	@Column (name = "movieDirector")
	@NotEmpty(message="required")
	private String movieDirector;
	
	@Column (name = "movieHero")
	@NotEmpty(message="required")
	private String movieHero;
	
	
	
	

	


	@Transient
	private CommonsMultipartFile photo;   //for DataBinder to bind <input type="file".../>
										  //will not be mapped for Hibernate as we store the file in the FileSystem
										  //file will be placed into this field by DataBinder
										  //file is in the memory. needs to be transferred to the FileSystem using java.io.file
	@Column(name = "filename")
	
	private String filename;   	 
	
	public Movie() {};
	




	public int getId() {
		return Id;
	}


	public void setId(int id) {
		Id = id;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	


	public String getReleaseDate() {
		return releaseDate;
	}


	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}


	public String getMovieLength() {
		return movieLength;
	}


	public void setMovieLength(String movieLength) {
		this.movieLength = movieLength;
	}


	public String getMovieGenre() {
		return movieGenre;
	}


	public void setMovieGenre(String movieGenre) {
		this.movieGenre = movieGenre;
	}


	public String getMovieLanguage() {
		return movieLanguage;
	}


	public void setMovieLanguage(String movieLanguage) {
		this.movieLanguage = movieLanguage;
	}


	public String getMovieDescription() {
		return movieDescription;
	}


	public void setMovieDescription(String movieDescription) {
		this.movieDescription = movieDescription;
	}


	public String getMovieStatus() {
		return movieStatus;
	}


	public void setMovieStatus(String movieStatus) {
		this.movieStatus = movieStatus;
	}


	public String getMovieDirector() {
		return movieDirector;
	}


	public void setMovieDirector(String movieDirector) {
		this.movieDirector = movieDirector;
	}


	public String getMovieHero() {
		return movieHero;
	}


	public void setMovieHero(String movieHero) {
		this.movieHero = movieHero;
	}


	

	public CommonsMultipartFile getPhoto() {
		return photo;
	}


	public void setPhoto(CommonsMultipartFile photo) {
		this.photo = photo;
	}


	public String getFilename() {
		return filename;
	}


	public void setFilename(String filename) {
		this.filename = filename;
	}
	
	
	
	
//constructor
	
}
