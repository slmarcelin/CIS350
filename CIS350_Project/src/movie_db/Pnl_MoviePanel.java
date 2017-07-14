package movie_db;

import info.movito.themoviedbapi.model.MovieDb;

import java.awt.Dimension;
import java.awt.BorderLayout;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Pnl_MoviePanel extends JPanel {
		
	public Pnl_MoviePanel(MovieDb movie) {
		setLayout((new BorderLayout()));
		setPreferredSize(new Dimension(700, 150));

		JLabel lblTitle = new JLabel(movie.getTitle());
		
		JPanel pnlFacts = new JPanel();
		pnlFacts.setLayout(new BoxLayout(pnlFacts, BoxLayout.Y_AXIS));
		pnlFacts.setPreferredSize(new Dimension(100, 130));
		
		JTextArea txtRelease = new JTextArea(movie.getReleaseDate());
		JTextArea txtCost = new JTextArea("$" + movie.getBudget());
		pnlFacts.add(txtRelease);
		pnlFacts.add(txtCost);
		
		JTextArea txtOverview = new JTextArea(movie.getOverview());
		txtOverview.setWrapStyleWord(true);
		txtOverview.setLineWrap(true);
		
		add(lblTitle, BorderLayout.NORTH);
		add(pnlFacts, BorderLayout.WEST);
		add(txtOverview, BorderLayout.CENTER);
	}
}
