package movie_db;
import java.awt.EventQueue;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Color;


import info.movito.themoviedbapi.model.MovieDb;

import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.JScrollPane;

public class Frm_SearchMovies {

	private JFrame movies_search;
	private JPanel totalResults;
	private Cls_MovieData data;
	private String str_SearchValue;

	public static void movieSearch(String str_SearchValue) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frm_SearchMovies window = new Frm_SearchMovies(str_SearchValue);
					window.movies_search.setLocationRelativeTo(null);
					window.movies_search.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Frm_SearchMovies(String str_SearchValue) {
		this.str_SearchValue = str_SearchValue;
		
		initialize();
	}

	private void initialize() {
		movies_search = new JFrame();
		movies_search.setTitle("Your Movie Search results");
		movies_search.setBounds(100, 100, 900, 600);
		movies_search.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		movies_search.getContentPane().setLayout(new BorderLayout());
		
		totalResults = new JPanel();
		totalResults.setLayout(new BoxLayout(totalResults, BoxLayout.Y_AXIS));
		
		data = new Cls_MovieData();
		
		for(MovieDb md : data.m_getSearchMovies(str_SearchValue)) {
			//TODO: Pnl_ArtworkPanel a = new Pnl_ArtworkPanel("http://image.tmdb.org/t/p/w92/" + md.getPosterPath(), dataFormat);
			totalResults.add(new Pnl_MoviePanel(md));
		}
		
		JScrollPane scrollPane = new JScrollPane(totalResults);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		movies_search.getContentPane().add(scrollPane);
	}
}
