import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ResourceBundle;
import java.util.logging.Logger;

import javax.imageio.ImageIO;
import javax.swing.Action;
import javax.swing.ActionMap;
import javax.swing.JComponent;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;
import javax.swing.plaf.basic.BasicTabbedPaneUI;


public class CustomTabUI extends BasicTabbedPaneUI {
    private static final String TABBED_PANE_UI_LOGGER = "TabbedPaneUI";
    private static final Logger LOGGER = Logger.getLogger(TABBED_PANE_UI_LOGGER);

    private   int TAB_WIDTH = 0;
    private static  int TAB_HEIGHT = 40;

    private static BufferedImage tabSelectedPressed;
    private static BufferedImage tabSelected;
    private static BufferedImage tabRollover;
    private static BufferedImage tab;
    private static ResourceBundle bundle;
    private int tabPressed = -1;
    private int width;
    static {
        ResourceBundle bundle = getResourceBundle();
        try {
            tabSelectedPressed = ImageIO.read(
                    CustomTabUI.class.getResource(
                            bundle.getString("tabUI.tabSelectedPressed")));
            tabSelected = ImageIO.read(CustomTabUI.class.getResource(
                    bundle.getString("tabUI.tabSelected")));
            tabRollover = ImageIO.read(CustomTabUI.class.getResource(
                    bundle.getString("tabUI.tabRollover")));
            tab = ImageIO.read(CustomTabUI.class.getResource(
                    bundle.getString("tabUI.tab")));
        } catch (IOException e) {
            LOGGER.warning("Could not load SliderUI images");
        }
    }


    
    public CustomTabUI(int width) {
    	TAB_WIDTH = width;
    }

    @Override
    public void installUI(JComponent c) {
        JTabbedPane tabPane = (JTabbedPane) c;
        tabPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);

        // TODO Test on Windows, this is a Mac OS X workaround
        Constructor<?> constructor = null;
        try {
            Class<?> aClass = Class.forName(
                    "javax.swing.plaf.basic.BasicTabbedPaneUI$Actions");
            constructor = aClass.getDeclaredConstructor(String.class);
            constructor.setAccessible(true);
        } catch (ClassNotFoundException e) {
            getLogger().warning("Cannot access tabbed pane UI actions");
        } catch (NoSuchMethodException e) {
            getLogger().warning("Constructor does not exist");
        }

        if (constructor != null) {
            ActionMap map = tabPane.getActionMap();
            try {
                map.put("scrollTabsBackwardAction",
                    (Action) constructor.newInstance("scrollTabsBackwardAction"));
                map.put("scrollTabsForwardAction",
                        (Action) constructor.newInstance("scrollTabsForwardAction"));
            } catch (InstantiationException e) {
                getLogger().warning("Cannot instantiate action");
            } catch (IllegalAccessException e) {
                getLogger().warning("Action cannot be accessed");
            } catch (InvocationTargetException e) {
                getLogger().warning("Cannot instantiate action");
            }
        }

        super.installUI(c);
    }

    @Override
    protected void installDefaults() {
        UIManager.put("TabbedPane.tabAreaInsets", new Insets(0, 0, 0, 0));
        UIManager.put("TabbedPane.font",
                      ((Font) UIManager.get("TabbedPane.font")).deriveFont(Font.BOLD));
     
       /* UIManager.put("TabbedPane.font",
                new Font("Thoma",Font.BOLD,12));
*/
        UIManager.put("TabbedPane.contentBorderInsets", new Insets(0, 0, 0, 0));
        UIManager.put("TabbedPane.selectedTabPadInsets", new Insets(0, 0, 0, 0));

        super.installDefaults();
    }

    @Override
    protected void installListeners() {
        super.installListeners();

        tabPane.addMouseListener(new TabPressedTracker());
    }

    protected void paintText(Graphics g, int tabPlacement, Font font, FontMetrics metrics, int tabIndex, String title, Rectangle textRect, boolean isSelected){
        if ((isSelected)){
            super.paintText(g, tabPlacement, tabPane.getFont().deriveFont(Font.BOLD), metrics, tabIndex, title, textRect, isSelected);
        }else{
            super.paintText(g, tabPlacement, font, metrics, tabIndex, title, textRect, isSelected);
        }
    }
    
    @Override
    protected int calculateTabHeight(int tabPlacement, int tabIndex,
                                     int fontHeight) {
        return TAB_HEIGHT;
    }

    @Override
    protected int calculateMaxTabHeight(int tabPlacement) {
        return TAB_HEIGHT;
    }

    @Override
    protected int calculateTabWidth(int tabPlacement, int tabIndex,
                                    FontMetrics metrics) {
        return TAB_WIDTH;
    }

    @Override
    protected int calculateMaxTabWidth(int tabPlacement) {
        return TAB_WIDTH;
    }

    @Override
    protected int getTabRunIndent(int tabPlacement, int run) {
        return 0;
    }

    @Override
    protected void setRolloverTab(int index) {
        int oldIndex = getRolloverTab();
        super.setRolloverTab(index);

        if (oldIndex != index) {
            if (oldIndex != -1) {
                tabPane.repaint(getTabBounds(tabPane, oldIndex));
            }

            if (index != -1) {
                tabPane.repaint(getTabBounds(tabPane, index));
            }
        }
    }

    @Override
    protected int getTabLabelShiftX(int tabPlacement, int tabIndex,
                                    boolean isSelected) {
        return rects[tabIndex].width % 2;
    }

    @Override
    protected int getTabLabelShiftY(int tabPlacement, int tabIndex,
                                    boolean isSelected) {
        return 0;
    }

    @Override
    public void paint(Graphics g, JComponent c) {
        int tabPlacement = tabPane.getTabPlacement();
    Graphics2D g2d = (Graphics2D)g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING , RenderingHints.VALUE_ANTIALIAS_ON);
    	
        Insets insets = c.getInsets();
        Dimension size = c.getSize();

        if (tabPane.getTabPlacement() == TOP) {
            g2d.drawImage(tab, insets.left, insets.top,
                        size.width - insets.right - insets.left,
                        calculateTabAreaHeight(tabPlacement, runCount,
                                               maxTabHeight),
                        null);
        }
       /*System.out.println("Tab Height"+calculateTabAreaHeight(tabPlacement, runCount,
               maxTabHeight));*/
        super.paint(g2d, c);
    }

    @Override
    protected void paintTabBackground(Graphics g, int tabPlacement,
                                      int tabIndex, int x, int y, int w, int h,
                                      boolean isSelected) {
        BufferedImage background;
        Graphics2D g2d = (Graphics2D)g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING , RenderingHints.VALUE_ANTIALIAS_ON);
    
        if (isSelected) {
            if (tabPressed == tabIndex) {
                background = tabSelectedPressed;
            } else {
                background = tabSelected;
            }
        } else {
            if (getRolloverTab() == tabIndex) {
                background = tabRollover;
            } else {
                background = tab;
            }
        }

        if (x < 0) {
            x = 0;
        }

        if (y < 0) {
            y = 0;
        }
        // draw background
        g2d.drawImage(background, x , y, TAB_WIDTH, TAB_HEIGHT, null);
    }

    private class TabPressedTracker extends MouseAdapter {
        @Override
        public void mousePressed(MouseEvent e) {
            if (!tabPane.isEnabled()) {
                return;
            }

            tabPressed = tabForCoordinate(tabPane, e.getX(), e.getY());
            if (tabPressed != -1) {
                tabPane.repaint(getTabBounds(tabPane, tabPressed));
            }
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            int oldTabPressed = tabPressed;
            tabPressed = -1;
            if (oldTabPressed != -1) {
                tabPane.repaint(getTabBounds(tabPane, oldTabPressed));
            }
        }
    }

    // Methods below are overriden to get rid of the painting

    @Override
    protected void paintFocusIndicator(Graphics g, int tabPlacement,
                                       Rectangle[] rects, int tabIndex,
                                       Rectangle iconRect, Rectangle textRect,
                                       boolean isSelected) {
    }

    @Override
    protected void paintTabBorder(Graphics g, int tabPlacement, int tabIndex,
                                  int x, int y, int w, int h,
                                  boolean isSelected) {
    }

    @Override
    protected void paintContentBorder(Graphics g, int tabPlacement,
                                      int selectedIndex) {
    }

    private static Logger getLogger() {
        return LOGGER;
    }
    public static synchronized ResourceBundle getResourceBundle() {
        if (bundle == null) {
            bundle = ResourceBundle.getBundle("messages");
        }
        return bundle;
    }
}