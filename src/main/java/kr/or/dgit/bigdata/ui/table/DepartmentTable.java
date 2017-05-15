package kr.or.dgit.bigdata.ui.table;

import java.util.List;

import javax.swing.SwingConstants;

import kr.or.dgit.bigdata.dto.Department;
import kr.or.dgit.bigdata.service.DepartmentService;

public class DepartmentTable extends PlainTable {
	private List<Department> dList;
	
	public DepartmentTable() {
		setToolTipText("원하는 정보에 커서를 두고 우클릭을 하면 기능이 나타납니다.");
		setEnabled(false);
		getDatas();
		setTableWithData();
	}
	
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
		System.out.println("DepartmentTable start");
		dList = DepartmentService.getInstance().selectAll();
		if(!dList.isEmpty()){
			String[][] res = new String[dList.size()][];
			for(int i=0;i<res.length;i++){
				res[i] = dList.get(i).toArray();
				//System.out.println(dList.get(i).toArray());
			}
			
			return res;
		}else{
			//System.out.println("DepartmentTable empty");
		}
		return new String[][]{};
	}

	@Override
	public Object getSelectedItemWithIndex(int index) {
		return dList.get(index);
	}

}
