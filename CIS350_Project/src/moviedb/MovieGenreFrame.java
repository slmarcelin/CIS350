package moviedb;

import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;

import info.movito.themoviedbapi.model.Genre;
import info.movito.themoviedbapi.model.MovieDb;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.event.ItemListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;

import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

/**
 * Frm_GenreMovies class.
 **/
@SuppressWarnings("serial")
public class MovieGenreFrame extends JFrame {
    /**the scrollpane.*/
    private JScrollPane scrollPane;
    /**totalResults JPanel.*/
    private JPanel totalResults;
    /**Runnable refreshPage variable.*/
    private Runnable refreshPage;
    /**current page initialized to 1.*/
    private int page = 1;
    /**current Genre ID.*/
    private int genreID = 0;
    /**the panel to control the page number. */
    private PrevNextPanel pnlPage;

    /**
     * Launches the Genres frame properties.
     */
    public static void displayMovieGenreFrame() {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    MovieGenreFrame window = new MovieGenreFrame();
                    window.setLocationRelativeTo(null);
                    window.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }


    /**
     * Constructor call the initialize function.
     */
    public MovieGenreFrame() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        setTitle("Movie Genres");
        getContentPane().setBackground(new Color(250, 235, 215));
        setBounds(100, 100, 900, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new BorderLayout());

        ImageIcon i = new ImageIcon(getClass().getResource("movies.png"));
        setIconImage(i.getImage());

        totalResults = new JPanel();
        scrollPane = new JScrollPane();
        pnlPage = new PrevNextPanel();

        refreshPage = () -> {
            totalResults.removeAll();

            for (MovieDb md : MovieData.getMoviesByGenre(genreID, page)) {
                totalResults.add(new ArtworkPanel(
                        MovieData.getMoviePoster(md, "w92"),
                        		new MoviePanel(md)));
            }

            scrollPane.setViewportView(totalResults);
            totalResults.repaint();
        };
        
        JComboBox<Genre> genreComboBox = new JComboBox<Genre>();
        genreComboBox.addItemListener(new ItemListener() {
            public void itemStateChanged(final ItemEvent arg0) {
                Genre temp = (Genre) arg0.getItem();
                genreID = temp.getId();
                page = 1;
                pnlPage.setEnabledStatus();
                
                refresh();
            }
        });
        genreComboBox.setBounds(10, 222, 410, 22);

        for (Genre g : MovieData.getGenres()) {
            genreComboBox.addItem(g);
        }

        totalResults.setLayout(new BoxLayout(totalResults, BoxLayout.Y_AXIS));
        totalResults.setBounds(100, 100, 450, 300);

        scrollPane.setHorizontalScrollBarPolicy(
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setBounds(100, 100, 450, 300);
        scrollPane.setViewportView(totalResults);
        getContentPane().add(scrollPane);
        add(genreComboBox, BorderLayout.NORTH);

        getContentPane().add(pnlPage, BorderLayout.SOUTH);

        refresh();
    }

    /**
     * Refreshes the page using the given refresh runnable.
     */
    private void refresh() {
        refreshPage.run();
    }

    /**
     * Pnl_PrevNext class.
     * Sets up the status of either previous and next buttons.
     **/
    private class PrevNextPanel extends Container {
        /** The button to return to the previous page. **/
        private JButton previous;
        /** The button to move to the next page. **/
        private JButton next;

        /**
         * Creates a container with previous and next buttons.
         */
        PrevNextPanel() {
            this.setLayout(new FlowLayout());
            this.setPreferredSize(new Dimension(200, 50));

            previous = new JButton("Previous Page");
            previous.addActionListener(new ActionListener() {
                public void actionPerformed(final ActionEvent arg0) {
                    page--;
                    refresh();
                    setEnabledStatus();
                }
            });

            next = new JButton("Next Page");
            next.addActionListener(new ActionListener() {
                public void actionPerformed(final ActionEvent e) {
                    page++;
                    refresh();
                    setEnabledStatus();
                }
            });

            setEnabledStatus();

            add(previous);
            add(next);
        }

        /**
         * Enables and disables the previous and next buttons.
         */
        public void setEnabledStatus() {
            if (page <= 1) {
                previous.setEnabled(false);
            } else {
                previous.setEnabled(true);
            }
            if (page >= 9) {
                next.setEnabled(false);
            } else {
                next.setEnabled(true);
            }
        }
    }
}
