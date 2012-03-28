import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JPanel;


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

	public String getQuestion() {
		return question.getQuestion();
	}
}
