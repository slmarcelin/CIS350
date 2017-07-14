package movie_db;

import java.awt.EventQueue;
import java.awt.Point;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Color;

import info.movito.themoviedbapi.model.Genre;
import info.movito.themoviedbapi.model.MovieDb;

import javax.swing.JTextArea;
import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

public class Frm_GenreMovies {

	private JFrame movie_Genre;
	private JTextArea results;
	private JPanel totalResults;
	private JScrollPane scrollPane;

	/**
	 * Launch the application.
	 */
	public void movieGenres() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frm_GenreMovies window = new Frm_GenreMovies();
					window.movie_Genre.setLocationRelativeTo(null);
					window.movie_Genre.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	

	/**
	 * Create the application.
	 */
	public Frm_GenreMovies() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		movie_Genre = new JFrame();
		movie_Genre.setTitle("Movie Genres");
		movie_Genre.getContentPane().setBackground(new Color(250, 235, 215));
		movie_Genre.setBounds(100, 100, 450, 300);
		movie_Genre.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		movie_Genre.getContentPane().setLayout(new BorderLayout());
	
		String dataFormat = "";
		totalResults = new JPanel();
		JScrollPane scrollPane = new JScrollPane();
		
		JComboBox cmb_GenreComboBox = new JComboBox();
		cmb_GenreComboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				String dataFormat = "";
				Genre temp = (Genre)arg0.getItem();
				
				totalResults.removeAll();
				
				for(MovieDb md : Cls_MovieData.m_getMoviesByGenre(temp.getId())) {
					dataFormat = " Movie title: " + md.getTitle() + "\n   Released Date: ";
					dataFormat += md.getReleaseDate() + "\n   Description: ";
					dataFormat += md.getOverview() + "\n\n";
					
					Pnl_ArtworkPanel a = new Pnl_ArtworkPanel("http://image.tmdb.org/t/p/w92/" + md.getPosterPath(), dataFormat);
					totalResults.add(a);
				}
			}
		});
		cmb_GenreComboBox.setBounds(10, 222, 410, 22);
		
		for(Genre g : Cls_MovieData.m_getGenres()) {
			cmb_GenreComboBox.addItem(g);
		}
		
		Genre temp = (Genre)cmb_GenreComboBox.getSelectedItem();
		
		totalResults.setLayout(new BoxLayout(totalResults, BoxLayout.Y_AXIS));
		totalResults.setBounds(100, 100, 450, 300);
		
		for(MovieDb md : Cls_MovieData.m_getMoviesByGenre(temp.getId())) {
			dataFormat = " Movie title: " + md.getTitle() + "\n   Released Date: ";
			dataFormat += md.getReleaseDate() + "\n   Description: ";
			dataFormat += md.getOverview() + "\n\n";
			
			Pnl_ArtworkPanel a = new Pnl_ArtworkPanel("http://image.tmdb.org/t/p/w92/" + md.getPosterPath(), dataFormat);
			totalResults.add(a);
		}
		
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(100, 100, 450, 300);
		scrollPane.setViewportView(totalResults);
		movie_Genre.getContentPane().add(scrollPane);
		movie_Genre.add(cmb_GenreComboBox, BorderLayout.NORTH);
		
		totalResults.repaint();
		
	}
}
