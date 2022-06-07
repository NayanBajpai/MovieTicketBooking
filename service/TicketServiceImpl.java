package MovieTicket.MovieTicket.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import MovieTicket.MovieTicket.DAO.ShowDAO;
import MovieTicket.MovieTicket.DAO.TicketDAO;
import MovieTicket.MovieTicket.entity.Ticket;
@Service
@Transactional
public class TicketServiceImpl implements TicketService {
	@Autowired
	TicketDAO tdao;
	@Override
	public int add(Ticket ticket) {
		// TODO Auto-generated method stub
		return tdao.add(ticket);
	}

	@Override
	public int update(Ticket ticket) {
		// TODO Auto-generated method stub
		return tdao.update(ticket);
	}

	@Override
	public int delete(Ticket ticket) {
		// TODO Auto-generated method stub
		return tdao.delete(ticket);
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return tdao.delete(id);
	}

	@Override
	public List<Ticket> getAll() {
		// TODO Auto-generated method stub
		return tdao.getAll();
	}

	@Override
	public Ticket getById(int id) {
		// TODO Auto-generated method stub
		return tdao.getById(id);
	}

}
