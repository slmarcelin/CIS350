package movie_db;

import info.movito.themoviedbapi.model.MovieDb;
import info.movito.themoviedbapi.model.people.Person;
import info.movito.themoviedbapi.model.tv.TvSeries;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

public class Frm_DisplayResults extends JFrame{
	private JPanel totalResults;
	
	/**
	 * Creates a JFrame to display movies
	 * @param title the title of the JFrame
	 * @param movies the movies to display on the JFrame
	 */
	public static void displayMovies(String title, ArrayList<MovieDb> movies) {
		Frm_DisplayResults display = new Frm_DisplayResults(title);
		
		display.addMovies(movies);
		
		display.setLocationRelativeTo(null);
		display.setVisible(true);
	}

	/**
	 * Creates a JFrame to display TV series
	 * @param title the title of the JFrame
	 * @param tvseries the TV series to display on the JFrame
	 */
	public static void displayTvSeries(String title, ArrayList<TvSeries> tvseries) {
		Frm_DisplayResults display = new Frm_DisplayResults(title);
		
		display.addTvSeries(tvseries);
		
		display.setLocationRelativeTo(null);
		display.setVisible(true);
	}

	/**
	 * Creates a JFrame to display people
	 * @param title the title of the JFrame
	 * @param people the people to display on the JFrame
	 */
	public static void displayPeople(String title, ArrayList<Person> people) {
		Frm_DisplayResults display = new Frm_DisplayResults(title);
		
		display.addPeople(people);
		
		display.setLocationRelativeTo(null);
		display.setVisible(true);
	}
	
	/**
	 * Constructs up the basic form
	 * @param title the title of the JFrame
	 */
	private Frm_DisplayResults(String title) {
		setTitle(title);
		setBounds(100, 100, 900, 600);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(new BorderLayout());
		
		totalResults = new JPanel();
		totalResults.setLayout(new BoxLayout(totalResults, BoxLayout.Y_AXIS));

		JScrollPane scrollPane = new JScrollPane(totalResults);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		getContentPane().add(scrollPane);
	}

	/**
	 * Adds a list of movies to the frame
	 * @param movies the list of movies to add to the frame
	 */
	private void addMovies(ArrayList<MovieDb> movies) {
		for(MovieDb md : movies) {
			totalResults.add(new Pnl_ArtworkPanel(Cls_MovieData.m_getMoviePoster(md), new Pnl_MoviePanel(md)));
		}
	}

	/**
	 * Adds a list of TV series to the frame
	 * @param tvseries the list of TV series to add to the frame
	 */
	private void addTvSeries(ArrayList<TvSeries> tvseries) {
		for(TvSeries tv : tvseries) {
			totalResults.add(new Pnl_ArtworkPanel(Cls_MovieData.m_getTvPoster(tv), new Pnl_TvPanel(tv)));
		}
	}

	/**
	 * Adds a list of people to the frame
	 * @param people the list of people to add to the frame
	 */
	private void addPeople(ArrayList<Person> people) {
		for(Person person : people) {
			totalResults.add(new Pnl_ArtworkPanel(Cls_MovieData.m_getPersonProfile(person), new Pnl_PersonPanel(person)));
		}
	}
}
