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
@Table(name="Screen")
public class Screen implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int Id;
	
	@Column(name="title")	
	@NotEmpty(message="required")
	private String title;
	
	@Column(name="seats")	
	@NotEmpty(message="required")
	private String seats;
	
	
	
	
	
	

	


	@Transient
	private CommonsMultipartFile photo;   //for DataBinder to bind <input type="file".../>
										  //will not be mapped for Hibernate as we store the file in the FileSystem
										  //file will be placed into this field by DataBinder
										  //file is in the memory. needs to be transferred to the FileSystem using java.io.file
	@Column(name = "filename")
	
	private String filename;   	 
	
	public Screen() {};
	




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


	


	


	

	public String getSeats() {
		return seats;
	}





	public void setSeats(String seats) {
		this.seats = seats;
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
