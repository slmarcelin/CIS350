//CHECKSTYLE:OFF
package moviedb;

import static org.junit.Assert.*;

import org.junit.Test;

public class HangmanGameTest {
	private static final String TEST_WORD = "asglek:JLTJlj;lj"; 
    @Test
    public void testGuessingCompleteWord() {
        HangmanGame game = new HangmanGame(TEST_WORD);

        game.isWithin(game.getWord());
    	assertEquals(game.getIncorrect(), 0);
    	assertEquals(game.getState(), 2);
    	assertEquals(game.getGuess(), game.getWord());
    }
    
    public void testGuessingAllLetters() {
        HangmanGame game = new HangmanGame(TEST_WORD);

        assertEquals(game.getState(), 0);
        
        String nextLetter;
        for(int i = 0; i < game.getWord().length() - 1; i++) {
        	nextLetter = game.getWord().substring(i, i+1);
        	game.isWithin(nextLetter);
        	assertEquals(game.getState(), 0);
        	assertEquals(game.getIncorrect(), 0);
        }
        nextLetter = game.getWord().substring(game.getWord().length() - 1);
    	game.isWithin(nextLetter);
    	assertEquals(game.getIncorrect(), 0);
    	assertEquals(game.getState(), 2);
    	assertEquals(game.getGuess(), game.getWord());
    }
    
    public void testGuessingWrong() {
        HangmanGame game = new HangmanGame(TEST_WORD);
    	
        String startGuess = game.getGuess();
        String wrong = game.getWord() + "X";
        
        assertEquals(game.getState(), 0);
        for(int i = 0; i < 5; i++) {
        	game.isWithin(wrong);
        	assertEquals(game.getState(), 0);
        	assertEquals(game.getIncorrect(), i);
        }
    	game.isWithin(wrong);
    	assertEquals(game.getState(), 1);
    	assertEquals(game.getIncorrect(), 6);
    	assertEquals(game.getGuess(), startGuess);
    }
}
//CHECKSTYLE:ON
