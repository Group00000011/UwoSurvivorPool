import net.rim.device.api.ui.component.ButtonField;

/**
 * MyButtonField class creates buttons of a specified width
 * 
 * @author Manor Freeman, Hazel Rivera, Martin Grabarczyk, Liam Corrigan, Jeff
 *         Westaway, Delerina Hill
 * @version 1.0
 * 
 */
public class MyButtonField extends ButtonField {
	// Attributes
	private int width;

	/**
	 * Contstructor for MyButtonFieldObject
	 * 
	 * @param label
	 *            String that will be displayed on button
	 * @param Width
	 *            Width of button
	 */
	MyButtonField(String label, int Width) {
		super(label);
		width = Width;
	}

	/**
	 * Returns width of MyButtonField object
	 * 
	 * @return width of button
	 */
	public int getPreferredWidth() {
		return width;
	}
}