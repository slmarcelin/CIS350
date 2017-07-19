package movie_db;

import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;

import info.movito.themoviedbapi.model.Genre;
import info.movito.themoviedbapi.model.MovieDb;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ItemListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

/*Frm_GenreMovies class.*/
public class Frm_GenreMovies extends JFrame {

	/*movie_Genre JFrame variable.*/
	private JFrame movie_Genre;
	
	JScrollPane scrollPane;
	/*totalResults JPanel.*/
	private JPanel totalResults;
    /*Runnable refreshPage variable.*/
	private Runnable refreshPage;
    /*current page initialized to 1.*/
	private int page = 1;
	/*current Genre ID.*/
	private int genreID = 0;

	/**
	 * Launches the Genres frame properties.
	 */
	public void movieGenres() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frm_GenreMovies window = new Frm_GenreMovies();
					window.movie_Genre.setLocationRelativeTo(null);
					window.movie_Genre.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	

	/**
	 * Constructor call the initialize function.
	 */
	public Frm_GenreMovies() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		movie_Genre = new JFrame();
		movie_Genre.setTitle("Movie Genres");
		movie_Genre.getContentPane().setBackground(new Color(250, 235, 215));
		movie_Genre.setBounds(100, 100, 900, 600);
		movie_Genre.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		movie_Genre.getContentPane().setLayout(new BorderLayout());
		
		ImageIcon i = new ImageIcon(getClass().getResource("movies.png"));
		movie_Genre.setIconImage(i.getImage());
	
		totalResults = new JPanel();
		scrollPane = new JScrollPane();
		
		JComboBox<Genre> cmb_GenreComboBox = new JComboBox<Genre>();
		cmb_GenreComboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				Genre temp = (Genre)arg0.getItem();
				genreID = temp.getId();
				
				totalResults.removeAll();
				
				for(MovieDb md : Cls_MovieData.m_getMoviesByGenre(genreID, 0)) {					
					totalResults.add(new Pnl_ArtworkPanel(Cls_MovieData.m_getMoviePoster(md), new Pnl_MoviePanel(md)));
				}
				
				scrollPane.setViewportView(totalResults);
				totalResults.repaint();
			}
		});
		cmb_GenreComboBox.setBounds(10, 222, 410, 22);
		
		for(Genre g : Cls_MovieData.m_getGenres()) {
			cmb_GenreComboBox.addItem(g);
		}
		
		Genre temp = (Genre)cmb_GenreComboBox.getSelectedItem();
		
		totalResults.setLayout(new BoxLayout(totalResults, BoxLayout.Y_AXIS));
		totalResults.setBounds(100, 100, 450, 300);
		
		for(MovieDb md : Cls_MovieData.m_getMoviesByGenre(temp.getId(), 0)) {
			totalResults.add(new Pnl_ArtworkPanel(Cls_MovieData.m_getMoviePoster(md), new Pnl_MoviePanel(md)));
		}
		
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(100, 100, 450, 300);
		scrollPane.setViewportView(totalResults);
		movie_Genre.getContentPane().add(scrollPane);
		movie_Genre.add(cmb_GenreComboBox, BorderLayout.NORTH);
		
		Pnl_PrevNext pnlPage = new Pnl_PrevNext();
		movie_Genre.getContentPane().add(pnlPage, BorderLayout.SOUTH);
		
		totalResults.repaint();
		
	}
	
	/*
	 * Pnl_PrevNext class, sets up the status of 
	 * either previous and next buttons.
	 */
	private class Pnl_PrevNext extends Container {
		private JButton previous;
		private JButton next;
		
		public Pnl_PrevNext(){
			this.setLayout(new FlowLayout());
			this.setPreferredSize(new Dimension(200,50));
			
			previous = new JButton("Previous Page");
			previous.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {		
					page--;
					
					totalResults.removeAll();
					
					for(MovieDb md : Cls_MovieData.m_getMoviesByGenre(genreID, page)) {					
						totalResults.add(new Pnl_ArtworkPanel(Cls_MovieData.m_getMoviePoster(md), new Pnl_MoviePanel(md)));
					}
					setEnabledStatus();
					scrollPane.setViewportView(totalResults);
					totalResults.repaint();
				}
			});
			
			next = new JButton("Next Page");
			next.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					page++;
					
					totalResults.removeAll();
					
					for(MovieDb md : Cls_MovieData.m_getMoviesByGenre(genreID, page)) {					
						totalResults.add(new Pnl_ArtworkPanel(Cls_MovieData.m_getMoviePoster(md), new Pnl_MoviePanel(md)));
					}
					setEnabledStatus();
					scrollPane.setViewportView(totalResults);
					totalResults.repaint();
				}
			});

			setEnabledStatus();
			
			add(previous);
			add(next);
		}
		
		private void setEnabledStatus() {
			if(page <= 1){
				previous.setEnabled(false);
			}else{
				previous.setEnabled(true);
			}
			if(page >= 9){
				next.setEnabled(false);
			}
			else{
				next.setEnabled(true);
			}
		}
	}
}
