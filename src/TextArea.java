import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.text.BadLocationException;

/**
 * Custom titled text area packed into a JPanel. Text area has an input
 * character limit.
 * 
 * @author Manor Freeman, Hazel Rivera, Martin Grabarczyk, Liam Corrigan, Jeff
 *         Westaway, Delerina Hill V 1.0 02/18/12
 * 
 */
@SuppressWarnings("serial")
public class TextArea extends JPanel {

	private static final int MAX_CHARACTERS = 200;
	private JLabel header;
	private JTextArea body;
	private JScrollPane scrollPane;
	private Doc document;

	/**
	 * Constructor to create 
	 * @param title <code>String</code> to set as the title of panel
	 * @param text	<code>String</code> to set as the body of the JTextArea
	 */
	public TextArea(String title, String text) {
		super(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();

		// Add Title
		header = new JLabel();
		header.setText(title);
		c.gridwidth = GridBagConstraints.REMAINDER;
		c.fill = GridBagConstraints.HORIZONTAL;
		add(header, c);

		// Add Body
		body = new JTextArea(text, 5, 30);
		document = new Doc(MAX_CHARACTERS);
		body.setDocument(document);
		body.setWrapStyleWord(true);
		body.setLineWrap(true);  
		body.setText(text);
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 1.0;
		c.weighty = 1.0;
		scrollPane = new JScrollPane(body);
		add(scrollPane, c);

	}

	/**
	 * sets the text in the JTextArea
	 * @param	text <code> String </code> that you want to change the text to
	 */
	public void setText(String text) {
		text = text.trim();
		if (text.length() > MAX_CHARACTERS) {
			text = text.substring(0, MAX_CHARACTERS - 1);
		}
		Doc d = new Doc(MAX_CHARACTERS);
		try {
			d.insertString(0, text, null);
		} catch (BadLocationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		body.setDocument(d);
		body.revalidate();
		this.revalidate();
	}
	
	/**
	 * Method sets whether you can edit the JTextArea in this panel
	 * @param	canEdit <code> boolean </code> true to make JTextArea editable. False to disable editing
	 */
	public void setEditable(boolean canEdit) {
		body.setEditable(canEdit);
		this.revalidate();
	}
	
	/**
	 * Gets the text from the JTextArea
	 * @return	text <code>String</code> of text from JTextArea
	 */
	public String getText() {
		try {
			return body.getDocument().getText(0, body.getDocument().getLength());
		} catch (BadLocationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "";
		}
	}
}
