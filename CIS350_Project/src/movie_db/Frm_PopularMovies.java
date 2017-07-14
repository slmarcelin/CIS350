package movie_db;

import java.awt.EventQueue;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

import info.movito.themoviedbapi.model.MovieDb;

import java.awt.BorderLayout;
import java.awt.Color;

public class Frm_PopularMovies {

	private JFrame Popular;
	private JPanel totalResults;
	private Cls_MovieData data;

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
		
		totalResults = new JPanel();
		totalResults.setLayout(new BoxLayout(totalResults, BoxLayout.Y_AXIS));
		
		data = new Cls_MovieData();
		String dataFormat = "";
		
		for(MovieDb md : data.m_getPopularMovies()) {
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
		Popular.getContentPane().add(scrollPane);
		
		totalResults.repaint();
	}

}
