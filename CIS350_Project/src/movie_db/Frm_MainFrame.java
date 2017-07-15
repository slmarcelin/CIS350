
package movie_db;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.ActionEvent;

import javax.swing.JButton;

import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.Color;
import java.awt.Panel;
import java.awt.Dialog.ModalExclusionType;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JSeparator;

public class Frm_MainFrame extends JFrame {
	//private final Action action = new SwingAction();
	//private final Action action_1 = new SwingAction_1();
	private JTextField actors_textField;
	private JTextField movies_textField;
	private JTextField shows_textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frm_MainFrame frame = new Frm_MainFrame();
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
	public Frm_MainFrame() {
		setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
		setBackground(new Color(153, 204, 255));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 459, 353);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(new Color(245, 222, 179));
		setJMenuBar(menuBar);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("                                     Menu");
		mntmNewMenuItem_1.setForeground(new Color(0, 0, 0));
		mntmNewMenuItem_1.setBackground(new Color(244, 164, 96));
		mntmNewMenuItem_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 21));
		menuBar.add(mntmNewMenuItem_1);
		
		JPanel Menu_Panel = new JPanel();
		Menu_Panel.setBackground(new Color(244, 164, 96));
		getContentPane().add(Menu_Panel, BorderLayout.CENTER);
		
		//this will display an image when user hovers over a choice
		Panel panel = new Panel();
		panel.setBounds(320, 70, 100, 95);
		Menu_Panel.add(panel);
		
		final JLabel imageLabel = new JLabel(" ");
		imageLabel.setBounds(320, 70, 100, 95);
		final ImageIcon movies=new ImageIcon(getClass().getResource("movies.png"));
		imageLabel.setIcon(movies);
		panel.add(imageLabel);

		
		JButton Theaters_button = new JButton("In theaters");
		Theaters_button.setFont(new Font("Tahoma", Font.BOLD, 11));
		Theaters_button.setForeground(new Color(0, 0, 0));
		Theaters_button.setBackground(new Color(153, 204, 255));
		Theaters_button.setBounds(3, 5, 105, 23);
		Theaters_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
	//			Frm_DisplayResults.displayMovies("Movies in Theaters", Cls_MovieData::m_getInTheaterMovies);
			}
		});
		Theaters_button.addMouseListener(new MouseAdapter()
        {
			public void mouseEntered(MouseEvent e)
            {
				ImageIcon theater=new ImageIcon(getClass().getResource("now-in-theaters.jpg"));
				imageLabel.setIcon(theater);
            }
			public void mouseExited(MouseEvent e)
			{
				imageLabel.setIcon(movies);
			}
	   });
		
		Menu_Panel.setLayout(null);
		Menu_Panel.add(Theaters_button);
		
		JButton newMovies_button = new JButton("New Movies");
		newMovies_button.setForeground(Color.BLACK);
		newMovies_button.setFont(new Font("Tahoma", Font.BOLD, 11));
		newMovies_button.setBackground(new Color(153, 204, 255));
		newMovies_button.setBounds(105, 5, 121, 23);
		newMovies_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		//		Frm_DisplayResults.displayMovies("New Movies", Cls_MovieData::m_getNewMovies);
			}
		});
		
		newMovies_button.addMouseListener(new MouseAdapter()
        {
			public void mouseEntered(MouseEvent e)
            {
				ImageIcon newMovie=new ImageIcon(getClass().getResource("newMovies.png"));
				imageLabel.setIcon(newMovie);
            }
			
			public void mouseExited(MouseEvent e)
			{
				imageLabel.setIcon(movies);
			}
	   });
		Menu_Panel.add(newMovies_button);
		
		JButton btnPopularMovies = new JButton("Popular Movies");
		btnPopularMovies.setForeground(Color.BLACK);
		btnPopularMovies.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnPopularMovies.setBackground(new Color(153, 204, 255));
		btnPopularMovies.setBounds(224, 5, 141, 23);
		Menu_Panel.add(btnPopularMovies);
		btnPopularMovies.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		//		Frm_DisplayResults.displayMovies("Popular Movies", Cls_MovieData::m_getPopularMovies);
			}
		});
		btnPopularMovies.addMouseListener(new MouseAdapter()
        {
			public void mouseEntered(MouseEvent e)
            {
				ImageIcon popular=new ImageIcon(getClass().getResource("popular.png"));
				imageLabel.setIcon(popular);
            }
			
			public void mouseExited(MouseEvent e)
			{
				imageLabel.setIcon(movies);
			}
	   });
		
		JButton btnTopRated = new JButton("Top rated ");
		btnTopRated.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnTopRated.setBackground(new Color(153, 204, 255));
		btnTopRated.setBounds(288, 33, 110, 23);
		Menu_Panel.add(btnTopRated);
		btnTopRated.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			//	Frm_DisplayResults.displayTvSeries("Top Rated TV Shows", Cls_MovieData::m_getTvShowsTopRated);
			}
		});
		btnTopRated.addMouseListener(new MouseAdapter()
        {
			public void mouseEntered(MouseEvent e)
            {
				ImageIcon top=new ImageIcon(getClass().getResource("topTV.png"));
				imageLabel.setIcon(top);
            }
			
			public void mouseExited(MouseEvent e)
			{
				imageLabel.setIcon(movies);
			}
	   });
		
		JButton tvShows_button = new JButton("On Air");
		tvShows_button.setForeground(Color.BLACK);
		tvShows_button.setFont(new Font("Tahoma", Font.BOLD, 11));
		tvShows_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			//	Frm_DisplayResults.displayTvSeries("TV Series on Air", Cls_MovieData::m_getTvShowsOnAir);
			}
		});
		tvShows_button.setBackground(new Color(153, 204, 255));
		tvShows_button.setBounds(72, 33, 97, 23);
		Menu_Panel.add(tvShows_button);
		tvShows_button.addMouseListener(new MouseAdapter()
        {
			public void mouseEntered(MouseEvent e)
            {
				ImageIcon onAir=new ImageIcon(getClass().getResource("onAir.jpg"));
				imageLabel.setIcon(onAir);
            }
			public void mouseExited(MouseEvent e)
			{
				imageLabel.setIcon(movies);
			}
	   });
		
		JButton newTvShows_button = new JButton("Pop. TV Shows");
		newTvShows_button.setForeground(Color.BLACK);
		newTvShows_button.setFont(new Font("Tahoma", Font.BOLD, 11));
		newTvShows_button.setBackground(new Color(153, 204, 255));
		newTvShows_button.setBounds(160, 33, 132, 23);
		Menu_Panel.add(newTvShows_button);
		newTvShows_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			//	Frm_DisplayResults.displayTvSeries("Popular TV Shows", Cls_MovieData::m_getTvShowsPopular);
			}
		});
		newTvShows_button.addMouseListener(new MouseAdapter()
        {
			public void mouseEntered(MouseEvent e)
            {
				ImageIcon popular_shows=new ImageIcon(getClass().getResource("popular_shows.jpg"));
				imageLabel.setIcon(popular_shows);
            }
			public void mouseExited(MouseEvent e)
			{
				imageLabel.setIcon(movies);
			}
	   });
		
		JButton btnGenres = new JButton("Genres");
		btnGenres.setForeground(Color.BLACK);
		btnGenres.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnGenres.setBackground(new Color(153, 204, 255));
		btnGenres.setBounds(358, 5, 89, 23);
		Menu_Panel.add(btnGenres);
		btnGenres.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Frm_GenreMovies genreList= new Frm_GenreMovies();
				genreList.movieGenres();
			}
		});
		btnGenres.addMouseListener(new MouseAdapter()
        {
			public void mouseEntered(MouseEvent e)
            {
				ImageIcon genres=new ImageIcon(getClass().getResource("genres.jpg"));
				imageLabel.setIcon(genres);
            }
			public void mouseExited(MouseEvent e)
			{
				imageLabel.setIcon(movies);
			}
	   });
		
		System.out.println();
		System.out.println();
		JButton actorsSearch = new JButton("Search");
		actorsSearch.setForeground(Color.BLACK);
		actorsSearch.setFont(new Font("Dialog", Font.BOLD, 11));
		actorsSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(actors_textField.getText().length() < 3) {
					JOptionPane.showMessageDialog(null,"You should at least enter 3 letters!!"
							,"ALERT", JOptionPane.ERROR_MESSAGE);
					return;
				}
				
			//	Frm_DisplayResults.displayPeople("Actor Search Results", (page) -> Cls_MovieData.m_getSearchActors(actors_textField.getText(), page));
			}
		});
		actorsSearch.setBackground(new Color(153, 204, 255));
		actorsSearch.setBounds(228, 71, 79, 21);
		Menu_Panel.add(actorsSearch);
		actors_textField = new JTextField();
		actors_textField.setBounds(63, 71, 166, 20);
		Menu_Panel.add(actors_textField);
		actors_textField.setColumns(20);
		
		JLabel actorsLabel = new JLabel("Actors");
		actorsLabel.setForeground(Color.BLACK);
		actorsLabel.setBounds(3, 72, 64, 21);
		actorsLabel.setFont(new Font("Dialog", Font.BOLD, 15));
		Menu_Panel.add(actorsLabel);
		
		movies_textField = new JTextField();
		movies_textField.setBounds(63, 105, 166, 20);
		Menu_Panel.add(movies_textField);
		movies_textField.setColumns(20);
		
		JLabel moviesLabel = new JLabel("Movies");
		moviesLabel.setForeground(Color.BLACK);
		moviesLabel.setBounds(3, 103, 64, 22);
		moviesLabel.setFont(new Font("Dialog", Font.BOLD, 15));
		Menu_Panel.add(moviesLabel);
		
		JButton moviesSearch = new JButton("Search");
		moviesSearch.setForeground(Color.BLACK);
		moviesSearch.setFont(new Font("Dialog", Font.BOLD, 11));
		moviesSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(movies_textField.getText().length() < 3) {
					JOptionPane.showMessageDialog(null,"You should at least enter 3 letters!!"
							,"ALERT", JOptionPane.ERROR_MESSAGE);
					return;
				}
				
			//	Frm_DisplayResults.displayMovies("Movie Search Results", (page) -> Cls_MovieData.m_getSearchMovies(movies_textField.getText(), page));
			}
		});
		moviesSearch.setBackground(new Color(153, 204, 255));
		moviesSearch.setBounds(228, 105, 79, 20);
		Menu_Panel.add(moviesSearch);
		
		shows_textField = new JTextField();
		shows_textField.setBounds(63, 138, 166, 20);
		Menu_Panel.add(shows_textField);
		shows_textField.setColumns(20);
		
		JLabel showsLabel = new JLabel("Shows");
		showsLabel.setBounds(3, 139, 64, 17);
		showsLabel.setFont(new Font("Dialog", Font.BOLD, 15));
		Menu_Panel.add(showsLabel);
		
		JButton showsSearch = new JButton("Search");
		showsSearch.setForeground(Color.BLACK);
		showsSearch.setFont(new Font("Dialog", Font.BOLD, 11));
		showsSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(shows_textField.getText().length() < 3) {
					JOptionPane.showMessageDialog(null,"You should at least enter 3 letters!!"
							,"ALERT", JOptionPane.ERROR_MESSAGE);
					return;
				}
				
	//			Frm_DisplayResults.displayTvSeries("TV Series Search Results", (page) -> Cls_MovieData.m_getSearchTVShows(shows_textField.getText(), page));
			}
		});
		showsSearch.setBackground(new Color(153, 204, 255));
		showsSearch.setBounds(228, 136, 80, 21);
		Menu_Panel.add(showsSearch);
		
		JLabel movie_Games = new JLabel("Games");
		movie_Games.setForeground(Color.BLACK);
		movie_Games.setFont(new Font("Dialog", Font.BOLD, 15));
		movie_Games.setBounds(8, 170, 81, 19);
		Menu_Panel.add(movie_Games);
		
		JButton TriviaBtn = new JButton("Trivia");
		TriviaBtn.setForeground(Color.BLACK);
		TriviaBtn.setBackground(new Color(135, 206, 235));
		TriviaBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actorTrivia playGame = new actorTrivia();
				playGame.play();
			}
		});
		TriviaBtn.setBounds(92, 171, 100, 21);
		Menu_Panel.add(TriviaBtn);	
		
		JSeparator separator = new JSeparator();
		separator.setBackground(new Color(178, 34, 34));
		separator.setForeground(new Color(244, 164, 96));
		separator.setBounds(-11, 201, 482, 2);
		Menu_Panel.add(separator);
		
		JButton movieHangman = new JButton("Hangman");
		movieHangman.setForeground(Color.BLACK);
		movieHangman.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Frm_Hangman playGame = new Frm_Hangman();
				playGame.play();
			}
		});
		movieHangman.setBackground(new Color(135, 206, 235));
		movieHangman.setBounds(192, 171, 115, 21);
		Menu_Panel.add(movieHangman);
	}
}
