import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Custom JPanel to display the four possible answers for a multiple choice question.
 * The correct answer is highlighted by a green background. Text can be made editable 
 * to modify/update a question.
 * 
 * @author Manor Freeman, Hazel Rivera, Martin Grabarczyk, Liam Corrigan, Jeff
 *         Westaway, Delerina Hill V 1.0 02/18/12
 * 
 */
@SuppressWarnings("serial")
public class MCAnswerArea extends JPanel {
	// CONSTANTS
	private static final int MAX_CHARACTERS = 200;
	// FIELDS
	private JLabel header;
	private JTextField a1, a2, a3, a4;
	private Doc d1, d2, d3, d4;
	private JPanel answerBox, row1, row2;
	private String correctAnswer;
	private String answers[];
	private BonusQuestion question;

	/**
	 * Constructor creates an answer area. The bonus question passed in must be a 
	 * multiple choice and contain atleast 4 answers.
	 * @param title <code>String</code> to set as the title to this answer area
	 * @param q <code>BonusQuestion</code> to display answers from. 
	 */
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

	/**
	 * Sets the correct answer
	 * @param answer <code>String</code> to set as the new correct answer
	 */
	public void setCorrectAnswer(String answer) {
		this.correctAnswer = answer.trim();
	}

	/**
	 * checks to make sure a <code>String</code> is less than or equal to
	 * MAX_CHARACTERS and shortens it if it is too long
	 * @param testString <code>String</code> whose length to test
	 * @return the <code>String</code> with leading and trailing zeros removed and shortened if need be.
	 */
	private String testLength(String testString) {
		testString = testString.trim();
		if (testString.length() > MAX_CHARACTERS) {
			testString = testString.substring(0, MAX_CHARACTERS - 1);
		}
		return testString;
	}

	/**
	 * Sets the four answer text fields and highlights the correct answer
	 * @param answers <code>String</code> array containing four answers
	 */
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

	/**
	 * sets weather or not text fields are editable
	 * @param canEdit <code>boolean</code> true to set the fields editable, false otherwise.
	 */
	public void setEditable(boolean canEdit) {
		a1.setEditable(canEdit);
		a2.setEditable(canEdit);
		a3.setEditable(canEdit);
		a4.setEditable(canEdit);

		this.revalidate();
	}

	/**
	 * gets the correct answer
	 * @return <code>String</code> of correct answer
	 */
	public String getCorrectAnswer() {
		getFields();
		return correctAnswer;
	}

	/**
	 * gets the array of answers (three fake and one real)
	 * @return array of <code>String</code> answers
	 */
	public String[] getAnswers() {
		getFields();
		return answers;
	}

	/**
	 * gets the <code>String</code> from each field to refresh answer fields. 
	 * Sets each textfield's text into the answers array. 
	 * Also checks for the correct answer field and sets the 
	 * correctAnswer field accordingly
	 */
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
