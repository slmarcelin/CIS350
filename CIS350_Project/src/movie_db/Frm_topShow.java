package movie_db;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import info.movito.themoviedbapi.model.MovieDb;
import info.movito.themoviedbapi.model.tv.TvSeries;

public class Frm_topShow {

	private JFrame frame5;
	private Cls_MovieData topShow;
	private JScrollPane scrollPane;

	/**
	 * Launch the application.
	 */
	public void topTV() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frm_topShow window = new Frm_topShow();
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
		frame5.setBounds(100, 100, 450, 300);
		frame5.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame5.getContentPane().setLayout(new BorderLayout());
		frame5.getContentPane().setLayout(new BorderLayout());
		
		topShow = new Cls_MovieData();
		String dataFormat = "";
		
		for(TvSeries md : topShow.m_getTvShowsTopRated()) {
			dataFormat += " Show Title: " + md.getName() + "\n First Aired: ";
			dataFormat += md.getFirstAirDate() + "\n Description: ";
			dataFormat += md.getOverview() + "\n\n";
		}
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 410, 220);
		frame5.getContentPane().add(scrollPane);
		
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
