package moviedb;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextArea;

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
import java.util.Random;
/**
 * The window for displaying a trivia quiz.
 */
@SuppressWarnings("serial")
public class TriviaFrame extends JFrame {
    /** The quiz being taken. */
    private TriviaQuiz quiz;
    /** Question 1 TextField. */
    private JTextField question1;
    /** Question 2 TextField. */
    private JTextField question2;
    /** Question 3 TextField. */
    private JTextField question3;
    /** Question 4 TextField. */
    private JTextField question4;
    /** Question 5 TextField. */
    private JTextField question5;

    /***************************************************************************
     * Launch the play application.
     **************************************************************************/
    public static void play() {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    TriviaFrame window = new TriviaFrame();
                    window.setVisible(true);
                    window.setResizable(false);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    /***************************************************************************
     * Determine the user's points.
     * @return points the number of points earned by user
     **************************************************************************/
    public int results() {
        int points = 0;
        if (quiz.getQuestion(0).checkAnswer(this.question1.getText())) {
            points++;
        }
        if (quiz.getQuestion(1).checkAnswer(this.question2.getText())) {
            points++;
        }
        if (quiz.getQuestion(2).checkAnswer(this.question3.getText())) {
            points++;
        }
        if (quiz.getQuestion(3).checkAnswer(this.question4.getText())) {
            points++;
        }
        if (quiz.getQuestion(4).checkAnswer(this.question5.getText())) {
            points++;
        }
        return points;
    }
    
    /***************************************************************************
     * Initialize the application.
     **************************************************************************/
    public TriviaFrame() {
        quiz = new TriviaQuiz(12);
        initialize();
    }

    /***************************************************************************
     * Initialize the contents of the frame.
     **************************************************************************/
    private void initialize() {
        setBounds(100, 100, 479, 358);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        ImageIcon i = new ImageIcon(getClass().getResource("movies.png"));
        setIconImage(i.getImage());
        
        JPanel actorTrivia = new JPanel();
        actorTrivia.setBackground(new Color(245, 222, 179));
        getContentPane().add(actorTrivia, BorderLayout.CENTER);
        actorTrivia.setLayout(null);
        
        JSeparator separator = new JSeparator();
        separator.setBounds(28, 28, 391, 2);
        actorTrivia.add(separator);
        
        JLabel lblNewLabel = new JLabel("Questions");
        lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 17));
        lblNewLabel.setBounds(172, 3, 100, 30);
        actorTrivia.add(lblNewLabel);
        
        JTextArea question1Lb1 = new JTextArea("1- "
                + quiz.getQuestion(0).getQuestion());
        question1Lb1.setWrapStyleWord(true);
        question1Lb1.setFont(new Font("Tahoma", Font.PLAIN, 12));
        question1Lb1.setBackground(new Color(245, 222, 179));
        question1Lb1.setForeground(new Color(178, 34, 34));
        question1Lb1.setBounds(10, 41, 250, 30);
        question1Lb1.setLineWrap(true);
        question1Lb1.setEditable(false);
        actorTrivia.add(question1Lb1);
        
        JTextArea question2Lb1 = new JTextArea("2- "
                + quiz.getQuestion(1).getQuestion());
        question2Lb1.setWrapStyleWord(true);
        question2Lb1.setFont(new Font("Tahoma", Font.PLAIN, 12));
        question2Lb1.setBackground(new Color(245, 222, 179));
        question2Lb1.setForeground(new Color(178, 34, 34));
        question2Lb1.setBounds(10, 82, 250, 30);
        question2Lb1.setLineWrap(true);
        question2Lb1.setEditable(false);
        actorTrivia.add(question2Lb1);
        
        JTextArea question3Lb1 = new JTextArea("3- "
                + quiz.getQuestion(2).getQuestion());
        question3Lb1.setWrapStyleWord(true);
        question3Lb1.setFont(new Font("Tahoma", Font.PLAIN, 12));
        question3Lb1.setBackground(new Color(245, 222, 179));
        question3Lb1.setForeground(new Color(178, 34, 34));
        question3Lb1.setBounds(10, 136, 244, 30);
        question3Lb1.setLineWrap(true);
        question3Lb1.setEditable(false);
        actorTrivia.add(question3Lb1);
        
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
        
        JTextArea question4Lb1 = new JTextArea("4- "
                + quiz.getQuestion(3).getQuestion());
        question4Lb1.setWrapStyleWord(true);
        question4Lb1.setBackground(new Color(245, 222, 179));
        question4Lb1.setForeground(new Color(178, 34, 34));
        question4Lb1.setFont(new Font("Tahoma", Font.PLAIN, 12));
        question4Lb1.setBounds(10, 178, 250, 32);
        question4Lb1.setLineWrap(true);
        question4Lb1.setEditable(false);
        actorTrivia.add(question4Lb1);
        
        question4 = new JTextField();
        question4.setFont(new Font("Tahoma", Font.PLAIN, 12));
        question4.setColumns(10);
        question4.setBackground(new Color(255, 228, 181));
        question4.setBounds(269, 184, 176, 28);
        actorTrivia.add(question4);
        
        JTextArea question5Lb1 = new JTextArea("5- "
                + quiz.getQuestion(4).getQuestion());
        question5Lb1.setWrapStyleWord(true);
        question5Lb1.setFont(new Font("Tahoma", Font.PLAIN, 12));
        question5Lb1.setBackground(new Color(245, 222, 179));
        question5Lb1.setForeground(new Color(178, 34, 34));
        question5Lb1.setBounds(10, 238, 250, 30);
        question5Lb1.setLineWrap(true);
        question5Lb1.setEditable(false);
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
            public void actionPerformed(final ActionEvent e) {
                int results = results();
                JOptionPane.showMessageDialog(null, "You have scored "
                   + results + " points\n"
                   +"       Answers\n"+ "1-"+ quiz.getQuestion(0).getAnswer()
                   +"\n2-" + quiz.getQuestion(1).getAnswer()
                   +"\n3-" + quiz.getQuestion(2).getAnswer()
                   +"\n4-" + quiz.getQuestion(3).getAnswer()
                   +"\n5-" + quiz.getQuestion(4).getAnswer(),"The results",
                   JOptionPane.INFORMATION_MESSAGE);
               
                question1.setText("");
                question2.setText("");
                question3.setText("");
                question4.setText("");
                question5.setText("");
            }
        });
    }
}
