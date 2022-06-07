package MovieTicket.MovieTicket.DAO;

import java.util.List;

import MovieTicket.MovieTicket.entity.Movie;



public interface MovieDAO {
	public int addMovie(Movie movie);
	public int deleteMovie(Movie movie);
	public int deleteMovie(int id);
	public int updateMovie(Movie movie);
	
	public List<Movie> getAllMovies();
	public Movie getMovieById(int id);

}
