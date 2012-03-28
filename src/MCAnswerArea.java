import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;

public class MCAnswerArea extends JPanel {

	private static final int MAX_CHARACTERS = 200;
	private static final int MAX_QUESTIONS = 4;
	private JLabel header;
	private JTextField a1, a2, a3, a4;
	private Doc d1, d2, d3, d4;
	private JPanel answerBox, row1, row2;
	private String correctAnswer;
	private String answers[];
	private BonusQuestion question;

	public MCAnswerArea(String title, BonusQuestion q) {
		super(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		question = q;
		answers = new String[4];
		
		// Add Title
		header = new JLabel();
		header.setText(title);
		c.gridwidth = GridBagConstraints.REMAINDER;
		c.fill = GridBagConstraints.HORIZONTAL;
		add(header, c);

		// Add Body
		answerBox = new JPanel();
		answerBox.setLayout(new BoxLayout(answerBox, BoxLayout.Y_AXIS));

		row1 = new JPanel();
		row2 = new JPanel();
		row1.setLayout(new BoxLayout(row1, BoxLayout.X_AXIS));
		row2.setLayout(new BoxLayout(row2, BoxLayout.X_AXIS));
		answerBox.add(row1);
		answerBox.add(row2);

		a1 = new JTextField(20);
		a2 = new JTextField(20);
		a3 = new JTextField(20);
		a4 = new JTextField(20);

		d1 = new Doc(MAX_CHARACTERS);
		d2 = new Doc(MAX_CHARACTERS);
		d3 = new Doc(MAX_CHARACTERS);
		d4 = new Doc(MAX_CHARACTERS);
		
		row1.add(a1);
		row1.add(a2);
		row2.add(a3);
		row2.add(a4);

		a1.setDocument(d1);
		a2.setDocument(d2);
		a3.setDocument(d3);
		a4.setDocument(d4);
		
		setCorrectAnswer(question.getCorrectAnswer());
		setAnswers(question.getAnswers());
			
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 1.0;
		c.weighty = 1.0;
		add(answerBox, c);

		revalidate();
	}

	public void setCorrectAnswer(String answer) {
		this.correctAnswer = answer.trim();
	}

	private String testLength(String testString) {
		testString = testString.trim();
		if (testString.length() > MAX_CHARACTERS) {
			testString = testString.substring(0, MAX_CHARACTERS - 1);
		}
		return testString;
	}

	public void setAnswers(String answers[]) {
		this.answers = answers;
		a1.setText(testLength(answers[0]));
		a2.setText(testLength(answers[1]));
		a3.setText(testLength(answers[2]));
		a4.setText(testLength(answers[3]));
		if (a1.getText().equalsIgnoreCase(correctAnswer)) {
			a1.setBackground(Color.GREEN);
			a2.setBackground(Color.LIGHT_GRAY);
			a3.setBackground(Color.LIGHT_GRAY);
			a4.setBackground(Color.LIGHT_GRAY);
		} else if (a2.getText().equalsIgnoreCase(correctAnswer)) {
			a1.setBackground(Color.LIGHT_GRAY);
			a2.setBackground(Color.GREEN);
			a3.setBackground(Color.LIGHT_GRAY);
			a4.setBackground(Color.LIGHT_GRAY);
		} else if (a3.getText().equalsIgnoreCase(correctAnswer)) {
			a1.setBackground(Color.LIGHT_GRAY);
			a2.setBackground(Color.LIGHT_GRAY);
			a3.setBackground(Color.GREEN);
			a4.setBackground(Color.LIGHT_GRAY);
		} else {
			a1.setBackground(Color.LIGHT_GRAY);
			a2.setBackground(Color.LIGHT_GRAY);
			a3.setBackground(Color.LIGHT_GRAY);
			a4.setBackground(Color.GREEN);
		}

		this.revalidate();
	}

	public void setEditable(boolean canEdit) {
		a1.setEditable(canEdit);
		a2.setEditable(canEdit);
		a3.setEditable(canEdit);
		a4.setEditable(canEdit);

		this.revalidate();
	}

	public String getCorrectAnswer() {
		getFields();
		return correctAnswer;
	}

	public String[] getAnswers() {
		getFields();
		return answers;
	}
	
	private void getFields() {
		if (a1.getBackground() == Color.GREEN) {
			setCorrectAnswer(a1.getText());
		} else if (a2.getBackground() == Color.GREEN) {
			setCorrectAnswer(a2.getText());
		} else if (a3.getBackground() == Color.GREEN) {
			setCorrectAnswer(a3.getText());
		} else {
			setCorrectAnswer(a4.getText());
		}
		answers[0] = a1.getText();
		answers[1] = a2.getText();
		answers[2] = a3.getText();
		answers[3] = a4.getText();
	}
}
