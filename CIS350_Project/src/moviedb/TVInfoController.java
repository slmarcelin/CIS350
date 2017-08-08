package moviedb;
import info.movito.themoviedbapi.model.tv.TvSeries;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Scanner;




import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.TextAlignment;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

/**
 * The TVInfo controller for fx.
 */
public class TVInfoController {
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
     * Empty constructor.
     */
    public TVInfoController() {    	
    }
    
    /**
     * Initializes the program.
     * @param pShow chosen by user
     */
    public void init(final TvSeries pShow) {
    	this.show = pShow;
    	setTvTitle();
    	setTvImage();
    	setTvDetails();
    	setTrailerView();
    	setCast();
    }
    
    /**
     * Setter sets the title of the tv show.
     */
    private void setTvTitle() {
    	tvTitle.setText(show.getName());
    }
    
    /**
     * Setter sets the poster image of the tv show.
     */
    private void setTvImage() {
    	Image imgPoster = new Image(
    	        "http://image.tmdb.org/t/p/w342/" + show.getPosterPath());
    	tvPoster.setImage(imgPoster);
    }
    
    /**
     * Setter sets th etv show overview details.
     */
    private void setTvDetails() {
    	
      tvDetails.setStyle("-fx-border-color: black;");
      tvDetails.setText("Original Title: " + show.getOriginalName()
    		  + "\nReleased Date: " + show.getFirstAirDate()
    		  + "\nNumber of seasons: " + show.getNumberOfSeasons()
    		  + "\n\nShow Description \n" + show.getOverview());
    }
    
    /**
     * Setter sets the cast of the tv show.
     */
    private void setCast() {
    	castScroller.setStyle("-fx-border-color: black;");
    	VBox vbox = getCastPane(MovieData.getTvCast(show.getId()));
    	castScroller.setFitToWidth(true);
    	castScroller.setContent(vbox);
    }
    
    /**
     * Setter sets the trailer view of the tv show.
     */
    private void setTrailerView() {
    	String trailerKey = null;
    	String youtubeKey = "http://api.themoviedb.org/3/tv/" + show.getId()
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
                trailerKey = trailerKey.substring(trailerKey.indexOf("key") + 6,
	    				trailerKey.indexOf("key") + 17);
	    		//Group  root  =  new  Group();
	    		//trailerView = new WebView();
	    		WebEngine webEngine = trailerView.getEngine();
	    		webEngine.load("http://www.youtube.com/embed/"
	    				+ trailerKey + "?autoplay=1");
	    	}
    }
    
    /**
     * gets the cast pane.
     * @param list of cast members
     * @return VBox
     */
    private VBox getCastPane(final ArrayList<TvCastMember> list) {
    	VBox vbox = new VBox();
    	
    	for (TvCastMember member : list) {
    		BorderPane memberPane = new BorderPane();
    		Image profile = new Image(
                    "http://image.tmdb.org/t/p/w45" + member.getProfilePath());
    		ImageView memberView = new ImageView(profile);
    		
    		Label memberName = new Label(member.getName());
    		memberName.setStyle("-fx-background-color: linear-gradient("
    		        + "from 25% 25% to 100% 100%, #c0c0c0, #ffffff)");
    		Label memberInfo = new Label(" ID: " + member.getId() + "\n" 
                    + " Character Played: " + member.getCharacterName() + "\n");
    		memberInfo.setAlignment(Pos.CENTER_LEFT);
    		//memberInfo.setTextAlignment(TextAlignment.LEFT);
    		
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