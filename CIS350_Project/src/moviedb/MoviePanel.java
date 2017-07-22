package moviedb;

import info.movito.themoviedbapi.model.MovieDb;

import java.awt.Dimension;
import java.awt.BorderLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Pnl_MoviePanel class.
 **/
@SuppressWarnings("serial")
public class MoviePanel extends JPanel {
    /**
     * Pn_MoviePanel construction.
     * @param movie of type MovieDb
     */
    public MoviePanel(final MovieDb movie) {
        setLayout((new BorderLayout()));
        setPreferredSize(new Dimension(700, 150));

        JLabel lblTitle = new JLabel(movie.getTitle());

        JPanel pnlFacts = new JPanel();
        pnlFacts.setLayout(new BoxLayout(pnlFacts, BoxLayout.Y_AXIS));
        pnlFacts.setPreferredSize(new Dimension(100, 130));

        JTextArea txtRelease = new JTextArea(movie.getReleaseDate());
        txtRelease.setEditable(false);
        pnlFacts.add(txtRelease);

        JTextArea txtOverview = new JTextArea(movie.getOverview());
        txtOverview.setWrapStyleWord(true);
        txtOverview.setLineWrap(true);
        txtOverview.setEditable(false);
        
        JButton btnMoreInfo = new JButton("More Movie Info");
        btnMoreInfo.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		MovieInfoFrame mif = new MovieInfoFrame(movie);
        	}
        });

        add(lblTitle, BorderLayout.NORTH);
        add(pnlFacts, BorderLayout.WEST);
        add(txtOverview, BorderLayout.CENTER);
        add(btnMoreInfo, BorderLayout.SOUTH);
    }
}
