
package moviedb;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.ActionEvent;

import javax.swing.JButton;

import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.Color;
import java.awt.Panel;
import java.awt.Dialog.ModalExclusionType;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JSeparator;

/**
 * Frm_MainFrame class.
 **/
@SuppressWarnings("serial")
public class MainFrame extends JFrame {
    /** The textfield to use for actor searches. **/
    private JTextField actorsTextField;
    /** The textfield to use for movie searches. **/
    private JTextField moviesTextField;
    /** The textfield to use for tv show searches. **/
    private JTextField showsTextField;
    /** The textfield to use for general searches. **/
    private JTextField multiTextField;
    /** The icon used to display images. */
    private JLabel imageLabel;
    /** The default icon image. */
    private ImageIcon movies;
    /** The main menu panel. */
    private JPanel menuPanel;

    /**
     * Launches the entire movie database application.
     * @param args the command line input
     */
    public static void main(final String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    MainFrame frame = new MainFrame();
                    frame.setVisible(true);
                    frame.setResizable(false);
                    frame.setLocationRelativeTo(null);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public MainFrame() {
        setResizable(false);
        setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
        setBackground(new Color(153, 204, 255));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 459, 353);

        ImageIcon i = new ImageIcon(getClass().getResource("movies.png"));
        this.setIconImage(i.getImage());

        buildMenu();

        menuPanel = new JPanel();
        menuPanel.setBackground(new Color(244, 164, 96));
        getContentPane().add(menuPanel, BorderLayout.CENTER);

        //this will display an image when user hovers over a choice
        Panel panel = new Panel();
        panel.setBounds(320, 70, 100, 95);
        menuPanel.add(panel);

        imageLabel = new JLabel(" ");
        imageLabel.setBounds(320, 70, 100, 95);
        movies = new ImageIcon(getClass().getResource("movies.png"));
        imageLabel.setIcon(movies);
        panel.add(imageLabel);

        menuPanel.setLayout(null);
        
        addLookupButtons();
        
        addSearchComponents();

        JLabel movieGames = new JLabel("Games");
        movieGames.setForeground(Color.BLACK);
        movieGames.setFont(new Font("Dialog", Font.BOLD, 15));
        movieGames.setBounds(8, 200, 81, 19);
        menuPanel.add(movieGames);

        JButton triviaBtn = new JButton("Trivia");
        triviaBtn.setForeground(Color.BLACK);
        triviaBtn.setBackground(new Color(135, 206, 235));
        triviaBtn.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent e) {
                TriviaFrame.play();
            }
        });
        triviaBtn.setBounds(92, 200, 100, 21);
        menuPanel.add(triviaBtn);    

        JSeparator separator = new JSeparator();
        separator.setBackground(new Color(178, 34, 34));
        separator.setForeground(new Color(244, 164, 96));
        separator.setBounds(-11, 231, 482, 2);
        menuPanel.add(separator);

        JButton movieHangman = new JButton("Hangman");
        movieHangman.setForeground(Color.BLACK);
        movieHangman.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent e) {
                new HangmanView();
            }
        });
        movieHangman.setBackground(new Color(135, 206, 235));
        movieHangman.setBounds(192, 200, 115, 21);
        menuPanel.add(movieHangman);
    }
    
    /**
     * Constructs the menu.
     */
    private void buildMenu() {
        JMenuBar menuBar = new JMenuBar();
        menuBar.setBackground(new Color(245, 222, 179));
        setJMenuBar(menuBar);
        
        JMenuItem mntmNewMenuItem1 =
                new JMenuItem("                      The Movie Database App");
        mntmNewMenuItem1.setForeground(new Color(0, 0, 0));
        mntmNewMenuItem1.setBackground(new Color(244, 164, 96));
        mntmNewMenuItem1.setFont(
                new Font("Times New Roman", Font.BOLD | Font.ITALIC, 21));
        menuBar.add(mntmNewMenuItem1);
    }
    
    /**
     * Adds the buttons for looking up various results.
     */
    private void addLookupButtons() {
        menuPanel.add(createMenuButton(3, 5, 105, 23, "In Theaters",
                new ImageIcon(getClass().getResource("now-in-theaters.jpg")),
                () -> {
                    ResultsFrame.displayMovies("Movies in Theaters",
                            MovieData::getInTheaterMovies);
                }));

        menuPanel.add(createMenuButton(225, 5, 121, 23, "New Movies",
                new ImageIcon(getClass().getResource("newMovies.png")),
                () -> {
                    ResultsFrame.displayMovies("New Movies",
                            MovieData::getNewMovies);
                }));

        menuPanel.add(createMenuButton(105, 5, 121, 23, "Popular Movies",
                new ImageIcon(getClass().getResource("popular.png")),
                () -> {
                    ResultsFrame.displayMovies("Popular Movies",
                            MovieData::getPopularMovies);
                }));

        menuPanel.add(createMenuButton(288, 33, 110, 23, "Top Rated TV",
                new ImageIcon(getClass().getResource("topTV.png")),
                () -> {
                    ResultsFrame.displayTvSeries("Top Rated TV Shows",
                            MovieData::getTvShowsTopRated);
                }));

        menuPanel.add(createMenuButton(72, 33, 97, 23, "TV On Air",
                new ImageIcon(getClass().getResource("onAir.jpg")),
                () -> {
                    ResultsFrame.displayTvSeries("TV Series on Air",
                            MovieData::getTvShowsOnAir);
                }));

        menuPanel.add(createMenuButton(160, 33, 132, 23, "Pop. TV Shows",
                new ImageIcon(getClass().getResource("popular_shows.jpg")),
                () -> {
                    ResultsFrame.displayTvSeries("Popular TV Shows",
                            MovieData::getTvShowsPopular);
                }));

        menuPanel.add(createMenuButton(345, 5, 89, 23, "Genres",
                new ImageIcon(getClass().getResource("genres.jpg")),
                () -> {
                    MovieGenreFrame.displayMovieGenreFrame();
                }));
    }
    
    /**
     * Adds the components needed for searching for results.
     */
    private void addSearchComponents() {
        actorsTextField = new JTextField();
        actorsTextField.setBounds(63, 71, 166, 20);
        actorsTextField.setColumns(20);
        menuPanel.add(actorsTextField);
        
        JLabel actorsLabel = new JLabel("Actors");
        actorsLabel.setForeground(Color.BLACK);
        actorsLabel.setBounds(3, 72, 64, 21);
        actorsLabel.setFont(new Font("Dialog", Font.BOLD, 15));
        menuPanel.add(actorsLabel);

        menuPanel.add(createMenuButton(228, 71, 79, 21, "Search",
                new ImageIcon(getClass().getResource("search.png")),
                () -> {
                    if (actorsTextField.getText().length() < 3) {
                        JOptionPane.showMessageDialog(null,
                                "You should at least enter 3 letters!!",
                                "ALERT", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    
                    ResultsFrame.displayPeople("Actor Search Results", (page) ->
                            MovieData.getSearchActors(
                            actorsTextField.getText(), page));
                }));
        
        moviesTextField = new JTextField();
        moviesTextField.setBounds(63, 105, 166, 20);
        menuPanel.add(moviesTextField);
        moviesTextField.setColumns(20);
        
        JLabel moviesLabel = new JLabel("Movies");
        moviesLabel.setForeground(Color.BLACK);
        moviesLabel.setBounds(3, 103, 64, 22);
        moviesLabel.setFont(new Font("Dialog", Font.BOLD, 15));
        menuPanel.add(moviesLabel);

        menuPanel.add(createMenuButton(228, 105, 79, 20, "Search",
                new ImageIcon(getClass().getResource("search.png")),
                () -> {
                    if (moviesTextField.getText().length() < 3) {
                        JOptionPane.showMessageDialog(null,
                                "You should at least enter 3 letters!!",
                                "ALERT", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    
                    ResultsFrame.displayMovies("Movie Search Results", (page) ->
                            MovieData.getSearchMovies(
                            moviesTextField.getText(), page));
                }));
        
        showsTextField = new JTextField();
        showsTextField.setBounds(63, 138, 166, 20);
        menuPanel.add(showsTextField);
        showsTextField.setColumns(20);
        
        JLabel showsLabel = new JLabel("Shows");
        showsLabel.setForeground(Color.BLACK);
        showsLabel.setBounds(3, 139, 64, 17);
        showsLabel.setFont(new Font("Dialog", Font.BOLD, 15));
        menuPanel.add(showsLabel);

        menuPanel.add(createMenuButton(228, 136, 80, 21, "Search",
                new ImageIcon(getClass().getResource("search.png")),
                () -> {
                    if (showsTextField.getText().length() < 3) {
                        JOptionPane.showMessageDialog(null,
                                "You should at least enter 3 letters!!",
                                "ALERT", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    ResultsFrame.displayTvSeries("TV Series Search Results",
                            (page) -> MovieData.getSearchTVShows(
                                    showsTextField.getText(), page));
                }));

        multiTextField = new JTextField();
        multiTextField.setBounds(63, 170, 166, 20);
        menuPanel.add(multiTextField);
        multiTextField.setColumns(20);
        
        JLabel multiLabel = new JLabel("All");
        multiLabel.setForeground(Color.BLACK);
        multiLabel.setBounds(3, 170, 64, 17);
        multiLabel.setFont(new Font("Dialog", Font.BOLD, 15));
        menuPanel.add(multiLabel);

        menuPanel.add(createMenuButton(228, 170, 80, 21, "Search",
                new ImageIcon(getClass().getResource("search.png")),
                () -> {
                    if (showsTextField.getText().length() < 3) {
                        JOptionPane.showMessageDialog(null,
                                "You should at least enter 3 letters!!",
                                "ALERT", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    ResultsFrame.displayMulti("Search Results",
                            (page) -> MovieData.getSearch(
                            		multiTextField.getText(), page));
                }));
    }
    
    /**
     * Creates a menu button.
     * @param x the button's x position
     * @param y the button's y position
     * @param w the button's width
     * @param h the button's height
     * @param btnText the text to display on the button
     * @param hoverImage the image to display when the button is hovered over
     * @param actionOnClick the action to perform when the button is clicked
     * @return the menu button
     **/
    private JButton createMenuButton(final int x, final int y, final int w,
            final int h, final String btnText, final ImageIcon hoverImage,
            final Runnable actionOnClick) {
        JButton menuButton = new JButton(btnText);
        menuButton.setFont(new Font("Tahoma", Font.BOLD, 11));
        menuButton.setForeground(new Color(0, 0, 0));
        menuButton.setBackground(new Color(153, 204, 255));
        menuButton.setBounds(x, y, w, h);
        menuButton.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent e) {
                actionOnClick.run();
            }
        });
        menuButton.addMouseListener(new MouseAdapter() {
            public void mouseEntered(final MouseEvent e) {
                imageLabel.setIcon(hoverImage);
            }
            public void mouseExited(final MouseEvent e) {
                imageLabel.setIcon(movies);
            }
        });
        
        return menuButton;
    }
}
