package movie_db;

import info.movito.themoviedbapi.model.MovieDb;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

public class Frm_DisplayMovies extends JFrame{
	/**
	 * Constructs the JFrame to display movies
	 * @param title the title of the JFrame
	 * @param movies the movies to display on the JFrame
	 */
	public Frm_DisplayMovies(String title, ArrayList<MovieDb> movies) {
		setTitle(title);
		setBounds(100, 100, 900, 600);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(new BorderLayout());
		
		addMovies(movies);
		
		setLocationRelativeTo(null);
		setVisible(true);
	}

	/**
	 * Adds a list of movies to the frame
	 * @param movies the list of movies to add to the frame
	 */
	private void addMovies(ArrayList<MovieDb> movies) {
		JPanel totalResults = new JPanel();
		totalResults.setLayout(new BoxLayout(totalResults, BoxLayout.Y_AXIS));
				
		for(MovieDb md : movies) {
			//TODO: Pnl_ArtworkPanel a = new Pnl_ArtworkPanel("http://image.tmdb.org/t/p/w92/" + md.getPosterPath(), dataFormat);
			totalResults.add(new Pnl_MoviePanel(md));
		}
		
		JScrollPane scrollPane = new JScrollPane(totalResults);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		getContentPane().add(scrollPane);
	}

}
