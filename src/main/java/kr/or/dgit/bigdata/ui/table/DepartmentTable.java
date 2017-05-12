package kr.or.dgit.bigdata.ui.table;

import java.util.List;

import javax.swing.SwingConstants;

import kr.or.dgit.bigdata.dto.DepartmentDto;

public class DepartmentTable extends PlainTable {
	private List<DepartmentDto> dList;
	@Override
	public void tableSetAlignWidth() {
		tableCellAlignment(SwingConstants.CENTER, 0,1,2);
		tableSetWidth(60,200,100);
	}

	@Override
	public String[] getColumnData() {
		String[] strArr = null;
		strArr = new String[]{ "번호", "부서명", "위치"};
		return strArr;
	}

	@Override
	public String[][] getDatas() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getSelectedItemWithIndex(int index) {
		return dList.get(index);
	}

}
