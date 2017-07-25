package moviedb;
import java.util.Random;

/**
 * A quiz question.
 * @author Zachary Ash
 */
public class TriviaQuestion {
    /** the question text. */
    private String question;
    /** the answer text. */
    private String answer;
    private static int nextV=0;
    private static int prev=2;
    private static int[]list=new int[10];
    private static Random rand = new Random();

    /**
     * Constructs a new question.
     * @param q the question text
     * @param a the answer text
     */
    public TriviaQuestion(final String q, final String a) {
        question = q;
        answer = a;
    }

    /**
     * Returns the question text.
     * @return the question text
     */
    public String getQuestion() {
        return question;
    }
    
    /**
     * Returns the answer to the question.
     * @return the answer to the question
     */
    public String getAnswer() {
        return answer;
    }
    
    public static void resetList()
    {
    	int i;
    	for(i=0;i<10;i++)
    	{
    		list[i]=0;
    	}
    }
   
   public static int setrandom(int current)
    {  
	   int value1=0;
	   value1=rand.nextInt((7-0)+1)+0;
	   while(value1==current || value1==nextV || value1==prev)
	   {
		   value1=rand.nextInt((8-1)+1)+1;
	   }
	nextV=value1;   
	return value1;
}
    
    /**
     * Determines if the given guess is the correct answer.
     * @param guess the user's guess
     * @return whether the guess is correct or not
     */
    public boolean checkAnswer(final String guess) {
        return guess.toLowerCase().equals(answer.toLowerCase());
    }
    
    /** an int used to iterate through the current set of questions. */
    private static int currQuestion = 0;
    
    /**
     * Generates a random question.
     * @return a random question
     */
    public static TriviaQuestion generateRandomQuestion() {
        resetList();
        String[] setQuestions = new String[] {
                "Brad Pitt plays General Glen McMahon\n"
                       + "in which film directed by David Michod?",
                "Which star plays Mitch Buchannon in\n"
                        + "the Baywatch movie released in 2017?",
                "The character played by Hugh Jackman in"
                       + " nine of the ten X-Men movie franchise films?",
                "He played 'Beast' in the film adapation of "
                        +"the fairy tale 'Beauty and the Beast'?\n",
                "Who always plays captain Jack Sparrow?",               
                 "In the Star Wars universe,"
                             +" who is Luke Skywalker's mother?",
                 "In the Lord of the Rings film series,"
                              +" which actor plays the character of Saruman?",
                 "In 'The Jungle Book',"
                                +" what is the name of the orphaned boy?",
                 "The name of the actress who plays Hermione Granger,"
                                +" in the Harry Potter series of films?",
                 "The name of the kleptomaniac monkey,"
                                +" in the Disney movie 'Aladdin'?",
                "Which actress played identical twins in the 1998 "
                                +" movie remake of The Parent Trap?",
                "In the Disney movie 'Beauty and the Beast', what is"
                                +" the name of Gaston's bumbling sidekick?",
                "Who played James Bond in the 1969 film"
                                + " 'On Her Majesty's Secret Service'?"
        };
        String[] setAnswers = new String[]{
                "war machine",
                "dwayne johnson",
                "logan",
                "dan stevens",
                "johnny depp",
                "padme amidala",
                "christopher lee",
                "mowgli",
                "emma watson",
                "abu",
                "lindsay lohan",
                "lefou",
                "george robert"
        };
        TriviaQuestion q = new TriviaQuestion(
         setQuestions[currQuestion], setAnswers[currQuestion]);
         currQuestion=setrandom(currQuestion);
         currQuestion%=10;
         prev=currQuestion;
        return q;
    }
}
