package moviedb;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Simple hangman game with GUI.
 * Created by Rafael on 5/12/2015.
 */
public class HangmanView extends JFrame {
    /**
     * Creates a hangman window.
     */
    public static void play() {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    HangmanView window = new HangmanView();
                    window.setVisible(true);
                    window.setResizable(false);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    
    /** The label for displaying commands to the user. */
    private JLabel commandTitle = new JLabel("Type in a letter to guess");
    /** The label to display the part of the word guessed so far. */
    private JLabel knownWordLabel = new JLabel();
    /** The label to display wrong guesses. */
    private JLabel wrongGuesses = new JLabel();
    /** The textfield for entering guesses. */
    private JTextField wordTextField = new JTextField(20);
    /** The image of the hangman. */
    private BufferedImage hangmanImage =
            new BufferedImage(500, 500, BufferedImage.TYPE_INT_ARGB);
    /** The panel displaying the hangman. */
    private JPanel hangmanPanel;
    /** The panel for input. */
    private JPanel inputPanel;
    /** The word to guess. */
    private String wordToGuess = null;
    /** The current number of wrong guesses. */
    private int numOfWrongGuesses = 0;
    /** The string for the number of wrong guesses. */
    private String wrongGuessesString = "Wrong Guesses: ";
    /** The currently known portion of the string. */
    private String wordKnown = "";
    /** A button to create a new hangman game. */
    private final JButton btnNewGame = new JButton("New Game");
    /** Constraints for layout purposes. */
    private GridBagConstraints gridBagConstraints1;
    /** A label for messages. */
    private final JLabel label = new JLabel("   ");
    

    /**
     * Constructs a new hangman window.
     */
    public HangmanView() {
        getContentPane().setLayout(new BorderLayout());
        drawHangmanStand(hangmanImage);
        
        ImageIcon i = new ImageIcon(getClass().getResource("movies.png"));
        this.setIconImage(i.getImage());

        inputPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.insets = new Insets(0, 0, 5, 5);
        gridBagConstraints.gridx = 1;
        gridBagConstraints.ipadx = 1;
        gridBagConstraints.gridy = 1;
        inputPanel.add(commandTitle, gridBagConstraints);
        gridBagConstraints1 = new GridBagConstraints();
        gridBagConstraints1.insets = new Insets(0, 0, 5, 0);
        gridBagConstraints1.gridx = 2;
        gridBagConstraints1.gridy = 1;
        inputPanel.add(wordTextField, gridBagConstraints1);

        getContentPane().add(inputPanel);
        
        GridBagConstraints gbcNewGameBtn = new GridBagConstraints();
        gbcNewGameBtn.gridx = 2;
        gbcNewGameBtn.gridy = 9;
        btnNewGame.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent arg0) {
                reset();
            }
        });
        
        GridBagConstraints gbcLabel = new GridBagConstraints();
        gbcLabel.insets = new Insets(0, 0, 5, 0);
        gbcLabel.gridx = 2;
        gbcLabel.gridy = 8;
        inputPanel.add(label, gbcLabel);
        inputPanel.add(btnNewGame, gbcNewGameBtn);
        initialize();

        wordTextField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                //Initialize();

                if (wordToGuess.toLowerCase().indexOf(
                        wordTextField.getText().toLowerCase()) >= 0) {
                    guessRight();
                } else {
                    guessWrong();
                    wordTextField.setText("");
                }
                
                String displayWord = "";
                for (int i = 0; i < wordKnown.length(); i++) {
                    displayWord += "  " + wordKnown.charAt(i) + "  ";
                }
                
                knownWordLabel.setText(displayWord);
            }
        });

        setSize(1000, 600);
        setVisible(true);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        showChangedHangman();
        revalidate();
        setLocationRelativeTo(null);

    }
    
    /**
     * Sets up a new hangman game.
     */
    private void initialize() {
        if (wordToGuess == null) {
            HangmanGame h = new HangmanGame();
             wordToGuess = h.getWord();
            
            wordTextField.setText("");
            commandTitle.setText("Guess a letter");
            String displayWord = "";
            wordKnown = "";
            for (int i = 0; i < wordToGuess.length(); i++) {
                if (wordToGuess.charAt(i) != ' ') {
                    wordKnown += "_";
                    displayWord += "  __  ";
                } else {
                    wordKnown += " ";
                    displayWord += "      ";
                }
            }
            knownWordLabel.setText(displayWord);
            GridBagConstraints gridBagConstraints2 = new GridBagConstraints();
            gridBagConstraints2.gridx = 1;
            gridBagConstraints2.gridy = 2;
            gridBagConstraints2.gridwidth = 2;
            inputPanel.add(knownWordLabel, gridBagConstraints2);
            gridBagConstraints2 = new GridBagConstraints();
            gridBagConstraints2.gridx = 1;
            gridBagConstraints2.gridy = 3;
            gridBagConstraints2.gridwidth = 2;
            inputPanel.add(wrongGuesses, gridBagConstraints2);
        }
    }

    /**
     * Displays a win message.
     */
    private void guessRight() {
        String guess = wordTextField.getText().toLowerCase();
        addGuessToKnownWord(guess);
        String displayString = "";
        for (int i = 0; i < wordKnown.length(); i++) {
            displayString += wordKnown.substring(i, i + 1) + " ";
        }
        knownWordLabel.setText(displayString);

        if (wordKnown.indexOf("_") < 0) {
            JOptionPane.showMessageDialog(this, "You Win!");
            reset();
        }
        wordTextField.setText("");
    }

    /**
     * Reveals guessed letters in the word.
     * @param guess the string guessed
     */
    private void addGuessToKnownWord(final String guess) {
        ArrayList<Integer> indexes = new ArrayList<>();
        for (int index = wordToGuess.toLowerCase().indexOf(guess);
             index >= 0;
             index = wordToGuess.toLowerCase().indexOf(guess, index + 1)) {
            indexes.add(index);
        }
        for (int i = 0; i < indexes.size(); i++) {
            int index = indexes.get(i);
            StringBuilder stringBuilder = new StringBuilder(wordKnown);
            stringBuilder.replace(index,
                    index + guess.length(), guess.toUpperCase());
            wordKnown = stringBuilder.toString();
        }
    }

    /**
     * Updates for an incorrect guess.
     */
    private void guessWrong() {
        numOfWrongGuesses++;

        wrongGuessesString += wordTextField.getText() + ", ";
        wrongGuesses.setText(wrongGuessesString);
        Graphics2D g = (Graphics2D) hangmanImage.getGraphics();
        int x = 250, y = 200;
        g.setStroke(new BasicStroke(2));
        g.setColor(Color.BLACK);

        switch (numOfWrongGuesses) {
            case 1: // Head
                g.drawOval(-20 + x, y, 40, 40);
                break;
            case 2: // Body
                g.drawLine(x, y + 40, x, y + 40 + 80);
                break;
            case 3: // R Arm
                g.drawLine(x, y + 40 + 20, x + 20, y + 40 + 60);
                break;
            case 4: // L Arm
                g.drawLine(x, y + 40 + 20, x - 20, y + 40 + 60);
                break;
            case 5: // R Leg
                g.drawLine(x, y + 40 + 80, x + 20, y + 40 + 80 + 40);
                break;
            case 6: // L Leg
                g.drawLine(x, y + 40 + 80, x - 20, y + 40 + 80 + 40);
                JOptionPane.showMessageDialog(this,
                        "You Lose! The word was " + wordToGuess);
                reset();
                break;
            default:
                break;
        }
        g.dispose();
        showChangedHangman();
        revalidate();
    }

    /**
     * Updates the hangman drawing.
     */
    private void showChangedHangman() {
        if (hangmanPanel != null) {
            remove(hangmanPanel);
        }

        hangmanPanel = new JPanel();
        hangmanPanel.add(new JLabel(new ImageIcon(hangmanImage)));
        getContentPane().add(hangmanPanel, BorderLayout.WEST);
        revalidate();

    }
    
    /**
     * Resets the hangman game.
     */
    private void reset() {
        wordToGuess = null;
        numOfWrongGuesses = 0;
        wrongGuessesString = "Wrong Guesses: ";
        wrongGuesses.setText("");
        
        hangmanImage = new BufferedImage(500, 500, BufferedImage.TYPE_INT_ARGB);
        drawHangmanStand(hangmanImage);
        showChangedHangman();
        initialize();
    }

    /**
     * Draws the hangman stand.
     * @param image the image to draw
     */
    private static void drawHangmanStand(final BufferedImage image) {
        Graphics2D g = (Graphics2D) image.getGraphics();
        g.setStroke(new BasicStroke(2));
        g.setColor(Color.BLACK);

        g.drawLine(10, 475, 250, 475);
        g.drawLine(100, 475, 100, 100);
        g.drawLine(100, 100, 250, 100);
        g.drawLine(250, 100, 250, 200);

        g.dispose();
    }
}
