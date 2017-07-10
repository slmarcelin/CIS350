package movie_db;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;

public class Pnl_ArtworkPanel extends Container {
	private JLabel poster;
	private JTextArea results;
	
	Pnl_ArtworkPanel(String str_PosterLoc, String str_results){
		setLayout(new BorderLayout());
		setBounds(100, 100, 450, 300);

		BufferedImage img = null;
		try {
			img = ImageIO.read(new URL(str_PosterLoc));
		} catch (MalformedURLException e) {
			//Red image
			e.printStackTrace();
		} catch (IOException e) {
			//Red image
			e.printStackTrace();
		}
		ImageIcon i = new ImageIcon(img);
		poster = new JLabel(i);
		poster.setBorder(LineBorder.createBlackLineBorder());
		
		results = new JTextArea();
		
		results.setWrapStyleWord(true);
		results.setLineWrap(true);
		results.setColumns(100);
		results.setTabSize(100);
		results.setRows(100);
		results.setText(str_results);
		results.setEditable(false);
		results.setBounds(poster.getWidth(), 0, this.getWidth(), this.getHeight());
		results.setBorder(LineBorder.createBlackLineBorder());
		
		
		add(results, BorderLayout.CENTER);
		add(poster, BorderLayout.WEST);
	}
}
