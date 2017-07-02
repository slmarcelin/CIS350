package movie_db;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JMenuBar;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;

public class Genres {

	private JFrame Genre_frame;

	/**
	 * Launch the application.
	 */
	public void genreWindow() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Genres window = new Genres();
					window.Genre_frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Genres() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Genre_frame = new JFrame();
		Genre_frame.setTitle("Movie Genres");
		Genre_frame.setBounds(100, 100, 450, 300);
		Genre_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Genre_frame.getContentPane().setLayout(new GridLayout(1, 0, 0, 0));
		
		JPanel btnCrime = new JPanel();
		btnCrime.setBackground(new Color(0, 204, 204));
		btnCrime.setForeground(new Color(0, 204, 255));
		Genre_frame.getContentPane().add(btnCrime);
		btnCrime.setLayout(null);
		
		JButton btnAction = new JButton("Action");
		btnAction.setBackground(new Color(153, 204, 255));
		btnAction.setBounds(68, 39, 89, 23);
		btnCrime.add(btnAction);
		
		JLabel lblGenres = new JLabel("Genres");
		lblGenres.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		lblGenres.setBounds(185, 24, 109, 23);
		btnCrime.add(lblGenres);
		
		JButton btnAdventures = new JButton("Adventures");
		btnAdventures.setBackground(new Color(153, 204, 255));
		btnAdventures.setBounds(277, 39, 89, 23);
		btnCrime.add(btnAdventures);
		
		JButton btnDrama = new JButton("Drama");
		btnDrama.setBackground(new Color(153, 204, 255));
		btnDrama.setBounds(68, 109, 89, 23);
		btnCrime.add(btnDrama);
		
		JButton btnFamily = new JButton("Family");
		btnFamily.setBackground(new Color(153, 204, 255));
		btnFamily.setBounds(277, 109, 89, 23);
		btnCrime.add(btnFamily);
		
		JButton btnNewButton_5 = new JButton("Crime");
		btnNewButton_5.setBackground(new Color(153, 204, 255));
		btnNewButton_5.setBounds(172, 78, 89, 23);
		btnCrime.add(btnNewButton_5);
		
		JButton btnMistery = new JButton("Mistery");
		btnMistery.setBackground(new Color(153, 204, 255));
		btnMistery.setBounds(121, 162, 89, 23);
		btnCrime.add(btnMistery);
		
		JButton btnRomance = new JButton("Romance");
		btnRomance.setBackground(new Color(153, 204, 255));
		btnRomance.setBounds(220, 162, 89, 23);
		btnCrime.add(btnRomance);
	}
}
