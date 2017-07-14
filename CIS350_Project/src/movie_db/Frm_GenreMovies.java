package movie_db;

import java.awt.EventQueue;

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
	private Cls_MovieData data;
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
	
		data = new Cls_MovieData();
		
		JComboBox cmb_GenreComboBox = new JComboBox();
		cmb_GenreComboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				String dataFormat = "";
				Genre temp = (Genre)arg0.getItem();
				
				for(MovieDb md : data.m_getMoviesByGenre(temp.getId())) {
					dataFormat += "Movie Title: "+ md.getTitle() + "\nReleased Date: ";
					dataFormat += md.getReleaseDate() + "\nDescription: ";
					dataFormat += md.getOverview() + "\n\n";
				}
				
				try {
					results.setText(dataFormat);
					results.repaint();
				}
				catch(Exception e)
				{ return; }
		
			}
		});
		cmb_GenreComboBox.setBounds(10, 222, 410, 22);
		
		for(Genre g : data.m_getGenres()) {
			cmb_GenreComboBox.addItem(g);
		}
		
		Genre temp = (Genre)cmb_GenreComboBox.getSelectedItem();
		
		totalResults = new JPanel();
		totalResults.setLayout(new BoxLayout(totalResults, BoxLayout.Y_AXIS));
		totalResults.setBounds(100, 100, 450, 300);
		
		String dataFormat = "";
		
		for(MovieDb md : data.m_getMoviesByGenre(temp.getId())) {
			dataFormat = " Movie title: " + md.getTitle() + "\n   Released Date: ";
			dataFormat += md.getReleaseDate() + "\n   Description: ";
			dataFormat += md.getOverview() + "\n\n";
			
			Pnl_ArtworkPanel a = new Pnl_ArtworkPanel("http://image.tmdb.org/t/p/w92/" + md.getPosterPath(), dataFormat);
			totalResults.add(a);
		}
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(100, 100, 450, 300);
		scrollPane.setViewportView(totalResults);
		movie_Genre.getContentPane().add(scrollPane);
		
		totalResults.repaint();
		
	}
}
