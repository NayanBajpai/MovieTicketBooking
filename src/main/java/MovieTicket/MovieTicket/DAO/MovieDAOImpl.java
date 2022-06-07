package MovieTicket.MovieTicket.DAO;

import java.util.List;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import MovieTicket.MovieTicket.entity.Movie;
@Repository
public class MovieDAOImpl implements MovieDAO {
	@Autowired //injecting Session Factory
	  private SessionFactory sessionFactory;

	@Override
	public int addMovie(Movie movie) {
		// adding the session object
		Session session=sessionFactory.getCurrentSession();
		//saving the movie for the first time
		session.save(movie);
		return  movie.getId();
	}

	@Override
	public int deleteMovie(Movie movie) {
		
		//create the object of the Session using the SessionFactory
		Session session=sessionFactory.getCurrentSession();
		//search the movie exists the id exists or not
		Movie std=	session.get(Movie.class, movie.getId());
		//check the std is null or null if null means no record
		if(std==null)
		{
			return -1;//no record found; 
		}
		//if found then delete the record
		session.delete(movie);
		return 1;//record is updated successfully
	}

	@Override
	public int updateMovie(Movie movie) {
		//create the object of the Session using the SessionFactory
		Session session=sessionFactory.getCurrentSession();
		//We will call the method saveorupdate to update the record
		session.saveOrUpdate(movie);
		return movie.getId();
	}

	@Override
	public List<Movie> getAllMovies() {
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		//createCriteria the object provided by the  HiberNate
		//we pass the class and we get the list of the object
		//select * from movies
		List<Movie> movies=currentSession.createCriteria(Movie.class).list();
		return movies;
	}

	@Override
	public Movie getMovieById(int id) {
		//get the current session object using the session factory object
		Session session=sessionFactory.getCurrentSession();
		//using the session object get method passing the class we get the object
		//second parameter is the primary key
		Movie movie=session.get(Movie.class,id);
		return  movie;
	}

	@Override
	public int deleteMovie(int id) {
		Session session=sessionFactory.getCurrentSession();
		//search the student eixts the id exists or not
		Movie std=	session.get(Movie.class, id);
	//check the std is null or null if null means no record
	if(std==null)
	{
		return -1;//no record found; 
	}
	//if found then delete the record
	session.delete(std);
	//close the session
	//session.close();
		return 1;//record is updated successfully
	}

}
