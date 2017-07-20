package moviedb;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

/**
 * Pnl_ArtworkPanel class.
 **/
public class ArtworkPanel extends JPanel {
    /**
     * Pn_ArtworkPanel construction.
     * @param i of type ImageIcon
     * @param component of type of Component
     */
    public ArtworkPanel(final ImageIcon i, final Component component) {
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(850, 150));

        JLabel poster = new JLabel(i);
        poster.setBorder(LineBorder.createBlackLineBorder());

        add(component, BorderLayout.CENTER);
        add(poster, BorderLayout.WEST);
    }
}
