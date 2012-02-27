/**
 * Round class creates round objects in the Survivor Pool
 * 
 * @author Manor Freeman, Hazel Rivera, Martin Grabarczyk, Liam Corrigan, Jeff
 *         Westaway, Delerina Hill
 * 
 */
public class Round {
	// Attributes
	private int roundNum;
	private BonusQuestion[] bonusQuestion;
	private Contestant contestantEliminated;

	/**
	 * Constructor for objects of class Round that initializes the round number
	 * of the round
	 * 
	 * @param roundNum
	 *            the round number of the round
	 */
	public Round(int roundNum) {

	}

	// Accessor Methods

	/**
	 * Gets the round number of the round
	 * 
	 * @return the round number of the round
	 */
	public int getRoundNum() {
		return this.roundNum;
	}

	/**
	 * Gets the bonus question(s) of the round
	 * 
	 * @return an array storing the bonus questions of the round
	 */
	public BonusQuestion[] getBonusQuestion() {
		return this.bonusQuestion;
	}

	/**
	 * Gets the contestant eliminated in that round
	 * 
	 * @return the contestant eliminated of the Round object
	 */
	public Contestant getContestantEliminated() {
		return this.contestantEliminated;
	}

	// Mutator Methods

	/**
	 * Sets the contestant eliminated in that round
	 * 
	 * @param cont
	 *            the updated contestant eliminated of that round object
	 */
	public void setContestantEliminated(Contestant cont) {
		this.contestantEliminated = cont;
	}

	/**
	 * Adds a bonus question to the Round
	 * 
	 * @param quest
	 *            the bonus question to be added to the round
	 */
	public void addBonusQuestion(BonusQuestion quest) {

	}

	/**
	 * Removes a bonus question with the specified question from the round
	 * 
	 * @param question
	 *            the question to be removed from the round
	 */
	public void removeBonusQuestion(String question) {

	}
}
