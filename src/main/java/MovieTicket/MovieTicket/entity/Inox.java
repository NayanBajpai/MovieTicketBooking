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
@Table(name="Inox")
public class Inox implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int Id;
	
	@Column(name="title")	
	@NotEmpty(message="required")
	private String title;
	
	
	
	@Column (name = "inoxLocation")
	//@Pattern(regexp="/^\\d{4}-(0[1-9]|1[0-2])-(0[1-9]|[12][0-9]|3[01])/",message="Date should only contain numeric values") 
	@NotNull(message="required")
	private String inoxLocation;
	
	@Column (name = "inoxServiceRating")
	//@Pattern(regexp="^(?=.*[0-9])$",message="Movie Length should only contain numeric values") 
	@NotNull(message="required")
	private String inoxServiceRating;
	
	@Column (name = "noOfScreens")
	@NotEmpty(message="required")
	private String noOfScreens;
	
	
	
	
	
	

	


	@Transient
	private CommonsMultipartFile photo;   //for DataBinder to bind <input type="file".../>
										  //will not be mapped for Hibernate as we store the file in the FileSystem
										  //file will be placed into this field by DataBinder
										  //file is in the memory. needs to be transferred to the FileSystem using java.io.file
	@Column(name = "filename")
	
	private String filename;   	 
	
	public Inox() {};
	




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


	


	


	

	public String getInoxLocation() {
		return inoxLocation;
	}





	public void setInoxLocation(String inoxLocation) {
		this.inoxLocation = inoxLocation;
	}





	public String getInoxServiceRating() {
		return inoxServiceRating;
	}





	public void setInoxServiceRating(String inoxServiceRating) {
		this.inoxServiceRating = inoxServiceRating;
	}





	public String getNoOfScreens() {
		return noOfScreens;
	}





	public void setNoOfScreens(String noOfScreens) {
		this.noOfScreens = noOfScreens;
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
