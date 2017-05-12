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

public class TitlePanel extends JPanel {
	private JTextField tfTNum;
	private JTextField tfTName;

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
		tfTNum.setEditable(false);
		panel.add(tfTNum);
		tfTNum.setColumns(10);
		
		JLabel lblTeam = new JLabel("부서명");
		panel.add(lblTeam);
		lblTeam.setHorizontalAlignment(SwingConstants.RIGHT);
		
		tfTName = new JTextField();
		panel.add(tfTName);
		tfTName.setColumns(10);
		
	}

}
