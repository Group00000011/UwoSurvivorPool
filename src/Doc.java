import java.awt.Toolkit;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

/**
 * Subclass of PlainDocument that limits the number of characters that can be 
 * added to the document. This can be attached to any text field to limit the 
 * number of characters that can be input into that field. When a user tries to 
 * type more characters into the field the computer will beep
 * 
 * V 1.0 04/01/12
 *  
 * @author Manor Freeman, Hazel Rivera, Martin Grabarczyk, Liam Corrigan, Jeff
 *         Westaway, Delerina Hill 
 *
 */
@SuppressWarnings("serial")
public class Doc extends PlainDocument {
	private int limit;

	/**
	 * Constructor to create a character limited document
	 * @param limit the maximum number (int) of characters that can be typed in this document.
	 */
	public Doc(int limit) {
		super();
		this.limit = limit;
	}

	/**
	 * Overwritten method for inserting characters into the document.
	 * now this method checks to make sure the total characters does not exceed 
	 * the limit. Extra characters are removed and the system beeps to indicate overflow
	 */
	public void insertString(int offset, String str, AttributeSet attr)
			throws BadLocationException {
		if (str == null)
			return;

		if ((getLength() + str.length()) <= limit) {
			super.insertString(offset, str, attr);
		} else {
			Toolkit.getDefaultToolkit().beep();
		}
	}
}