package kr.or.dgit.bigdata.ui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import kr.or.dgit.bigdata.dto.Department;
import kr.or.dgit.bigdata.dto.Employee;
import kr.or.dgit.bigdata.dto.Title;
import kr.or.dgit.bigdata.service.DepartmentService;
import kr.or.dgit.bigdata.service.EmployeeService;
import kr.or.dgit.bigdata.service.TitleService;
import kr.or.dgit.bigdata.ui.panel.MemberPanel;
import kr.or.dgit.bigdata.ui.panel.TeamPanel;
import kr.or.dgit.bigdata.ui.panel.TitlePanel;
import kr.or.dgit.bigdata.ui.table.DepartmentTable;
import kr.or.dgit.bigdata.ui.table.EmployeeTable;
import kr.or.dgit.bigdata.ui.table.PlainTable;
import kr.or.dgit.bigdata.ui.table.TitleTable;


public class ERP_Application extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JButton btnMem;
	private JButton btnTeam;
	private JButton btnTitle;
	private JScrollPane sp;
	JPanel inputPanel;
	/**
	 * Create the frame.
	 */
	private SubFrame sf;
	private JPanel pnInput;
	private JPanel pnBtn;
	private PlainTable table;
	public ERP_Application() {
		setTitle("대구아이티ERP");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 114);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(20, 20, 20, 20));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 3, 20, 0));
		
		btnMem = new JButton("사원관리");
		btnMem.addActionListener(this);
		contentPane.add(btnMem);
		
		btnTeam = new JButton("부서관리");
		btnTeam.addActionListener(this);
		contentPane.add(btnTeam);
		
		btnTitle = new JButton("직책관리");
		btnTitle.addActionListener(this);
		contentPane.add(btnTitle);
		
		sf = new SubFrame();
		pnInput  = sf.getPnInput();
		pnBtn = sf.getPnBtn();
		
		sp = sf.getScrollPane();
	}
	public void actionPerformed(ActionEvent e) {
		pnInput.removeAll();
		pnInput.add(pnBtn, BorderLayout.SOUTH);
		if (e.getSource() == btnMem) {
			sf.setTitle("사원관리");
			inputPanel = new MemberPanel();
			Employee employee = EmployeeService.getInstance().selectLastOne();
			int etNum = employee.getTitle();
			Title title = TitleService.getInstance().selectOne(etNum);			
			String[] titleList = ((MemberPanel)inputPanel).getTitleList();
			int titleIndex =0;			
			for (int i = 0; i < titleList.length; i++) {
				if (titleList[i].equals(title)) {
					titleIndex = i;
					break;
				}
			}
			
			int dpNum = employee.getDno();
			Department department = DepartmentService.getInstance().selectOne(dpNum);		
			String[] departmentList = ((MemberPanel)inputPanel).getDepartmentList();
			int dpIndex= 0;
			for (int i = 0; i < departmentList.length; i++) {
				String[] sdArr = departmentList[i].split("(");
				if (sdArr[0].equals(department.getDname())) {
					dpIndex =i;
					break;
				}
			}
			
			((MemberPanel)inputPanel).getTfNum().setText(employee.getEno()+"");
			((MemberPanel)inputPanel).getCbTtile().setSelectedIndex(titleIndex);
			((MemberPanel)inputPanel).getSpSal().setValue(employee.getSalary());
			((MemberPanel)inputPanel).getCbFloor().setSelectedIndex(dpIndex);
			
			
			if (employee.isGender()) {//여 true
				((MemberPanel)inputPanel).getRbM().setSelected(false);
				((MemberPanel)inputPanel).getRbF().setSelected(true);				
			}else {
				((MemberPanel)inputPanel).getRbM().setSelected(true);
				((MemberPanel)inputPanel).getRbF().setSelected(false);
			}
			
			pnInput.add(inputPanel, BorderLayout.CENTER);
			sf.setBounds(100, 220, 700, 750);
			table = new EmployeeTable();
			
			
		} else if (e.getSource() == btnTeam) {
			sf.setTitle("부서관리");
			inputPanel = new TeamPanel();
			pnInput.add(inputPanel, BorderLayout.CENTER);
			sf.setBounds(100, 220, 700, 380);
			table = new DepartmentTable();
			
		} else if (e.getSource() == btnTitle) {
			sf.setTitle("직책관리");
			inputPanel = new TitlePanel();
			pnInput.add(inputPanel, BorderLayout.CENTER);
			sf.setBounds(100, 220, 700, 290);
			table = new TitleTable();		
		}	
		sp.setViewportView(table);
		sf.setVisible(true);
	}

}
