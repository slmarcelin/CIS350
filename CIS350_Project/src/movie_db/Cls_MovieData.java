package movie_db;

import java.awt.image.BufferedImage;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import info.movito.themoviedbapi.TmdbApi;
import info.movito.themoviedbapi.TmdbAuthentication;
import info.movito.themoviedbapi.TmdbGenre;
import info.movito.themoviedbapi.TmdbMovies;
import info.movito.themoviedbapi.TmdbPeople;
import info.movito.themoviedbapi.TmdbPeople.PersonResultsPage;
import info.movito.themoviedbapi.TmdbSearch;
import info.movito.themoviedbapi.TmdbTV;
import info.movito.themoviedbapi.TvResultsPage;
import info.movito.themoviedbapi.model.Genre;
import info.movito.themoviedbapi.model.MovieDb;
import info.movito.themoviedbapi.model.config.TokenSession;
import info.movito.themoviedbapi.model.core.MovieResultsPage;
import info.movito.themoviedbapi.model.core.SessionToken;
import info.movito.themoviedbapi.model.people.Person;
import info.movito.themoviedbapi.model.tv.TvSeries;

public class Cls_MovieData {
	
	private static TmdbApi tmdbApi;
	private static SessionToken sessionToken;
	private static final String IMAGE_ROOT_URL = "http://image.tmdb.org/t/p/w92/";
	
	static {
		tmdbApi = new TmdbApi("d69cd7f2a6f9624840bee0c1fc2a9ee0");
		sessionToken = getNewSessionToken();
	}
	
	private Cls_MovieData() {}
	
	/*********************************************************************************
	Generate a new session token
	*********************************************************************************/
	private static SessionToken getNewSessionToken() {
		TmdbAuthentication tmdbAuth = tmdbApi.getAuthentication();
		TokenSession tokenSession = tmdbAuth.getSessionLogin("slmarcelin","Slmarcelin2013");
		System.out.println("Session ID: " + tokenSession.getSessionId());
		SessionToken sessionToken = new SessionToken(tokenSession.getSessionId());
		return sessionToken;
	}
	
	/*********************************************************************************
	  Returns the list of the searched 
	  movies
	  @param page the current display page
	  @param str_SeachValue of type string
	  @return the MovieDb arraylist of 
	          searched movies
	*********************************************************************************/
	public static ArrayList<MovieDb> m_getSearchMovies(String str_SearchValue, int page) {
		TmdbSearch tmdbSearch = tmdbApi.getSearch();
		ArrayList<MovieDb> eachMovie = new ArrayList<MovieDb>();
		
		MovieResultsPage results = tmdbSearch.searchMovie(str_SearchValue, 0, "en", true, page);
		Iterator<MovieDb> iterator = results.iterator();
		while (iterator.hasNext()) {
			MovieDb movie = iterator.next();
			eachMovie.add(movie);
		}
		return eachMovie;
	}
	
	/*********************************************************************************
	  Returns the list of the searched 
	  actors
	  @param page the current display page
	  @param str_SeachValue of type string
	  @return the Person arraylist of 
	          searched actors
	*********************************************************************************/
	public static ArrayList<Person> m_getSearchActors(String str_SearchValue, int page) {
		TmdbSearch tmdbSearch = tmdbApi.getSearch();
		ArrayList<Person> eachActor = new ArrayList<Person>();
		
		PersonResultsPage results = tmdbSearch.searchPerson(str_SearchValue, true, page);
		Iterator<Person> iterator = results.iterator();
		while (iterator.hasNext()) {
			Person person = iterator.next();
			eachActor.add(person);
		}
		return eachActor;
	}
	
	/*********************************************************************************
	  Returns the list of the searched 
	  TV show
	  @param page the current display page
	  @param str_SeachValue of type string
	  @return the TvSeries arraylist of 
	          searched shows
	*********************************************************************************/
	public static ArrayList<TvSeries> m_getSearchTVShows(String str_SearchValue, int page) {
		TmdbSearch tmdbSearch = tmdbApi.getSearch();
		ArrayList<TvSeries> eachShow = new ArrayList<TvSeries>();
		
		TvResultsPage results = tmdbSearch.searchTv(str_SearchValue, "en", page);
		Iterator<TvSeries> iterator = results.iterator();
		while (iterator.hasNext()) {
			TvSeries tv = iterator.next();
			eachShow.add(tv);
		}
		return eachShow;
	}
	
	/*********************************************************************************
	  Returns the list of moves in theater
	  @param page the current display page
	  @return the MovieDb arraylist of movies
	          in theater
	*********************************************************************************/
	public static ArrayList<MovieDb> m_getInTheaterMovies(int page){
		TmdbMovies tmdbMovie = tmdbApi.getMovies();
		ArrayList<MovieDb> eachMovie = new ArrayList<MovieDb>();
		
		MovieResultsPage results = tmdbMovie.getNowPlayingMovies("en", page);
		Iterator<MovieDb> iterator = results.iterator();
		while (iterator.hasNext()) {
			MovieDb movie = iterator.next();
			eachMovie.add(movie);
		}
		return eachMovie;
	}
	
	/*********************************************************************************
	  Returns the list of new movies
	  @param page the current display page
	  @return the MovieDb arraylist of new
	           movies
	*********************************************************************************/
	public static ArrayList<MovieDb> m_getNewMovies(int page){
		TmdbMovies tmdbMovie = tmdbApi.getMovies();
		ArrayList<MovieDb> eachMovie = new ArrayList<MovieDb>();
		
		MovieResultsPage results = tmdbMovie.getUpcoming("en", page);
		Iterator<MovieDb> iterator = results.iterator();
		while (iterator.hasNext()) {
			MovieDb movie = iterator.next();
			eachMovie.add(movie);
		}
		return eachMovie;
	}
	
	/*********************************************************************************
	  Returns the list popular movies
	  @param page the current display page
	  @return the array list of popular
	          movies
	*********************************************************************************/
	public static ArrayList<MovieDb> m_getPopularMovies(int page){
		TmdbMovies tmdbMovie = tmdbApi.getMovies();
		ArrayList<MovieDb> eachMovie = new ArrayList<MovieDb>();
		
		MovieResultsPage results = tmdbMovie.getPopularMovies("en", page);
		Iterator<MovieDb> iterator = results.iterator();
		while (iterator.hasNext()) {
			MovieDb movie = iterator.next();
			eachMovie.add(movie);
		}
		return eachMovie;
	}
	
	/*********************************************************************************
	  Returns the list of top rated shows
	  @param page the current display page
	  @return the array list of top rated
	          shows
	*********************************************************************************/	
	public static ArrayList<Genre> m_getGenres(){
		TmdbGenre tmdbGenre = tmdbApi.getGenre();
		return (ArrayList<Genre>)tmdbGenre.getGenreList("en");
	}
	
	/*********************************************************************************
	  Returns the list of movies by genre
	  @param page the current display page
	  @param int_GenreId the genre id
	  @return the array list of movies
	          by genre
	*********************************************************************************/
	public static ArrayList<MovieDb> m_getMoviesByGenre(int int_GenreID, int page){
		TmdbGenre tmdbGenre = tmdbApi.getGenre();
		ArrayList<MovieDb> eachMovie = new ArrayList<MovieDb>();
		
		MovieResultsPage results = tmdbGenre.getGenreMovies(int_GenreID, "en", page, true);
		Iterator<MovieDb> iterator = results.iterator();
		while (iterator.hasNext()) {
			MovieDb movie = iterator.next();
			eachMovie.add(movie);
		}
		return eachMovie;
	}
	
	/*********************************************************************************
	  Returns the list of shows on Air
	  @param page the current display page
	  @return the array list of shows on
	          Air
	*********************************************************************************/
	public static ArrayList<TvSeries> m_getTvShowsOnAir(int page){
		TmdbTV tmdbTv = tmdbApi.getTvSeries();
		ArrayList<TvSeries> eachSeries = new ArrayList<TvSeries>();
		
		TvResultsPage results = tmdbTv.getOnTheAir("en", page);
		Iterator<TvSeries> iterator = results.iterator();
		while (iterator.hasNext()) {
			TvSeries tv = iterator.next();
			eachSeries.add(tv);
		}
		return eachSeries;
	}
	
	/*********************************************************************************
	  Returns the list of popular shows
	  @param page the current display page
	  @return the array list of popular
	          shows
	*********************************************************************************/
	public static ArrayList<TvSeries> m_getTvShowsPopular(int page){
		TmdbTV tmdbTv = tmdbApi.getTvSeries();
		ArrayList<TvSeries> eachSeries = new ArrayList<TvSeries>();
		
		TvResultsPage results = tmdbTv.getPopular("en", page);
		Iterator<TvSeries> iterator = results.iterator();
		while (iterator.hasNext()) {
			TvSeries tv = iterator.next();
			eachSeries.add(tv);
		}
		return eachSeries;
	}
	
	/*********************************************************************************
	  Returns the list of top rated shows
	  @param page the current display page
	  @return the array list of top rated
	          shows
	*********************************************************************************/
	public static ArrayList<TvSeries> m_getTvShowsTopRated(int page){
		TmdbTV tmdbTv = tmdbApi.getTvSeries();
		ArrayList<TvSeries> eachSeries = new ArrayList<TvSeries>();
		
		TvResultsPage results = tmdbTv.getPopular("en", page);
		Iterator<TvSeries> iterator = results.iterator();
		while (iterator.hasNext()) {
			TvSeries tv = iterator.next();
			eachSeries.add(tv);
		}
		return eachSeries;
	}
	
	/*********************************************************************************
	  Find a random movie
	  @param person the id of a movie
	  @return MovieDb the selected movie
	*********************************************************************************/
	public static MovieDb m_getRandMovie(int movie) {
		int count = 0;
		TmdbMovies tmdbMovies = tmdbApi.getMovies();
		MovieResultsPage results = tmdbMovies.getPopularMovies("en", 5);
		Iterator<MovieDb> iterator = results.iterator();
		MovieDb m = null;
		while (iterator.hasNext() && movie > count) {
			m = iterator.next();
			count++;
		}
		return m;
	}
	
	/*********************************************************************************
	  Find a random show
	  @param show the id of a show
	  @return TvSeries the selected show
	*********************************************************************************/
	public static TvSeries m_getRandShow(int show) {
		int count = 0;
		TmdbTV tmdbTV = tmdbApi.getTvSeries();
		TvResultsPage results = tmdbTV.getPopular("en", 5);
		Iterator<TvSeries> iterator = results.iterator();
		TvSeries tv = null;
		while (iterator.hasNext() && show > count) {
			tv = iterator.next();
			count++;
		}
		return tv;
	}
	
	/*********************************************************************************
	  Find a random actor
	  @param person the id of an actor
	  @return Person the selected actor
	*********************************************************************************/
	public static Person m_getRandActor(int person) {
		int count = 0;
		TmdbPeople tmdbPeople = tmdbApi.getPeople();
		PersonResultsPage results = tmdbPeople.getPersonPopular(5);
		Iterator<Person> iterator = results.iterator();
		Person p = null;
		while (iterator.hasNext() && person > count) {
			p = iterator.next();
			count++;
		}
		return p;
	}
	
	/*********************************************************************************
	  Find the poster image of the movie
	  @param movie of type MOvieDb
	  @return ImageIcon the image 
	*********************************************************************************/
	public static ImageIcon m_getMoviePoster(MovieDb movie) {
		try {
			BufferedImage img = ImageIO.read(new URL(IMAGE_ROOT_URL + movie.getPosterPath()));
			return new ImageIcon(img);
		} catch(Exception e) {
			// Red image
			return new ImageIcon(Cls_MovieData.class.getResource("tmdb.png"));
		}
	}
	
	/*********************************************************************************
	  Find the poster image of the show
	  @param tv of TvSeries
	  @return ImageIcon the image 
	*********************************************************************************/
	public static ImageIcon m_getTvPoster(TvSeries tv) {
		try {
			BufferedImage img = ImageIO.read(new URL(IMAGE_ROOT_URL + tv.getPosterPath()));
			return new ImageIcon(img);
		} catch(Exception e) {
			// Red image
			return new ImageIcon(Cls_MovieData.class.getResource("tmdb.png"));
		}
	}
	
	/*********************************************************************************
	  Find the profile image of an actor
	  @param p of type Person
	  @return ImageIcon the image 
	*********************************************************************************/
	public static ImageIcon m_getPersonProfile(Person p) {
		try {
			BufferedImage img = ImageIO.read(new URL(IMAGE_ROOT_URL + p.getProfilePath()));
			return new ImageIcon(img);
		} catch(Exception e) {
			// Red image
			return new ImageIcon(Cls_MovieData.class.getResource("tmdb.png"));
		}
	}
}
