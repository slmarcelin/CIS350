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

public class Frm_Hangman extends JFrame {

	private Cls_Hangman hangman;
	private JPanel contentPane;
	
	private JPanel enterPane;
	private JLabel enteredChars;
	private JTextField keyBox;
	private JButton submitKeyButton;
	
	private JPanel hangmanPane;
	private JLabel guessLabel;
	private JLabel man;

	/**
	 * Launch the application.
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
	 * Create the frame.
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
	
	private String printGuess(String guess) {
		int strLen = guess.length();
		String retVal = "";
		for(int i = 0; i < strLen; i++)
			retVal += guess.charAt(i) + " ";
		
		return retVal;
			
	}
	
	private void enterClicked() {
		hangman.isWithin(keyBox.getText());
		keyBox.setText("");
		guessLabel.setText(printGuess(hangman.getGuess()));
		drawMan(hangman.getIncorrect());
		
		if(hangman.getState() != 0) {
			hangmanPane.add(new JLabel(hangman.getWord()));
		}
	}

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
