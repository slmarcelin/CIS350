package moviedb;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import info.movito.themoviedbapi.model.MovieDb;
import javafx.embed.swing.SwingNode;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
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
    @FXML
    private ScrollPane castScroller;
    @FXML
    private BorderPane borderPane;
    
    public MovieInfoController() {
    	
    }
    
    public void init(MovieDb movie) {
    	this.movie = movie;
    	
    	setMovieTitle();
    	setMovieImage();
    	setMovieDetails();
    	setTrailerView();
    	setCast();
    }
    
    private void setMovieTitle() {
    	//borderPane.setStyle("-fx-border-color: black;");
    	movieTitle.setText(movie.getTitle());
    }
    
    private void setMovieImage() {
    	Image imgPoster = new Image("http://image.tmdb.org/t/p/w342/" + movie.getPosterPath());
    	moviePoster.setImage(imgPoster);
    }
    
    private void setMovieDetails() {
    	
    	movieDetails.setStyle("-fx-border-color: black;");
      movieDetails.setText("Original Title: "+movie.getOriginalTitle()+"\nReleased Date: "
      +movie.getReleaseDate()+"\nOriginal Language: "+movie.getOriginalLanguage() +
      "\n\nMovie Description: "+movie.getOverview());
    }
    
    private void setCast()
    {
    	castScroller.setStyle("-fx-border-color: black;");
    	VBox vbox = getCastPane(MovieData.getMovieCast(movie.getId()));
    	castScroller.setFitToWidth(true);
    	castScroller.setContent(vbox);
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
    
    private VBox getCastPane(ArrayList<MovieCastMember> list)
    {
    	VBox vbox = new VBox();
    	
    	for(MovieCastMember member : list) {
    		BorderPane memberPane = new BorderPane();
    		Image profile = new Image("http://image.tmdb.org/t/p/w45" + member.getProfilePath());
    		ImageView memberView = new ImageView(profile);
    		
    		Label memberName = new Label(member.getName());
    		memberName.setStyle("-fx-background-color: linear-gradient(from 25% 25% to 100% 100%, #c0c0c0, #ffffff)");
    		Label memberInfo = new Label(" ID: " + member.getCastId() + "\n" + 
    				" Character Played: " + member.getCharacterName() + "\n");
    		
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

