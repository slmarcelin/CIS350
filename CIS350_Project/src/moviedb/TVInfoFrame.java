package moviedb;
import info.movito.themoviedbapi.model.tv.TvSeries;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 * Frame of TV show info.
 */
@SuppressWarnings("serial")
public class TVInfoFrame extends JFrame {
	/**
	 * Constructs a TVInfoFrame window.
	 * @param tv the tv show to display
	 */
	TVInfoFrame(final TvSeries tv) {
		setLayout(new BorderLayout());
		TVInfoPanel tvip = new TVInfoPanel(); 
		
		SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                tvip.initAndShowGUI(tv);
            }
        });
		
		add(tvip, BorderLayout.CENTER);
		setSize(new Dimension(1250, 445));
		setLocationRelativeTo(null);
		setVisible(true);
	}
}
