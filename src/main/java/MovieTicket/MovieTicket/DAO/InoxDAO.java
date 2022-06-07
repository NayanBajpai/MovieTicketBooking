package MovieTicket.MovieTicket.DAO;

import java.util.List;

import org.springframework.beans.factory.parsing.Location;

import MovieTicket.MovieTicket.entity.Inox;


public interface InoxDAO {
	
	public int addInox(Inox inox);
	public int updateInox(Inox inox);
	public int deleteInox(Inox inox);
	public int deleteInox(int id);
	
	public List<Inox> getAllInox();
	public Inox getInoxById(int id);
	

}
