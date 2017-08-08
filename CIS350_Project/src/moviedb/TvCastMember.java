package moviedb;

import info.movito.themoviedbapi.model.people.Person;

/**
 * A TV show cast member.
 */
@SuppressWarnings("serial")
public class TvCastMember extends Person {
	/**  the name of the character. */
	private String characterName;
	
	/**
	 * the tv cast member constructor.
	 */
	public TvCastMember() {
	}
	
	/**
	 * Getter returns character name.
	 * @return characterName of type String.
	 */
	public String getCharacterName() {
		return characterName;
	}
	
	/**
	 * Setter sets the name of the Character.
	 * @param name the character's name
	 */
	public void setCharacterName(final String name) {
		characterName = name;
	}

	
	/**********************************************************************
	 * Compares two objects.
	 * @param other the object to compare to
	 * @return whether the objects are equal
	 *********************************************************************/
	public boolean equals(final Object other) {
		return super.equals(other);
	}

	/**********************************************************************
	 * Returns a hashcode for comparison purposes.
	 * @return a hashcode
	 *********************************************************************/
	public int hashCode() {
		return super.hashCode();
	}
}