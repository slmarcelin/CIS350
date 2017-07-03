package movie_db;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import info.movito.themoviedbapi.model.MovieDb;
import info.movito.themoviedbapi.model.tv.TvSeries;

public class Frm_OnAir {

	private JFrame frame4;
	private Cls_MovieData onAir;

	/**
	 * Launch the application.
	 */
	public static void onAirShows() {
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
		
		onAir = new Cls_MovieData();
		String dataFormat = "";
		
		
		for(TvSeries md : onAir.m_getTvShowsOnAir()) {
			dataFormat += " Show Title: " + md.getName() + "\n First Aired: ";
			dataFormat += md.getFirstAirDate() + "\n Description: ";
			dataFormat += md.getOverview() + "\n\n";
		}
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 410, 220);
		frame4.getContentPane().add(scrollPane);
		
		JTextArea results = new JTextArea();
		scrollPane.setViewportView(results);
		results.setColumns(100);
		results.setTabSize(100);
		results.setRows(100);
		
		results.setText(dataFormat);
	}

}
