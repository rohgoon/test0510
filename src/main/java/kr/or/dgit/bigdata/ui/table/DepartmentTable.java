package kr.or.dgit.bigdata.ui.table;

import java.util.List;

import javax.swing.SwingConstants;

import kr.or.dgit.bigdata.dto.Department;
import kr.or.dgit.bigdata.service.DepartmentService;

public class DepartmentTable extends PlainTable {
	private List<Department> dList;
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
		dList = DepartmentService.getInstance().selectAll();
		if(!dList.isEmpty()){
			String[][] res = new String[dList.size()][];
			for(int i=0;i<res.length;i++){
				res[i] = dList.get(i).toArray();
			}
			return res;
		}
		return new String[][]{};
	}

	@Override
	public Object getSelectedItemWithIndex(int index) {
		return dList.get(index);
	}

}
