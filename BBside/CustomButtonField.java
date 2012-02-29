import net.rim.device.api.ui.Color;
import net.rim.device.api.ui.Field;
import net.rim.device.api.ui.Font;
import net.rim.device.api.ui.Graphics;

public class CustomButtonField extends Field
{

    private int backgroundColour = Color.GRAY;
    private int highlightColour;
    private int fieldWidth;
    private int fieldHeight;
    private String text;
    private int padding = 8;

    public CustomButtonField(String text, int highlightColour, int width)
    {
        super(Field.FOCUSABLE);
        this.text = text;
        this.highlightColour = highlightColour;
        Font defaultFont = Font.getDefault();
        fieldHeight = defaultFont.getHeight() + padding;
        fieldWidth = width + (padding * 2);
        this.setPadding(2, 2, 2, 2);
    }

    protected boolean navigationClick(int status, int time)
    {
        fieldChangeNotify(1);
        return true;
    }

    protected void onFocus(int direction)
    {
        backgroundColour = highlightColour;
        invalidate();
    }

    protected void onUnfocus()
    {
        backgroundColour = Color.GRAY;
        invalidate();
    }

    public int getPreferredWidth()
    {
        return fieldWidth;
    }

    public int getPreferredHeight()
    {
        return fieldHeight;
    }

    protected void layout(int arg0, int arg1)
    {
        setExtent(getPreferredWidth(), getPreferredHeight());
    }

    protected void drawFocus(Graphics graphics, boolean on)
    {

    }

    protected void fieldChangeNotify(int context)
    {
        try
        {
            this.getChangeListener().fieldChanged(this, context);
        }
        catch (Exception e)
        {}
    }

    protected void paint(Graphics graphics)
    {
        graphics.setColor(backgroundColour);
        graphics.fillRoundRect(0, 0, fieldWidth, fieldHeight, 8, 8);
        graphics.setColor(Color.GRAY);
        graphics.drawRoundRect(0, 0, fieldWidth, fieldHeight, 8, 8);
        graphics.setColor(Color.WHITE);
        graphics.drawText(text, padding - 1, padding / 2 + 1);
    }
}

