package movie_db;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import info.movito.themoviedbapi.model.MovieDb;

import java.awt.BorderLayout;
import java.awt.Color;

public class Frm_PopularMovies {

	private JFrame Popular;
	
	private Cls_MovieData popular_movies;

	/**
	 * Launch the application.
	 */
	public void popular() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frm_PopularMovies window = new Frm_PopularMovies();
					window.Popular.setLocationRelativeTo(null);
					window.Popular.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Frm_PopularMovies() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Popular = new JFrame();
		Popular.getContentPane().setBackground(new Color(245, 222, 179));
		Popular.getContentPane().setLayout(null);
		Popular.setTitle("Popular Movies");
		Popular.setBounds(100, 100, 450, 300);
		Popular.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		Popular.getContentPane().setLayout(new BorderLayout());
		Popular.getContentPane().setLayout(new BorderLayout());
		
		popular_movies = new Cls_MovieData();
		String dataFormat = "";
		
		for(MovieDb md : popular_movies.m_getPopularMovies()) {
			dataFormat += " Movie title: " + md.getTitle() + "\n\n Released date: ";
			dataFormat += md.getReleaseDate() + "\n Description: ";
			dataFormat += md.getOverview() + "\n\n";
		}
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 410, 220);
		Popular.getContentPane().add(scrollPane);
		
		JTextArea results = new JTextArea();
		results.setWrapStyleWord(true);
		results.setLineWrap(true);
		scrollPane.setViewportView(results);
		results.setColumns(100);
		results.setTabSize(100);
		results.setRows(100);
		
		results.setText(dataFormat);
	}

}
