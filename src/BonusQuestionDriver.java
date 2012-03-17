import javax.swing.JFrame;

public class BonusQuestionDriver {

	private static final int WIDTH = 1024;
	private static final int HEIGHT = 768;
	private static final int NUMBER_OF_WEEKS = 15;

	private static JFrame window;
	private static BonusQuestionGUI bonusQuestionPane;
	private static int currentRound;
	private static Round[] round;

	public static void main(String[] args) {
		window = new JFrame();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setSize(WIDTH, HEIGHT);
		window.setLocationRelativeTo(null);
		window.setTitle("Test Bonus Question Feature");
		window.setVisible(true);
		
		round = new Round[NUMBER_OF_WEEKS];
		currentRound = 3;
		for (int i = 0; i < currentRound; i++) {
			round[i] = new Round(i);
		}
		round[0].addBonusQuestion(new BonusQuestion("What Round Is This?", new String[]{"one", "twenty seven"}, "one"));
		round[0].addBonusQuestion(new BonusQuestion("here is wuation 2?", new String[]{"one"}, "answer 2"));
		round[2].addBonusQuestion(new BonusQuestion("What should my question be for round three... I don't know", new String[]{""} , "I don't know"));
		
		bonusQuestionPane = new BonusQuestionGUI(round, currentRound);
		window.add(bonusQuestionPane);


	}
}
