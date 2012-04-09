import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

/**
 * Special listener class to listen to update, cancel, and delete buttons 
 * for editing bonus question in BonusQuestionGUI class.
 * 
 * This is a bit of a hack and in future revisions should be moved into the
 * BonusQuestionGUI class itself. one instance of this class is created per 
 * editable question.
 * 
 * V 1.0 04/01/12
 *  
 * @author Manor Freeman, Hazel Rivera, Martin Grabarczyk, Liam Corrigan, Jeff
 *         Westaway, Delerina Hill 
 *
 */
public class ButtonListener implements ActionListener {

	// FILEDS
	private QuestionPanel question;
	private int qNum;
	private Round round;
	private BonusQuestionGUI gui;
	private SurvivorPoolAdminGUI mainGUI;

	// CONSTRUCTOR
	/**
	 * Constructor sets up listener to update, modify and delete already existing bonus questions
	 * 
	 * no longer need parrentPanel or buttonsPanel but need to be removed from entire set of classes
	 * 
	 * @param currentRound int number of current round/week
	 * @param questionNumber int number of question within current round whose mod-buttons are being listened to
	 * @param questionPanel custom JPanel for the question 
	 * @param gui the BonusQuestionGUI containing buttons registering this listener
	 * @param mainGUI main game GUI. This class is needed for methods of reading and writing settings to disk.
	 */
	public ButtonListener(Round currentRound, int questionNumber,
			QuestionPanel questionPanel, JPanel buttonsPanel,
			JPanel parrentPanel, BonusQuestionGUI gui,
			SurvivorPoolAdminGUI mainGUI) {
		question = questionPanel;
		qNum = questionNumber;
		round = currentRound;
		this.gui = gui;
		this.mainGUI = mainGUI;
	}

	/**
	 * Method listens to UPDATE CANCEL and DELETE buttons for each editable quesiton
	 * has checks to ensure no parts of the question are left blank. Beeps to alert the user 
	 * if there is a blank field when trying to save.
	 * 
	 * when a question is updated/delete the changes are written to disk by the main gui class
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("update")) { 
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
