package movie_db;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import java.awt.GridLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.Button;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;

public class MainFrame extends JFrame {
	//private final Action action = new SwingAction();
	//private final Action action_1 = new SwingAction_1();
	private JTextField actors_textField;
	private JTextField movies_textField;
	private JTextField genres_textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
					frame.setVisible(true);
					frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("                                     Menu");
		mntmNewMenuItem_1.setFont(new Font("Times New Roman", Font.ITALIC, 18));
		menuBar.add(mntmNewMenuItem_1);
		
		JPanel Menu_Panel = new JPanel();
		getContentPane().add(Menu_Panel, BorderLayout.CENTER);
		
		JButton movies_button = new JButton("Movies");
		movies_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Movies listMovies= new Movies();
				listMovies.movieList();
			}
		});
		Menu_Panel.add(movies_button);
		
		JButton newMovies_button = new JButton("New Movies");
		newMovies_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new_Movies newMovie= new new_Movies();
				newMovie.movies_new();
			}
		});
		Menu_Panel.add(newMovies_button);
		
		JButton tvShows_button = new JButton("TV Shows");
		Menu_Panel.add(tvShows_button);
		
		JButton newTvShows_button = new JButton("New TV Shows");
		Menu_Panel.add(newTvShows_button);
		
		actors_textField = new JTextField();
		Menu_Panel.add(actors_textField);
		actors_textField.setColumns(20);
		
		JLabel actorsLabel = new JLabel("Actors");
		actorsLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
		Menu_Panel.add(actorsLabel);
		
		JButton actorsSearch = new JButton("Search");
		Menu_Panel.add(actorsSearch);
		
		movies_textField = new JTextField();
		Menu_Panel.add(movies_textField);
		movies_textField.setColumns(20);
		
		JLabel moviesLabel = new JLabel("Movies");
		moviesLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
		Menu_Panel.add(moviesLabel);
		
		JButton moviesSearch = new JButton("Search");
		Menu_Panel.add(moviesSearch);
		
		genres_textField = new JTextField();
		Menu_Panel.add(genres_textField);
		genres_textField.setColumns(20);
		
		JLabel genresLabel = new JLabel("Genres");
		genresLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
		Menu_Panel.add(genresLabel);
		
		JButton genresSearch = new JButton("Search");
		Menu_Panel.add(genresSearch);
	}

	
}
