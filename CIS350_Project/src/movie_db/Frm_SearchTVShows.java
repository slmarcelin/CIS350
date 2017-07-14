package movie_db;

import java.awt.EventQueue;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Color;
import info.movito.themoviedbapi.model.tv.TvSeries;

import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.JScrollPane;

public class Frm_SearchTVShows {

	private JFrame tv_search;
	private JPanel totalResults;
	private Cls_MovieData data;
	private String str_SearchValue;

	/**
	 * Launch the application.
	 */
	public void tvSearch(String str_SearchValue) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frm_SearchTVShows window = new Frm_SearchTVShows(str_SearchValue);
					window.tv_search.setLocationRelativeTo(null);
					window.tv_search.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Frm_SearchTVShows(String str_SearchValue) {
		   this.str_SearchValue = str_SearchValue;
		   
		   initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		tv_search = new JFrame();
		tv_search.setTitle("Your TV Show Search results");
		tv_search.getContentPane().setBackground(new Color(250, 235, 215));
		tv_search.setBounds(100, 100, 450, 300);
		tv_search.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		tv_search.getContentPane().setLayout(new BorderLayout());
		
		totalResults = new JPanel();
		totalResults.setLayout(new BoxLayout(totalResults, BoxLayout.Y_AXIS));
		
		data = new Cls_MovieData();
		String dataFormat = "";
		
		for(TvSeries md : data.m_getSearchTVShows(str_SearchValue)) {
			dataFormat = " Show Title: " + md.getName() + "\n   First Aired: ";
			dataFormat += md.getFirstAirDate() + "\n   Description: ";
			dataFormat += md.getOverview() + "\n\n";
			
			Pnl_ArtworkPanel a = new Pnl_ArtworkPanel("http://image.tmdb.org/t/p/w92/" + md.getPosterPath(), dataFormat);
			totalResults.add(a);
		}
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(100, 100, 450, 300);
		scrollPane.setViewportView(totalResults);
		tv_search.getContentPane().add(scrollPane);
		
		
		totalResults.repaint();
		
	}
}
