package movie_db;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.Color;
import info.movito.themoviedbapi.model.tv.TvSeries;

import javax.swing.JTextArea;
import javax.swing.JScrollPane;

public class Frm_SearchTVShows {

	private JFrame tv_search;
	
	private Cls_MovieData data;
	private String str_SearchValue;

	/**
	 * Launch the application.
	 */
	public static void tvSearch(String str_SearchValue) {
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
		
		data = new Cls_MovieData();
		String dataFormat = "";
		
		for(TvSeries tvd : data.m_getSearchTVShows(str_SearchValue)) {
			dataFormat += "TV Show Title: "+ tvd.getName() + "\n   ";
			dataFormat += "First Air Date: " + tvd.getFirstAirDate() + "\n";
			dataFormat +="Last Air Date: "+ tvd.getLastAirDate() + "\n   ";
			dataFormat +="TV Show description: "+ tvd.getOverview() + "\n   ";
		}
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 410, 231);
		tv_search.getContentPane().add(scrollPane);
		
		JTextArea results = new JTextArea();
		scrollPane.setViewportView(results);
		results.setWrapStyleWord(true);
		results.setLineWrap(true);
		results.setColumns(100);
		results.setTabSize(100);
		results.setRows(100);
		
		results.setText(dataFormat);
		
	}
}
