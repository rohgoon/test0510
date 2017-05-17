package kr.or.dgit.bigdata.ui.panel;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import kr.or.dgit.bigdata.dto.Department;
import kr.or.dgit.bigdata.dto.Title;
import kr.or.dgit.bigdata.service.DepartmentService;
import kr.or.dgit.bigdata.service.TitleService;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class MemberPanel extends JPanel {
	private JTextField tfNum;
	private JTextField tfName;
	private JTextField tfRegDate;
	private JRadioButton rbM;
	private JRadioButton rbF;
	private JComboBox cbTtile;
	private JSpinner spSal;
	private JComboBox cbFloor;
	List<Title> tList;
	List<Department> dList;
	private Map<String,String> tfMap;
	/**
	 * Create the panel.
	 */
	public MemberPanel() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new EmptyBorder(0, 60, 0, 60));
		add(panel_1, BorderLayout.WEST);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new EmptyBorder(0, 60, 0, 60));
		add(panel_2, BorderLayout.EAST);
		
		JPanel panel = new JPanel();
		add(panel);
		panel.setLayout(new GridLayout(7, 2, 10, 10));
		
		JLabel lblNum = new JLabel("번호");
		panel.add(lblNum);
		lblNum.setHorizontalAlignment(SwingConstants.RIGHT);
		
		tfNum = new JTextField();
		tfNum.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				collectTf();
			}
		});
		tfNum.setEditable(false);
		tfNum.setText("E017001");
		panel.add(tfNum);
		tfNum.setColumns(10);
		
		JLabel lblName = new JLabel("사원명");
		panel.add(lblName);
		lblName.setHorizontalAlignment(SwingConstants.RIGHT);
		
		tfName = new JTextField();
		tfName.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				collectTf();
			}
		});
		panel.add(tfName);
		tfName.setColumns(10);
		
		JLabel lblTitle = new JLabel("직책");
		panel.add(lblTitle);
		lblTitle.setHorizontalAlignment(SwingConstants.RIGHT);
		
		cbTtile = new JComboBox();
		cbTtile.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				collectTf();
			}
		});
		tList = TitleService.getInstance().selectAll(); 
		String[] titleList = new String[tList.size()];
		for (int i = 0; i < titleList.length; i++) {
			titleList[i] = tList.get(i).getTname();
		}
		cbTtile.setModel(new DefaultComboBoxModel(titleList));
		panel.add(cbTtile);
		
		JLabel lblSal = new JLabel("급여");
		panel.add(lblSal);
		lblSal.setHorizontalAlignment(SwingConstants.RIGHT);
		
		spSal = new JSpinner();
		spSal.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				collectTf();
			}
		});
		spSal.setModel(new SpinnerNumberModel(1500000, 1000000, 5000000, 1));
		panel.add(spSal);
		
		JLabel lblJen = new JLabel("성별");
		panel.add(lblJen);
		lblJen.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JPanel pnJender = new JPanel();
		pnJender.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				collectTf();
			}
		});
		panel.add(pnJender);
		pnJender.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		rbM = new JRadioButton("남");
		rbM.setSelected(true);
		rbF = new JRadioButton("여");
		
		ButtonGroup activityG = new ButtonGroup();
		activityG.add(rbM);
		activityG.add(rbF);
		
		pnJender.add(rbM);
		pnJender.add(rbF);
		
		
		
		JLabel lblFloor = new JLabel("부서");
		panel.add(lblFloor);
		lblFloor.setHorizontalAlignment(SwingConstants.RIGHT);
		
		cbFloor = new JComboBox();
		cbFloor.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				collectTf();
			}
		});
		dList = DepartmentService.getInstance().selectAll(); 
		String[] departmentList = new String[dList.size()];
		for (int i = 0; i < departmentList.length; i++) {
			departmentList[i] = dList.get(i).getDname()+"("+dList.get(i).getFloor()+"층)";
		}
		cbFloor.setModel(new DefaultComboBoxModel(departmentList));
		panel.add(cbFloor);
		
		JLabel lblRegDate = new JLabel("입사일");
		panel.add(lblRegDate);
		lblRegDate.setHorizontalAlignment(SwingConstants.RIGHT);
		
		tfRegDate = new JTextField();
		tfRegDate.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				collectTf();
			}
		});
		Date rgd = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String resRgd = sdf.format(rgd);
		tfRegDate.setText(resRgd);
		panel.add(tfRegDate);
		tfRegDate.setColumns(10);
		
		tfMap = new HashMap<String, String>();
	}

	protected void collectTf() {		
		tfMap.put("eno", tfNum.getText());
		tfMap.put("ename", tfName.getText());
		tfMap.put("salary", spSal.getValue()+"");
		tfMap.put("dno", cbFloor.getSelectedIndex()+"");		
		if (rbM.isSelected()) {
			tfMap.put("gender", 0+"");
		}else if (rbF.isSelected()) {
			tfMap.put("gender", 1+"");
		}
		tfMap.put("joindate", tfRegDate.getText());
		tfMap.put("title", cbTtile.getSelectedIndex()+"");		
	}

	public JTextField getTfNum() {
		return tfNum;
	}

	public void setTfNum(JTextField tfNum) {
		this.tfNum = tfNum;
	}

	public JTextField getTfName() {
		return tfName;
	}

	public void setTfName(JTextField tfName) {
		this.tfName = tfName;
	}

	public JTextField getTfRegDate() {
		return tfRegDate;
	}

	public void setTfRegDate(JTextField tfRegDate) {
		this.tfRegDate = tfRegDate;
	}

	public JRadioButton getRbM() {
		return rbM;
	}

	public void setRbM(JRadioButton rbM) {
		this.rbM = rbM;
	}

	public JRadioButton getRbF() {
		return rbF;
	}

	public void setRbF(JRadioButton rbF) {
		this.rbF = rbF;
	}

	public JComboBox getCbTtile() {
		return cbTtile;
	}

	public void setCbTtile(JComboBox cbTtile) {
		this.cbTtile = cbTtile;
	}

	public JSpinner getSpSal() {
		return spSal;
	}

	public void setSpSal(JSpinner spSal) {
		this.spSal = spSal;
	}

	public JComboBox getCbFloor() {
		return cbFloor;
	}

	public void setCbFloor(JComboBox cbFloor) {
		this.cbFloor = cbFloor;
	}


	public Map<String, String> getTfMap() {
		return tfMap;
	}

	public List<Title> gettList() {
		return tList;
	}

	public void settList(List<Title> tList) {
		this.tList = tList;
	}

	public List<Department> getdList() {
		return dList;
	}

	public void setdList(List<Department> dList) {
		this.dList = dList;
	}

	public void setTfMap(Map<String, String> tfMap) {
		this.tfMap = tfMap;
	}
	
}
