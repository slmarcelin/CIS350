package moviedb;

import java.awt.Dimension;
import java.awt.GridBagConstraints;

import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import info.movito.themoviedbapi.model.MovieDb;

import java.awt.GridBagLayout;

public class MovieInfoPanel extends JPanel {
	public MovieInfoPanel(MovieDb movie) {
		setPreferredSize(new Dimension(1000, 666));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.rowWeights = new double[]{0.0, 1.0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0};
		this.setLayout(gridBagLayout);
		
		WebBrowserPanel wbp = new WebBrowserPanel();
		SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                wbp.initAndShowGUI(movie);
            }
        });
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 1;
		c.gridy = 1;
		c.gridwidth = 10;
		c.gridheight = 10;
		add(wbp, c);
		
		
		
	}

}
