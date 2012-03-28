import javax.swing.JFrame;

public class BonusQuestionDriver {

	private static final int WIDTH = 1024;
	private static final int HEIGHT = 768;

	private static JFrame window;
	private static BonusQuestionGUI bqPane;
	
	private static GameInProgressStub fakeGame;
	
	public static void main(String[] args) {
		makeWindow();
		fakeGame = new GameInProgressStub();
		bqPane = new BonusQuestionGUI(fakeGame.getRoundArray(), fakeGame.CURRENT_ROUND);
		window.add(bqPane);
		window.revalidate();
	}
	
	private static void makeWindow() {
		window = new JFrame();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setSize(WIDTH, HEIGHT);
		window.setLocationRelativeTo(null);
		window.setTitle("Test Bonus Question Feature");
		window.setVisible(true);
		
	}
}
