package MovieTicket.MovieTicket.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


import MovieTicket.MovieTicket.entity.Role;
import MovieTicket.MovieTicket.entity.User;
import MovieTicket.MovieTicket.service.RoleService;
import MovieTicket.MovieTicket.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userservice;
	@Autowired
	private RoleService roleservice;
	
	@RequestMapping("/list")
	public ModelAndView getAllUser()
	{
	 List<User> users=  userservice.getAll();
	 	return new ModelAndView("userlist","users",users);
	}
	@RequestMapping("/add")
	public ModelAndView createUser()
	{
		//get the list of the Role
		List<Role>	roles=roleservice.getAll();
		Map<String, Object> model = new HashMap<String, Object>();
		//for(Category category : categories)
		//{
		   // categoriesMap.put(category, category.getCategoryName());
		//}
		model.put("rolelist",  roles);
		model.put("user", new User());
		return new ModelAndView("user-form",model);
	}
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public ModelAndView userSave(@Valid @ModelAttribute("user")User user,BindingResult result)
	{
		//System.out.println("Email:"+user.getEmail());
		//System.out.println("Role:"+user.getRole().getRoleid());
		//return new ModelAndView("user-form");
		if(result.hasErrors())
		{
			System.out.println("error");
			List<Role>	roles=roleservice.getAll();
			Map<String, Object> model = new HashMap<String, Object>();
			//for(Category category : categories)
			//{
			   // categoriesMap.put(category, category.getCategoryName());
			//}
			model.put("rolelist",  roles);
			//model.put("user", new User());
			return new ModelAndView("user-form",model);
		}
		else
		{
		userservice.add(user);
		return new ModelAndView("redirect:/user/list");
		}
	}
		@RequestMapping("/deleteuser")
		public ModelAndView deleteUser(@RequestParam("email") String email)
		{
		User user= userservice.getById(email);
		
			System.out.println(email);
			userservice.delete(email);
			return new ModelAndView("userlist");
		}
		
		@RequestMapping("/edituser")
		public ModelAndView editUser(@RequestParam("email") String email)
		{
		User user= userservice.getById(email);
		List<Role>	roles=roleservice.getAll();
		Map<String, Object> model = new HashMap<String, Object>();
		//for(Category category : categories)
		//{
		   // categoriesMap.put(category, category.getCategoryName());
		//}
		model.put("rolelist",  roles);
		model.put("user", user);
		return new ModelAndView("user-form",model);
			
		}
	
}
