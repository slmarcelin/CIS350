package movie_db;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.Color;


import info.movito.themoviedbapi.model.MovieDb;

import javax.swing.JTextArea;
import javax.swing.JScrollPane;

public class Frm_SearchMovies {

	private JFrame movies_search;
	
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
		movies_search.getContentPane().setBackground(new Color(250, 235, 215));
		movies_search.setBounds(100, 100, 450, 300);
		movies_search.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		movies_search.getContentPane().setLayout(new BorderLayout());
		
		data = new Cls_MovieData();
		String dataFormat = "";
		
		for(MovieDb md : data.m_getSearchMovies(str_SearchValue)) {
			dataFormat += "Movie Title: "+md.getTitle() + "\n Released Date: ";
			dataFormat += md.getReleaseDate() + "\n Description: ";
			dataFormat += md.getOverview() + "\n\n";
		}
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 410, 231);
		movies_search.getContentPane().add(scrollPane);
		
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
