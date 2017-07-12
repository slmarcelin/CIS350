package movie_db;

import java.awt.EventQueue;

import javax.swing.BoxLayout;
import javax.swing.JFrame;

import java.awt.BorderLayout;
import java.awt.Color;
import info.movito.themoviedbapi.model.people.Person;
import info.movito.themoviedbapi.model.tv.TvSeries;

import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
public class Frm_SearchActors {

	private JFrame actors_search;
	private JPanel totalResults;
	private Cls_MovieData data;
	private String str_SearchValue;

	/**
	 * Launch the application.
	 */
	public static void actorSearch(String str_SearchValue) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frm_SearchActors window = new Frm_SearchActors(str_SearchValue);
					window.actors_search.setLocationRelativeTo(null);
					window.actors_search.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Frm_SearchActors(String str_SearchValue) {
		   this.str_SearchValue = str_SearchValue;
		   
		   initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		actors_search = new JFrame();
		actors_search.setTitle("Your Actor Search results");
		actors_search.getContentPane().setBackground(new Color(250, 235, 215));
		actors_search.setBounds(100, 100, 450, 300);
		actors_search.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		actors_search.getContentPane().setLayout(new BorderLayout());
		
		totalResults = new JPanel();
		totalResults.setLayout(new BoxLayout(totalResults, BoxLayout.Y_AXIS));
		
		data = new Cls_MovieData();
		String dataFormat = "";
		
		for(Person pd : data.m_getSearchActors(str_SearchValue)) {
			dataFormat = "Actor's name: "+ pd.getName() + "\n";
			dataFormat += "Actor's Id Number: "+ pd.getId()+"\n\n";
			
			Pnl_ArtworkPanel a = new Pnl_ArtworkPanel("http://image.tmdb.org/t/p/w92/" + pd.getProfilePath(), dataFormat);
			totalResults.add(a);
		}
		
		actors_search.add(totalResults, BorderLayout.CENTER);
		
		totalResults.repaint();
		
	}
}
