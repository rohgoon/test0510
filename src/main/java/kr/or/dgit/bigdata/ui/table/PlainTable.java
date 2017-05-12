package kr.or.dgit.bigdata.ui.table;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

public abstract class PlainTable extends JTable {
	
	
	protected void tableSetWidth(int... width) {
		TableColumnModel model = getColumnModel();
		for (int i = 0; i < width.length; i++) {
			model.getColumn(i).setPreferredWidth(width[i]);
			isCellEditable(0, i);
		}		
	}
	@Override
	public boolean isCellEditable(int row, int column) {
		if(column >= 0){
			return false;
		}else{
			return true;
		}
	}
	
	public abstract void tableSetAlignWidth(); 
	
	protected void tableCellAlignment(int align, int... idx) {
		DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
		dtcr.setHorizontalAlignment(align);
		TableColumnModel model = getColumnModel();
		for (int i = 0; i < idx.length; i++) {
			model.getColumn(idx[i]).setCellRenderer(dtcr);
		}
	}
	public void setTableWithData(){
		setModel(new DefaultTableModel(getDatas(), getColumnData()));		
		tableSetAlignWidth();
	};
	public abstract String[][] getDatas();
	public abstract String[] getColumnData();
	public abstract Object getSelectedItemWithIndex(int index);
	
}
