/**
 * BonuQuestion -- Class creates a bonus question for a round of the survivor
 * pool -- Gets & sets the bonus question and answers
 * 
 * @author Manor Freeman, Hazel Rivera, Martin Grabarczyk, Liam Corrigan, Jeff
 *         Westaway, Delerina Hill V 1.0 02/18/12
 * 
 */
public class BonusQuestion {

	// Attributes
	private String question;
	private String[] answers;
	private String correctAnswer;

	/**
	 * Constructor for objects of the class BonusQuestion that initializes the
	 * question, answers, and correct answer of the bonus question
	 * 
	 * @param question
	 *            The question of the bonus question
	 * @param answers
	 *            The possible answers of the bonus question
	 * @param correctAnswer
	 *            The correct answer to the bonus question
	 */
	public BonusQuestion(String question, String[] answers, String correctAnswer) {
		this.question = question;
		this.answers = answers;
		this.correctAnswer = correctAnswer;
	}

	// Accessor methods

	/**
	 * Gets the question of the bonus question
	 * 
	 * @return the question of the bonus question
	 */
	public String getQuestion() {
		return this.question;
	}

	/**
	 * Gets the possible answers to the bonus question
	 * 
	 * @return An array storing the possible answers to the bonus question
	 */
	public String[] getAnswers() {
		return this.answers;
	}

	/**
	 * Gets the correct answer to the bonus question
	 * 
	 * @return the correct answer to the bonus question
	 */
	public String getCorrectAnswer() {
		return this.correctAnswer;
	}

	// Mutator methods
	/**
	 * Sets the question of the bonus question object
	 * 
	 * @param question
	 *            the question of the bonus question object
	 **/
	public void setQuestion(String question) {
		this.question = question;
	}

	/**
	 * Sets the possible answers of the bonus question object
	 * 
	 * @param answers
	 *            an array of the possible answers to the question
	 */
	public void setAnswers(String answers[]) {
		this.answers = answers;
	}

	/**
	 * Sets the correct answer of the bonus question object
	 * 
	 * @param correctAnswer
	 *            The correct answer of the bonus question object
	 */
	public void setCorrectAnswer(String correctAnswer) {
		this.correctAnswer = correctAnswer;
	}

	// Other methods

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
		if (this.correctAnswer.equals(answer))
			return true;
		else
			return false;
	}

	/**
	 * Returns true if the question is a multiple choice question, otherwise
	 * returns false
	 * 
	 * @return true if the question is multiple choice, otherwise returns false
	 */
	public boolean isMultipleChoice() {
		if (this.answers.length > 1)
			return true;
		return false;
	}

}
