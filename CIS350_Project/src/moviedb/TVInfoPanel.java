package moviedb;
import info.movito.themoviedbapi.model.tv.TvSeries;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

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
 * Panel to display tv show information.
 */
@SuppressWarnings("serial")
public class TVInfoPanel extends JPanel {
	/**
	 * sets up the tv panel.
	 * @param tv the tv show to display
	 */
	public void initAndShowGUI(final TvSeries tv) {
		setLayout(new BorderLayout());
		
		final JFXPanel fxPanel = new JFXPanel();
		
		add(fxPanel, BorderLayout.CENTER);
		
		Platform.runLater(new Runnable() {
            @Override
            public void run() {
                initFX(fxPanel, tv);
            }
       });
		
	}
	
	/**
	 * initialize fx.
	 * @param fxPanel the fx panel
	 * @param tv the tv show
	 */
	private void initFX(final JFXPanel fxPanel, final TvSeries tv) {
        // This method is invoked on the JavaFX thread

		try {
			FXMLLoader loader = new FXMLLoader(
				    getClass().getResource(
				      "TVInfoUI.fxml"));

			
            Parent root = (Parent) loader.load();
            TVInfoController controller =
            		loader.<TVInfoController>getController();
            controller.init(tv);
            Scene scene = new Scene(root, 250, 150);
            fxPanel.setScene(scene);
        } catch (IOException exc) {
            exc.printStackTrace();
        }
    }
}
