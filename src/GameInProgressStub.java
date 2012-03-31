import javax.swing.JFrame;

/**
 * GameInProgressStub -- creates a fake game at the 6th (out of 15) week of play
 * there are fake bonus questions added for some weeks and not for other weeks
 * you can add bonus questions to the current round of this fake game
 * 
 * @author Manor Freeman, Hazel Rivera, Martin Grabarczyk, Liam Corrigan, Jeff
 *         Westaway, Delerina Hill
 *  V 1.0 03/15/12
 */
public class GameInProgressStub {

	private static final int NUMBER_OF_WEEKS = 15;
	public static final int CURRENT_ROUND = 6;

	private Round[] rounds;

	public GameInProgressStub() {
		rounds = new Round[NUMBER_OF_WEEKS];
		for (int i = 0; i < CURRENT_ROUND; i++) {
			rounds[i] = new Round(i);
		}
		// add two questions for round 1
		rounds[0].addBonusQuestion(new BonusQuestion("What Round Is This?", new String[]{"one", "twenty seven","3","444444"}, "one"));
		rounds[0].addBonusQuestion(new BonusQuestion("here is quation 2?", new String[]{"answe2"}, "answer 2"));
		// one question for round 3
		rounds[2].addBonusQuestion(new BonusQuestion("here is the question for week three of the game", new String[]{"1","2","3","4"} , "I don't know"));
		// and one question for round 6
		rounds[5].addBonusQuestion(new BonusQuestion("fourht bonus question", new String[]{"here is the answer blah blah"} , "No Answer is right but none are wrong..."));
		
	
	}

	public Round[] getRoundArray() {
		return null;
		// return rounds;
	}
}


	
