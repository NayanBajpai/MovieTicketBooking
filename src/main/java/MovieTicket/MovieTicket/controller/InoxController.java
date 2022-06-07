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

import MovieTicket.MovieTicket.entity.Inox;

import MovieTicket.MovieTicket.service.InoxService;


@Controller
//requestmapping for the controller
@RequestMapping("/inox")
public class InoxController {
	//inject the MovieService
		@Autowired
		private InoxService inoxservice;
		@Autowired
		ServletContext servletcontext;
		@RequestMapping("showform")
		public String showForm(Model model)
		{
			//create the object of the student class
			Inox inox=new Inox();
			//create add the student to the model 
			model.addAttribute("inox",inox);
			return "inox-form";
		}
		
		@RequestMapping(value="save",method=RequestMethod.POST)
		public String saveBus(HttpServletRequest request,@Valid @ModelAttribute("inox") Inox inox ,Model model,BindingResult result,HttpSession session) throws Exception
		{
			System.out.println("FILE NAME IS"+request.getParameter("filename"));
			inox.setFilename(request.getParameter("filename"));
			//System.out.println("THE CATEGORY NAME SENT IS "+request.getParameter("buscategory"));
			if(result.hasErrors()) {
				return ("redirect:/inox/showform");
			}
			try
			{
				if(inox.getFilename()==""||inox.getFilename()!=null)
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
					inox.setFilename("");
					path=session.getServletContext().getRealPath("/resources/images/");
					System.out.println(path);
					directory=new File(path+"\\"+inox.getFilename());
				
					boolean temp=directory.exists();
					if(!temp)
					{
						temp=directory.mkdir();
					}
					if(temp)
					{
						CommonsMultipartFile photoInMemory=inox.getPhoto();
						String fileName=photoInMemory.getOriginalFilename();
						
						File localfile=new File(directory.getPath(),fileName);
						
						 photoInMemory.transferTo(localfile);
			               inox.setFilename(localfile.getPath());
			                System.out.println("File is stored at" + localfile.getPath());
			                System.out.print("registerNewUser");
		
			                if(inox.getId()>0) 
			                {
			                	inoxservice.updateInox(inox) ;
			                }
			                else
			                {
			                	inoxservice.addInox(inox);
			                }
			                return "redirect:/inox/list";
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

		@RequestMapping("list")
		public String list(Model model)
		{
			//get the list of the students from the service
			List<Inox> inox	= inoxservice.getAllInox();
			//we add the studentlist to the model
			model.addAttribute("inoxes",inox);
			//retunr the view
			return "inoxlist";
		}
		@RequestMapping("editinox/{id}")
		//{id} we can get this by using @pathvariable to get the value from the url
		public String editInox(@PathVariable int id,Model model)
		{
			//we get the student information from the service for the id
			Inox inox=inoxservice.getInoxById(id);
			//add the student object to the model
			model.addAttribute("inox", inox);
			//retunr the view
			return "inox-form";
		}
		@RequestMapping("deleteinox/{id}")
		//{id} we can get this by using @pathvariable to get the value from the url
		public String deleteInox(@PathVariable int id,Model model)
		{
			System.out.println(id);
			//we get the student information from the service for the id
			inoxservice.deleteInox(id);
			//add the student object to the model
			//model.addAttribute("student", student);
			//return the view
			return "redirect:/inox/list";
		}
}
