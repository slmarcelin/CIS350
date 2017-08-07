package moviedb;
import info.movito.themoviedbapi.model.tv.TvSeries;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;


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

public class TVInfoController 
{
	/** the chosen tv show. */
	private TvSeries show;
    @FXML
    /** Label of tvTitle. */
    private Label tvTitle;
    @FXML 
    /** webView of trailer View. */
    private WebView trailerView;
    @FXML
    /** Imageview of tv show poster. */
    private ImageView tvPoster;
    @FXML
    /** TextArea of tv show details. */
    private TextArea tvDetails;
    @FXML
    /** scrollPane of cast. */
    private ScrollPane castScroller;
    @FXML
    /** BorderPane for display. */
    private BorderPane borderPane;
    
    /**
     * Empty constructor
     */
    public TVInfoController() 
    {
    	
    }
    
    /**
     * Initializes the program
     * @param show chosen by user
     */
    public void init(TvSeries show) 
    {
    	this.show = show;
    	setTvTitle();
    	setTvImage();
    	setTvDetails();
    	setTrailerView();
    	setCast();
    }
    
    /**
     * Setter sets thetitle of the tv show
     */
    private void setTvTitle() 
    {
    	tvTitle.setText(show.getName());
    }
    
    /**
     * Setter sets the poster image of the tv show
     */
    private void setTvImage() 
    {
    	Image imgPoster = new Image("http://image.tmdb.org/t/p/w342/" + show.getPosterPath());
    	tvPoster.setImage(imgPoster);
    }
    
    /**
     * Setter sets th etv show overview details
     */
    private void setTvDetails() 
    {
    	
      tvDetails.setStyle("-fx-border-color: black;");
      tvDetails.setText("Original Title: "+show.getOriginalName()+"\nReleased Date: "
      +show.getFirstAirDate()+ "\nNumber of seasons: "+show.getNumberOfSeasons()+
      "\n\nShow Description \n"+show.getOverview());
    }
    
    /**
     * Setter sets the cast of the tv show
     */
    private void setCast()
    {
    	castScroller.setStyle("-fx-border-color: black;");
    	VBox vbox = getCastPane(MovieData.getMovieCast(show.getId()));
    	castScroller.setFitToWidth(true);
    	castScroller.setContent(vbox);
    }
    
    /**
     * Setter sets the trailer view of the tv show
     */
    private void setTrailerView() 
    {
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
    
    /**
     * gets the cast pane
     * @param list of cast members
     * @return VBox
     */
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