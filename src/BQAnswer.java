/**
 * Bonus Question Answer -- stores a player's answer to a bonus question.
 * need one instance of this class per answer per player.
 * 
 * V 1.0 04/01/12
 *  
 * @author Manor Freeman, Hazel Rivera, Martin Grabarczyk, Liam Corrigan, Jeff
 *         Westaway, Delerina Hill 
 *
 */
public class BQAnswer {

	// ATTRIBUTES
	private BonusQuestion question;
	private int round;
	private String answer;

	// CONSTRUCTOR
	/**
	 * Constructor creates a new blank answer. 
	 * @param b BonusQuestion instance for which answer is being provided
	 * @param currentRound integer representing the round this Bonus Question belongs to
	 */
	public BQAnswer(BonusQuestion b, int currentRound) {
		this.question = b;
		this.answer = "DEADBEEF";
		this.round = currentRound;
	}

	// OTHER METHODS
	/**
	 * Returns true if the specified answer is the correct answer to the
	 * question, otherwise returns false
	 * 
	 * @param answer
	 *            The player's answer to the bonus question
	 * @return true if the answer matches the correct answer of the bonus
	 *         question, otherwise false
	 */
	public boolean answerQuestion(String answer) {
		this.answer = answer;
		if (this.question.getCorrectAnswer().equalsIgnoreCase(answer)) {
			return true;
		} else
			return false;
	}
	
	/**
	 * Accessor method to get the answer set for this question
	 * returns DEADBEEF if no answer has been set
	 * @return the answer to the question as a String
	 */
	public String getAnswer() {
		return answer;
	}

	/**
	 * Method for getting the question to which this answer is associated.
	 * @return BonusQuestion to which this answer corresponds.
	 */
	public BonusQuestion getQuestion() {
		return question;
	}

	/**
	 * Accessor to check the round number this answer (and it's associated question) belongs to
	 * @return current round number as int.
	 */
	public int getRound() {
		return round;
	}

	/**
	 * Method to check whether the set answer is correct.
	 * Ignores case when comparing strings to check answer.
	 * @return TRUE if the answer is right, FALSE otherwise
	 */
	public boolean isCorrect() {
		return (this.question.getCorrectAnswer().equalsIgnoreCase(this.answer));
	}

	/**
	 * Accessor to set an answer
	 * @param answer String answer to set
	 */
	public void setAnswer(String answer) {
		this.answer = answer;
	}

	/**
	 * Accessor method to change the question associated with this answer
	 * @param question
	 */
	public void setQuestion(BonusQuestion question) {
		this.question = question;
	}

	/**
	 * Accessor method to set the round of play this answer is associated with.
	 * @param round
	 */
	public void setRound(int round) {
		this.round = round;
	}

}
