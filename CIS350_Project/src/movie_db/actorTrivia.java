package movie_db;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JMenuBar;
import javax.swing.JSeparator;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;

public class actorTrivia {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;

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
		frame.setResizable(false);
		frame.setBounds(100, 100, 461, 328);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel btnNewButton = new JPanel();
		btnNewButton.setBackground(new Color(245, 222, 179));
		frame.getContentPane().add(btnNewButton, BorderLayout.CENTER);
		btnNewButton.setLayout(null);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(28, 28, 373, 2);
		btnNewButton.add(separator);
		
		JLabel lblNewLabel = new JLabel("Questions");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel.setBounds(172, 3, 74, 14);
		btnNewButton.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Brad Pitt plays General Glen McMahon ");
		lblNewLabel_1.setBounds(10, 41, 184, 14);
		btnNewButton.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel(" in which film directed by David Michod?");
		lblNewLabel_2.setBounds(10, 55, 188, 14);
		btnNewButton.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("which star plays Mitch Buchannon in");
		lblNewLabel_3.setBounds(10, 89, 172, 14);
		btnNewButton.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("the Baywatch movie released in 2017?");
		lblNewLabel_4.setBounds(10, 105, 184, 14);
		btnNewButton.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("the name of the character played by Hugh Jackman");
		lblNewLabel_5.setBounds(10, 137, 248, 14);
		btnNewButton.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("New label");
		lblNewLabel_6.setBounds(10, 205, 46, 14);
		btnNewButton.add(lblNewLabel_6);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textField.setBounds(225, 41, 176, 28);
		btnNewButton.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textField_1.setColumns(10);
		textField_1.setBounds(225, 86, 176, 28);
		btnNewButton.add(textField_1);
	}
}
