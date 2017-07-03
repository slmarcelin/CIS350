
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
import java.awt.Dialog.ModalExclusionType;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
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
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("                                     Menu");
		mntmNewMenuItem_1.setForeground(new Color(0, 0, 0));
		mntmNewMenuItem_1.setBackground(new Color(0, 204, 204));
		mntmNewMenuItem_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 21));
		menuBar.add(mntmNewMenuItem_1);
		
		JPanel Menu_Panel = new JPanel();
		Menu_Panel.setBackground(new Color(0, 204, 204));
		getContentPane().add(Menu_Panel, BorderLayout.CENTER);
		
		//this will display an image when user hovers over a choice
		Panel panel = new Panel();
		panel.setBounds(320, 70, 100, 95);
		Menu_Panel.add(panel);
		
		JLabel imageLabel = new JLabel(" ");
		imageLabel.setBounds(320, 70, 100, 95);
		ImageIcon movies=new ImageIcon(getClass().getResource("movies.png"));
		imageLabel.setIcon(movies);
		panel.add(imageLabel);

		
		JButton Theaters_button = new JButton("In theaters");
		Theaters_button.setForeground(new Color(0, 0, 0));
		Theaters_button.setBackground(new Color(153, 204, 255));
		Theaters_button.setBounds(8, 5, 97, 23);
		Theaters_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Frm_InTheaterMovies listMovies= new Frm_InTheaterMovies();
				listMovies.movieList();
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
		newMovies_button.setBackground(new Color(153, 204, 255));
		newMovies_button.setBounds(105, 5, 110, 23);
		newMovies_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Frm_NewMovies newMovie= new Frm_NewMovies();
				newMovie.movies_new();
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
		btnPopularMovies.setBackground(new Color(153, 204, 255));
		btnPopularMovies.setBounds(215, 5, 121, 23);
		Menu_Panel.add(btnPopularMovies);
		btnPopularMovies.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Frm_PopularMovies popularMovie= new Frm_PopularMovies();
				popularMovie.popular();
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
		btnTopRated.setBackground(new Color(153, 204, 255));
		btnTopRated.setBounds(281, 33, 110, 23);
		Menu_Panel.add(btnTopRated);
		btnTopRated.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Frm_topShow topShows= new Frm_topShow();
				topShows.topTV();
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
		tvShows_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Frm_OnAir onAir = new Frm_OnAir();
				onAir.onAirShows();
			}
		});
		tvShows_button.setBackground(new Color(153, 204, 255));
		tvShows_button.setBounds(63, 33, 97, 23);
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
		newTvShows_button.setBackground(new Color(153, 204, 255));
		newTvShows_button.setBounds(160, 33, 121, 23);
		Menu_Panel.add(newTvShows_button);
		newTvShows_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Frm_popularShows popShows= new Frm_popularShows();
				popShows.popTV();
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
		btnGenres.setBackground(new Color(153, 204, 255));
		btnGenres.setBounds(336, 5, 89, 23);
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
		actorsSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Frm_SearchActors searchActors = new Frm_SearchActors(actors_textField.getText());
				searchActors.actorSearch(actors_textField.getText());
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
		actorsLabel.setBounds(3, 72, 50, 21);
		actorsLabel.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		Menu_Panel.add(actorsLabel);
		
		movies_textField = new JTextField();
		movies_textField.setBounds(63, 105, 166, 20);
		Menu_Panel.add(movies_textField);
		movies_textField.setColumns(20);
		
		JLabel moviesLabel = new JLabel("Movies");
		moviesLabel.setBounds(3, 103, 50, 22);
		moviesLabel.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		Menu_Panel.add(moviesLabel);
		
		JButton moviesSearch = new JButton("Search");
		moviesSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Frm_SearchMovies searchMovies = new Frm_SearchMovies(movies_textField.getText());
				searchMovies.movieSearch(movies_textField.getText());
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
		showsLabel.setBounds(3, 139, 44, 17);
		showsLabel.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		Menu_Panel.add(showsLabel);
		
		JButton showsSearch = new JButton("Search");
		showsSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Frm_SearchTVShows searchShows = new Frm_SearchTVShows(shows_textField.getText());
				searchShows.tvSearch(shows_textField.getText());
			}
		});
		showsSearch.setBackground(new Color(153, 204, 255));
		showsSearch.setBounds(228, 136, 80, 21);
		Menu_Panel.add(showsSearch);
		
		
		
	}
}
