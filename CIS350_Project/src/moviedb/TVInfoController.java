package moviedb;
import info.movito.themoviedbapi.model.tv.TvSeries;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
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
import javafx.scene.text.TextFlow;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

public class TVInfoController {
	private TvSeries show;
    @FXML
    private Label tvTitle;
    @FXML 
    private WebView trailerView;
    @FXML
    private ImageView tvPoster;
    @FXML
    private TextArea tvDetails;
    @FXML
    private ScrollPane castScroller;
    @FXML
    private BorderPane borderPane;
    
    public TVInfoController() {
    	
    }
    
    public void init(TvSeries show) {
    	this.show = show;
    	
    	setTvTitle();
    	setTvImage();
    	setTvDetails();
    	setTrailerView();
    	setCast();
    }
    
    private void setTvTitle() {
    	//borderPane.setStyle("-fx-border-color: black;");
    	tvTitle.setText(show.getName());
    }
    
    private void setTvImage() {
    	Image imgPoster = new Image("http://image.tmdb.org/t/p/w342/" + show.getPosterPath());
    	tvPoster.setImage(imgPoster);
    }
    
    private void setTvDetails() {
    	
    	tvDetails.setStyle("-fx-border-color: black;");
      tvDetails.setText("Original Title: "+show.getOriginalName()+"\nReleased Date: "
      +show.getFirstAirDate()+
      "\n\nMovie Description: "+show.getOverview());
    }
    
    private void setCast()
    {
    	castScroller.setStyle("-fx-border-color: black;");
    	VBox vbox = getCastPane(MovieData.getMovieCast(show.getId()));
    	castScroller.setFitToWidth(true);
    	castScroller.setContent(vbox);
    }
    
    private void setTrailerView() {
    	String youtubeKey = "http://api.themoviedb.org/3/tv/" + 
	    		show.getId() + "/videos?api_key=d69cd7f2a6f9624840bee0c1fc2a9ee0";
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