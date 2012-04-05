/**
 * BonuQuestion -- Class creates a bonus question for a round of the survivor
 * pool -- Gets & sets the bonus question and answers
 * 
 * @author Manor Freeman, Hazel Rivera, Martin Grabarczyk, Liam Corrigan, Jeff
 *         Westaway, Delerina Hill V 1.0 02/18/12
 * 
 */
public class BQAnswer {

	// Attributes
	private BonusQuestion question;
	private int round;
	private String answer;

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
	public BQAnswer(BonusQuestion b, int currentRound) {
		this.question = b;
		this.answer = "DEADBEEF";
		this.round = currentRound;
	}

	// Other methods

	public BonusQuestion getQuestion() {
		return question;
	}

	public void setQuestion(BonusQuestion question) {
		this.question = question;
	}

	public int getRound() {
		return round;
	}

	public void setRound(int round) {
		this.round = round;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

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

	public boolean isCorrect() {
		return (this.question.getCorrectAnswer().equalsIgnoreCase(this.answer));
	}

}
