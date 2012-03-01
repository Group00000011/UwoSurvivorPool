import net.rim.device.api.system.Bitmap;
import net.rim.device.api.system.Display;
import net.rim.device.api.ui.*;
import net.rim.device.api.ui.component.*;
import net.rim.device.api.ui.component.table.*;
import net.rim.device.api.ui.container.*;
import net.rim.device.api.ui.decor.BackgroundFactory;
import net.rim.device.api.ui.decor.Border;
import net.rim.device.api.ui.decor.BorderFactory;


public class PickContestantScreen extends MainScreen implements FieldChangeListener {
       private ButtonField backButton;
       private ButtonField exitButton;
       private BitmapField logoBitmapField;
       
       private RegionStyles _style;
       private TableModel _tableModel;
       private TableView _tableView;
       private TableController _controller;    

       private static final int NUM_ROWS = 4;    
       private static final int NUM_COLUMNS = 3;
       private static final int IMAGE_WIDTH = 50;
       
       private String modelNum[] = {"8100", "8220", "8300", "8330", "8700g", "8800", "9000", "9500"};
       private String modelName[] = {"Pearl", "Pearl Flip", "Curve", "Curve", "8700g", "8800", "Bold", "Storm"};
       private String osVersion[] = {"4.3", "4.6", "4.5", "4.6", "4.1", "4.2.1", "4.6", "4.7"};
       private String deviceYear[] = {"2006", "2008", "2008", "2008", "2005","2007", "2008", "2008"};
       private String deviceInterface[] = {"keyboard/trackball", "keyboard/trackball", "keyboard/trackball",
           "keyboard/trackball", "keyboard", "keyboard/trackball", "keyboard/trackball", "keyboard/trackball/touch"};
       
       
       public PickContestantScreen() {
    	   	  /*super(Manager.NO_VERTICAL_SCROLL);
              
    	      Bitmap logoBitmap = Bitmap.getBitmapResource("PC.png");
              logoBitmapField = new BitmapField(logoBitmap, Field.FIELD_HCENTER);
              add(logoBitmapField);
              
              
              setTitle("Table Model Demo");

              _style = new RegionStyles(BorderFactory.createSimpleBorder(new XYEdges(1, 1, 1, 1), Border.STYLE_SOLID), null,
                              null, null, RegionStyles.ALIGN_LEFT, RegionStyles.ALIGN_MIDDLE);

              _tableModel = new TableModel();

              _tableView = new TableView(_tableModel);
              _tableView.setDataTemplateFocus(BackgroundFactory.createLinearGradientBackground(Color.WHITE, Color.WHITE, 
                  Color.BLUEVIOLET, Color.BLUEVIOLET));
              _controller = new TableController(_tableModel, _tableView);
              _tableView.setController(_controller);

              setStyle();

              add(new LabelField("BlackBerry Devices", LabelField.FIELD_HCENTER));
              add(new SeparatorField());
              add(_tableView);

              for(int i = 0; i < modelName.length; i++)
              {
                 String imageFileName = modelNum[i] + ".png";
                 Bitmap bitmap = Bitmap.getBitmapResource(imageFileName);

                 StringBuffer displayName = new StringBuffer(modelNum[i]);

                 if(!modelName[i].equals(modelNum[i]))
                 {
                     displayName.append(" (");
                     displayName.append(modelName[i]);
                     displayName.append(")");
                 }

                  _tableModel.addRow(new Object[] {bitmap, displayName.toString(), osVersion[i], deviceYear[i], deviceInterface[i]});
              }*/

              
    	   
    	   	  backButton = new ButtonField("Back");
              exitButton = new ButtonField("Quit");
              backButton.setChangeListener(this);
              exitButton.setChangeListener(this);
              this.add(backButton);
              this.add(exitButton);
       }
       /*
       public void setStyle()
       {
           DataTemplate dataTemplate = new DataTemplate(_tableView, NUM_ROWS, NUM_COLUMNS)
           {
               public Field[] getDataFields(int modelRowIndex)
               {
                   Object[] data = (Object[]) _tableModel.getRow(modelRowIndex);
                   Field[] fields = new Field[data.length];
                   for(int i = 0; i < data.length; i++)
                   {
                       if(data[i] instanceof Bitmap)
                       {
                           fields[i] = new BitmapField((Bitmap) data[i]);
                       }
                       else if(data[i] instanceof String)
                       {
                           fields[i] = new LabelField(data[i], Field.FOCUSABLE);
                       }
                       else
                       {
                           fields[i] = (Field) data[i];
                       }
                   }

                   return fields;
               }
           };

           dataTemplate.createRegion(new XYRect(0, 1, 1, 3), _style);

           dataTemplate.createRegion(new XYRect(0, 0, 2, 1), _style);
           dataTemplate.setRowProperties(0, new TemplateRowProperties(Font.getDefault().getHeight() + 
               (_style.getBorder() == null ? 0 : _style.getBorder().getTop() + _style.getBorder().getBottom()) +
               (_style.getMargin() == null ? 0 : _style.getMargin().top + _style.getMargin().bottom)));

           for(int i = 1; i < NUM_ROWS; i++)
           {
               dataTemplate.createRegion(new XYRect(1, i, 1, 1), _style);
               dataTemplate.setRowProperties(i, new TemplateRowProperties(Font.getDefault().getHeight() +
                   (_style.getBorder() == null ? 0 : _style.getBorder().getTop() + _style.getBorder().getBottom()) +
                   (_style.getMargin() == null ? 0 : _style.getMargin().top + _style.getMargin().bottom)));
           }

           int width = IMAGE_WIDTH + (_style.getBorder() == null ? 0 : _style.getBorder().getTop() + _style.getBorder().getBottom()) +
               (_style.getMargin() == null ? 0 : _style.getMargin().top + _style.getMargin().bottom);
           dataTemplate.setColumnProperties(0, new TemplateColumnProperties(width));

           dataTemplate.setColumnProperties(1, new TemplateColumnProperties(Display.getWidth() - width));

           _tableView.setDataTemplate(dataTemplate);
           dataTemplate.useFixedHeight(true);
       }*/
       
       public void fieldChanged(Field field, int context) {
              if (field == backButton) {
                  UiApplication.getUiApplication().popScreen(UiApplication.getUiApplication().getActiveScreen());
              }
              if (field == exitButton){
            	  System.exit(0);
              }
       }
}
