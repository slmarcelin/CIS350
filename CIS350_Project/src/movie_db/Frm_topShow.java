package movie_db;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import info.movito.themoviedbapi.model.tv.TvSeries;

public class Frm_topShow {

	private JFrame frame5;
	private JPanel totalResults;
	private Cls_MovieData data;

	/**
	 * Launch the application.
	 */
	public void topTV() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frm_topShow window = new Frm_topShow();
					window.frame5.setLocationRelativeTo(null);
					window.frame5.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Frm_topShow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame5 = new JFrame();
		frame5.setTitle("Top rated TV Shows");
		frame5.setBounds(100, 100, 450, 300);
		frame5.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame5.getContentPane().setLayout(new BorderLayout());
		frame5.getContentPane().setLayout(new BorderLayout());
		
		totalResults = new JPanel();
		totalResults.setLayout(new BoxLayout(totalResults, BoxLayout.Y_AXIS));
		
		data = new Cls_MovieData();
		String dataFormat = "";
		
		for(TvSeries md : data.m_getTvShowsTopRated()) {
			dataFormat = " Show Title: " + md.getName() + "\n   First Aired: ";
			dataFormat += md.getFirstAirDate() + "\n   Description: ";
			dataFormat += md.getOverview() + "\n\n";
			
			Pnl_ArtworkPanel a = new Pnl_ArtworkPanel("http://image.tmdb.org/t/p/w92/" + md.getPosterPath(), dataFormat);
			totalResults.add(a);
		}
		
		frame5.add(totalResults, BorderLayout.CENTER);
		
		totalResults.repaint();
	}

}
