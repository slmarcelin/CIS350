package movie_db;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import info.movito.themoviedbapi.model.tv.TvSeries;

public class Frm_popularShows {

	private JFrame frame6;
	private JPanel totalResults;
	private Cls_MovieData data;
	/**
	 * Launch the application.
	 */
	public void popTV() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frm_popularShows window = new Frm_popularShows();
					window.frame6.setLocationRelativeTo(null);
					window.frame6.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Frm_popularShows() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame6 = new JFrame();
		frame6.setTitle("Popular TV Shows");
		frame6.setBounds(100, 100, 450, 300);
		frame6.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame6.getContentPane().setLayout(new BorderLayout());
		
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
		
		frame6.add(totalResults, BorderLayout.CENTER);
		
		totalResults.repaint();
	}

}
