package movie_db;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import info.movito.themoviedbapi.TmdbApi;
import info.movito.themoviedbapi.TmdbAuthentication;
import info.movito.themoviedbapi.TmdbMovies;
import info.movito.themoviedbapi.TmdbPeople.PersonResultsPage;
import info.movito.themoviedbapi.TmdbKeywords;
import info.movito.themoviedbapi.TmdbLists;
import info.movito.themoviedbapi.TmdbSearch;
import info.movito.themoviedbapi.TvResultsPage;
import info.movito.themoviedbapi.model.MovieDb;
import info.movito.themoviedbapi.model.config.TokenSession;
import info.movito.themoviedbapi.model.core.MovieResultsPage;
import info.movito.themoviedbapi.model.core.SessionToken;
import info.movito.themoviedbapi.model.people.Person;
import info.movito.themoviedbapi.model.tv.TvSeries;

public class Cls_MovieData {
	
	private static TmdbApi tmdbApi;
	private static SessionToken sessionToken;
	
	Cls_MovieData(){
		tmdbApi = new TmdbApi("d69cd7f2a6f9624840bee0c1fc2a9ee0");
		
		sessionToken = getSessionToken();
	}
	
	private static SessionToken getSessionToken() {
		// There are two ways to generate a session id
		
		// Method 1: Generating session id using API calls (requires username and password)
		
		TmdbAuthentication tmdbAuth = tmdbApi.getAuthentication();
		TokenSession tokenSession = tmdbAuth.getSessionLogin("slmarcelin","Slmarcelin2013");
		System.out.println("Session ID: " + tokenSession.getSessionId());
		SessionToken sessionToken = new SessionToken(tokenSession.getSessionId());
		
		return sessionToken;
	}
	
	public ArrayList<MovieDb> m_getSearchMovies(String str_SearchValue) {
		TmdbSearch tmdbSearch = tmdbApi.getSearch();
		ArrayList<MovieDb> eachMovie = new ArrayList<MovieDb>();
		
		MovieResultsPage results = tmdbSearch.searchMovie(str_SearchValue, 0, "en", true, 0);
		Iterator<MovieDb> iterator = results.iterator();
		while (iterator.hasNext()) {
			MovieDb movie = iterator.next();
			eachMovie.add(movie);
		}
		return eachMovie;
	}
	
	public ArrayList<Person> m_getSearchActors(String str_SearchValue) {
		TmdbSearch tmdbSearch = tmdbApi.getSearch();
		ArrayList<Person> eachActor = new ArrayList<Person>();
		
		PersonResultsPage results = tmdbSearch.searchPerson(str_SearchValue, true, 0);
		Iterator<Person> iterator = results.iterator();
		while (iterator.hasNext()) {
			Person person = iterator.next();
			eachActor.add(person);
		}
		return eachActor;
	}
	
	public ArrayList<TvSeries> m_getSearchTVShows(String str_SearchValue) {
		TmdbSearch tmdbSearch = tmdbApi.getSearch();
		ArrayList<TvSeries> eachShow = new ArrayList<TvSeries>();
		
		TvResultsPage results = tmdbSearch.searchTv(str_SearchValue, "en", 0);
		Iterator<TvSeries> iterator = results.iterator();
		while (iterator.hasNext()) {
			TvSeries tv = iterator.next();
			eachShow.add(tv);
		}
		return eachShow;
	}
	
	public ArrayList<MovieDb> m_getInTheaterMovies(){
		TmdbMovies tmdbMovie = tmdbApi.getMovies();
		ArrayList<MovieDb> eachMovie = new ArrayList<MovieDb>();
		
		MovieResultsPage results = tmdbMovie.getNowPlayingMovies("en", 0);
		Iterator<MovieDb> iterator = results.iterator();
		while (iterator.hasNext()) {
			MovieDb movie = iterator.next();
			eachMovie.add(movie);
		}
		return eachMovie;
	}
}
