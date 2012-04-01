import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

public class ButtonListener implements ActionListener {

	private QuestionPanel question;
	private JPanel parent, buttons;
	private int qNum;
	private Round round;
	private BonusQuestionGUI gui;
	private SurvivorPoolAdminGUI mainGUI;

	public ButtonListener(Round currentRound, int questionNumber,
			QuestionPanel questionPanel, JPanel buttonsPanel,
			JPanel parrentPanel, BonusQuestionGUI gui,
			SurvivorPoolAdminGUI mainGUI) {
		question = questionPanel;
		parent = parrentPanel;
		qNum = questionNumber;
		round = currentRound;
		buttons = buttonsPanel;
		this.gui = gui;
		this.mainGUI = mainGUI;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("update")) { // BQ UPDATE
			if (((String) question.getQuestion()).length() < 1) {
				Toolkit.getDefaultToolkit().beep();
				question.discardChanges();
				question.revalidate();
				Toolkit.getDefaultToolkit().beep();
			} else {
				BonusQuestion q = question.update();
				round.updateQuestion(qNum, q);
				mainGUI.writeRounds("rounds.txt");
			}
		} else if (e.getActionCommand().equals("cancel")) {
			question.discardChanges();
			question.revalidate();
		} else {
			round.removeBonusQuestion(question.getQuestion());
			mainGUI.writeRounds("rounds.txt");
			gui.refresh();
		}

	}

}
