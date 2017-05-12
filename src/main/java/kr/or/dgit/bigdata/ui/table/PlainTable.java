package kr.or.dgit.bigdata.ui.table;

import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumnModel;

public class PlainTable extends JTable {
	public PlainTable() {
	}
	int ColumDataIndex;
	
	protected void tableSetWidth(int... width) {//
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
	
	public void tableSetAlignWidth() {
		if (ColumDataIndex == 1) {
			tableCellAlignment(SwingConstants.CENTER, 0, 1, 2,4,5,6);
			tableCellAlignment(SwingConstants.RIGHT, 3);
			tableSetWidth(60, 100, 100, 200,100,200,200);
			
		}else if (ColumDataIndex == 2) {
			tableCellAlignment(SwingConstants.CENTER, 0,1,2);
			tableSetWidth(60,200,100);
			
		}else if (ColumDataIndex == 3) {
			tableCellAlignment(SwingConstants.CENTER, 0,1);
			tableSetWidth(60,300);			
			
		}
		
	}
	
	protected void tableCellAlignment(int align, int... idx) {//
		DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
		dtcr.setHorizontalAlignment(align);
		TableColumnModel model = getColumnModel();
		for (int i = 0; i < idx.length; i++) {
			model.getColumn(idx[i]).setCellRenderer(dtcr);
		}
	}
	public String[] getColumnData() {
		String[] strArr = null;
		if (ColumDataIndex == 1) {
			strArr = new String[]{ "번호", "사원명", "직책", "급여", "성별","부서","입사일" };
			
		}else if (ColumDataIndex == 2) {
			strArr = new String[]{ "번호", "부서명", "위치"};
			
		}else if (ColumDataIndex == 3) {
			strArr =new String[]{ "번호","직책"};
			
		}
		
		return strArr;
	}
	public int getColumDataIndex() {
		return ColumDataIndex;
	}
	public void setColumDataIndex(int columDataIndex) {
		ColumDataIndex = columDataIndex;
	}
	
}
