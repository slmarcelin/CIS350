package moviedb;

import java.util.ArrayList;

/**
 * A quiz about movie trivia.
 * @author Zachary Ash
 */
public class TriviaQuiz {
    /** the questions on the quiz. */
    private ArrayList<TriviaQuestion> questions;

    /**
     * Constructs a new quiz.
     * @param numQuestions the number of questions on the quiz
     */
    public TriviaQuiz(final int numQuestions) {
        questions = new ArrayList<TriviaQuestion>();
        for (int i = 0; i < numQuestions; i++) {
            questions.add(TriviaQuestion.generateRandomQuestion());
        }
    }
    
    /**
     * Gets the number of questions.
     * @return the number of questions
     */
    public int numberOfQuestions() {
        return questions.size();
    }
    
    /**
     * Gets the requested question.
     * @param i the number question to access
     * @return the corresponding question
     */
    public TriviaQuestion getQuestion(final int i) {
        return questions.get(i);
    }
}
