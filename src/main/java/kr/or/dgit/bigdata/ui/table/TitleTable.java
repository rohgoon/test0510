package kr.or.dgit.bigdata.ui.table;

import java.util.List;

import javax.swing.SwingConstants;

import kr.or.dgit.bigdata.dto.Title;
import kr.or.dgit.bigdata.service.DepartmentService;
import kr.or.dgit.bigdata.service.TitleService;

public class TitleTable extends PlainTable {
	private List<Title> tList;
	public TitleTable() {
		setToolTipText("원하는 정보에 커서를 두고 우클릭을 하면 기능이 나타납니다.");
		setEnabled(false);
		getDatas();
		setTableWithData();
	}
	
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
		tList = TitleService.getInstance().selectAll();
		if(!tList.isEmpty()){
			String[][] res = new String[tList.size()][];
			for(int i=0;i<res.length;i++){
				res[i] = tList.get(i).toArray();
			}
			return res;
		}
		return new String[][]{};
	}

	@Override
	public Object getSelectedItemWithIndex(int index) {
		return tList.get(index);
	}

}
