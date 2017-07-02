package movie_db;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Window.Type;
import javax.swing.JTextField;
import javax.swing.JTextArea;

public class Movies {

	private JFrame Movie_list;
	private JTextField textField;

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
		
		JTextArea results = new JTextArea();
		results.setColumns(100);
		results.setTabSize(100);
		results.setRows(100);
		results.setBounds(10, 11, 420, 220);
		Movie_list.getContentPane().add(results);
		
	}
}
