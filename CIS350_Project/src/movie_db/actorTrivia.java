package movie_db;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JSeparator;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JOptionPane;
public class actorTrivia extends JFrame {
   
	/*Declare JFrame.*/
	private JFrame frame;
	/*Question 1 TextField.*/
	private JTextField question1;
	/*Question 2 TextField.*/
	private JTextField question2;
	/*Question 3 TextField.*/
	private JTextField question3;
	/*Question 4 TextField.*/
	private JTextField question4;
	/*Question 5 TextField.*/
	private JTextField question5;

	/*********************************************************************************
	 * Launch the play application.
	 *********************************************************************************/
	public void play() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					actorTrivia window = new actorTrivia();
					window.frame.setVisible(true);
					frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
    /*********************************************************************************
     * Determine the user's points
     * @return: points the number of points earned by user
     **********************************************************************************/
    public int results()
    {
    	int points=0;
    	if(this.question1.getText().toLowerCase().equals("war machine")){
    		points++;
    	}
    	if(this.question2.getText().toLowerCase().equals("dwayne johnson")){
    		points++;
    	}
    	if(this.question3.getText().toLowerCase().equals("logan")){
    		points++;
    	}
    	if(this.question4.getText().toLowerCase().equals("dan stevens")){
    		points++;
    	}
    	if(this.question5.getText().toLowerCase().equals("johnny depp")){
    		points++;
    	}
    	return points;
    }
    
    /*********************************************************************************
	 * Initialize the application.
	 *********************************************************************************/
	public actorTrivia() {
		initialize();
	}

	/*********************************************************************************
	 * Initialize the contents of the frame.
	 *********************************************************************************/
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 479, 358);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		ImageIcon i = new ImageIcon(getClass().getResource("movies.png"));
		frame.setIconImage(i.getImage());
		
		JPanel actorTrivia = new JPanel();
		actorTrivia.setBackground(new Color(245, 222, 179));
		frame.getContentPane().add(actorTrivia, BorderLayout.CENTER);
		actorTrivia.setLayout(null);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(28, 28, 391, 2);
		actorTrivia.add(separator);
		
		JLabel lblNewLabel = new JLabel("questions");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel.setBounds(172, 3, 100, 30);
		actorTrivia.add(lblNewLabel);
		
		JLabel question1Lb1 = new JLabel("1- Brad Pitt plays General Glen McMahon ");
		question1Lb1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		question1Lb1.setBackground(new Color(255, 222, 173));
		question1Lb1.setForeground(new Color(178, 34, 34));
		question1Lb1.setBounds(10, 41, 224, 15);
		actorTrivia.add(question1Lb1);
		
		JLabel question1Lb2 = new JLabel(" in which film directed by David Michod?");
		question1Lb2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		question1Lb2.setForeground(new Color(178, 34, 34));
		question1Lb2.setBounds(10, 55, 218, 15);
		actorTrivia.add(question1Lb2);
		
		JLabel question2Lb1 = new JLabel("2- Which star plays Mitch Buchannon in");
		question2Lb1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		question2Lb1.setForeground(new Color(178, 34, 34));
		question2Lb1.setBounds(10, 89, 214, 15);
		actorTrivia.add(question2Lb1);
		
		JLabel question2Lb2 = new JLabel("the Baywatch movie released in 2017?");
		question2Lb2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		question2Lb2.setForeground(new Color(178, 34, 34));
		question2Lb2.setBounds(10, 105, 212, 15);
		actorTrivia.add(question2Lb2);
		
		JLabel question3Lb1 = new JLabel("3- The character played by Hugh Jackman in");                                           
		question3Lb1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		question3Lb1.setForeground(new Color(178, 34, 34));
		question3Lb1.setBounds(10, 137, 244, 15);
		actorTrivia.add(question3Lb1);
		
		JLabel question3Lb2 = new JLabel("nine of the ten X-Men movie franchise films?");
		question3Lb2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		question3Lb2.setForeground(new Color(178, 34, 34));
		question3Lb2.setBounds(10, 153, 243, 15);
		actorTrivia.add(question3Lb2);
		
		question1 = new JTextField();
		question1.setBackground(new Color(255, 228, 181));
		question1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		question1.setBounds(269, 41, 176, 28);
		actorTrivia.add(question1);
		question1.setColumns(10);
		
		question2 = new JTextField();
		question2.setBackground(new Color(255, 228, 181));
		question2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		question2.setColumns(10);
		question2.setBounds(269, 83, 176, 28);
		actorTrivia.add(question2);
		
		question3 = new JTextField();
		question3.setBackground(new Color(255, 228, 181));
		question3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		question3.setColumns(10);
		question3.setBounds(269, 131, 176, 28);
		actorTrivia.add(question3);
		
		JLabel question4Lb1 = new JLabel("4- He played 'Beast' in the film adapation of");
		question4Lb1.setForeground(new Color(178, 34, 34));
		question4Lb1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		question4Lb1.setBounds(10, 186, 224, 15);
		actorTrivia.add(question4Lb1);
		
		JLabel question4Lb2 = new JLabel(" the fairy tale 'Beauty and the Beast'?");
		question4Lb2.setForeground(new Color(178, 34, 34));
		question4Lb2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		question4Lb2.setBounds(10, 203, 208, 15);
		actorTrivia.add(question4Lb2);
		
		question4 = new JTextField();
		question4.setFont(new Font("Tahoma", Font.PLAIN, 12));
		question4.setColumns(10);
		question4.setBackground(new Color(255, 228, 181));
		question4.setBounds(269, 184, 176, 28);
		actorTrivia.add(question4);
		
		JLabel question5Lb1 = new JLabel("5- Who always plays captain Jack Sparrow?");
		question5Lb1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		question5Lb1.setForeground(new Color(178, 34, 34));
		question5Lb1.setBounds(10, 238, 235, 15);
		actorTrivia.add(question5Lb1);
		
		question5 = new JTextField();
		question5.setFont(new Font("Tahoma", Font.PLAIN, 12));
		question5.setColumns(10);
		question5.setBackground(new Color(255, 228, 181));
		question5.setBounds(269, 236, 176, 28);
		actorTrivia.add(question5);
		
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
				question1.setText(" ");
				question2.setText(" ");
				question3.setText(" ");
				question4.setText(" ");
				question5.setText(" ");
			}
		});
	}
}
