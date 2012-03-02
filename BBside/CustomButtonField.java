import net.rim.device.api.ui.Color;
import net.rim.device.api.ui.Field;
import net.rim.device.api.ui.Font;
import net.rim.device.api.ui.Graphics;

/**
 * CustomButtonField creates customized buttons
 * 
 * @author Manor Freeman, Hazel Rivera, Martin Grabarczyk, Liam Corrigan, Jeff
 *         Westaway, Delerina Hill
 * @version 1.0
 */
public class CustomButtonField extends Field {
	// Attributes
	private int backgroundColour = Color.GRAY;
	private int highlightColour;
	private int fieldWidth;
	private int fieldHeight;
	private String text;
	private int padding = 8;

	/**
	 * Constructor for CustomButtonField
	 * 
	 * @param text
	 *            Text that is shown on button
	 * @param highlightColour
	 *            Integer specifying color of button when scrolled over
	 * @param width
	 *            Width of button
	 */
	public CustomButtonField(String text, int highlightColour, int width) {
		super(Field.FOCUSABLE);
		this.text = text;
		this.highlightColour = highlightColour;
		Font defaultFont = Font.getDefault();
		fieldHeight = defaultFont.getHeight() + padding;
		fieldWidth = width + (padding * 2);
		this.setPadding(2, 2, 2, 2);
	}

	/**
	 * Method invoked when navigational action is selected on button
	 * 
	 * @param status
	 *            Bitfield of values defined by KeypadListener
	 * @param time
	 *            Number of milliseconds since device was turned on
	 */
	protected boolean navigationClick(int status, int time) {
		fieldChangeNotify(1);
		return true;
	}

	/**
	 * Method invoked when the field recieves the focus
	 * 
	 * @param direction
	 *            Indicates from which direction focus enters field
	 */
	protected void onFocus(int direction) {
		// highlight button when button is in focus
		backgroundColour = highlightColour;
		invalidate();
	}

	/**
	 * Method invoked when the field loses focus
	 */
	protected void onUnfocus() {
		// return button color to gray on unfocus
		backgroundColour = Color.GRAY;
		invalidate();
	}

	/**
	 * Method that returns the fields preferred width
	 * 
	 * @return Preferred width in pixels
	 */
	public int getPreferredWidth() {
		return fieldWidth;
	}

	/**
	 * Retrieves the fields preferred height
	 * 
	 * @return Preferred height for field in pixels
	 */
	public int getPreferredHeight() {
		return fieldHeight;
	}

	/**
	 * Lays out fields contents
	 * 
	 * @param width
	 *            Amount of available horizontal space
	 * @param height
	 *            Amount of available vertical space
	 */
	protected void layout(int width, int height) {
		setExtent(getPreferredWidth(), getPreferredHeight());
	}

	/**
	 * Draws focus indicator for this field
	 * 
	 * @param graphics
	 *            Graphics context for drawing the focus
	 * @param on
	 *            True if focus should be set; otherwise, false
	 */
	protected void drawFocus(Graphics graphics, boolean on) {

	}

	/**
	 * Invokes action listener for field when a change event occurs
	 * 
	 * @param context
	 *            Information specifying the origin of the change
	 */
	protected void fieldChangeNotify(int context) {
		try {
			this.getChangeListener().fieldChanged(this, context);
		} catch (Exception e) {
		}
	}

	/**
	 * Method invoked by framework to redraw this field
	 * 
	 * @param graphics
	 *            Graphics context for drawing in this field
	 */
	protected void paint(Graphics graphics) {
		graphics.setColor(backgroundColour);
		graphics.fillRoundRect(0, 0, fieldWidth, fieldHeight, 8, 8);
		graphics.setColor(Color.GRAY);
		graphics.drawRoundRect(0, 0, fieldWidth, fieldHeight, 8, 8);
		graphics.setColor(Color.WHITE);
		graphics.drawText(text, padding - 1, padding / 2 + 1);
	}
}
