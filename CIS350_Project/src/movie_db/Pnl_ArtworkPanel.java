package movie_db;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class Pnl_ArtworkPanel extends JPanel {
	public Pnl_ArtworkPanel(ImageIcon i, Component component){
		setLayout(new BorderLayout());
		setPreferredSize(new Dimension(850,150));

		JLabel poster = new JLabel(i);
		poster.setBorder(LineBorder.createBlackLineBorder());
		
		add(component, BorderLayout.CENTER);
		add(poster, BorderLayout.WEST);
	}
}
