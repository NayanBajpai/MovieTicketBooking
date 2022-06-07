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
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import MovieTicket.MovieTicket.entity.Movie;
import MovieTicket.MovieTicket.entity.Screen;
import MovieTicket.MovieTicket.service.MovieService;
import MovieTicket.MovieTicket.service.ScreenService;

@Controller
//requestmapping for the controller
@RequestMapping("/screen")
public class ScreenController {
	//inject the MovieService
		@Autowired
		private ScreenService screenservice;
		@Autowired
		ServletContext servletcontext;
		@RequestMapping("showform")
		public String showForm(Model model)
		{
			//create the object of the student class
			Screen screen=new Screen();
			//create add the student to the model 
			model.addAttribute("screen",screen);
			return "screen-form";
		}
		
		@RequestMapping(value="save",method=RequestMethod.POST)
		public String saveBus(HttpServletRequest request,@Valid @ModelAttribute("screen") Screen screen ,Model model,BindingResult result,HttpSession session) throws Exception
		{
			System.out.println("FILE NAME IS"+request.getParameter("filename"));
			screen.setFilename(request.getParameter("filename"));
			//System.out.println("THE CATEGORY NAME SENT IS "+request.getParameter("buscategory"));
			if(result.hasErrors()) {
				return ("redirect:/screen/showform");
			}
			try
			{
				if(screen.getFilename()==""||screen.getFilename()!=null)
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
					screen.setFilename("");
					//path=session.getServletContext().getRealPath("/resources/images/");
					path="D:\\Core-Java-Programs\\MovieTicket\\src\\main\\webapp\\resources\\images";
					System.out.println(path);
					directory=new File(path+"\\"+screen.getFilename());
				
					boolean temp=directory.exists();
					if(!temp)
					{
						temp=directory.mkdir();
					}
					if(temp)
					{
						CommonsMultipartFile photoInMemory=screen.getPhoto();
						String fileName=photoInMemory.getOriginalFilename();
						
						File localfile=new File(directory.getPath(),fileName);
						
						 photoInMemory.transferTo(localfile);
			               screen.setFilename(localfile.getPath());
			                System.out.println("File is stored at" + localfile.getPath());
			                System.out.print("registerNewUser");
		
			                if(screen.getId()>0) 
			                {
			                	screenservice.updateScreen(screen) ;
			                }
			                else
			                {
			                	screenservice.addScreen(screen);
			                }
			                return "redirect:/screen/list";
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
			List<Screen> screen	= screenservice.getAllScreens();
			//we add the studentlist to the model
			model.addAttribute("screen",screen);
			//retunr the view
			return "screenlist";
		}
		@RequestMapping("editscreen/{id}")
		//{id} we can get this by using @pathvariable to get the value from the url
		public String editScreen(@PathVariable int id,Model model)
		{
			//we get the student information from the service for the id
			Screen screen=screenservice.getScreenById(id);
			//add the student object to the model
			model.addAttribute("screen", screen);
			//retunr the view
			return "screen-form";
		}
		@RequestMapping("deletescreen/{id}")
		//{id} we can get this by using @pathvariable to get the value from the url
		public String deleteScreen(@PathVariable int id,Model model)
		{
			System.out.println(id);
			//we get the student information from the service for the id
			screenservice.deleteScreen(id);
			//add the student object to the model
			//model.addAttribute("student", student);
			//return the view
			return "redirect:/screen/list";
		}
}
