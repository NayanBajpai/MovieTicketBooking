package MovieTicket.MovieTicket.service;


import java.util.List;

import MovieTicket.MovieTicket.entity.Inox;

public interface InoxService {

		public int addInox(Inox inox);
		public int updateInox(Inox student);
		public int deleteInox(Inox student);
		public int deleteInox(int id);
		
		public List<Inox> getAllInox();
		public Inox getInoxById(int id);
}
