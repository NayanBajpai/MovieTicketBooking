package MovieTicket.MovieTicket.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import MovieTicket.MovieTicket.entity.Movie;
import MovieTicket.MovieTicket.service.MovieService;

@Controller
//requestmapping for the controller
@RequestMapping("/movie")
public class MovieController {
	//inject the MovieService
		@Autowired
		private MovieService movieservice;
		@Autowired
		ServletContext servletcontext;
		@RequestMapping("showform")
		public String showForm(Model model)
		{
			//create the object of the student class
			Movie movie=new Movie();
			//create add the student to the model 
			model.addAttribute("movie",movie);
			return "movie-form";
		}
		
		@RequestMapping(value="save",method=RequestMethod.POST)
		public String saveBus(HttpServletRequest request,@Valid @ModelAttribute("movie") Movie theMovie ,Model model,BindingResult result,HttpSession session) throws Exception
		{
			System.out.println("FILE NAME IS"+request.getParameter("filename"));
			theMovie.setFilename(request.getParameter("filename"));
			//System.out.println("THE CATEGORY NAME SENT IS "+request.getParameter("buscategory"));
			if(result.hasErrors()) {
				return ("showform");
			}
			try
			{
				if(theMovie.getFilename()==""||theMovie.getFilename()!=null)
				{
					File directory;
					String check=File.separator;
					
					String path=null;
					if(check.equalsIgnoreCase("\\"))
					{
						path=servletcontext.getRealPath("").replace("build\\", "");
					}
					if(check.equalsIgnoreCase("/"))
					{
						path=servletcontext.getRealPath("").replace("build/", "");
						path+="/";
					}
					theMovie.setFilename("");
					//path=session.getServletContext().getRealPath("/resources/images/");
					path="D:\\Core-Java-Programs\\MovieTicket\\src\\main\\webapp\\resources\\images";
					System.out.println(path);
					directory=new File(path+"\\"+theMovie.getFilename());
				
					boolean temp=directory.exists();
					if(!temp)
					{
						temp=directory.mkdir();
					}
					if(temp)
					{
						CommonsMultipartFile photoInMemory=theMovie.getPhoto();
						String fileName=photoInMemory.getOriginalFilename();
						
						File localfile=new File(directory.getPath(),fileName);
						
						 photoInMemory.transferTo(localfile);
			               theMovie.setFilename("resources/images/"+fileName);
			                System.out.println("File is stored at" + localfile.getPath());
			                System.out.print("registerNewUser");
		
			                if(theMovie.getId()>0) 
			                {
			                	movieservice.updateMovie(theMovie); 
			                }
			                else
			                {
			                	movieservice.addMovie(theMovie);
			                }
			                return "redirect:/movie/list";
					}
					else 
					{
		                System.out.println("Failed to create directory!");
		                return "error";
		            }

			        
		        }

		    } catch (IllegalStateException e) {
		        System.out.println("* IllegalStateException: " + e.getMessage());
		        return "error";
		    } catch (IOException e) {
		        // TODO Auto-generated catch block
		        System.out.println("* IOException: " + e.getMessage());
		        return "error";
		    }


			return "error";

		}
//		@RequestMapping(value="save",method=RequestMethod.POST)
//		public String SaveMovies(@Valid @ModelAttribute("movie") Movie theMovie, BindingResult br)
//		{
//			//we check the value of the movie id
//			//if it is null or 0 we will add the record else
//			//update the record
//			//call the service method to add the student and pass the movie object
//			//print the value of the id
//			if(br.hasErrors()) {
//				return"movie-form";
//			}else {
//			System.out.println("Id"+theMovie.getId());
//			if(theMovie.getId()>0)
//			{
//				movieservice.updateMovie(theMovie);
//			}
//			else
//			{
//			movieservice.addMovie(theMovie);
//			}
//
//			
//			return "confirmation";}
//		}
		@RequestMapping("list")
		public String list(Model model)
		{
			//get the list of the students from the service
			List<Movie> movies	= movieservice.getAllMovies();
			//we add the studentlist to the model
			model.addAttribute("movies",movies);
			//retunr the view
			return "movielist";
		}
		
		
		@RequestMapping("editmovie/{id}")
		//{id} we can get this by using @pathvariable to get the value from the url
		public String editMovie(@PathVariable int id,Model model)
		{
			//we get the student information from the service for the id
			Movie movie=movieservice.getMovieById(id);
			//add the student object to the model
			model.addAttribute("movie", movie);
			//retunr the view
			return "movie-form";
		}
		@RequestMapping("deletemovie/{id}")
		//{id} we can get this by using @pathvariable to get the value from the url
		public String deleteMovie(@PathVariable int id,Model model)
		{
			System.out.println(id);
			//we get the student information from the service for the id
			movieservice.deleteMovie(id);
			//add the student object to the model
			//model.addAttribute("student", student);
			//return the view
			return "redirect:/movie/list";
		}
}