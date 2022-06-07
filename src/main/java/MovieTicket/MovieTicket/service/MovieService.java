package MovieTicket.MovieTicket.service;

import java.util.List;

import MovieTicket.MovieTicket.entity.Movie;



public interface MovieService {
	public int addMovie(Movie movie);
	public int updateMovie(Movie movie);
	public int deleteMovie(Movie movie);
	public int deleteMovie(int id);
	
	//create some method to get the student
	public List<Movie> getAllMovies();
	public Movie getMovieById(int id);

}
