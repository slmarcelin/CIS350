package movie_db;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Window.Type;
import javax.swing.JTextField;

import info.movito.themoviedbapi.model.Genre;
import info.movito.themoviedbapi.model.MovieDb;

import javax.swing.JTextArea;
import javax.swing.JComboBox;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class Frm_GenreMovies {

	private JFrame movie_Genre;
	private JTextField textField;
	private JTextArea results;
	
	private Cls_MovieData data;

	/**
	 * Launch the application.
	 */
	public static void movieGenres() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frm_GenreMovies window = new Frm_GenreMovies();
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
		movie_Genre.setTitle("Movie List");
		movie_Genre.getContentPane().setBackground(new Color(250, 235, 215));
		movie_Genre.setBounds(100, 100, 450, 300);
		movie_Genre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		movie_Genre.getContentPane().setLayout(null);
		
		data = new Cls_MovieData();
		String dataFormat = "";
		
		JComboBox cmb_GenreComboBox = new JComboBox();
		cmb_GenreComboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				String dataFormat = "";
				Genre temp = (Genre)arg0.getItem();
				
				for(MovieDb md : data.m_getMoviesByGenre(temp.getId())) {
					dataFormat += md.getTitle() + "\n   ";
					dataFormat += md.getReleaseDate() + "\n   ";
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
		cmb_GenreComboBox.setBounds(10, 220, 410, 22);
		
		for(Genre g : data.m_getGenres()) {
			cmb_GenreComboBox.addItem(g);
		}
		
		Genre temp = (Genre)cmb_GenreComboBox.getSelectedItem();
		
		for(MovieDb md : data.m_getMoviesByGenre(temp.getId())) {
			dataFormat += md.getTitle() + "\n   ";
			dataFormat += md.getReleaseDate() + "\n   ";
			dataFormat += md.getOverview() + "\n\n";
		}
		
		movie_Genre.getContentPane().add(cmb_GenreComboBox);
		
		results = new JTextArea();
		results.setColumns(100);
		results.setTabSize(100);
		results.setRows(100);
		results.setBounds(10, 11, 410, 198);
		results.setText(dataFormat);
		
		movie_Genre.getContentPane().add(results);
		
	}
}
