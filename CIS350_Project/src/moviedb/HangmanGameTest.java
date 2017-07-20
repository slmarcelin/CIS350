//CHECKSTYLE:OFF
package moviedb;

import static org.junit.Assert.*;

import org.junit.Test;

public class HangmanGameTest {
	private static final String TEST_WORD = "a;iuiwewljljlssxz"; 
    @Test
    public void testBasics() {
        HangmanGame game = new HangmanGame(TEST_WORD);

    	assertEquals(game.getIncorrect(), 0);
    	assertTrue(game.getWord().equalsIgnoreCase(TEST_WORD));
    	assertEquals(game.getState(), 0);
    }
    
    @Test
    public void testGuessingAllLetters() {
        HangmanGame game = new HangmanGame(TEST_WORD);
        
        String nextLetter;
        for(int i = 0; i < game.getWord().length(); i++) {
        	assertEquals(game.getState(), 0);
        	assertEquals(game.getIncorrect(), 0);
        	nextLetter = game.getWord().substring(i, i+1);
        	game.isWithin(nextLetter);
        }
    	assertEquals(game.getIncorrect(), 0);
    	assertEquals(game.getState(), 2);
    	assertEquals(game.getGuess(), game.getWord());
    }
    
    @Test
    public void testGuessingWrong() {
        HangmanGame game = new HangmanGame(TEST_WORD);
    	
        String startGuess = game.getGuess();
        String wrong = game.getWord() + "X";
        
        for(int i = 0; i < 6; i++) {
        	assertEquals(game.getState(), 0);
        	assertEquals(game.getIncorrect(), i);
        	game.isWithin(wrong);
        }
    	assertEquals(game.getState(), 1);
    	assertEquals(game.getIncorrect(), 6);
    	assertEquals(game.getGuess(), startGuess);
    }
}
//CHECKSTYLE:ON
