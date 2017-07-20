package moviedb;

import info.movito.themoviedbapi.model.tv.TvSeries;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 * A panel for displaying a TV series's information.
 * @author Zachary Ash
 *
 */
public class TvPanel extends JPanel {
    /**
     * Pn_TvPanel construction.
     * @param tv of type TvSeries
     */
    public TvPanel(final TvSeries tv) {
        setLayout((new BorderLayout()));
        setPreferredSize(new Dimension(700, 150));

        JLabel lblTitle = new JLabel(tv.getName());

        JPanel pnlFacts = new JPanel();
        pnlFacts.setLayout(new BoxLayout(pnlFacts, BoxLayout.Y_AXIS));
        pnlFacts.setPreferredSize(new Dimension(100, 130));

        JTextArea txtAired = new JTextArea(tv.getFirstAirDate());
        txtAired.setEditable(false);
        pnlFacts.add(txtAired);

        JTextArea txtOverview = new JTextArea(tv.getOverview());
        txtOverview.setWrapStyleWord(true);
        txtOverview.setLineWrap(true);
        txtOverview.setEditable(false);

        add(lblTitle, BorderLayout.NORTH);
        add(pnlFacts, BorderLayout.WEST);
        add(txtOverview, BorderLayout.CENTER);
    }
}
