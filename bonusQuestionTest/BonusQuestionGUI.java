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
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

public class BonusQuestionGUI extends JPanel {

	private int currentRound, totalRounds;
	private Round[] rounds;

	private JTextField qField;
	private JTextField aField;
	private JTextField wField;

	private JLabel question;
	private JLabel answer;
	private JLabel fakeAnswer;

	private JTabbedPane questionPane;

	private JButton newButton;

	JPanel newQuestionPanel;

	public BonusQuestionGUI(Round[] rounds, int currentRound) {
		super();
		this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		this.newQuestionPanel = new JPanel();
		newQuestionPanel.setLayout(new BoxLayout(newQuestionPanel, BoxLayout.Y_AXIS));
		this.rounds = rounds;
		this.totalRounds = rounds.length;// TODO get total rounds
		this.currentRound = currentRound;// TODO get current round

		initQuestionPane();
		this.add(questionPane);

		this.newButton = new JButton("Add Question");
		newButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				addQuestion();
			}
		});

		this.add(newButton);
		// makeNewQuestionButton();
		// add(newQuestionButton);
	}

	public void refresh() {
		this.remove(newQuestionPanel);
		this.newButton = new JButton("Add Question");
		newButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				addQuestion();
			}
		});
		this.remove(questionPane);
		initQuestionPane();
		this.add(questionPane);
		this.add(newButton);
		this.revalidate();
	}
	public void addQuestion() {
		newQuestionPanel = new JPanel();
		newQuestionPanel.setLayout(new BoxLayout(newQuestionPanel, BoxLayout.Y_AXIS));
		// Create Labels
		question = new JLabel(" Question:");
		answer = new JLabel(" Answer:");
		fakeAnswer = new JLabel(" Fake Answer:"); // TODO implement MC/SHORt answer
		// Create the text fields/areas & set them up
		qField = new JTextField();
		qField.setColumns(20);
		aField = new JTextField();
		aField.setColumns(20);
		wField = new JTextField();
		wField.setColumns(20);
		// Tell accessibility tools about label/textfield & area pairs
		question.setLabelFor(qField);
		answer.setLabelFor(aField);
		fakeAnswer.setLabelFor(wField);

		// Layout the text fields/area in a panel
		newQuestionPanel.add(question);
		newQuestionPanel.add(qField);
		newQuestionPanel.add(answer);
		newQuestionPanel.add(aField);
		newQuestionPanel.add(fakeAnswer);
		newQuestionPanel.add(wField);

		// Create the buttons
		JButton enterButton = new JButton("Enter");
		enterButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String q, a, w;
				q = qField.getText();
				a = aField.getText();
				w = wField.getText();
				if (q.length() < 1 || q.length() > 200) {
					qField.setText("");
					JOptionPane
							.showMessageDialog(null,
									"The Question Must be between 1 and 200 characters", "Error",JOptionPane.INFORMATION_MESSAGE); 
					// TODO make better
				} else if (a.length() < 1 || a.length() > 200) {
					aField.setText("");
					JOptionPane.showMessageDialog(null,
							"The answer must be between 1 and 200 characters", "Error", JOptionPane.INFORMATION_MESSAGE); 
				} else if (w.length() < 1 || w.length() > 200) {
					wField.setText("");
					JOptionPane.showInputDialog(null,
							"The answer must be between 1 and 200 characters", "Error", JOptionPane.INFORMATION_MESSAGE); 
				} else {
					BonusQuestion b = new BonusQuestion(q,
							new String[] { a, w }, a);
					rounds[currentRound-1].addBonusQuestion(b);
					refresh();

				}
			}

		});
		// JButton cancelButton = new JButton("Cancel");
		// Layout the buttons in a panel
		JPanel buttonPane = new JPanel(new FlowLayout(FlowLayout.CENTER));
		buttonPane.add(enterButton);
		// buttonPane.add(cancelButton);

		// right, buttons on the bottom
		newQuestionPanel.setBorder(BorderFactory.createEmptyBorder(100, 100, 100, 100));
		newQuestionPanel.add(buttonPane);
		this.remove(newButton);
		this.add(newQuestionPanel);
		this.revalidate();
	}

	private JComponent makeTextPanel(int rNumber) {
		String text = "No Questions This Round";
		JPanel panel = new JPanel(false);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		try {
			BonusQuestion[] b = rounds[rNumber - 1].getBonusQuestion();
			int i = 0;
			if (b[i] == null) {
				JLabel textLabel = new JLabel(text);
				panel.add(textLabel);
			} else {
				while (b[i] != null) {
					text = "QUESTION " + (i + 1) + ":";
					panel.add(new JLabel(text));
					text = b[i].getQuestion();
					panel.add(new JLabel(text));
					text = "ANSWER:";
					panel.add(new JLabel(text));
					text = b[i].getCorrectAnswer();
					panel.add(new JLabel(text));
					text = "";
					panel.add(new JLabel(text));
					text = "	";
					panel.add(new JLabel(text));
					i++;
				}
			}
		} catch (Exception e) {
			panel.add(new JLabel(text));
		}
		return panel;
	}

	private void initQuestionPane() {
		questionPane = new JTabbedPane();
		questionPane.setTabPlacement(JTabbedPane.LEFT);
		for (int i = totalRounds; i > 0; i--) {
			String tabName = "Week " + Integer.toString(i);
			// TODO tab icon
			questionPane.addTab(tabName, makeTextPanel(i));
		}
		for (int i = currentRound; i < totalRounds; i++) {
			questionPane.setEnabledAt(totalRounds - i - 1, false);
		}
		questionPane.setSelectedIndex(totalRounds - currentRound);

	}

}