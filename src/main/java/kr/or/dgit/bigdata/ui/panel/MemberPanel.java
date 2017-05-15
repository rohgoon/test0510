package kr.or.dgit.bigdata.ui.panel;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.text.SimpleDateFormat;
import java.util.Date;

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

public class MemberPanel extends JPanel {
	private JTextField tfNum;
	private JTextField tfName;
	private JTextField tfRegDate;
	private JRadioButton rbM;
	private JRadioButton rbF;
	private JComboBox cbTtile;
	private JSpinner spSal;
	private JComboBox cbFloor;	
	private String[] titleList ={"사장", "부장", "과장", "대리", "사원"};
	private String[] departmentList = {"마케팅(10층)", "개발(9층)", "인사(6층)", "총무(7층)", "경영(4층)"};
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
		tfNum.setEditable(false);
		tfNum.setText("E017001");
		panel.add(tfNum);
		tfNum.setColumns(10);
		
		JLabel lblName = new JLabel("사원명");
		panel.add(lblName);
		lblName.setHorizontalAlignment(SwingConstants.RIGHT);
		
		tfName = new JTextField();
		panel.add(tfName);
		tfName.setColumns(10);
		
		JLabel lblTitle = new JLabel("직책");
		panel.add(lblTitle);
		lblTitle.setHorizontalAlignment(SwingConstants.RIGHT);
		
		cbTtile = new JComboBox();
		cbTtile.setModel(new DefaultComboBoxModel(titleList));
		panel.add(cbTtile);
		
		JLabel lblSal = new JLabel("급여");
		panel.add(lblSal);
		lblSal.setHorizontalAlignment(SwingConstants.RIGHT);
		
		spSal = new JSpinner();
		spSal.setModel(new SpinnerNumberModel(1500000, 1000000, 5000000, 1));
		panel.add(spSal);
		
		JLabel lblJen = new JLabel("성별");
		panel.add(lblJen);
		lblJen.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JPanel pnJender = new JPanel();
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
		cbFloor.setModel(new DefaultComboBoxModel(departmentList));
		panel.add(cbFloor);
		
		JLabel lblRegDate = new JLabel("입사일");
		panel.add(lblRegDate);
		lblRegDate.setHorizontalAlignment(SwingConstants.RIGHT);
		
		tfRegDate = new JTextField();
		Date rgd = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String resRgd = sdf.format(rgd);
		tfRegDate.setText(resRgd);
		panel.add(tfRegDate);
		tfRegDate.setColumns(10);
		
		
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

	public String[] getTitleList() {
		return titleList;
	}

	public String[] getDepartmentList() {
		return departmentList;
	}
	
}
