import net.rim.device.api.ui.component.ButtonField;

class MyButtonField extends ButtonField
{
    private int width;

    MyButtonField( String label, int Width)
    {   super( label);
        width = Width;
    }
    public int getPreferredWidth()
    {   return width;
    }
}