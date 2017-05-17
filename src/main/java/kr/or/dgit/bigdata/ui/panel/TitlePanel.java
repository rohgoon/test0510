package kr.or.dgit.bigdata.ui.panel;

import javax.swing.JPanel;
import java.awt.GridLayout;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.border.EmptyBorder;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class TitlePanel extends JPanel {
	private JTextField tfTNum;
	private JTextField tfTName;
	private Map<String,String> tfMap;
	/**
	 * Create the panel.
	 */
	public TitlePanel() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new EmptyBorder(0, 60, 0, 60));
		add(panel_1, BorderLayout.WEST);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new EmptyBorder(0, 60, 0, 60));
		add(panel_2, BorderLayout.EAST);
		
		JPanel panel = new JPanel();
		add(panel);
		panel.setLayout(new GridLayout(2, 2, 10, 10));
		
		JLabel lblNum = new JLabel("번호");
		panel.add(lblNum);
		lblNum.setHorizontalAlignment(SwingConstants.RIGHT);
		
		tfTNum = new JTextField();
		tfTNum.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				collectTf();
			}
		});
		tfTNum.setEditable(false);
		panel.add(tfTNum);
		tfTNum.setColumns(10);
		
		JLabel lblTeam = new JLabel("부서명");
		panel.add(lblTeam);
		lblTeam.setHorizontalAlignment(SwingConstants.RIGHT);
		
		tfTName = new JTextField();
		tfTName.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				collectTf();
			}
		});
		panel.add(tfTName);
		tfTName.setColumns(10);
		tfMap = new HashMap<String, String>();
	}
	protected void collectTf() {		
		tfMap.put("tcode", tfTNum.getText());
		tfMap.put("tname", tfTName.getText());	
	}
	public Map<String, String> getTfMap() {
		return tfMap;
	}
	public JTextField getTfTNum() {
		return tfTNum;
	}
	public void setTfTNum(JTextField tfTNum) {
		this.tfTNum = tfTNum;
	}
	public JTextField getTfTName() {
		return tfTName;
	}
	public void setTfTName(JTextField tfTName) {
		this.tfTName = tfTName;
	}
	public void setTfMap(Map<String, String> tfMap) {
		this.tfMap = tfMap;
	}
	
}
