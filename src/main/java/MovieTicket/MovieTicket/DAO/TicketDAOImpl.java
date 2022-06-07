package MovieTicket.MovieTicket.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import MovieTicket.MovieTicket.entity.Show;
import MovieTicket.MovieTicket.entity.Ticket;
@Repository
public class TicketDAOImpl implements TicketDAO {
	@Autowired
	SessionFactory sessionFactory;
	@Override
	public int add(Ticket ticket) {
		Session session=sessionFactory.getCurrentSession();
		session.save(ticket);
		return  ticket.getId();
	}

	@Override
	public int update(Ticket ticket) {
		Session session=sessionFactory.getCurrentSession();
		session.saveOrUpdate(ticket);
		return  ticket.getId();
	}

	@Override
	public int delete(Ticket ticket) {
		Session session=sessionFactory.getCurrentSession();
		Ticket ticket1=	session.get(Ticket.class, ticket.getId());
		if(ticket1==null)
		{
			return -1;
		}
		session.delete(ticket1);
		return 1;
	}

	@Override
	public int delete(int id) {
		Session session=sessionFactory.getCurrentSession();
		Ticket ticket1=	session.get(Ticket.class, id);
		if(ticket1==null)
		{
			return -1;
		}
		session.delete(ticket1);
		
			return 1;
	}

	@Override
	public List<Ticket> getAll() {
		Session currentSession = sessionFactory.getCurrentSession();
		List<Ticket> tickets=currentSession.createCriteria(Ticket.class).list();
		return tickets;
	}

	@Override
	public Ticket getById(int id) {
		Session session=sessionFactory.getCurrentSession();
		//search the student eixts the id exists or not
		Ticket ticket=session.get(Ticket.class, id);
		return ticket;
	}

}
