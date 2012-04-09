import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

/**
 * Custom JPanel to display a bonus question.
 * One of these panel is created for each bonus question. The panel 
 * displays the question and answer(s) with headings.
 * If the question is multiple choice the correct answer will be 
 * displayed along side three fake answers but will be highlighted in 
 * green.
 * 
 * @author Manor Freeman, Hazel Rivera, Martin Grabarczyk, Liam Corrigan, Jeff
 *         Westaway, Delerina Hill V 1.0 02/18/12
 * 
 */
@SuppressWarnings("serial")
public class QuestionPanel extends JPanel {
	// CONSTANTS
	private final static String Q_TITLE = "QUESTION:", A_TITLE = "ANSWER:";
	private static final int PANEL_HEIGHT = 300;
	private static final int PANEL_WIDTH = 200;
	
	// FILEDS
	private JPanel aArea;
	private TextArea qArea;
	private BonusQuestion question;
	private boolean isMC;
	
	// CONSTRUCTOR
	/**
	 * Constructor makes a panel to display a bonus question. 
	 * The panel's text areas can be set to editable.
	 * 
	 * @param q <code>BonusQuestion</code> to display.
	 * @param canEdit <code>boolean</code> true makes text fields editable
	 */
	public QuestionPanel(BonusQuestion q, boolean canEdit) {
		super();
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
		this.setMaximumSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
		this.setMinimumSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));

		question = q;
		isMC = question.isMultipleChoice();
		
		// create question area
		qArea = new TextArea(Q_TITLE, question.getQuestion());
		qArea.setText(question.getQuestion());
		((TextArea) qArea).setEditable(canEdit);
		this.add(qArea);
		
		// Create answer area
		if (isMC) {
			aArea = new MCAnswerArea(A_TITLE, question);
			((MCAnswerArea) aArea).setEditable(canEdit);
			this.add(aArea);
		} else {
			aArea = new TextArea(A_TITLE, question.getCorrectAnswer());
			((TextArea) aArea).setText(question.getCorrectAnswer());
			((TextArea) aArea).setEditable(canEdit);
			this.add(aArea);
		}
	}
	
	/**
	 * gets text from question and answer text fields and updates the BonusQuestion variable
	 * using those fields.
	 * 
	 * @return <code>BonusQuestion</code> object updated to match the TextAreas
	 */
	public BonusQuestion update() {
		question.setQuestion(qArea.getText());
		if (isMC) {
			question.setCorrectAnswer(((MCAnswerArea) aArea).getCorrectAnswer());
			question.setAnswers(((MCAnswerArea) aArea).getAnswers());
		}
		else {
			question.setCorrectAnswer(((TextArea) aArea).getText());
			question.setAnswers(new String[]{((TextArea) aArea).getText()});
		}
		return question;
	}
	
	/**
	 * resets the question and answer text fields to match the BonusQuestion variable.
	 * ie. gets question and answer(s) from BonusQuestion and displays them.
	 * 
	 */
	public void discardChanges() {
		qArea.setText(question.getQuestion());
		if (isMC) {
			((MCAnswerArea) aArea).setAnswers(question.getAnswers());
			((MCAnswerArea) aArea).setCorrectAnswer(question.getCorrectAnswer());
		}
		else {
			((TextArea) aArea).setText(question.getCorrectAnswer());
		}
	}

	/**
	 * Gets the question <code>String</code> from the bonus question field 
	 * @return	the question as a <code>String</code>
	 */
	public String getQuestion() {
		return question.getQuestion();
	}
}
