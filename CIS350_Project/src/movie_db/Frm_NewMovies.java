package movie_db;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;

import info.movito.themoviedbapi.model.MovieDb;

import java.awt.BorderLayout;
import java.awt.Color;

public class Frm_NewMovies {

	private JFrame frame3;
	private Cls_MovieData new_movies;

	/**
	 * Launch the application.
	 */
	public static void movies_new() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frm_NewMovies window = new Frm_NewMovies();
					window.frame3.setLocationRelativeTo(null);
					window.frame3.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Frm_NewMovies() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame3 = new JFrame();
		frame3.getContentPane().setBackground(new Color(250, 235, 215));
		frame3.setTitle("New Movies");
		frame3.setBounds(100, 100, 450, 300);
		frame3.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		
		new_movies = new Cls_MovieData();
		String dataFormat = "";
		
		for(MovieDb md : new_movies.m_getNewMovies()) {
			dataFormat += " Movie Title: " + md.getTitle() + "\n Released Date: ";
			dataFormat += md.getReleaseDate() + "\n Description: ";
			dataFormat += md.getOverview() + "\n\n";
		}
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 410, 220);
		frame3.getContentPane().add(scrollPane);
		
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
