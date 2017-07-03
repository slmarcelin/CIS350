package movie_db;

import java.awt.EventQueue;

import javax.swing.JFrame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Window.Type;
import javax.swing.JTextField;

import info.movito.themoviedbapi.model.MovieDb;

import javax.swing.JTextArea;
import javax.swing.JScrollPane;

public class Frm_InTheaterMovies {

	private JFrame Movie_list;
	private JTextField textField;
	
	private Cls_MovieData data;

	/**
	 * Launch the application.
	 */
	public static void movieList() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frm_InTheaterMovies window = new Frm_InTheaterMovies();
					window.Movie_list.setLocationRelativeTo(null);
					window.Movie_list.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Frm_InTheaterMovies() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Movie_list = new JFrame();
		Movie_list.setTitle("Movie List");
		Movie_list.getContentPane().setBackground(new Color(0, 204, 204));
		Movie_list.setBounds(100, 100, 450, 300);
		Movie_list.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		Movie_list.getContentPane().setLayout(null);
		Movie_list.getContentPane().setLayout(new BorderLayout());
		
		data = new Cls_MovieData();
		String dataFormat = "";
		
		for(MovieDb md : data.m_getInTheaterMovies()) {
			dataFormat += " Movie title: " + md.getTitle() + "\n Released date: ";
			dataFormat += md.getReleaseDate() + "\n Description: ";
			dataFormat += md.getOverview() + "\n\n";
		}
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 410, 220);
		Movie_list.getContentPane().add(scrollPane);
		
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
