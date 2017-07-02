package movie_db;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;

public class popular_Movies {

	private JFrame Popular;

	/**
	 * Launch the application.
	 */
	public void popular() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					popular_Movies window = new popular_Movies();
					window.Popular.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public popular_Movies() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Popular = new JFrame();
		Popular.getContentPane().setBackground(new Color(245, 222, 179));
		Popular.getContentPane().setLayout(null);
		Popular.setTitle("Popular Movies");
		Popular.setBounds(100, 100, 450, 300);
		Popular.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
