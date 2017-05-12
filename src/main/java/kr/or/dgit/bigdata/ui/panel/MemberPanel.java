package kr.or.dgit.bigdata.ui.panel;

import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.border.EmptyBorder;
import javax.swing.DefaultComboBoxModel;

public class MemberPanel extends JPanel {
	private JTextField tfNum;
	private JTextField tfName;
	private JTextField tfRegDate;
	private JRadioButton rbM;
	private JRadioButton rbF;
	private JComboBox cbTtile;
	private JSpinner spSal;
	private JComboBox cbFloor;

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
		cbTtile.setModel(new DefaultComboBoxModel(new String[] {"사장", "부장", "과장", "대리", "사원"}));
		panel.add(cbTtile);
		
		JLabel lblSal = new JLabel("급여");
		panel.add(lblSal);
		lblSal.setHorizontalAlignment(SwingConstants.RIGHT);
		
		spSal = new JSpinner();
		panel.add(spSal);
		
		JLabel lblJen = new JLabel("성별");
		panel.add(lblJen);
		lblJen.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JPanel pnJender = new JPanel();
		panel.add(pnJender);
		pnJender.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		rbM = new JRadioButton("남");
		pnJender.add(rbM);
		
		rbF = new JRadioButton("여");
		pnJender.add(rbF);
		
		JLabel lblFloor = new JLabel("부서");
		panel.add(lblFloor);
		lblFloor.setHorizontalAlignment(SwingConstants.RIGHT);
		
		cbFloor = new JComboBox();
		cbFloor.setModel(new DefaultComboBoxModel(new String[] {"마케팅(10층)", "개발(9층)", "인사(6층)", "총무(7층)", "경영(4층)"}));
		panel.add(cbFloor);
		
		JLabel lblRegDate = new JLabel("입사일");
		panel.add(lblRegDate);
		lblRegDate.setHorizontalAlignment(SwingConstants.RIGHT);
		
		tfRegDate = new JTextField();
		panel.add(tfRegDate);
		tfRegDate.setColumns(10);
		
	}

}
