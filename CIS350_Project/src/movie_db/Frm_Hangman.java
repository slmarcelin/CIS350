package movie_db;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Simple hangman game with GUI
 * Created by Rafael on 5/12/2015.
 */
public class Frm_Hangman extends JFrame {
    public static void main(String[] args) {
        new Frm_Hangman();
    }

    private JLabel commandTitle = new JLabel("Type in a letter to guess"), knownWordLabel = new JLabel(), wrongGuesses = new JLabel();
    private JTextField wordTextField = new JTextField(20);
    private BufferedImage hangmanImage = new BufferedImage(500, 500, BufferedImage.TYPE_INT_ARGB);
    private JPanel hangmanPanel, inputPanel;
    private String wordToGuess = null;
    private int numOfWrongGuesses = 0;
    private String wrongGuessesString = "Wrong Guesses: ", wordKnown = "";
    private final JButton btnNewGame = new JButton("New Game");
    private GridBagConstraints gridBagConstraints_1;
    private final JLabel label = new JLabel("   ");
    

    public Frm_Hangman() {
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
        gridBagConstraints_1 = new GridBagConstraints();
        gridBagConstraints_1.insets = new Insets(0, 0, 5, 0);
        gridBagConstraints_1.gridx = 2;
        gridBagConstraints_1.gridy = 1;
        inputPanel.add(wordTextField, gridBagConstraints_1);

        getContentPane().add(inputPanel);
        
        GridBagConstraints gbc_btnNewGame = new GridBagConstraints();
        gbc_btnNewGame.gridx = 2;
        gbc_btnNewGame.gridy = 9;
        btnNewGame.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		reset();
        	}
        });
        
        GridBagConstraints gbc_label = new GridBagConstraints();
        gbc_label.insets = new Insets(0, 0, 5, 0);
        gbc_label.gridx = 2;
        gbc_label.gridy = 8;
        inputPanel.add(label, gbc_label);
        inputPanel.add(btnNewGame, gbc_btnNewGame);
        Initialize();

        wordTextField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Initialize();

                if (wordToGuess.toLowerCase().indexOf(wordTextField.getText().toLowerCase()) >= 0) {
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
    
    private void Initialize() {
		if (wordToGuess == null) {
			Cls_Hangman h = new Cls_Hangman();
         	wordToGuess = h.getWord();
        	
            wordTextField.setText("");
            commandTitle.setText("Guess a letter");
            String displayWord = "";
            wordKnown = "";
            for (int i = 0; i < wordToGuess.length(); i++) {
            	if(wordToGuess.charAt(i) != ' ') {
            		wordKnown += "_";
                	displayWord += "  __  ";
            	}
            	else
            	{
            		wordKnown += " ";
            		displayWord += "      ";
            	}
            }
            knownWordLabel.setText(displayWord);
            GridBagConstraints gridBagConstraints1 = new GridBagConstraints();
            gridBagConstraints1.gridx = 1;
            gridBagConstraints1.gridy = 2;
            gridBagConstraints1.gridwidth = 2;
            inputPanel.add(knownWordLabel, gridBagConstraints1);
            gridBagConstraints1 = new GridBagConstraints();
            gridBagConstraints1.gridx = 1;
            gridBagConstraints1.gridy = 3;
            gridBagConstraints1.gridwidth = 2;
            inputPanel.add(wrongGuesses, gridBagConstraints1);
        }
	}

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

    private void addGuessToKnownWord(String guess) {
        ArrayList<Integer> indexes = new ArrayList<>();
        for (int index = wordToGuess.toLowerCase().indexOf(guess);
             index >= 0;
             index = wordToGuess.toLowerCase().indexOf(guess, index + 1)) {
            indexes.add(index);
        }
        for (int i = 0; i < indexes.size(); i++) {
            int index = indexes.get(i);
            StringBuilder stringBuilder = new StringBuilder(wordKnown);
            stringBuilder.replace(index, index + guess.length(), guess.toUpperCase());
            wordKnown = stringBuilder.toString();
        }
    }

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
                JOptionPane.showMessageDialog(this, "You Lose! The word was " + wordToGuess);
                reset();
                break;
            default:
                break;
        }
        g.dispose();
        showChangedHangman();
        revalidate();
    }

    private void showChangedHangman() {
        if (hangmanPanel != null)
            remove(hangmanPanel);

        hangmanPanel = new JPanel();
        hangmanPanel.add(new JLabel(new ImageIcon(hangmanImage)));
        getContentPane().add(hangmanPanel, BorderLayout.WEST);
        revalidate();

    }
    
    private void reset() {
    	wordToGuess = null;
    	numOfWrongGuesses = 0;
    	wrongGuessesString = "Wrong Guesses: ";
    	wrongGuesses.setText("");
    	
    	hangmanImage = new BufferedImage(500, 500, BufferedImage.TYPE_INT_ARGB);
    	drawHangmanStand(hangmanImage);
    	showChangedHangman();
    	Initialize();
    }

    private static void drawHangmanStand(BufferedImage image) {
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