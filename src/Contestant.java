/**
 * Contestant -- class creates a contestant in the Survivor Pool
 * 
 * @author Manor Freeman, Hazel Rivera, Martin Grabarczyk, Liam Corrigan, Jeff
 *         Westaway, Delerina Hill V 1.0 02/18/12
 */
public class Contestant {
	// Attributes
	private String firstName;
	private String lastName;
	private String contID;
	private String tribe;
	private String picture;
	private Round eliminationRound;

	/**
	 * Constructor for objects of the class Contestant that initializes the
	 * contestant's first name, last name, tribe name, ID, and display picture
	 * 
	 * @param first
	 *            the first name of the Contestant
	 * @param last
	 *            the last name of the Contestant
	 * @param contID
	 *            the ID of the contestant
	 * @param tribe
	 *            the tribe name of the contestant
	 * @param picture
	 *            the display picture of the contestant
	 */
	public Contestant(String first, String last, String contID, String tribe,
			String picture) {
		this.firstName = first;
		this.lastName = last;
		this.contID = contID;
		this.tribe = tribe;
		this.picture = picture;
		this.eliminationRound = null;

	}

	// Accessor methods

	/**
	 * Gets the Contestant's first name
	 * 
	 * @return the first name of the contestant
	 */
	public String getFirst() {
		return this.firstName;
	}

	/**
	 * Gets the Contestant's last name
	 * 
	 * @return the last name of the contestant
	 */
	public String getLast() {
		return this.lastName;
	}

	/**
	 * Gets the Contestant's ID
	 * 
	 * @return the ID of the contestant
	 */
	public String getID() {
		return this.contID;
	}

	/**
	 * Gets the Contestant's tribe name
	 * 
	 * @return the tribe of the contestant
	 */
	public String getTribe() {
		return this.tribe;
	}

	/**
	 * Gets the Contestant's display picture
	 * 
	 * @return the pathname of contestant's display picture
	 */
	public String getPicture() {
		return this.picture;
	}

	/**
	 * Gets the round that the contestant was eliminated
	 * 
	 * @return the round that the contestant was eliminated, if contestant has
	 *         not been eliminated returns null
	 */
	public Round getElimRound() {
		return this.eliminationRound;
	}

	// Mutator methods

	/**
	 * Sets the Contestant's first name
	 * 
	 * @param first
	 *            Contestant's first name
	 */
	public void setFirst(String first) {
		this.firstName = first;
	}

	/**
	 * Sets the Contestant's picture
	 * 
	 * @param pic
	 *            Contestant's picture
	 */
	public void setPic(String pic) {
		this.picture = pic;
	}

	/**
	 * Sets the Contestant's last name
	 * 
	 * @param last
	 *            Contestant's last name
	 */
	public void setLast(String last) {
		this.lastName = last;
	}

	/**
	 * Sets the contestant's tribe
	 * 
	 * @param tribe
	 *            the tribe of the contestant
	 */
	public void setTribe(String tribe) {
		this.tribe = tribe;
	}

	/**
	 * Sets the round that the contestant was eliminated
	 * 
	 * @param elimRound
	 *            the round that the contestant was eliminated
	 */
	public void setElimRound(Round elimRound) {
		this.eliminationRound = elimRound;
	}
}
