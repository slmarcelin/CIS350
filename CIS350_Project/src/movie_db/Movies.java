package movie_db;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Window.Type;

public class Movies {

	private JFrame Movie_list;

	/**
	 * Launch the application.
	 */
	public static void movieList() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Movies window = new Movies();
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
	public Movies() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Movie_list = new JFrame();
		Movie_list.setTitle("Movie List");
		Movie_list.getContentPane().setBackground(new Color(250, 235, 215));
		Movie_list.setBounds(100, 100, 450, 300);
		Movie_list.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Movie_list.getContentPane().setLayout(null);
	}

}
