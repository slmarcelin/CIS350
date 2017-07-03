package movie_db;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Window.Type;
import javax.swing.JTextField;

import info.movito.themoviedbapi.model.MovieDb;
import info.movito.themoviedbapi.model.people.Person;

import javax.swing.JTextArea;
import javax.swing.JScrollPane;

public class Frm_SearchActors {

	private JFrame actors_search;
	private JTextField textField;
	
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
		actors_search.setTitle("Movie List");
		actors_search.getContentPane().setBackground(new Color(250, 235, 215));
		actors_search.setBounds(100, 100, 450, 300);
		actors_search.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		actors_search.getContentPane().setLayout(null);
		
		data = new Cls_MovieData();
		String dataFormat = "";
		
		for(Person pd : data.m_getSearchActors(str_SearchValue)) {
			dataFormat += pd.getName() + "\n   ";
			dataFormat += pd.getId() + "\n\n";
		}
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 410, 231);
		actors_search.getContentPane().add(scrollPane);
		
		JTextArea results = new JTextArea();
		scrollPane.setViewportView(results);
		results.setColumns(100);
		results.setTabSize(100);
		results.setRows(100);
		
		results.setText(dataFormat);
		
	}
}
