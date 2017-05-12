package kr.or.dgit.bigdata.ui.table;

import java.util.List;

import javax.swing.SwingConstants;

import kr.or.dgit.bigdata.dto.Title;

public class TitleTable extends PlainTable {
	private List<Title> tList;
	@Override
	public void tableSetAlignWidth() {
		tableCellAlignment(SwingConstants.CENTER, 0,1);
		tableSetWidth(60,300);	

	}

	@Override
	public String[] getColumnData() {
		String[] strArr = null;
		strArr =new String[]{ "번호","직책"};
		return strArr;
	}

	@Override
	public String[][] getDatas() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getSelectedItemWithIndex(int index) {
		return tList.get(index);
	}

}
