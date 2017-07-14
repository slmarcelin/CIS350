package movie_db;

import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;

import info.movito.themoviedbapi.model.MovieDb;

import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.JScrollPane;

public class Frm_InTheaterMovies {

	private JFrame Movie_list;
	private JPanel totalResults;
	private Pnl_PrevNext pagePnl;

	private int page = 0;
	
	/**
	 * Launch the application.
	 */
	public static void movieList() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frm_InTheaterMovies window = new Frm_InTheaterMovies();
					window.Movie_list.setLocationRelativeTo(null);
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
	public Frm_InTheaterMovies() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Movie_list = new JFrame();
		Movie_list.setTitle("Movies In Theaters");
		Movie_list.getContentPane().setBackground(new Color(0, 204, 204));
		Movie_list.setBounds(100, 100, 450, 300);
		Movie_list.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		Movie_list.getContentPane().setLayout(new BorderLayout());
		
		totalResults = new JPanel();
		totalResults.setLayout(new BoxLayout(totalResults, BoxLayout.Y_AXIS));
		pagePnl = new Pnl_PrevNext();
		
		dataSetup();
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(100, 100, 450, 300);
		scrollPane.setViewportView(totalResults);
		Movie_list.getContentPane().add(scrollPane);
		Movie_list.getContentPane().add(pagePnl, BorderLayout.SOUTH);
		
		totalResults.repaint();
		
	}
	
	private void dataSetup() {
		totalResults.removeAll();
		
		for(MovieDb md : Cls_MovieData.m_getInTheaterMovies(page)) {
			String dataFormat = "";
			dataFormat = " Movie Title: " + md.getTitle() + "\n   Released Date: ";
			dataFormat += md.getReleaseDate() + "\n   Description: ";
			dataFormat += md.getOverview() + "\n\n";
			
			Pnl_ArtworkPanel a = new Pnl_ArtworkPanel("http://image.tmdb.org/t/p/w92/" + md.getPosterPath(), dataFormat);
			totalResults.add(a);
		}
		
		totalResults.repaint();
	}
	
	public class Pnl_PrevNext extends Container {
		private JButton previous;
		private JButton next;
		
		Pnl_PrevNext(){
			this.setLayout(new FlowLayout());
			this.setPreferredSize(new Dimension(200,50));
			
			previous = new JButton("Previous Page");
			previous.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {		
					page--;
					
					dataSetup();
					
					if(page == 0)
						previous.setEnabled(false);
					else
						previous.setEnabled(true);
					if(page == 9)
						next.setEnabled(false);
					else
						next.setEnabled(true);
				}
			});
			previous.setEnabled(false);
			
			next = new JButton("Next Page");
			next.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					page++;
					
					dataSetup();
					
					if(page == 0)
						previous.setEnabled(false);
					else
						previous.setEnabled(true);
					if(page == 9)
						next.setEnabled(false);
					else
						next.setEnabled(true);
				}
			});
			
			add(previous);
			add(next);
		}
	}
}
