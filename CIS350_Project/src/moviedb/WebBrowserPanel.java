package moviedb;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

import javax.swing.JPanel;

import info.movito.themoviedbapi.model.MovieDb;
import javafx.*;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

public class WebBrowserPanel extends JPanel {
	public void initAndShowGUI(MovieDb movie) {
        // This method is invoked on the EDT thread
        //JFrame frame = new JFrame("Swing and JavaFX");
        final JFXPanel fxPanel = new JFXPanel();
        //fxPanel.setPreferredSize(new Dimension(450,300));
        //frame.add(fxPanel);
        //frame.setSize(300, 200);
        //frame.setVisible(true);
        //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(450, 300));
        add(fxPanel, BorderLayout.CENTER);

        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                initFX(fxPanel, movie);
            }
       });
    }

    private void initFX(JFXPanel fxPanel, MovieDb movie) {
        // This method is invoked on the JavaFX thread
        Scene scene = createScene(movie);
        fxPanel.setScene(scene);
    }

    private Scene createScene(MovieDb movie) {
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
    	WebView browser = new WebView();
    	WebEngine webEngine = browser.getEngine();
    	webEngine.load("http://www.youtube.com/embed/" + trailerKey + "?autoplay=1");
        Scene  scene  =  new  Scene(browser);
        
        /*text.setX(40);
        text.setY(100);
        text.setFont(new Font(25));
        text.setText("Welcome JavaFX!");

        root.getChildren().add(text);*/

        return scene;
    }
}
