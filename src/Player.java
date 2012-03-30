import java.util.Iterator;
import java.util.Vector;

/**
 * Player - creates a player in the Survivor Pool
 * 
 * @author Manor Freeman, Hazel Rivera, Martin Grabarczyk, Liam Corrigan, Jeff
 *         Westaway, Delerina Hill
 *  V 1.0 03/01/12
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
	private Vector<BQAnswer> answers;

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
	 **/
	public Player(String firstName, String lastName, String userID){
		this.firstName=firstName;
		this.lastName=lastName;
		this.userID=userID;
		this.finalPick=null;
		this.roundOfFinalPick= 0;
		this.score = 0;
		this.weeklyPicks=null;
	}
	
	public boolean answerQuestion(BonusQuestion b, String answer, int round) {
		BQAnswer ans = new BQAnswer(b, round);
		answers.add(ans);
		return ans.answerQuestion(answer);
	}
	
	public int getBQScore() {
		int score = 0;
		if(answers!=null){
		Iterator<BQAnswer> iter = answers.iterator();
		while (iter.hasNext()) {
			if (iter.next().isCorrect())
				score = score + 2;
		}
		}
		return score;
	}
		

 	public void setFirst(String first){
		this.firstName=first;
	}
	
	
	public void setLast(String last){
		this.lastName=last;
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
	 * @return the RoundPick for the specified round if it has been made, else return null 
	 */
	public RoundPick getWeekPick(int roundNum) {
		if(this.weeklyPicks!=null && this.weeklyPicks.length >= roundNum)
			return this.weeklyPicks[roundNum - 1];
		else
			return null;
	}

	public RoundPick[] getAllWeekPicks() {
		
		return this.weeklyPicks;
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
		if(this.weeklyPicks==null){
			this.weeklyPicks=new RoundPick[roundNum];
			this.weeklyPicks[roundNum - 1] = new RoundPick(roundNum, cont);
		}
		else if(this.weeklyPicks.length >= roundNum)
			this.weeklyPicks[roundNum - 1] = new RoundPick(roundNum, cont);
		else{
			RoundPick[] newWeekPicks=new RoundPick[roundNum];
			for(int i=0;i<this.weeklyPicks.length; i++){
				newWeekPicks[i]=this.weeklyPicks[i];
			}
			newWeekPicks[roundNum-1] = new RoundPick(roundNum, cont);
			this.weeklyPicks=newWeekPicks;
		}
		
	}

	/**
	 * Sets the final RoundPick of the player
	 * 
	 * @param cont
	 *            the contestant the player thinks will win
	 * @param currRound
	 *            the round that the player chose the final round pick
	 * @param numRounds
	 *            the number of rounds in the game
	 */
	public void chooseWinner(Contestant cont, int currRound, int numRounds) {
		this.finalPick = new RoundPick(numRounds, cont);
		this.roundOfFinalPick = currRound;
		this.makeRoundPick(numRounds - 1,cont);
	}

}
