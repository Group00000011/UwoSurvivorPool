/**
 * Player class creates a player in the Survivor Pool
 * 
 * @author Manor Freeman, Hazel Rivera, Martin Grabarczyk, Liam Corrigan, Jeff
 *         Westaway, Delerina Hill
 * 
 */
public class Player {
	// Attributes
	private String firstName;
	private String lastName;
	private String userID;
	private RoundPick finalPick;
	private int roundOfFinalPick;
	private int score;
	private RoundPick[] weeklyPicks;

	/**
	 * Constructor for objects of class Player that initializes player's first
	 * name, last name,ID, and number of weekly picks
	 * 
	 * @param firstName
	 *            Players first name
	 * @param lastName
	 *            Player's Last name
	 * @param userID
	 *            Player's user ID
	 * @param numContestants
	 *            Number of contestants in pool
	 */
	public Player(String firstName, String lastName, String userID,
			int numContestants) {

	}

	// Accessor methods

	/**
	 * Gets the player's first name
	 * 
	 * @return the first name of the player
	 */
	public String getFirst() {
		return this.firstName;
	}

	/**
	 * Gets the player's last name
	 * 
	 * @return the last name of the player
	 */
	public String getLast() {
		return this.lastName;
	}

	/**
	 * Get the player's ID
	 * 
	 * @return the ID of the player
	 */
	public String getID() {
		return userID;
	}

	/**
	 * Get the player's pick for which contestant will win the game
	 * 
	 * @return the final pick of the player
	 */
	public RoundPick getFinal() {
		return this.finalPick;
	}

	/**
	 * Get the round that the player chose his/her final pick
	 * 
	 * @return the round of the final pick
	 */
	public int getRoundOfFinal() {
		return this.roundOfFinalPick;
	}

	/**
	 * Get the player's score
	 * 
	 * @return the score of the player
	 */
	public int getScore() {
		return this.score;
	}

	/**
	 * Gets the players RoundPick for a specified round
	 * 
	 * @param roundNum
	 *            The round of the RoundPick
	 * @return the RoundPick for the specified round
	 */
	public RoundPick getWeekPick(int roundNum) {
		return this.weeklyPicks[roundNum - 1];
	}

	// Mutator methods

	/**
	 * Set the player's score
	 * 
	 * @param score
	 *            The updated score of the player
	 */
	public void setScore(int score) {
		this.score = score;
	}

	// Other methods

	/**
	 * Increments the player's score
	 * 
	 * @param incNum
	 *            The amount that the score should be incremented
	 */
	public void incScore(int incNum) {
		this.score = this.score + incNum;
	}

	/**
	 * Decrements the player's score
	 * 
	 * @param decNum
	 *            The amount that the score should be decremented
	 */
	public void decScore(int decNum) {
		this.score = this.score - decNum;
	}

	/**
	 * Creates RoundPick object for specified round
	 * 
	 * @param roundNum
	 *            the round of the round pick
	 * @param cont
	 *            the contestant to be eliminated on the specified round
	 */
	public void makeRoundPick(int roundNum, Contestant cont) {

	}

	/**
	 * Sets the final RoundPick of the player
	 * 
	 * @param cont
	 *            the contestant the player thinks will win
	 * @param currRound
	 *            the round that the player chose the final round pick
	 */
	public void chooseWinner(Contestant cont, int currRound) {

	}

}
