package moviedb;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;

import info.movito.themoviedbapi.model.MovieDb;

public class MovieInfoFrame extends JFrame {
	MovieInfoFrame(MovieDb movie){
		setLayout(new BorderLayout());
		MovieInfoPanel mip = new MovieInfoPanel(movie);
		add(mip, BorderLayout.CENTER);
		setSize(new Dimension(1000, 666));
		setLocationRelativeTo(null);
		setVisible(true);
	}
}
