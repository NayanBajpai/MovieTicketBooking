package MovieTicket.MovieTicket.controller;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.net.http.HttpRequest;
import java.nio.file.Paths;
import java.util.List;

import javax.imageio.ImageIO;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;


import MovieTicket.MovieTicket.entity.Role;

import MovieTicket.MovieTicket.service.RoleService;

@Controller
//requestmapping for controller
@RequestMapping("/role")
public class RoleController {
//inject CategoryService
	@Autowired
	RoleService roleservice;
	@Autowired
    ServletContext context;
	//RequestMaping for List category
@RequestMapping("list")
public String getAllRole(Model model)
{
	List<Role> roles=roleservice.getAll();
	model.addAttribute("roles",roles);
	return "rolelist";
}
//RequestMaping for Add category
@RequestMapping("add")
public ModelAndView addRole()
{
	//create the object of the category
	//Category category=new Category();
	//ModelAndView model=new ModelAndView();
	return new ModelAndView("role-form", "role", new Role());
	//return "category-form";
}
//request mapping to save the record
@RequestMapping(value="saverole",method=RequestMethod.POST)
public String SaveCategories(HttpServletRequest request, @ModelAttribute("role") Role role  ,Model model)
{
	try {
		 
                if(role.getRoleid()>0)
                roleservice.update(role);
                else
                	 roleservice.add(role);
    			
    			//request.getSession().setAttribute("category", category);
    			
    			return "redirect://role/list";
                 
             

        
        }

     
    catch (Exception e) {
        // TODO Auto-generated catch block
        System.out.println("*** IOException: " + e.getMessage());
        return "error errorMessage error while creating directory";
    }


	

}
//RequestMaping for Add category
@RequestMapping("update/{id}")
public String updateCategories(@PathVariable int id, Model model)
{
	//create the object of the category
	Role role=roleservice.getById(id);
	model.addAttribute("role",role);
	return "role-form";
}
//RequestMaping for Add category
@RequestMapping("delete/{id}")
public String deleteCategories(@PathVariable int id, Model model)
{
	//create the object of the category
	roleservice.delete(id);
	
	return "redirect:/role/list";
}
//RequestMaping for search category
@RequestMapping("search")
public String searchCategories(@RequestParam String role, Model model)
{
	//create the object of the category
	//roleservice.delete(id);

 //List<Category>	categories=roleservice.searchCategory(catname);
	List<Role>	roles=roleservice.searchRole(role);

 model.addAttribute("roles",roles);
	return "rolelist";
}

}
