package MovieTicket.MovieTicket.DAO;

import java.util.List;

import MovieTicket.MovieTicket.entity.User;

public interface UserDAO {
	public String add(User user);
	public String update(User user);
	public int delete(User user);
	public int delete(String id);
	//create some method to get the student
	public List<User> getAll();
	public User getById(String id);
	//create a method to authenticate the user
	public User authenticateUser(String emailid,String password);
	
}
