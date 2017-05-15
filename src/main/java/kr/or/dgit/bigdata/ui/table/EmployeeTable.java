package kr.or.dgit.bigdata.ui.table;

import java.util.List;

import javax.swing.SwingConstants;

import kr.or.dgit.bigdata.dto.Employee;
import kr.or.dgit.bigdata.service.EmployeeService;

public class EmployeeTable extends PlainTable {
	private List<Employee> eList; 
	public EmployeeTable() {
		setToolTipText("원하는 정보에 커서를 두고 우클릭을 하면 기능이 나타납니다.");
		setEnabled(false);
		getDatas();
		setTableWithData();
	}
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
		eList = EmployeeService.getInstance().selectAll();
		if(!eList.isEmpty()){
			String[][] res = new String[eList.size()][];
			for(int i=0;i<res.length;i++){
				res[i] = eList.get(i).toArray();
			}
			return res;
		}
		return new String[][]{};
	}

	@Override
	public Object getSelectedItemWithIndex(int index) {
		
		return eList.get(index);
	}
	
}
