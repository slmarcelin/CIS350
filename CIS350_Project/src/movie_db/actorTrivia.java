package movie_db;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuBar;
import javax.swing.JSeparator;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JOptionPane;
public class actorTrivia {

	private JFrame frame;
	private JTextField Question1_textField;
	private JTextField Question2_textField;
	private JTextField Question3_textField;
	private JTextField Question4_textField;
	private JTextField Question5_textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					actorTrivia window = new actorTrivia();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

    public int results()
    {
    	int points=0;
    	if(this.Question1_textField.equals("War Machine"))
    		points++;
    	if(this.Question2_textField.equals("Dwayne Johnson"))
    		points++;
    	if(this.Question3_textField.equals("Logan"))
    		points++;
    	if(this.Question4_textField.equals("Dan Stevens"))
    		points++;
    	if(this.Question5_textField.equals("Gal Gadot"))
    		points++;	
    	
    	return points;
    }
	/**
	 * Create the application.
	 */
	public actorTrivia() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 479, 358);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel actorTrivia = new JPanel();
		actorTrivia.setBackground(new Color(245, 222, 179));
		frame.getContentPane().add(actorTrivia, BorderLayout.CENTER);
		actorTrivia.setLayout(null);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(28, 28, 391, 2);
		actorTrivia.add(separator);
		
		JLabel lblNewLabel = new JLabel("Questions");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel.setBounds(172, 3, 74, 14);
		actorTrivia.add(lblNewLabel);
		
		JLabel Question1Lb1 = new JLabel("1- Brad Pitt plays General Glen McMahon ");
		Question1Lb1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		Question1Lb1.setBackground(new Color(255, 222, 173));
		Question1Lb1.setForeground(new Color(178, 34, 34));
		Question1Lb1.setBounds(10, 41, 224, 15);
		actorTrivia.add(Question1Lb1);
		
		JLabel Question1Lb2 = new JLabel(" in which film directed by David Michod?");
		Question1Lb2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		Question1Lb2.setForeground(new Color(178, 34, 34));
		Question1Lb2.setBounds(10, 55, 218, 15);
		actorTrivia.add(Question1Lb2);
		
		JLabel Question2Lb1 = new JLabel("2- Which star plays Mitch Buchannon in");
		Question2Lb1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		Question2Lb1.setForeground(new Color(178, 34, 34));
		Question2Lb1.setBounds(10, 89, 214, 15);
		actorTrivia.add(Question2Lb1);
		
		JLabel Question2Lb2 = new JLabel("the Baywatch movie released in 2017?");
		Question2Lb2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		Question2Lb2.setForeground(new Color(178, 34, 34));
		Question2Lb2.setBounds(10, 105, 212, 15);
		actorTrivia.add(Question2Lb2);
		
		JLabel Question3Lb1 = new JLabel("3- The character played by Hugh Jackman in");
		Question3Lb1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		Question3Lb1.setForeground(new Color(178, 34, 34));
		Question3Lb1.setBounds(10, 137, 244, 15);
		actorTrivia.add(Question3Lb1);
		
		JLabel Question3Lb2 = new JLabel("nine of the ten X-Men movie franchise films?");
		Question3Lb2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		Question3Lb2.setForeground(new Color(178, 34, 34));
		Question3Lb2.setBounds(10, 153, 243, 15);
		actorTrivia.add(Question3Lb2);
		
		Question1_textField = new JTextField();
		Question1_textField.setBackground(new Color(255, 228, 181));
		Question1_textField.setFont(new Font("Tahoma", Font.PLAIN, 12));
		Question1_textField.setBounds(269, 41, 176, 28);
		actorTrivia.add(Question1_textField);
		Question1_textField.setColumns(10);
		
		Question2_textField = new JTextField();
		Question2_textField.setBackground(new Color(255, 228, 181));
		Question2_textField.setFont(new Font("Tahoma", Font.PLAIN, 12));
		Question2_textField.setColumns(10);
		Question2_textField.setBounds(269, 83, 176, 28);
		actorTrivia.add(Question2_textField);
		
		Question3_textField = new JTextField();
		Question3_textField.setBackground(new Color(255, 228, 181));
		Question3_textField.setFont(new Font("Tahoma", Font.PLAIN, 12));
		Question3_textField.setColumns(10);
		Question3_textField.setBounds(269, 131, 176, 28);
		actorTrivia.add(Question3_textField);
		
		JLabel Question4Lb1 = new JLabel("He played 'Beast' in the film adapation of");
		Question4Lb1.setForeground(new Color(178, 34, 34));
		Question4Lb1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		Question4Lb1.setBounds(10, 186, 224, 15);
		actorTrivia.add(Question4Lb1);
		
		JLabel Question4Lb2 = new JLabel(" the fairy tale 'Beauty and the Beast'?");
		Question4Lb2.setForeground(new Color(178, 34, 34));
		Question4Lb2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		Question4Lb2.setBounds(10, 203, 208, 15);
		actorTrivia.add(Question4Lb2);
		
		Question4_textField = new JTextField();
		Question4_textField.setFont(new Font("Tahoma", Font.PLAIN, 12));
		Question4_textField.setColumns(10);
		Question4_textField.setBackground(new Color(255, 228, 181));
		Question4_textField.setBounds(269, 184, 176, 28);
		actorTrivia.add(Question4_textField);
		
		JLabel Question5Lb1 = new JLabel("Who always plays captain Jack Sparrow?");
		Question5Lb1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		Question5Lb1.setForeground(new Color(178, 34, 34));
		Question5Lb1.setBounds(10, 238, 220, 15);
		actorTrivia.add(Question5Lb1);
		
		Question5_textField = new JTextField();
		Question5_textField.setFont(new Font("Tahoma", Font.PLAIN, 12));
		Question5_textField.setColumns(10);
		Question5_textField.setBackground(new Color(255, 228, 181));
		Question5_textField.setBounds(269, 236, 176, 28);
		actorTrivia.add(Question5_textField);
		
		JButton submitBtn = new JButton("Submit");
		submitBtn.setFont(new Font("Tahoma", Font.BOLD, 12));
		submitBtn.setBackground(new Color(233, 150, 122));
		submitBtn.setBounds(151, 280, 116, 28);
		actorTrivia.add(submitBtn);
		submitBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int results=results();
				JOptionPane.showMessageDialog(frame,"You have scored "+
			       results+" points"
						,"The results", JOptionPane.INFORMATION_MESSAGE);
				Question1_textField.setText(" ");
				Question2_textField.setText(" ");
				Question3_textField.setText(" ");
				Question4_textField.setText(" ");
				Question5_textField.setText(" ");
			}
		});
	}
}
