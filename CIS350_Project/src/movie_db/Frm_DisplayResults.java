package movie_db;

import info.movito.themoviedbapi.model.MovieDb;
import info.movito.themoviedbapi.model.people.Person;
import info.movito.themoviedbapi.model.tv.TvSeries;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import com.google.common.base.Function;

/*
 * Frm_DisplayResults class.
 */
public class Frm_DisplayResults extends JFrame{
	
	/*totalResults JPanel.*/
	private JPanel totalResults;
    /*Runnable refreshPage variable.*/
	private Runnable refreshPage;
    /*current page initialized to 1.*/
	private int page = 1;
	
	/*********************************************************************************
	  Creates a JFrame to display movies.
	  @param title the title of the JFrame
	  @param fetch_movies the movies to display on the JFrame
	 *********************************************************************************/
	public static void displayMovies(String title, Function<Integer, ArrayList<MovieDb>> fetch_movies) {
		Frm_DisplayResults display = new Frm_DisplayResults(title, (p) -> {
			try {
				ArrayList<MovieDb> movies = fetch_movies.apply(p);
				JPanel panels[] = new JPanel[movies.size()];
				for(int i = 0; i < movies.size(); i++) {
					panels[i] = new Pnl_ArtworkPanel(Cls_MovieData.m_getMoviePoster(movies.get(i)), new Pnl_MoviePanel(movies.get(i)));
				}
				return panels;
			} catch (Exception e) {
				return new JPanel[0];
			}
		});

		display.setLocationRelativeTo(null);
		display.setVisible(true);
	}

	/**
	 * Creates a JFrame to display TV series
	 * @param title the title of the JFrame
	 * @param fetch_tvseries ArrayList
	 */
	public static void displayTvSeries(String title, Function<Integer, ArrayList<TvSeries>> fetch_tvseries) {
		Frm_DisplayResults display = new Frm_DisplayResults(title, (p) -> {
			try {
				ArrayList<TvSeries> tvseries = fetch_tvseries.apply(p);
				JPanel panels[] = new JPanel[tvseries.size()];
				for(int i = 0; i < tvseries.size(); i++) {
					panels[i] = new Pnl_ArtworkPanel(Cls_MovieData.m_getTvPoster(tvseries.get(i)), new Pnl_TvPanel(tvseries.get(i)));
				}
				return panels;
			} catch (Exception e) {
				return new JPanel[0];
			}
		});
		
		display.setLocationRelativeTo(null);
		display.setVisible(true);
	}

	/**
	 * Creates a JFrame to display people
	 * @param title the title of the JFrame
	 * @param fetch_people the people to display on the JFrame
	 */
	public static void displayPeople(String title, Function<Integer, ArrayList<Person>> fetch_people) {
		Frm_DisplayResults display = new Frm_DisplayResults(title, (p) -> {
			try {
				ArrayList<Person> people = fetch_people.apply(p);
				JPanel panels[] = new JPanel[people.size()];
				for(int i = 0; i < people.size(); i++) {
					panels[i] = new Pnl_ArtworkPanel(Cls_MovieData.m_getPersonProfile(people.get(i)), new Pnl_PersonPanel(people.get(i)));
				}
				return panels;
			} catch (Exception e) {
				return new JPanel[0];
			}
		});
		
		display.setLocationRelativeTo(null);
		display.setVisible(true);
	}
	
	/**
	 * Constructs up the basic form.
	 * @param title the title of the JFrame
	 * @param fetch_panels a function that gets the panels corresponding to the current page of results
	 */
	private Frm_DisplayResults(String title, Function<Integer, JPanel[]> fetch_panels) {
		setTitle(title);
		setBounds(100, 100, 900, 600);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(new BorderLayout());
				
		totalResults = new JPanel();
		totalResults.setLayout(new BoxLayout(totalResults, BoxLayout.Y_AXIS));

		Pnl_PrevNext pnlPage = new Pnl_PrevNext();

		JScrollPane scrollPane = new JScrollPane(totalResults);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		getContentPane().add(scrollPane, BorderLayout.CENTER);
		getContentPane().add(pnlPage, BorderLayout.SOUTH);
		
		refreshPage = () -> {
				totalResults.removeAll();
				
				try {
					for(JPanel panel : fetch_panels.apply(page)) {
						totalResults.add(panel);
					}

					scrollPane.setViewportView(totalResults);
					totalResults.repaint();
				} catch (Exception e) {
					//TODO: some sort of error / empty output
				}
			};
			
		refresh();
	}
	
	/**
	 * Refreshes the page using the given refresh runnable.
	 */
	private void refresh() {
		refreshPage.run();
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
					refresh();
					setEnabledStatus();
				}
			});
			
			next = new JButton("Next Page");
			next.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					page++;
					refresh();
					setEnabledStatus();
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
