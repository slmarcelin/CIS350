
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
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Panel;

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
		mntmNewMenuItem_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 21));
		menuBar.add(mntmNewMenuItem_1);
		
		JPanel Menu_Panel = new JPanel();
		getContentPane().add(Menu_Panel, BorderLayout.CENTER);
		
		JButton movies_button = new JButton("Movies");
		movies_button.setBounds(3, 5, 79, 23);
		movies_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Movies listMovies= new Movies();
				listMovies.movieList();
			}
		});
		Menu_Panel.setLayout(null);
		Menu_Panel.add(movies_button);
		
		JButton newMovies_button = new JButton("New Movies");
		newMovies_button.setBounds(92, 5, 89, 23);
		newMovies_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new_Movies newMovie= new new_Movies();
				newMovie.movies_new();
			}
		});
		Menu_Panel.add(newMovies_button);
		
		JButton btnPopularMovies = new JButton("Popular Movies");
		btnPopularMovies.setBounds(191, 5, 105, 23);
		Menu_Panel.add(btnPopularMovies);
		
		JButton btnTopRated = new JButton("Top rated ");
		btnTopRated.setBounds(92, 33, 89, 23);
		Menu_Panel.add(btnTopRated);
		
		JButton tvShows_button = new JButton("TV Shows");
		tvShows_button.setBounds(3, 33, 79, 23);
		Menu_Panel.add(tvShows_button);
		
		JButton newTvShows_button = new JButton("New TV Shows");
		newTvShows_button.setBounds(191, 33, 103, 23);
		Menu_Panel.add(newTvShows_button);
		
		System.out.println();
		System.out.println();
		JButton actorsSearch = new JButton("Search");
		actorsSearch.setBounds(239, 70, 79, 21);
		Menu_Panel.add(actorsSearch);
		actors_textField = new JTextField();
		actors_textField.setBounds(63, 71, 166, 20);
		Menu_Panel.add(actors_textField);
		actors_textField.setColumns(20);
		
		JLabel actorsLabel = new JLabel("Actors");
		actorsLabel.setBounds(13, 72, 40, 17);
		actorsLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
		Menu_Panel.add(actorsLabel);
		
		movies_textField = new JTextField();
		movies_textField.setBounds(63, 105, 166, 20);
		Menu_Panel.add(movies_textField);
		movies_textField.setColumns(20);
		
		JLabel moviesLabel = new JLabel("Movies");
		moviesLabel.setBounds(10, 103, 43, 23);
		moviesLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
		Menu_Panel.add(moviesLabel);
		
		JButton moviesSearch = new JButton("Search");
		moviesSearch.setBounds(239, 104, 79, 23);
		Menu_Panel.add(moviesSearch);
		
		genres_textField = new JTextField();
		genres_textField.setBounds(63, 138, 166, 20);
		Menu_Panel.add(genres_textField);
		genres_textField.setColumns(20);
		
		JLabel genresLabel = new JLabel("Genres");
		genresLabel.setBounds(9, 137, 44, 17);
		genresLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
		Menu_Panel.add(genresLabel);
		
		JButton genresSearch = new JButton("Search");
		genresSearch.setBounds(239, 135, 79, 23);
		Menu_Panel.add(genresSearch);
		
		//this will display an image when user hovers over a choice
		Panel panel = new Panel();
		panel.setBounds(332, 33, 92, 95);
		Menu_Panel.add(panel);
	}
}
