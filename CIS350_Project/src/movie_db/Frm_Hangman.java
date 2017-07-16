package movie_db;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/*
 * Frm_Hangman class
 */
public class Frm_Hangman extends JFrame {

	/*Cls_Hangman variable*/
	private Cls_Hangman hangman;
	/*JPanel variable*/
	private JPanel contentPane;
	/*JPanel variable*/
	private JPanel enterPane;
	/*JLabel variable*/
	private JLabel enteredChars;
	/*JTextField variable*/
	private JTextField keyBox;
	/*JButton variable*/
	private JButton submitKeyButton;
	/*JPanel variable*/
	private JPanel hangmanPane;
	/*JLabel variable*/
	private JLabel guessLabel;
	/*JLabel variable*/
	private JLabel man;

	/**
	 * Launches the application.
	 */
	public void play() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frm_Hangman frame = new Frm_Hangman();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Creates the Hangman's game frame.
	 */
	public Frm_Hangman() {
		hangman = new Cls_Hangman();
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout());
		
		
		enterPane = new JPanel();
		enterPane.setLayout(new BoxLayout(enterPane, BoxLayout.Y_AXIS));
		
		enteredChars = new JLabel("");
		keyBox = new JTextField("");
		submitKeyButton = new JButton("Enter");
		submitKeyButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				enterClicked();
			}
		});
		
		enterPane.add(enteredChars);
		enterPane.add(keyBox);
		enterPane.add(submitKeyButton);
		
		hangmanPane = new JPanel();
		guessLabel = new JLabel(printGuess(hangman.getGuess()));
		man = new JLabel("");
		
		hangmanPane.setLayout(new BoxLayout(hangmanPane, BoxLayout.Y_AXIS));
		
		hangmanPane.add(guessLabel);
		hangmanPane.add(man);
		
		contentPane.add(hangmanPane, BorderLayout.CENTER);
		contentPane.add(enterPane, BorderLayout.EAST);
	}
	
	/*********************************************************************************
	  Finds and returns the poster image of the show.
	  @param guess the user's guess
	*********************************************************************************/
	private String printGuess(String guess) {
		int strLen = guess.length();
		String retVal = "";
		for(int i = 0; i < strLen; i++)
			retVal += guess.charAt(i) + " ";
		
		return retVal;
			
	}
	
	/*********************************************************************************
	  Formats the Hangman game display.
	*********************************************************************************/
	private void enterClicked() {
		hangman.isWithin(keyBox.getText());
		keyBox.setText("");
		guessLabel.setText(printGuess(hangman.getGuess()));
		drawMan(hangman.getIncorrect());
		
		if(hangman.getState() != 0) {
			hangmanPane.add(new JLabel(hangman.getWord()));
		}
	}
	/*********************************************************************************
	  Displays the man.
	  @param count of type int
	*********************************************************************************/
	private void drawMan(int count) {
		switch(count) {
			case 0:
				man.setText("<html></html>");
				break;
			case 1:
				man.setText("<html> O</html>");
				break;
			case 2:
				man.setText("<html> O<br>   |</html>");
				break;
			case 3:
				man.setText("<html> O<br>\\|</html>");
				break;
			case 4:
				man.setText("<html> O<br>\\|/</html>");
				break;
			case 5:
				man.setText("<html> O<br>\\|/<br>/</html>");
				break;
			case 6:
				man.setText("<html> O<br>\\|/<br>/ \\</html>");
				break;
		}
				
	}
}
