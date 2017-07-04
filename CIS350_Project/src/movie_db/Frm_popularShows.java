package movie_db;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import info.movito.themoviedbapi.model.tv.TvSeries;

public class Frm_popularShows {

	private JFrame frame6;
	private Cls_MovieData popShow;
	/**
	 * Launch the application.
	 */
	public void popTV() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frm_popularShows window = new Frm_popularShows();
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
		frame6.setBounds(100, 100, 450, 300);
		frame6.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame6.getContentPane().setLayout(new BorderLayout());
		
		popShow = new Cls_MovieData();
		String dataFormat = "";
		
		for(TvSeries md : popShow.m_getTvShowsPopular()) {
			dataFormat += " Show Title: " + md.getName() + "\n First Aired: ";
			dataFormat += md.getFirstAirDate() + "\n Description: ";
			dataFormat += md.getOverview() + "\n\n";
		}
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 410, 220);
		frame6.getContentPane().add(scrollPane);
		
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
