/**
 * @author Alec Willison
 */
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

/**
 *Sets a JPanel for movie info.
 */
@SuppressWarnings("serial")
public class MovieInfoPanel extends JPanel {
	/**
	 * Constructs the MovieInfoPanel GUI.
	 * @param movie the movie to display
	 */
	public void initAndShowGUI(final MovieDb movie) {
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
	
	/**
	 * Initializes fx.
	 * @param fxPanel the fx panel
	 * @param movie the movie to display
	 */
	private void initFX(final JFXPanel fxPanel, final MovieDb movie) {
        // This method is invoked on the JavaFX thread

		try {
			FXMLLoader loader = new FXMLLoader(
				    getClass().getResource(
				      "MovieInfoUI.fxml"));

			
            Parent root = (Parent) loader.load();
            MovieInfoController controller =
            		loader.<MovieInfoController>getController();
            controller.init(movie);
            Scene scene = new Scene(root, 250, 150);
            fxPanel.setScene(scene);
        } catch (IOException exc) {
            exc.printStackTrace();
        }
    }
}
