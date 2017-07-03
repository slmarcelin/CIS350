package movie_db;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTable;
import java.awt.Color;

public class Frm_NewMovies {

	private JFrame frame3;

	/**
	 * Launch the application.
	 */
	public static void movies_new() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frm_NewMovies window = new Frm_NewMovies();
					window.frame3.setLocationRelativeTo(null);
					window.frame3.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Frm_NewMovies() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame3 = new JFrame();
		frame3.getContentPane().setBackground(new Color(250, 235, 215));
		frame3.setTitle("New Movies");
		frame3.setBounds(100, 100, 450, 300);
		frame3.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame3.getContentPane().setLayout(null);
	}
}
