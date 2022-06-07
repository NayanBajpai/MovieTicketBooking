package MovieTicket.MovieTicket.DAO;

import java.util.List;

import MovieTicket.MovieTicket.entity.Show;

public interface ShowDAO {
	public int add(Show show);
	public int update(Show show);
	public int delete(Show show);
	public int delete(int id);
	//create some method to get the student
	public List<Show> getAll();
	public List<Show> getAll(String txt);
	public Show getById(int id);

}
