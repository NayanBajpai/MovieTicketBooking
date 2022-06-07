package MovieTicket.MovieTicket.DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import MovieTicket.MovieTicket.entity.Movie;
import MovieTicket.MovieTicket.entity.Show;




@Repository
public class ShowDAOImpl implements ShowDAO {
	@Autowired
	SessionFactory sessionFactory;
	@Override
	public int add(Show show) {
		Session session=sessionFactory.getCurrentSession();
		
		// save/upate the customer ... finally LOL
		//save or update
		//if the primarykey id is null -- save as new new record
		//if the primarykey id is not null -- update the record
		session.save(show);
		//close the session
		//session.close();
			return  show.getShowId();
	}

	@Override
	public int update(Show show) {
		Session session=sessionFactory.getCurrentSession();
		
		// save/upate the customer ... finally LOL
		//save or update
		//if the primarykey id is null -- save as new new record
		//if the primarykey id is not null -- update the record
		session.saveOrUpdate(show);
		//close the session
		//session.close();
			return  show.getShowId();
	}

	@Override
	public int delete(Show show) {
		Session session=sessionFactory.getCurrentSession();
		//search the student eixts the id exists or not
		Show show1=	session.get(Show.class, show.getShowId());
	//check the std is null or null if null means no record
	if(show1==null)
	{
		return -1;//no record found; 
	}
	//if found then delete the record
	session.delete(show1);
	//close the session
	//session.close();
		return 1;//record is updated successfully
	}

	@Override
	public int delete(int id) {
		Session session=sessionFactory.getCurrentSession();
		//search the student eixts the id exists or not
		Show show1=	session.get(Show.class, id);
	//check the std is null or null if null means no record
	if(show1==null)
	{
		return -1;//no record found; 
	}
	//if found then delete the record
	session.delete(show1);
	//close the session
	//session.close();
		return 1;//record is updated successfully
	}
	

	@Override
	public List<Show> getAll() {
		// TODO Auto-generated method stub
		Session currentSession = sessionFactory.getCurrentSession();
		//createCriteria the object provided by the  HiberNate
			//we pass the class and we get the list of the object
			//select * from student
	List<Show> categories=currentSession.createCriteria(Show.class).list();
	return categories;
	}

	@Override
	public Show getById(int id) {
		Session session=sessionFactory.getCurrentSession();
		//search the student eixts the id exists or not
		Show show=session.get(Show.class, id);
		return show;
	}

	@Override
	public List<Show> getAll(String txt) {
		// TODO Auto-generated method stub
		Session currentSession=sessionFactory.getCurrentSession();
		Query q = currentSession.createQuery("from Show  where movie.title LIKE :title ");
		q.setParameter("title", txt+"%");
	List<Show> shows=(List<Show>) q.list();
	return shows;
	}

}
