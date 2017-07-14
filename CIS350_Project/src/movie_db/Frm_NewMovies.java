package movie_db;

import java.awt.EventQueue;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

import info.movito.themoviedbapi.model.MovieDb;

import java.awt.BorderLayout;
import java.awt.Color;

public class Frm_NewMovies {

	private JFrame frame3;
	private JPanel totalResults;
	private Cls_MovieData data;

	/**
	 * Launch the application.
	 */
	public void movies_new() {
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
		
		
		totalResults = new JPanel();
		totalResults.setLayout(new BoxLayout(totalResults, BoxLayout.Y_AXIS));
		
		data = new Cls_MovieData();
		String dataFormat = "";
		
		for(MovieDb md : data.m_getNewMovies()) {
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
		frame3.getContentPane().add(scrollPane);
		
		totalResults.repaint();
	}
}
