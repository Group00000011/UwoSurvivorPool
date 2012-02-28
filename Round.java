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
		this.roundNum = roundNum;
		this.bonusQuestion = null;
		this.contestantEliminated = null;

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
		// if the round has no bonus questions
		if (this.bonusQuestion == null) {
			// create an array of size 1 to store bonus questions and add
			// question
			this.bonusQuestion = new BonusQuestion[1];
			this.bonusQuestion[0] = quest;
		}
		// if the round already has bonus questions
		else {
			// create a new array that is one slot larger than the old array
			BonusQuestion[] newArray = new BonusQuestion[this.bonusQuestion.length + 1];
			// copy questions from old array to new array
			for (int i = 0; i < this.bonusQuestion.length; i++)
				newArray[i] = this.bonusQuestion[i];
			// add question and set bonusQuestion attribute to new array
			newArray[newArray.length - 1] = quest;
			this.bonusQuestion = newArray;
		}
	}

	/**
	 * Removes a bonus question with the specified question from the round
	 * 
	 * @param question
	 *            the question to be removed from the round
	 */
	public void removeBonusQuestion(String question) {
		boolean isBonusQuestion = false;
		int i = 0;
		// while the bonus question has not been found, search all bonus
		// questions
		while (!isBonusQuestion && i < this.bonusQuestion.length) {
			// if we found the bonus question, set the marker to true
			if (this.bonusQuestion[i].getQuestion().equals(question))
				isBonusQuestion = true;
			// else increment index
			else
				i++;
		}
		// if we found the bonus question
		if (isBonusQuestion) {
			// create a new array of size one less than old array
			BonusQuestion[] newArray = new BonusQuestion[this.bonusQuestion.length - 1];
			// copy all questions except the question to be deleted from the old
			// array to the new array
			for (int j = 0; j < newArray.length; j++) {
				if (j < i)
					newArray[j] = this.bonusQuestion[j];
				else
					newArray[j] = this.bonusQuestion[j + 1];
			}
			// set the bonus question attribute equal to the new array
			this.bonusQuestion = newArray;
		}

	}

}
