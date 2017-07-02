package movie_db;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Window.Type;
import javax.swing.JTextField;

import info.movito.themoviedbapi.model.MovieDb;
import info.movito.themoviedbapi.model.people.Person;
import info.movito.themoviedbapi.model.tv.TvSeries;

import javax.swing.JTextArea;

public class Frm_SearchTVShows {

	private JFrame tv_search;
	private JTextField textField;
	
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
		tv_search.setTitle("Movie List");
		tv_search.getContentPane().setBackground(new Color(250, 235, 215));
		tv_search.setBounds(100, 100, 450, 300);
		tv_search.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		tv_search.getContentPane().setLayout(null);
		
		data = new Cls_MovieData();
		String dataFormat = "";
		
		JTextArea results = new JTextArea();
		results.setColumns(100);
		results.setTabSize(100);
		results.setRows(100);
		results.setBounds(10, 11, 420, 220);
		
		for(TvSeries tvd : data.m_getSearchTVShows(str_SearchValue)) {
			dataFormat += tvd.getName() + "\n   ";
			dataFormat += tvd.getFirstAirDate() + " - " + tvd.getLastAirDate() + "\n   ";
			dataFormat += tvd.getOverview() + "\n   ";
			dataFormat += tvd.getId() + "\n\n";
		}
		
		results.setText(dataFormat);
		
		tv_search.getContentPane().add(results);
		
	}
}
