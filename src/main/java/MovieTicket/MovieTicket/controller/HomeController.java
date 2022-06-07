package MovieTicket.MovieTicket.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import MovieTicket.MovieTicket.entity.User;
import MovieTicket.MovieTicket.service.UserService;



@Controller
public class HomeController {

	@Autowired
	UserService userservice;
	@Autowired
	
	@RequestMapping(value="/")
	public ModelAndView myHomePage()
	{
		//get all the categories
		
		//return the name of the view i.e jsp file name
		return new ModelAndView("home");
	}
	//to get the registration form we have to create the mapping
	@RequestMapping(value="/register")
	public String userRegister()
	{
		//return the name of the view i.e jsp file name
		return "registration";
	}
	@RequestMapping(value="/login")
	public String userlogin()
	{
		//return the name of the view i.e jsp file name
		return "login";
	}
	@RequestMapping(value="/processform",method=RequestMethod.POST)
	public String userRegisterProcess(HttpServletRequest request,Model model)
	{
		//get the getparameter(name of the control of each inside the form
		String name=request.getParameter("name");
		String emailid=request.getParameter("email");
		String password=request.getParameter("password");
		String message=" Please Confirm <br> Name :"+name+"<br> Email ID :"+emailid+"<br> Password:"+password;
		//add the the values into the Model object
		model.addAttribute("messages",message);
		
		//print the values 
		System.out.println("Name : "+name+" Email : "+emailid+" Password : "+password);
		//return the name of the view i.e jsp file name
		return "confirmation";
	}
	@RequestMapping(value="/processlogin",method=RequestMethod.POST)
	public String userloginProcess(HttpServletRequest request,Model model,HttpSession session)
	{
		//get the getparameter(name of the control of each inside the form
		//getting the values on form submit
		String emailid=request.getParameter("email");
		String password=request.getParameter("password");
		String message="";
		String viewpagename="";
		//we have method to authenticate the user
		User user=	userservice.authenticateUser(emailid, password);
		//if user!=null valid user
		if(user!=null)
		{
			//create a session object and add the user to the sesssion
			
			//check the role of the user
			System.out.println(user.getRole().getRole());
			String role=user.getRole().getRole();
			//we need the ssesion object to store the object and use it globally 
			//the valeu stroed into the session will be lost:
			//1. Session expired
			//2. User click on logout
			
			session.setAttribute("user", user);
			session.setAttribute("userrole", role.toLowerCase());
			System.out.println("Expire Time in Min"+ session.getMaxInactiveInterval());
			//role of the user
		if(role.equals("Admin"))
		{
		 message=" Welcome :"+ emailid ;
		 model.addAttribute("messages",message);
		 viewpagename="admindashboard";
		}
		
		else if(role.equals("Customer"))
		{
		 message=" Welcome :"+ emailid ;
		 model.addAttribute("messages",message);
		 viewpagename="customerdashboard";
		}
		}
		else
		{
				message="Invalid loginId and Password" ;
				model.addAttribute("errormessages",message);
				viewpagename="login";
		}
		//add the the values into the Model object
		
	
		//print the values 
		//System.out.println("Name : "+name+" Email : "+emailid+" Password : "+password);
		//return the name of the view i.e jsp file name
		return viewpagename;
	}
	
	@RequestMapping (value="/adminpanel")
	public ModelAndView panel(HttpServletRequest request,Model model,HttpSession session) {
		
		if(session.getAttribute("user")==null)
		{
			model.addAttribute("error", "Authentication Required.Please Login");
			return new ModelAndView("authorize");
		}
		String role=(String)session.getAttribute("userrole");
		if(role.contentEquals("admin") || role.equals("employee"))
		{
		return new ModelAndView("admin-panel");
		}
		else
		{
			model.addAttribute("error", "Sorry your are not authorized for this work");
			return new ModelAndView("authorize");	}
	}
	
}