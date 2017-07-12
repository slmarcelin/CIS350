package movie_db;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import info.movito.themoviedbapi.model.MovieDb;
import info.movito.themoviedbapi.model.tv.TvSeries;

public class Frm_OnAir {

	private JFrame frame4;
	private JPanel totalResults;
	private Cls_MovieData data;

	/**
	 * Launch the application.
	 */
	public void onAirShows() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frm_OnAir window = new Frm_OnAir();
					window.frame4.setLocationRelativeTo(null);
					window.frame4.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Frm_OnAir() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame4 = new JFrame();
		frame4.getContentPane().setBackground(new Color(250, 235, 215));
		frame4.setTitle("On Air");
		frame4.setBounds(100, 100, 450, 300);
		frame4.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame4.getContentPane().setLayout(null);
		frame4.getContentPane().setLayout(new BorderLayout());
		
		totalResults = new JPanel();
		totalResults.setLayout(new BoxLayout(totalResults, BoxLayout.Y_AXIS));
		
		data = new Cls_MovieData();
		String dataFormat = "";
		
		for(TvSeries md : data.m_getTvShowsOnAir()) {
			dataFormat = " Show Title: " + md.getName() + "\n   First Aired: ";
			dataFormat += md.getFirstAirDate() + "\n   Description: ";
			dataFormat += md.getOverview() + "\n\n";
			
			Pnl_ArtworkPanel a = new Pnl_ArtworkPanel("http://image.tmdb.org/t/p/w92/" + md.getPosterPath(), dataFormat);
			totalResults.add(a);
		}
		
		frame4.add(totalResults, BorderLayout.CENTER);
		
		totalResults.repaint();
	}

}
