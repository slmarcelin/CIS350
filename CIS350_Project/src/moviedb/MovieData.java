package moviedb;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;


import java.util.Scanner;

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
import info.movito.themoviedbapi.model.people.PersonCast;
import info.movito.themoviedbapi.model.tv.TvSeries;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/*******************************************************************************
 * MovieData class.
 * Provides access to the MovieDb Database
 ******************************************************************************/
public final class MovieData {
    /** A movie database API variable. **/
    private static TmdbApi tmdbApi;
    /** A session token. **/
    private static SessionToken sessionToken;
    /** the images root URL. **/
    private static final String IMAGE_ROOT_URL =
            "http://image.tmdb.org/t/p/";

    static {
        tmdbApi = new TmdbApi("d69cd7f2a6f9624840bee0c1fc2a9ee0");
        sessionToken = getNewSessionToken();
    }

    /***************************************************************************
     * Empty constructor.
     **************************************************************************/
    private MovieData() { }

    /***************************************************************************
     * Generate a new session token.
     * @return a new session token
     **************************************************************************/
    private static SessionToken getNewSessionToken() {
        TmdbAuthentication tmdbAuth = tmdbApi.getAuthentication();
        TokenSession tokenSession =
                tmdbAuth.getSessionLogin("slmarcelin", "Slmarcelin2013");
        System.out.println("Session ID: " + tokenSession.getSessionId());
        SessionToken newSessionToken =
                new SessionToken(tokenSession.getSessionId());
        return newSessionToken;
    }
    
    public static String getApiKey() {
    	return "d69cd7f2a6f9624840bee0c1fc2a9ee0";
    }

    /***************************************************************************
      Returns the list of the searched movies.
      @param page the current display page
      @param searchString of type string
      @return ArrayList of searched movies
    ***************************************************************************/
    public static ArrayList<MovieDb> getSearchMovies(
            final String searchString, final int page) {
        TmdbSearch tmdbSearch = tmdbApi.getSearch();
        ArrayList<MovieDb> eachMovie = new ArrayList<MovieDb>();

        MovieResultsPage results =
                tmdbSearch.searchMovie(searchString, 0, "en", true, page);
        Iterator<MovieDb> iterator = results.iterator();
        while (iterator.hasNext()) {
            MovieDb movie = iterator.next();
            eachMovie.add(movie);
        }
        return eachMovie;
    }
   
    /***************************************************************************
      Returns the list of the searched actors.
      @param page the current display page
      @param searchString of type string
      @return ArrayList of searched actors
    ***************************************************************************/
    public static ArrayList<Person> getSearchActors(
            final String searchString, final int page) {
        TmdbSearch tmdbSearch = tmdbApi.getSearch();
        ArrayList<Person> eachActor = new ArrayList<Person>();

        PersonResultsPage results =
                tmdbSearch.searchPerson(searchString, true, page);
        Iterator<Person> iterator = results.iterator();
        while (iterator.hasNext()) {
            Person person = iterator.next();
            eachActor.add(person);
        }
        return eachActor;
    }

    /***************************************************************************
      Returns the list of the searched TV show.
      @param page the current display page
      @param searchString of type string
      @return ArrayList of searched shows
    ***************************************************************************/
    public static ArrayList<TvSeries> getSearchTVShows(
            final String searchString, final int page) {
        TmdbSearch tmdbSearch = tmdbApi.getSearch();
        ArrayList<TvSeries> eachShow = new ArrayList<TvSeries>();

        TvResultsPage results = tmdbSearch.searchTv(searchString, "en", page);
        Iterator<TvSeries> iterator = results.iterator();
        while (iterator.hasNext()) {
            TvSeries tv = iterator.next();
            eachShow.add(tv);
        }
        return eachShow;
    }

    /***************************************************************************
      Returns the list of moves in theater.
      @param page the current display page
      @return ArrayList of movies
              in theater
    ***************************************************************************/
    public static ArrayList<MovieDb> getInTheaterMovies(final int page) {
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

    /***************************************************************************
      Returns the list of new movies.
      @param page the current display page
      @return ArrayList of new
               movies
    ***************************************************************************/
    public static ArrayList<MovieDb> getNewMovies(final int page) {
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

    /***************************************************************************
      Returns the list popular movies.
      @param page the current display page
      @return the array list of popular
              movies
    ***************************************************************************/
    public static ArrayList<MovieDb> getPopularMovies(final int page) {
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

    /***************************************************************************
      Returns the list of top rated shows.
      @return ArrayList of top rated shows
    ***************************************************************************/
    public static ArrayList<Genre> getGenres() {
        TmdbGenre tmdbGenre = tmdbApi.getGenre();
        return (ArrayList<Genre>) tmdbGenre.getGenreList("en");
    }

    /***************************************************************************
      Returns the list of movies by genre.
      @param page the current display page
      @param genreId the genre id
      @return ArrayList of movies
              by genre
    ***************************************************************************/
    public static ArrayList<MovieDb> getMoviesByGenre(
            final int genreId, final int page) {
        TmdbGenre tmdbGenre = tmdbApi.getGenre();
        ArrayList<MovieDb> eachMovie = new ArrayList<MovieDb>();

        MovieResultsPage results =
                tmdbGenre.getGenreMovies(genreId, "en", page, true);
        Iterator<MovieDb> iterator = results.iterator();
        while (iterator.hasNext()) {
            MovieDb movie = iterator.next();
            eachMovie.add(movie);
        }
        return eachMovie;
    }

    /***************************************************************************
      Returns the list of shows on Air.
      @param page the current display page
      @return ArrayList of shows on
              Air
    ***************************************************************************/
    public static ArrayList<TvSeries> getTvShowsOnAir(final int page) {
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

    /***************************************************************************
      Returns the list of popular shows.
      @param page the current display page
      @return ArrayList of popular
              shows
    ***************************************************************************/
    public static ArrayList<TvSeries> getTvShowsPopular(final int page) {
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

    /***************************************************************************
      Returns the list of top rated shows.
      @param page the current display page
      @return ArrayList of top rated shows
    ***************************************************************************/
    public static ArrayList<TvSeries> getTvShowsTopRated(final int page) {
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

    /***************************************************************************
      Finds and returns a random movie.
      @param movie the id of a movie
      @param page the current display page
      @return MovieDb the selected movie
    ***************************************************************************/
    public static MovieDb getRandMovie(final int movie, final int page) {
        int count = 0;
        TmdbMovies tmdbMovies = tmdbApi.getMovies();
        MovieResultsPage results = tmdbMovies.getPopularMovies("en", page);
        Iterator<MovieDb> iterator = results.iterator();
        MovieDb m = null;
        while (iterator.hasNext() && movie > count) {
            m = iterator.next();
            count++;
        }
        return m;
    }

    /***************************************************************************
      Find a random show.
      @param show the id of a show
      @param page the current display page
      @return TvSeries the selected show
    ***************************************************************************/
    public static TvSeries getRandShow(final int show, final int page) {
        int count = 0;
        TmdbTV tmdbTV = tmdbApi.getTvSeries();
        TvResultsPage results = tmdbTV.getPopular("en", page);
        Iterator<TvSeries> iterator = results.iterator();
        TvSeries tv = null;
        while (iterator.hasNext() && show > count) {
            tv = iterator.next();
            count++;
        }
        return tv;
    }

    /***************************************************************************
      Finds and returns a random actor.
      @param person the id of an actor
      @param page the current display page
      @return Person the selected actor
    ***************************************************************************/
    public static Person getRandActor(final int person, final int page) {
        int count = 0;
        TmdbPeople tmdbPeople = tmdbApi.getPeople();
        PersonResultsPage results = tmdbPeople.getPersonPopular(page);
        Iterator<Person> iterator = results.iterator();
        Person p = null;
        while (iterator.hasNext() && person > count) {
            p = iterator.next();
            count++;
        }
        return p;
    }

    /***************************************************************************
      Finds and returns the poster image of the movie.
      @param movie of type MOvieDb
      @return ImageIcon the image
    ***************************************************************************/
    public static ImageIcon getMoviePoster(final MovieDb movie, final String posterSize) {
        try {
            BufferedImage img = ImageIO.read(
                    new URL(IMAGE_ROOT_URL + posterSize + "/" + movie.getPosterPath()));
            return new ImageIcon(img);
        } catch (IOException e) {
            // Red image
            return new ImageIcon(MovieData.class.getResource("tmdb.png"));
        }
    }

    /***************************************************************************
      Finds and returns the poster image of the show.
      @param tv of TvSeries
      @return ImageIcon the image
    ***************************************************************************/
    public static ImageIcon getTvPoster(final TvSeries tv, String posterSize) {
        try {
            BufferedImage img = ImageIO.read(
                    new URL(IMAGE_ROOT_URL + posterSize + "/" + tv.getPosterPath()));
            return new ImageIcon(img);
        } catch (IOException e) {
            // Red image
            return new ImageIcon(MovieData.class.getResource("tmdb.png"));
        }
    }

    /***************************************************************************
      Finds and returns the profile image of an actor.
      @param p the actor to find an image for
      @return ImageIcon the image
    ***************************************************************************/
    public static ImageIcon getPersonProfile(final Person p, String posterSize) {
        try {
            BufferedImage img = ImageIO.read(
                    new URL(IMAGE_ROOT_URL + posterSize + "/" + p.getProfilePath()));
            return new ImageIcon(img);
        } catch (IOException e) {
            // Red image
            return new ImageIcon(MovieData.class.getResource("tmdb.png"));
        }
    }
    
    public static ArrayList<MovieCastMember> getMovieCast(final int movieID){
    	//http://api.themoviedb.org/3/movie/movieID/casts?api_key=apiTolken
    	//Example: http://api.themoviedb.org/3/movie/282035/casts?api_key=d69cd7f2a6f9624840bee0c1fc2a9ee0
    	String WEB_KEY = "http://api.themoviedb.org/3/movie/" + 
				movieID + "/casts?api_key="  + 
				MovieData.getApiKey();
    	
    	ArrayList<MovieCastMember> cast = new ArrayList<MovieCastMember>();
    	try {
    		Scanner url = new Scanner(new URL(WEB_KEY).openStream(), "UTF-8"); 
    		String castJson = url.useDelimiter("\\A").next();
    		url.close();
    		
    		JSONObject jObj = new JSONObject(castJson);
    		JSONArray castStrs = jObj.getJSONArray("cast");
    		for(int i = 0; i < castStrs.length(); i++) {
    			JSONObject castMember = castStrs.getJSONObject(i);
    			//int cast_id = castMember.getInt("cast_id");
    			String character = castMember.getString("character");
    			//String credit_id = castMember.getString("credit_id");
    			//int gender = castMember.getInt("gender");
    			int id = castMember.getInt("id");
    			String name = castMember.getString("name");
    			//int order = castMember.getInt("order");
    			String profilePath = castMember.getString("profile_path");

        		MovieCastMember mcm = new MovieCastMember();
        		mcm.setName(name);
        		mcm.setCharacterName(character);
        		mcm.setId(id);
        		mcm.setProfilePath(profilePath);
        		cast.add(mcm);
    		}
    	} catch (IOException e) {
    		
    	} catch (JSONException e) {
    		
    	}
    	
    	return cast;
    }
    
    public static ArrayList<TvCastMember> getTvCast(final int tvID){
    	//http://api.themoviedb.org/3/movie/movieID/casts?api_key=apiTolken
    	//Example: http://api.themoviedb.org/3/movie/282035/casts?api_key=d69cd7f2a6f9624840bee0c1fc2a9ee0
    	String WEB_KEY = "http://api.themoviedb.org/3/tv/" + 
				tvID + "/credits?api_key="  + 
				MovieData.getApiKey();
    	
    	ArrayList<TvCastMember> cast = new ArrayList<TvCastMember>();

    	try {
    		Scanner url = new Scanner(new URL(WEB_KEY).openStream(), "UTF-8"); 
    		String castJson = url.useDelimiter("\\A").next();
    		url.close();
    		
    		JSONObject jObj = new JSONObject(castJson);
    		JSONArray castStrs = jObj.getJSONArray("cast");
    		for(int i = 0; i < castStrs.length(); i++) {
    			JSONObject castMember = castStrs.getJSONObject(i);
    			//int cast_id = castMember.getInt("cast_id");
    			String character = castMember.getString("character");
    			//String credit_id = castMember.getString("credit_id");
    			//int gender = castMember.getInt("gender");
    			int id = castMember.getInt("id");
    			String name = castMember.getString("name");
    			//int order = castMember.getInt("order");
    			String profilePath = castMember.getString("profile_path");

        		TvCastMember tcm = new TvCastMember();
        		tcm.setName(name);
        		tcm.setCharacterName(character);
        		tcm.setId(id);
        		tcm.setProfilePath(profilePath);
        		cast.add(tcm);
    		}
    	} catch (IOException e) {
    		
    	} catch (JSONException e) {
    		
    	}
    	
    	return cast;
    }
}
