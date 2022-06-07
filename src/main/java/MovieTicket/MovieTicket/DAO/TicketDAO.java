package MovieTicket.MovieTicket.DAO;

import java.util.List;

import MovieTicket.MovieTicket.entity.Ticket;

public interface TicketDAO {
	
	public int add(Ticket ticket);
	public int update(Ticket ticket);
	public int delete(Ticket ticket);
	public int delete(int id);
	//create some method to get the student
	public List<Ticket> getAll();
	
	public Ticket getById(int id);

}
