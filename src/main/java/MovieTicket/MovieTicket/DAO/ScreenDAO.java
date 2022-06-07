package MovieTicket.MovieTicket.DAO;

import java.util.List;

import MovieTicket.MovieTicket.entity.Screen;



public interface ScreenDAO {
	public int addScreen(Screen s);
	public int updateScreen(Screen s);
	public int deleteScreen(Screen s);
	public int deleteScreen(int id);
	
	public List<Screen> getAllScreens();
	public Screen getScreenById(int id);

}
