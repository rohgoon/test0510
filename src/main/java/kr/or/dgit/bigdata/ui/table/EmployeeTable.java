package kr.or.dgit.bigdata.ui.table;

import java.util.List;

import javax.swing.SwingConstants;

import kr.or.dgit.bigdata.dto.EmployeeDto;

public class EmployeeTable extends PlainTable {
	private List<EmployeeDto> eList; 
	@Override
	public void tableSetAlignWidth() {
		tableCellAlignment(SwingConstants.CENTER, 0, 1, 2,4,5,6);
		tableCellAlignment(SwingConstants.RIGHT, 3);
		tableSetWidth(60, 100, 100, 200,100,200,200);
	}

	@Override
	public String[] getColumnData() {
		String[] strArr = null;
		strArr = new String[]{ "번호", "사원명", "직책", "급여", "성별","부서","입사일" };
		return strArr;
	}


	@Override
	public String[][] getDatas() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getSelectedItemWithIndex(int index) {
		
		return eList.get(index);
	}
	
}
