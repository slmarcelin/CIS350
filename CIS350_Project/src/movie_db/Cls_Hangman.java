package movie_db;

import java.util.Random;

/*
 * Cls_Hangman class.
 */
public class Cls_Hangman {
	
	/*random word of type string.*/
	private String word;
	/*The User's guess.*/
	private String userGuess;
	/*The current state of the game.*/
	private int state = 0;
	/*The number of turns of the user.*/
	private int turns = 0;
	/*random rand number.*/
	private int rand;
	/*random source number.*/
	private int source;
	/*page.*/
	private int page;
	
	/***************************************
	  Constructor initializes variables.
	***************************************/
	Cls_Hangman(){
		Random r = new Random();
		rand = r.nextInt(100);
		source = r.nextInt(20);
		page = r.nextInt(9) + 1;
		generateWord();
		userGuess = "";
		
		int i;
		for(i = 0; i < word.length(); i++){
			if(word.charAt(i) != ' '){
				userGuess += "_";
			}else{
				userGuess += " ";
			}
		}
	}
	
	/***************************************
	  getter returns the word.
	  @return word of type string
	***************************************/
	public String getWord() {
		return word;
	}
	
	/***************************************
	  getter returns the user's guess.
	  @return userGuess of type string
	***************************************/
	public String getGuess() {
		return userGuess;
	}
	
	/***************************************
	  getter returns the state.
	  @return state the state of the game
	***************************************/
	public int getState() {
		return state;
	}
	
	/***************************************
	  getter returns the number of turns.
	  @return turns the number of turns
	***************************************/
	public int getIncorrect() {
		return turns;
	}
	
	/*****************************************
	  Determines if the letter is within the
	  chosen random word.
	  @param letter user input of type string 
	  @return true or false if letter is 
	          within
	*****************************************/
	public boolean isWithin(String letter)
	{
		letter = letter.toUpperCase();
		if(!word.toUpperCase().contains(letter.toUpperCase())) {
			turns++;
			if(turns == 6){
				state = 1;
			}
			return false;
		}
		else {
			int i;
			for(i = 0; i < word.length(); i++) {
				if(word.charAt(i) == letter.charAt(0)) {
					userGuess = userGuess.substring(0,i) + letter.charAt(0) + userGuess.substring( i + 1 );
				}
			}
			
			if(userGuess == word){
				state = 2;
			}
			return true;
		}
	}
	
	/***************************************
	  Generates a random word, this word.
	  may be a movie, show or actor
	***************************************/
	private void generateWord() {
		//generate a word based on the rand value
		if(rand < 33){
			word = Cls_MovieData.m_getRandMovie(source, page).getTitle();
		}else if(rand >= 33 && rand < 66){
			word = Cls_MovieData.m_getRandShow(source, page).getName();
		}else{
			word = Cls_MovieData.m_getRandActor(source, page).getName();
		}
		word = word.toUpperCase();
	}
}
