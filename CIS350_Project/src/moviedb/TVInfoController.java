package moviedb;
import info.movito.themoviedbapi.model.tv.TvSeries;
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

public class TVInfoController {
	private TvSeries tv;
    @FXML
    private Label TVTitle;
    @FXML 
    private WebView trailerView;
    @FXML
    private ImageView TVPoster;
    @FXML
    private TextArea TVDetails;
    @FXML
    private TextArea Cast;
    
    public TVInfoController() {
    	
    }
    
    public void init(TvSeries tv) {
    	this.tv = tv;
    	
    	setTVTitle();
    	setTVImage();
    	setTVDetails();
    	setTrailerView();
    	setCast();
    }
    
    private void setTVTitle() {
    	TVTitle.setText(tv.getName());
    }
    
    private void setTVImage() {
    	Image imgPoster = new Image("http://image.tmdb.org/t/p/w185/" + tv.getPosterPath());
		TVPoster.setImage(imgPoster);
    }
    
    private void setTVDetails() {
      TVDetails.setText("Original Title: "+tv.getName()+"\nReleased date: "
      +tv.getFirstAirDate()+
      "\n\nMovie Description: "+tv.getOverview());
    	
    }
    
    private void setCast()
    {
    		Cast.setText("Actors\n");
    }
    
    private void setTrailerView() {
    	String youtubeKey = "http://api.themoviedb.org/3/tv/" + 
	    		tv.getId() + "/videos?api_key=d69cd7f2a6f9624840bee0c1fc2a9ee0";
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