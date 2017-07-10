package movie_db;

import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Color;
import info.movito.themoviedbapi.model.MovieDb;

import javax.swing.JTextArea;
import javax.swing.JScrollPane;

public class Frm_InTheaterMovies {

	private JFrame Movie_list;
	private JPanel totalResults;

	
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
		Movie_list.setTitle("Movies In Theaters");
		Movie_list.getContentPane().setBackground(new Color(0, 204, 204));
		Movie_list.setBounds(100, 100, 450, 300);
		Movie_list.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		Movie_list.getContentPane().setLayout(new BorderLayout());
		
		//JScrollPane scrollPane = new JScrollPane();
		//scrollPane.setBounds(10, 11, 410, 220);
		//Movie_list.getContentPane().add(scrollPane);
		
		totalResults = new JPanel();
		totalResults.setLayout(new BoxLayout(totalResults, BoxLayout.Y_AXIS));
		
		data = new Cls_MovieData();
		String dataFormat = "";
		
		for(MovieDb md : data.m_getInTheaterMovies()) {
			dataFormat = " Movie title: " + md.getTitle() + "\n Released date: ";
			dataFormat += md.getReleaseDate() + "\n Description: ";
			dataFormat += md.getOverview() + "\n\n";
			
			Pnl_ArtworkPanel a = new Pnl_ArtworkPanel("http://image.tmdb.org/t/p/w92/" + md.getPosterPath(), dataFormat);
			totalResults.add(a);
		}
		
		Movie_list.add(totalResults, BorderLayout.CENTER);
		
		//JTextArea results = new JTextArea();
		//results.setWrapStyleWord(true);
		//results.setLineWrap(true);
		//scrollPane.setViewportView(totalResults);
		//results.setColumns(100);
		//results.setTabSize(100);
		//results.setRows(100);
		
		//results.setText(dataFormat);
		
		//totalResults.add(results, BorderLayout.CENTER);
		//totalResults.add(resultsPic, BorderLayout.WEST);
		totalResults.repaint();
		
	}
}
