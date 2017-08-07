package moviedb;

import info.movito.themoviedbapi.model.people.Person;

public class TvCastMember extends Person {
	/**  the name of the character. */
	private String characterName = "Count Olaf";
	
	/**
	 * the tv cast member constructor.
	 */
	public TvCastMember() 
	{
		
	}
	
	/**
	 * Getter returns character name.
	 * @return characterName of type String.
	 */
	public String getCharacterName() 
	{
		return characterName;
	}
	
	/**
	 * Setter sets the name of the Character
	 * @param name the character's name
	 */
	public void setCharacterName(String name) 
	{
		characterName = name;
	}
}