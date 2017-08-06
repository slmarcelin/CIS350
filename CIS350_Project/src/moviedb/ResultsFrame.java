package moviedb;

import info.movito.themoviedbapi.model.MovieDb;
import info.movito.themoviedbapi.model.people.Person;
import info.movito.themoviedbapi.model.tv.TvSeries;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import com.google.common.base.Function;

/**
 * Frm_DisplayResults class.
 **/
@SuppressWarnings("serial")
public class ResultsFrame extends JFrame {

    /**totalResults JPanel.*/
    private JPanel totalResults;
    /**Runnable refreshPage variable.*/
    private Runnable refreshPage;
    /**current page initialized to 1.*/
    private int page = 1;

    /***************************************************************************
      Creates a JFrame to display movies.
      @param title the title of the JFrame
      @param fetchMovies the movies to display on the JFrame
     **************************************************************************/
    public static void displayMovies(final String title,
            final Function<Integer, ArrayList<MovieDb>> fetchMovies) {
        ResultsFrame display = new ResultsFrame(title, (p) -> {
            try {
                ArrayList<MovieDb> movies = fetchMovies.apply(p);
                JPanel[] panels = new JPanel[movies.size()];
                for (int i = 0; i < movies.size(); i++) {
                    panels[i] = new ArtworkPanel(MovieData.getMoviePoster(
                            movies.get(i), "w92"), new MoviePanel(movies.get(i)));
                }
                return panels;
            } catch (Exception e) {
                return new JPanel[0];
            }
        });

        display.setLocationRelativeTo(null);
        display.setVisible(true);
    }

    /**
     * Creates a JFrame to display TV series.
     * @param title the title of the JFrame
     * @param fetchTvseries ArrayList
     */
    public static void displayTvSeries(final String title,
            final Function<Integer, ArrayList<TvSeries>> fetchTvseries) {
        ResultsFrame display = new ResultsFrame(title, (p) -> {
            try {
                ArrayList<TvSeries> tvseries = fetchTvseries.apply(p);
                JPanel[] panels = new JPanel[tvseries.size()];
                for (int i = 0; i < tvseries.size(); i++) {
                    panels[i] = new ArtworkPanel(MovieData.getTvPoster(
                            tvseries.get(i), "w92"), new TvPanel(tvseries.get(i)));
                }
                return panels;
            } catch (Exception e) {
                return new JPanel[0];
            }
        });

        display.setLocationRelativeTo(null);
        display.setVisible(true);
    }

    /**
     * Creates a JFrame to display people.
     * @param title the title of the JFrame
     * @param fetchPeople the people to display on the JFrame
     */
    public static void displayPeople(final String title,
            final Function<Integer, ArrayList<Person>> fetchPeople) {
        	ResultsFrame display = new ResultsFrame(title, (p) -> {
            try {
                ArrayList<Person> people = fetchPeople.apply(p);
                JPanel[] panels = new JPanel[people.size()];
                for (int i = 0; i < people.size(); i++) {
                    panels[i] = new ArtworkPanel(MovieData.getPersonProfile(
                            people.get(i), "w92"), new PersonPanel(people.get(i)));
                }
                return panels;
            } catch (Exception e) {
                return new JPanel[0];
            }
        });

        display.setLocationRelativeTo(null);
        display.setVisible(true);
    }

    /**
     * Constructs up the basic form.
     * @param title the title of the JFrame
     * @param fetchPanels a function that gets the panels corresponding to the
     *        current page of results
     */
    public ResultsFrame(final String title,
            final Function<Integer, JPanel[]> fetchPanels) {
        setTitle(title);
        setBounds(100, 100, 900, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new BorderLayout());

        ImageIcon i = new ImageIcon(getClass().getResource("movies.png"));
        this.setIconImage(i.getImage());

        totalResults = new JPanel();
        totalResults.setLayout(new BoxLayout(totalResults, BoxLayout.Y_AXIS));

        PrevNextPanel pnlPage = new PrevNextPanel();

        JScrollPane scrollPane = new JScrollPane(totalResults);
        scrollPane.setHorizontalScrollBarPolicy(
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        getContentPane().add(scrollPane, BorderLayout.CENTER);
        getContentPane().add(pnlPage, BorderLayout.SOUTH);

        refreshPage = () -> {
                totalResults.removeAll();
                for (JPanel panel : fetchPanels.apply(page)) {
                    totalResults.add(panel);
                }

                scrollPane.setViewportView(totalResults);
                totalResults.repaint();
            };

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
        private void setEnabledStatus() {
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
