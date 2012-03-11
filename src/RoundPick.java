/**
 * RoundPick class creates round pick objects that hold which contestant a
 * player thinks will be eliminated for a specified round
 * 
  * @author Manor Freeman, Hazel Rivera, Martin Grabarczyk, Liam Corrigan, Jeff
 *         Westaway, Delerina Hill
 *  V 1.0 03/01/12
 */
public class RoundPick {
	// Attributes
	private int round;
	private Contestant contestant;

	/**
	 * Constructor for objects of class RoundPick initializing the round and the
	 * contestant that a player thinks will be eliminated for that round
	 * 
	 * @param round
	 *            the round of the round pick
	 * @param contestant
	 *            the contestant that the player thinks will be eliminated
	 */
	public RoundPick(int round, Contestant contestant) {
		this.round = round;
		this.contestant = contestant;
	}

	// Accessor Methods

	/**
	 * Gets the round of the RoundPick
	 * 
	 * @return the round of the RoundPick
	 */
	public int getRound() {
		return this.round;
	}

	/**
	 * Gets the contestant of the RoundPick
	 * 
	 * @return the contestant of the RoundPick
	 */
	public Contestant getContestant() {
		return this.contestant;
	}
}
