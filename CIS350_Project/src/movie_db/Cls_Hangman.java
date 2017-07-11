package movie_db;

import java.util.Random;

public class Cls_Hangman {
	private Cls_MovieData data;
	private String word;
	private String userGuess;
	private int state = 0;
	private int turns = 0;
	private int rand;
	private int source;
	
	Cls_Hangman(){
		data = new Cls_MovieData();
		Random r = new Random();
		rand = r.nextInt(100);
		source = r.nextInt(20);
		generateWord();
		userGuess = "";
		
		int i;
		for(i = 0; i < word.length(); i++)
			if(word.charAt(i) != ' ')
				userGuess += "_";
			else
				userGuess += " ";
	}
	
	public String getWord() {
		return word;
	}
	
	public String getGuess() {
		return userGuess;
	}
	
	public int getState() {
		return state;
	}
	
	public boolean isWithin(String letter)
	{
		
		letter = letter.toUpperCase();
		if(!word.toUpperCase().contains(letter.toUpperCase())) {
			turns++;
			if(turns == 6)
				state = 1;
			return false;
		}
		else {
			int i;
			for(i = 0; i < word.length(); i++) {
				if(word.charAt(i) == letter.charAt(0)) {
					userGuess = userGuess.substring(0,i) + letter.charAt(0) + userGuess.substring( i + 1 );
				}
			}
			
			if(userGuess == word)
				state = 2;
			return true;
		}
	}
	
	private void generateWord() {
		if(rand < 33)
			word = data.m_getRandMovie(source).getTitle();
		else if(rand > 33 && rand < 66)
			word = data.m_getRandShow(source).getName();
		else
			word = data.m_getRandActor(source).getName();
		
		word = word.toUpperCase();
	}
}
