package moviedb;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

import info.movito.themoviedbapi.model.MovieDb;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.TextFlow;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

public class MovieInfoController {
	private MovieDb movie;
    @FXML
    private Label movieTitle;
    @FXML 
    private WebView trailerView;
    @FXML
    private ImageView moviePoster;
    @FXML
    private TextArea movieDetails;
    
    public MovieInfoController() {
    	
    }
    
    public void init(MovieDb movie) {
    	this.movie = movie;
    	
    	setMovieTitle();
    	setMovieImage();
    	setMovieDetails();
    	setTrailerView();
    }
    
    private void setMovieTitle() {
    	movieTitle.setText(movie.getTitle());
    }
    
    private void setMovieImage() {
    	Image imgPoster = new Image("http://image.tmdb.org/t/p/w185/" + movie.getPosterPath());
		moviePoster.setImage(imgPoster);
    }
    
    private void setMovieDetails() {
    	movieDetails.setText(movie.getOverview());
    }
    
    private void setTrailerView() {
    	String youtubeKey = "http://api.themoviedb.org/3/movie/" + 
	    		movie.getId() + "/videos?api_key=d69cd7f2a6f9624840bee0c1fc2a9ee0";
	    	URL urlYoutubeKey = null;
	    	try {
				urlYoutubeKey = new URL(youtubeKey);
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	
	    	Scanner scnr = null;
	    	try {
				scnr = new Scanner(urlYoutubeKey.openStream());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	
	    	String trailerKey = scnr.nextLine();
	    	trailerKey = trailerKey.substring(trailerKey.indexOf("key") + 6, trailerKey.indexOf("key") + 17);
	        //Group  root  =  new  Group();
	    	//trailerView = new WebView();
	    	WebEngine webEngine = trailerView.getEngine();
	    	webEngine.load("http://www.youtube.com/embed/" + trailerKey + "?autoplay=1");
    }
}