package moviedb;

import info.movito.themoviedbapi.model.people.Person;


public class MovieCastMember extends Person {
	private String characterName = "";
	
	public MovieCastMember() {
		
	}
	
	public String getCharacterName() {
		return characterName;
	}
	
	public void setCharacterName(String name) {
		characterName = name;
	}
}
