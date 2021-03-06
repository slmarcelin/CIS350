package moviedb;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import info.movito.themoviedbapi.model.MovieDb;

/**
 * Sets the movie info frame for the
 * chosen movie.
 * @author Alec Willison
 */
@SuppressWarnings("serial")
public class MovieInfoFrame extends JFrame {
	/**
	 * Constructs a MovieInfoFrame.
	 * @param movie the movie to display in the frame
	 */
	MovieInfoFrame(final MovieDb movie) {
		setLayout(new BorderLayout());
		MovieInfoPanel mip = new MovieInfoPanel(); 
	
		SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                mip.initAndShowGUI(movie);
            }
        });
		add(mip, BorderLayout.CENTER);
		setSize(new Dimension(1250, 445));
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);
	}
}
