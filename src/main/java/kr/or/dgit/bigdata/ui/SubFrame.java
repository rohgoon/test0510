package kr.or.dgit.bigdata.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import kr.or.dgit.bigdata.ui.table.EmployeeTable;
import kr.or.dgit.bigdata.ui.table.PlainTable;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JButton;
import java.awt.GridLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class SubFrame extends JFrame {

	private JPanel contentPane;
	private JPanel pnInput;
	private JPanel pnTable;
	private JPanel pnBtn;
	private JButton btnAdd;
	private JButton btnCancel;
	private JPanel panel;
	private JScrollPane scrollPane;
	private int columnDataIndex = 1;
	/**
	 * Create the frame.
	 */
	public SubFrame() {
		
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 452, 759);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 1, 0, 0));
		
		pnInput = new JPanel();
		contentPane.add(pnInput);
		pnInput.setLayout(new BorderLayout(0, 0));
		
		
		pnBtn = new JPanel();
		pnInput.add(pnBtn, BorderLayout.SOUTH);
		
		btnAdd = new JButton("추가");
		pnBtn.add(btnAdd);
		
		btnCancel = new JButton("취소");
		pnBtn.add(btnCancel);
		
		pnTable = new JPanel();
		contentPane.add(pnTable);
		pnTable.setLayout(new BorderLayout(0, 0));
		
		scrollPane = new JScrollPane();
		pnTable.add(scrollPane, BorderLayout.CENTER);
	}
	public JPanel getPnInput() {
		return pnInput;
	}
	public void setPnInput(JPanel pnInput) {
		this.pnInput = pnInput;
	}
	public JButton getBtnAdd() {
		return btnAdd;
	}
	public void setBtnAdd(JButton btnAdd) {
		this.btnAdd = btnAdd;
	}
	public JButton getBtnCancel() {
		return btnCancel;
	}
	public void setBtnCancel(JButton btnCancel) {
		this.btnCancel = btnCancel;
	}
	public JPanel getPanel() {
		return panel;
	}
	public void setPanel(JPanel panel) {
		this.panel = panel;
	}
	public JScrollPane getScrollPane() {
		return scrollPane;
	}
	public void setScrollPane(JScrollPane scrollPane) {
		this.scrollPane = scrollPane;
	}
	public JPanel getPnBtn() {
		return pnBtn;
	}
	public void setPnBtn(JPanel pnBtn) {
		this.pnBtn = pnBtn;
	}
	
	

}
