package moviedb;

import info.movito.themoviedbapi.model.people.Person;

/******************************************************************************
 * A class to store a cast member of a movie.
 *****************************************************************************/
@SuppressWarnings("serial")
public class MovieCastMember extends Person {
	/** The character name of the cast member. */
	private String characterName = "";
	
	/**********************************************************************
	 * Constructs a new MovieCastMember.
	 *********************************************************************/
	public MovieCastMember() {	
	}

	/**********************************************************************
	 * Returns the character name.
	 * @return the character name
	 *********************************************************************/
	public String getCharacterName() {
		return characterName;
	}

	/**********************************************************************
	 * Sets the character name.
	 * @param name the character name
	 *********************************************************************/
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
