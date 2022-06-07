package MovieTicket.MovieTicket.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import org.springframework.web.servlet.ModelAndView;

import MovieTicket.MovieTicket.entity.Inox;
import MovieTicket.MovieTicket.entity.Movie;
import MovieTicket.MovieTicket.entity.Screen;
import MovieTicket.MovieTicket.entity.Show;
import MovieTicket.MovieTicket.service.InoxService;
import MovieTicket.MovieTicket.service.MovieService;
import MovieTicket.MovieTicket.service.ScreenService;
import MovieTicket.MovieTicket.service.ShowService;


@Controller
//requestmapping for the controller
@RequestMapping("/show")
public class ShowController {
	//inject the MovieService
		@Autowired
		private MovieService movieservice;
		@Autowired
		private ShowService showservice;
		@Autowired
		private InoxService inoxservice;
		@Autowired
		private ScreenService screenservice;
		@Autowired
		ServletContext servletcontext;
		
		@RequestMapping("showform")
		public ModelAndView addItem(Model model1)
		{
			List<Movie>	movies=movieservice.getAllMovies();
			Map<String, Object> model = new HashMap<String, Object>();
			
			List<Inox>	inox=inoxservice.getAllInox();
			Map<String, Object> model2 = new HashMap<String, Object>();
			
			List<Screen>	screen=screenservice.getAllScreens();
			Map<String, Object> model3 = new HashMap<String, Object>();
			
			model.put("movies",  movies);
			model.put("inox",  inox);
			model.put("screen", screen);
			model.put("show", new Show());
			
			return new ModelAndView("show-form", model);
			
		}
		
		
		@RequestMapping(value="save",method=RequestMethod.POST)
		public ModelAndView saveShow(HttpServletRequest request,@Valid @ModelAttribute("show") Show show ,Model model,BindingResult result,HttpSession session) throws Exception
		{
			
		System.out.println("Show"+show)	;
		if(show.getShowId()==null)	
		{
			show.setShowId(0);
		}
		if(show.getShowId()==0) 
		{
			  showservice.add(show); 
		}	               
		else
        {
        	showservice.update(show);
        }
        return new ModelAndView( "redirect:/show/list");
}	                
					

			        
		  
		    



		@RequestMapping("list")
		public ModelAndView list()
		{
			ModelAndView model=new ModelAndView();
			List<Show> shows=showservice.getAll();
				model.addObject("shows",shows);
				model.setViewName("showlist");
				return model;
			}
		
		@RequestMapping("search")
		public ModelAndView search(@RequestParam("freeText") String freeText)
		{
			ModelAndView model=new ModelAndView();
			List<Show> shows=showservice.getAll(freeText);
				model.addObject("shows",shows);
				model.setViewName("showlist");
				return model;
			}
		@RequestMapping(value="edititem/{id}")
			public ModelAndView editItem(@PathVariable("id") int id)
			{
				//get the item by id
			List<Movie>	movies=movieservice.getAllMovies();
			Map<String, Object> model1 = new HashMap<String, Object>();
			List<Inox>	inox=inoxservice.getAllInox();
			Map<String, Object> model2 = new HashMap<String, Object>();
			
			List<Screen>	screen=screenservice.getAllScreens();
			Map<String, Object> model3 = new HashMap<String, Object>();
			
			model1.put("movies",  movies);
			model1.put("inox",  inox);
			model1.put("screen", screen);
			model1.put("show", new Show());
			
			Show show=showservice.getById(id);
			//Item item=new Item();
			

			model1.put("show",show);
			
			return new ModelAndView("show-form",model1);
			}
			//mapping for delete item
			@RequestMapping(value="deletetem/{id}")
			public String deleteItem(@PathVariable("id") int id)
			{
				//get the item by id
				showservice.delete(id);
				
				return "redirect://show/list";
		}
		
}
