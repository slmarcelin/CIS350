package moviedb;

import info.movito.themoviedbapi.model.people.Person;

public class TvCastMember extends Person {
	/**serial version id. */
	private static final long serialVersionUID = 1L;
	/** actor id number. */
	private int personID = 99;
	/**  the name of the character. */
	private String characterName = "Count Olaf";
	/** the name of the actor. */
	private String actorName = "Neil Patrick-Harris";
	/** profile path of actor. */
	private String profilePath ="/v5sCdjk0zxwSdFT4kmlVwu6M3Hb.jpg";
	
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
	 * Getter returns actor's name.
	 * @return actorName of type String.
	 */
	public String getName() {
		return actorName;
	}
	
	/**
	 * Getter returns the profile path of the actor.
	 * @return profilePath of type String.
	 */
	public String getProfilePath()
	{
		return profilePath;
	}
	
	/**
	 * Getter returns the personId
	 * @return personId of type int
	 */
	public int getID()
	{
		return personID;
	}
	
	/**
	 * Setter sets the name of the Character
	 * @param name the character's name
	 */
	public void setCharacterName(String name) 
	{
		characterName = name;
	}
	
	/**
	 * Setter sets the actor's name
	 * @param name of the actor
	 */
	public void setActorName(String name) 
	{
		actorName = name;
	}
	
	/**
	 * Setter sets the profile path of the actor
	 * @param path of type String
	 */
	public void setProfilePath(String path) 
	{
		profilePath = path;
	}
	
	/**
	 * Setter sets the id of the actor
	 * @param id of type int
	 */
	public void setId(int id) 
	{
		personID = id;
	}
}