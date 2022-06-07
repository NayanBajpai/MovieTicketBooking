package MovieTicket.MovieTicket.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import MovieTicket.MovieTicket.DAO.MovieDAO;
import MovieTicket.MovieTicket.entity.Movie;
@Service
@Transactional
public class MovieServiceImpl implements MovieService{
	@Autowired
	private MovieDAO mdao;
	@Override
	@Transactional
	
	public int addMovie(Movie movie) {
		// TODO Auto-generated method stub
		return mdao.addMovie(movie);
	}

	@Override
	public int updateMovie(Movie movie) {
		// TODO Auto-generated method stub
		return mdao.updateMovie(movie);
	}

	@Override
	public int deleteMovie(Movie movie) {
		// TODO Auto-generated method stub
		return mdao.deleteMovie(movie);
	}

	@Override
	public List<Movie> getAllMovies() {
		// TODO Auto-generated method stub
		return mdao.getAllMovies();
	}

	@Override
	public Movie getMovieById(int id) {
		// TODO Auto-generated method stub
		return mdao.getMovieById(id);
	}

	@Override
	public int deleteMovie(int id) {
		// TODO Auto-generated method stub
		return mdao.deleteMovie(id);
	}

}
