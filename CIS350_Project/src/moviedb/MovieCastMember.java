package moviedb;

import info.movito.themoviedbapi.model.people.Person;


public class MovieCastMember extends Person {
	private int personID = 99;
	private String characterName = "Count Olaf";
	private String actorName = "Neil Patrick-Harris";
	private String profilePath ="/v5sCdjk0zxwSdFT4kmlVwu6M3Hb.jpg";
	
	public MovieCastMember() {
		
	}
	
	public String getCharacterName() {
		return characterName;
	}
	
	public String getName() {
		return actorName;
	}
	
	public String getProfilePath() {
		return profilePath;
	}
	
	public int getID() {
		return personID;
	}
	
	public void setCharacterName(String name) {
		characterName = name;
	}
	
	public void setActorName(String name) {
		actorName = name;
	}
	
	public void setProfilePath(String path) {
		profilePath = path;
	}
	
	public void setId(int id) {
		personID = id;
	}
}
