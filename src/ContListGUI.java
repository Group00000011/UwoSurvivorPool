import java.awt.*;
import java.awt.event.*;
import java.util.*;

import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.table.*;


public class ContListGUI extends JFrame{

private static final int WIDTH = 850;
private static final int HEIGHT = 400;
protected JTable table = new JTable();

protected MyTableModel tableModel;

protected JLabel titleLabel = new JLabel("Click table header to sort the column.");

public ContListGUI() {
  super();
  add(createContestantList());
//  setSize(600, 300);
//
//  tableModel = new MyTableModel();
//
//  getContentPane().add(titleLabel, BorderLayout.NORTH);
//  table.setModel((TableModel) tableModel);
//
//  JTableHeader header = table.getTableHeader();
//  header.setUpdateTableInRealTime(true);
//  header.addMouseListener(tableModel.new ColumnListener(table));
//  header.setReorderingAllowed(true);
//
//  JScrollPane ps = new JScrollPane();
//  ps.getViewport().add(table);
//  getContentPane().add(ps, BorderLayout.CENTER);
//
//  WindowListener wndCloser = new WindowAdapter() {
//    public void windowClosing(WindowEvent e) {
//      System.exit(0);
//    }
//  };
//  addWindowListener(wndCloser);
//  setVisible(true);
}

public JComponent createContestantList() {
	JPanel contListPanel = new JPanel();
	
	MyTableModel contTable = new MyTableModel();
	
	JTable table = new JTable(contTable);
	
	table.setPreferredScrollableViewportSize(new Dimension(WIDTH,HEIGHT));
	table.setFillsViewportHeight(true);
	table.setAutoCreateRowSorter(true);
	table.setRowHeight(77);
	
	table.setFont(new Font("Viner Hand ITC",Font.PLAIN,18));
	table.setForeground(Color.BLUE);
	table.setSelectionForeground(Color.RED);
	table.setSelectionBackground(new Color(0,0,0,64)); // When a cell is selected, this entire row is highlighted.

	//Create the scroll pane and add the table to it.
	JScrollPane scrollPane = new JScrollPane(table);
	contListPanel.add(scrollPane);	
	
	return contListPanel;
}

// Used to test the GUI
public static void main(String argv[]) {
  new ContListGUI();
}
}
class MyTableModel extends AbstractTableModel {
String[] colNames = {"User ID", "First Name", "Last Name", "Tribe", "Picture", "Eliminated"};

protected int sortCol = 0;

protected boolean isSortAsc = true;

Vector<?> rowData = new Vector<Object>();
public MyTableModel() {
    Vector<Vector<String>> rowData = new Vector<Vector<String>>();
    for (int i = 0; i < 1; i++) {
      Vector<String> colData = new Vector<String>(Arrays.asList("players.txt"));
      rowData.add(colData);
    }
}

public int getRowCount() {
  return rowData == null ? 0 : rowData.size();
}

public int getColumnCount() {
  return colNames.length;
}

public String getColumnName(int column) {
  return colNames[column];
}

public boolean isCellEditable(int nRow, int nCol) {
  return false;
}

public Object getValueAt(int nRow, int nCol) {
  if (nRow < 0 || nRow >= getRowCount())
    return "";
  if(nCol>1){
    return "";
  }
  return rowData.elementAt(nRow);
}

public String getTitle() {
  return "Contestant List ";
}

class ColumnListener extends MouseAdapter {
  protected JTable table;

  public ColumnListener(JTable t) {
    table = t;
  }

  public void mouseClicked(MouseEvent e) {
    TableColumnModel colModel = table.getColumnModel();
    int columnModelIndex = colModel.getColumnIndexAtX(e.getX());
    int modelIndex = colModel.getColumn(columnModelIndex)
        .getModelIndex();

    if (modelIndex < 0)
      return;
    if (sortCol == modelIndex)
      isSortAsc = !isSortAsc;
    else
      sortCol = modelIndex;

    for (int i = 0; i < colNames.length; i++) { 
      TableColumn column = colModel.getColumn(i);
      column.setHeaderValue(getColumnName(column.getModelIndex()));
    }
    table.getTableHeader().repaint();

    Collections.sort(rowData,new MyComparator(isSortAsc));
    table.tableChanged(new TableModelEvent(MyTableModel.this));
    table.repaint();
  }
}
}

class MyComparator implements Comparator<Object> {
protected boolean isSortAsc;

public MyComparator( boolean sortAsc) {
  isSortAsc = sortAsc;
}

public int compare(Object o1, Object o2) {
  if (!(o1 instanceof Integer) || !(o2 instanceof Integer))
    return 0;
  Integer s1 = (Integer) o1;
  Integer s2 = (Integer) o2;
  int result = 0;
  result = s1.compareTo(s2);
  if (!isSortAsc)
    result = -result;
  return result;
}

public boolean equals(Object obj) {
  if (obj instanceof MyComparator) {
    MyComparator compObj = (MyComparator) obj;
    return compObj.isSortAsc == isSortAsc;
  }
  return false;
}
}
