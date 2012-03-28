import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;


public class ButtonListener implements ActionListener {

	private QuestionPanel question;
	private JPanel parent, buttons;
	private int qNum;
	private Round round;
	private BonusQuestionGUI gui;
	
	public ButtonListener(Round currentRound, int questionNumber, QuestionPanel questionPanel, JPanel buttonsPanel, JPanel parrentPanel, BonusQuestionGUI gui) {
		question = questionPanel;
		parent = parrentPanel;
		qNum = questionNumber;
		round = currentRound;
		buttons = buttonsPanel;
		this.gui = gui;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("update")) {
			BonusQuestion q = question.update();
			round.updateQuestion(qNum, q);
		} else if (e.getActionCommand().equals("cancel")) {
			question.discardChanges();
			question.revalidate();
		} else {
			round.removeBonusQuestion(question.getQuestion());
			gui.refresh();
			//parent.remove(question);
			//parent.remove(buttons);
			//parent.revalidate();
		}

	}

}
