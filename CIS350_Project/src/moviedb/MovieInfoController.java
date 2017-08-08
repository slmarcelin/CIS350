package moviedb;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Scanner;

import info.movito.themoviedbapi.model.MovieDb;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

/**
 * The controller for the movie info view.
 */
public class MovieInfoController {
	/**The desired movie.*/
	private MovieDb movie;
    @FXML
    /**Label title of movie.*/
    private Label movieTitle;
    @FXML 
    /**The trailer view of movie.*/
    private WebView trailerView;
    @FXML
    /**The movie poster.*/
    private ImageView moviePoster;
    @FXML
    /**A TextArea on movie details.*/
    private TextArea movieDetails;
    @FXML
    /**scrollpane for the list of cast.*/
    private ScrollPane castScroller;
    @FXML
    /**The BorderPane for design.*/
    private BorderPane borderPane;
    
    /**
     * Constructs the MovieInfoController.
     */
    public MovieInfoController() {
    	
    }
    
    /**
     * init function instantiate the program.
     * @param pMovie the one chosen
     */
    public void init(final MovieDb pMovie) {
    	this.movie = pMovie;
    	setMovieTitle();
    	setMovieImage();
    	setMovieDetails();
    	setTrailerView();
    	setCast();
    }
    
    /**
     * Setter sets the movie title.
     */
    private void setMovieTitle() {
    	movieTitle.setText(movie.getTitle());
    }
    
    /**
     * Setter sets the movie poster image.
     */
    private void setMovieImage() {
    	Image imgPoster = new Image(
    	        "http://image.tmdb.org/t/p/w342/" + movie.getPosterPath());
    	moviePoster.setImage(imgPoster);
    }
    
    /**
     * Setter sets and displays the movie details.
     */
    private void setMovieDetails() {	
      movieDetails.setStyle("-fx-border-color: black;");
      movieDetails.setText("Original Title: " + movie.getOriginalTitle()
    		  + "\nReleased Date: " + movie.getReleaseDate()
    		  + "\nOriginal Language: " + movie.getOriginalLanguage()
    		  + "\n\nMovie Description: " + movie.getOverview());
    }
    
    /**
     * Setter sets the list of cast.
     */
    private void setCast() {
    	castScroller.setStyle("-fx-border-color: black;");
    	VBox vbox = getCastPane(MovieData.getMovieCast(movie.getId()));
    	castScroller.setFitToWidth(true);
    	castScroller.setContent(vbox);
    }
    
    /**
     * Setter sets the trailer view.
     */
    private void setTrailerView() {
    	String trailerKey = null;
    	String youtubeKey = "http://api.themoviedb.org/3/movie/" 
	    		+ movie.getId()
	    		+ "/videos?api_key=d69cd7f2a6f9624840bee0c1fc2a9ee0";
	    	URL urlYoutubeKey = null;
	    	try {
				urlYoutubeKey = new URL(youtubeKey);

		    	Scanner scnr = null;
		    	try {
		            scnr = new Scanner(new InputStreamReader(
		            		urlYoutubeKey.openStream(),
		            		Charset.defaultCharset()));
		            trailerKey = scnr.nextLine();
		            scnr.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		    	
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
	    	
	    	if (trailerKey != null) { 
	    	    trailerKey = trailerKey.substring(trailerKey.indexOf("key")
	    				+ 6, trailerKey.indexOf("key") + 17);
	    		//Group  root  =  new  Group();
	    		//trailerView = new WebView();
	    		WebEngine webEngine = trailerView.getEngine();
	    		webEngine.load("http://www.youtube.com/embed/"
	    				+ trailerKey + "?autoplay=1");
	    	}
    }
    
    /**
     * Sets the list of movie cast members.
     * @param list the members to display
     * @return VBox for display
     */
    private VBox getCastPane(final ArrayList<MovieCastMember> list) {
    	VBox vbox = new VBox();
    	for (MovieCastMember member : list) {
    		BorderPane memberPane = new BorderPane();
    		Image profile = new Image(
                    "http://image.tmdb.org/t/p/w45" + member.getProfilePath());
    		ImageView memberView = new ImageView(profile);
    		
    		Label memberName = new Label(member.getName());
    		memberName.setStyle("-fx-background-color: linear-gradient("
    			    + "from 25% 25% to 100% 100%, #c0c0c0, #ffffff)");
    		Label memberInfo = new Label(" ID: " + member.getId() + "\n" 
                    + " Character Played: " + member.getCharacterName() + "\n");
    		
    		memberPane.setLeft(memberView);
    		memberPane.setTop(memberName);
    		memberPane.setCenter(memberInfo);
    		memberPane.setStyle("-fx-border-color: black;");
    		
  
    		vbox.getChildren().add(memberPane);
    		vbox.setFillWidth(true);
    	}
    	
    	return vbox;
    }
}

