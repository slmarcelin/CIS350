package moviedb;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import info.movito.themoviedbapi.model.MovieDb;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class MovieInfoPanel extends JPanel {
	public void initAndShowGUI(MovieDb movie) {
		setLayout(new BorderLayout());
		
		final JFXPanel fxPanel = new JFXPanel();
		
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

		try {
			FXMLLoader loader = new FXMLLoader(
				    getClass().getResource(
				      "MovieInfoUI.fxml"));

			
            Parent root = (Parent)loader.load();
            MovieInfoController controller = loader.<MovieInfoController>getController();
            controller.init(movie);
            Scene scene = new Scene(root, 250, 150);
            fxPanel.setScene(scene);
        } catch (IOException exc) {
            exc.printStackTrace();
            System.exit(1);
        }
    }
}
