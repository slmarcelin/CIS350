package moviedb;

/**
 * A quiz question.
 * @author Zachary Ash
 */
public class TriviaQuestion {
    /** the question text. */
    private String question;
    /** the answer text. */
    private String answer;
    
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
        String[] setQuestions = new String[] {
                "Brad Pitt plays General Glen McMahon\n"
                       + "in which film directed by David Michod?",
                "Which star plays Mitch Buchannon in\n"
                        + "the Baywatch movie released in 2017?",
                "The character played by Hugh Jackman in"
                        + "nine of the ten X-Men movie franchise films?",
                "He played 'Beast' in the film adapation of "
                        +"the fairy tale 'Beauty and the Beast'?",
                "Who always plays captain Jack Sparrow?",               
                 "In the Star Wars universe,"
                             +"who is Luke Skywalker's mother?",
                 "In the Lord of the Rings film series,"
                              +"which actor plays the character of Saruman In the 2016,",
                 "In the American fantasy adventure film 'The Jungle Book',"
                                +"what is the name of the orphaned human boy?",
                 "The name of the actress who plays Hermione Granger,"
                                +"in the Harry Potter series of films?",
                 "The name of the kleptomaniac monkey,"
                                +"in the Disney movie 'Aladdin'?"
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
                "abu"
        };
        TriviaQuestion q = new TriviaQuestion(
         setQuestions[currQuestion], setAnswers[currQuestion]);
         currQuestion++;
         currQuestion %=5;
        return q;
    }
}
