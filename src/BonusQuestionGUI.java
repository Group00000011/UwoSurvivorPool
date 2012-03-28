/**
 * BonusQuestionGUI -- Panel to display past weeks bonus questions
 * and with  an option to add new bonus questions for the current week
 * 
 * @author Manor Freeman, Hazel Rivera, Martin Grabarczyk, Liam Corrigan, Jeff
 *         Westaway, Delerina Hill
 *  V 1.0 03/15/12
 */

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.text.AbstractDocument.Content;

public class BonusQuestionGUI extends JPanel implements ActionListener {

	private static final int MAX_CHARACTERS = 200;
	private int currentRound, totalRounds;
	private Round[] round;
	private JTabbedPane questionPane;
	private JButton newSAQuestionButton, newMCQuestionButton;
	private JScrollPane newQuestionScrollPane;
	private JPanel newAPanel;
	private TextArea questionArea;
	private JPanel answerArea;
	private JTextField correct, fake1, fake2, fake3;
	private Doc d1, d2, d3, d4;
	private JLabel correctAnswerLabel, fakeAnswersLabel;
	private JButton save, cancel;

	public BonusQuestionGUI(Round[] rounds, int currentRound) {
		super();
		this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		// set fields
		this.round = rounds;
		this.totalRounds = rounds.length;
		this.currentRound = currentRound;
		refresh();
	}

	public void addQuestion(boolean isMC) {

		this.removeAll();
		this.setLayout(new BoxLayout(this,
				BoxLayout.Y_AXIS));
		// make answer area
		newAPanel = new JPanel();
		newAPanel.setLayout(new GridBagLayout());
		// Constraints for lables
		GridBagConstraints labelsCon = new GridBagConstraints();
		GridBagConstraints fieldsCon = new GridBagConstraints();
		labelsCon.gridwidth = GridBagConstraints.REMAINDER;
		labelsCon.fill = GridBagConstraints.HORIZONTAL;
		// Constraints for fields
		fieldsCon.fill = GridBagConstraints.BOTH;
		fieldsCon.weightx = 1.0;
		fieldsCon.weighty = 1.0;
		// Create blank question area
		questionArea = new TextArea("Question:", "");
		this.add(questionArea);
		// MakeButtons
		JPanel bPanel = new JPanel();
		bPanel.setLayout(new BoxLayout(bPanel, BoxLayout.X_AXIS));
		save = new JButton("Save");
		save.addActionListener(this);
		cancel = new JButton("Cancel");
		cancel.setActionCommand("cancel");
		cancel.addActionListener(this);
		bPanel.add(save);
		bPanel.add(cancel);
		// Create the answer text fields/areas & set them up
		if (isMC) {
			// set up limited text fields
			d1 = new Doc(MAX_CHARACTERS);
			d2 = new Doc(MAX_CHARACTERS);
			d3 = new Doc(MAX_CHARACTERS);
			d4 = new Doc(MAX_CHARACTERS);
			// correct answer
			correctAnswerLabel = new JLabel("Correct Answer:");
			newAPanel.add(correctAnswerLabel, labelsCon);
			correct = new JTextField();
			correct.setColumns(20);
			correct.setDocument(d4);
			newAPanel.add(correct, labelsCon);
			// fake answers
			fakeAnswersLabel = new JLabel("Fake Answers:");
			newAPanel.add(fakeAnswersLabel, labelsCon);
			fake1 = new JTextField();
			fake1.setColumns(20);
			fake1.setDocument(d1);
			newAPanel.add(fake1, fieldsCon);
			fake2 = new JTextField();
			fake2.setColumns(20);
			correct.setDocument(d2);
			newAPanel.add(fake2, fieldsCon);
			fake3 = new JTextField();
			fake3.setColumns(20);
			correct.setDocument(d3);
			newAPanel.add(fake3, fieldsCon);
			save.setActionCommand("saveMC");
			this.add(newAPanel);
		} else {
			answerArea = new TextArea("Answer:", "");
			save.setActionCommand("saveSA");
			this.add(answerArea);
		}	
		this.add(newAPanel);
		this.add(bPanel);
		this.setBorder(BorderFactory.createEmptyBorder(100, 100,
				100, 100));
		// newQuestionPanel.add(buttonPane);
		this.remove(newSAQuestionButton);
		this.revalidate();
	}

	// TODO return to home uses this getter to save bonus questions
	/**
	 * getter to access updated round array
	 * 
	 * @return
	 */
	public Round[] getRoundsArray() {
		return this.round;
	}

	/**
	 * makes tabbed panel to display old questions
	 */
	private void initQuestionPane() {
		questionPane = new JTabbedPane();
		questionPane.setTabPlacement(SwingConstants.LEFT);
		for (int i = totalRounds; i > 0; i--) {
			String tab = "Week " + Integer.toString(i);
			// TODO tab icon
			questionPane.addTab(tab, makeQPanel(i));
		}
		for (int i = currentRound; i < totalRounds; i++) {
			questionPane.setEnabledAt(totalRounds - i - 1, false);
		}
		questionPane.setSelectedIndex(totalRounds - currentRound);

	}

	/**
	 * makes scrollable panel showing the bonus questions for the round number
	 * that is supplied
	 * 
	 * @param rNumber
	 *            Round number to get bonus questions from round array
	 * @return a scrollable panel to add to each tab
	 */
	private JComponent makeQPanel(int rNumber) {
		// main panel vertical layout scrollable
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		JScrollPane sp = new JScrollPane(panel);

		BonusQuestion[] b;
		// get bonus question array
		// if no questions this round then display message
		try {
			b = round[rNumber - 1].getBonusQuestion();
			if (b == null || b.length == 0) {
				panel.add(new JLabel("No Questions This Round"));
				return panel;
			}
		} catch (NullPointerException e) {
			panel.add(new JLabel("No Questions This Round."));
			return panel;
		}
		// if there are questions add them to the panel
		try {
			for (int i = 0; i < b.length; i++) {
				QuestionPanel qp = new QuestionPanel(b[i],
						(currentRound == rNumber));
				panel.add(qp);
				// if panel is being made for the current round
				// add edit buttons to it
				if (currentRound == rNumber) {
					JPanel buttonPanel = new JPanel();
					buttonPanel.setLayout(new BoxLayout(buttonPanel,
							BoxLayout.X_AXIS));
					JButton update, cancel, delete;
					update = new JButton("Update");
					cancel = new JButton("Cancel");
					delete = new JButton("Delete");
					// pass question number to action listener
					update.setActionCommand("update");
					cancel.setActionCommand("cancel");
					delete.setActionCommand("delete");
					update.addActionListener(new ButtonListener(
							round[currentRound - 1], i + 1, qp, buttonPanel,
							panel, this));
					cancel.addActionListener(new ButtonListener(
							round[currentRound - 1], i + 1, qp, buttonPanel,
							panel, this));
					delete.addActionListener(new ButtonListener(
							round[currentRound - 1], i + 1, qp, buttonPanel,
							panel, this));
					buttonPanel.add(update);
					buttonPanel.add(cancel);
					buttonPanel.add(delete);

					panel.add(buttonPanel);
				}
			}
		} catch (NullPointerException e) {
		}
		return sp;

	}

	private void makeButtons() {
		newSAQuestionButton = new JButton("New Short Answer Question");
		newSAQuestionButton.addActionListener(this);
		newSAQuestionButton.setActionCommand("newSA");

		newMCQuestionButton = new JButton("New Multiple Choice Question");
		newMCQuestionButton.setActionCommand("newMC");
		newMCQuestionButton.addActionListener(this);
	}

	public void refresh() {
		this.removeAll();
		this.revalidate();
		this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		this.setBorder(BorderFactory.createEmptyBorder(10, 10,
				10, 10));
		initQuestionPane();
		this.add(questionPane);
		makeButtons();
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
		buttonPanel.add(newSAQuestionButton);
		buttonPanel.add(newMCQuestionButton);
		this.add(buttonPanel);
		this.revalidate();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		String cmd = arg0.getActionCommand();
		if (cmd.equals("newMC")) {
			addQuestion(true);
		} else if (cmd.equals("newSA")) {
			addQuestion(false);
		} else if (cmd.equals("saveMC")) {
			String[] answers, answersRandom;
			String cAnswer, question;
			cAnswer = correct.getText();
			question = questionArea.getText();
			answers = new String[4];
			answersRandom = new String[4];
			answers[0] = correct.getText();
			answers[1] = fake1.getText();
			answers[2] = fake2.getText();
			answers[3] = fake3.getText();
			// Check input lengths
			if (question.length() < 1 || answers[0].length() < 1 || answers[1].length() < 1
					|| answers[2].length() < 1 || answers[3].length() < 1) {
				Toolkit.getDefaultToolkit().beep();
				return;
			}
			// Randomize answers
			Random rand = new Random();
			int randomNumber = rand.nextInt(4);
			for (int i = 0; i < 4; i++) {
				answersRandom[(randomNumber + i) % 4] = answers[i];
			}
			// New Bonus Question to round and load current week tab
			BonusQuestion b = new BonusQuestion(question, answersRandom,
					cAnswer);
			round[currentRound - 1].addBonusQuestion(b);
			refresh();
		} else if (cmd.equals("saveSA")) {
			String[] answers;
			String cAnswer, question;
			cAnswer = ((TextArea) answerArea).getText();
			question = questionArea.getText();
			answers = new String[1];
			answers[0] = cAnswer;
			// Check input length
			if (answers[0].length() < 1) {
				Toolkit.getDefaultToolkit().beep();
				return;
			}
			// Add new bonus question to round
			BonusQuestion b = new BonusQuestion(question, answers, cAnswer);
			round[currentRound - 1].addBonusQuestion(b);
			refresh();
		} else if (cmd.equals("cancel")) {
			refresh();
		}

	}
}
