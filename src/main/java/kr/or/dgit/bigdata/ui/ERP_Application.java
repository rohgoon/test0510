package kr.or.dgit.bigdata.ui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DecimalFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
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
	private JPanel inputPanel;
	private int tnForPopup;
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
		
		JButton btnAdd = sf.getBtnAdd();
		btnAdd.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				btnAddAction();
			}
		});
		
		JButton btnCancel = sf.getBtnAdd();
		btnCancel.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				btnCancelAction();
			}
		});
	}
	protected void btnAddAction() {
		switch (tnForPopup) {
		case 1:	//EmployeeService						
			Map<String,String> map = ((MemberPanel)inputPanel).getTfMap();
			Employee dto = new Employee();
			dto.setEname(map.get("ename"));
			dto.setSalary(Integer.parseInt(map.get("salary")));
			
			if(map.get("gender").equals("0")){
				dto.setGender(true);
			}else if(map.get("gender").equals("1")){
				dto.setGender(false);
			} 
			dto.setJoindate(new Date());			
			List<Title> titleList = TitleService.getInstance().selectAll();
			for (Title t : titleList) {
				if (t.getTname().equals(map.get("title"))) {
					dto.setTitle(t.getTcode());
				}
			}
			List<Department> dList = DepartmentService.getInstance().selectAll();
			//String[] dnoArr=map.get("dno").split("(");
			System.out.println(map.get("dno"));
			for (Department d : dList) {
				/*if (d.getDname().equals(dnoArr[0])) {
					dto.setDno(d.getDcode());
				}	*/			
			}			
			EmployeeService.getInstance().insert(dto);
			
			break;
		case 2:
			
			break;
		case 3:

			break;
		}
	}
	protected void btnCancelAction() {
		switch (tnForPopup) {
		case 1:							
			Employee employee = EmployeeService.getInstance().selectLastOne();
			btnMemClick(employee);
			break;
		case 2:
			
			break;
		case 3:

			break;
		}
	}
	public void actionPerformed(ActionEvent e) {
		
		pnInput.removeAll();
		pnInput.add(pnBtn, BorderLayout.SOUTH);
		if (e.getSource() == btnMem) {
			tnForPopup =1;
			sf.setTitle("사원관리");
			inputPanel = new MemberPanel();
			Employee employee = EmployeeService.getInstance().selectLastOne();
			btnMemClick(employee);
		} else if (e.getSource() == btnTeam) {
			tnForPopup =2;
			sf.setTitle("부서관리");
			inputPanel = new TeamPanel();
			pnInput.add(inputPanel, BorderLayout.CENTER);
			sf.setBounds(100, 220, 700, 380);
			table = new DepartmentTable();
			
		} else if (e.getSource() == btnTitle) {
			tnForPopup =3;
			sf.setTitle("직책관리");
			inputPanel = new TitlePanel();
			pnInput.add(inputPanel, BorderLayout.CENTER);
			sf.setBounds(100, 220, 700, 290);
			table = new TitleTable();		
		}
		
		table.addMouseListener(new MouseAdapter() {// popup
			@Override
			public void mouseReleased(MouseEvent e) {
				tableMouseReleased(e, table);
			}
		});
		
		sp.setViewportView(table);
		
		sf.setVisible(true);
	}
	
	
	protected void tableMouseReleased(MouseEvent e, PlainTable jt) {
		if(jt.getRowCount()>0){
			int r = jt.rowAtPoint(e.getPoint());
			if (r >= 0 && r < jt.getRowCount()) {
				jt.setRowSelectionInterval(r, r);
			} else {
				jt.clearSelection();
			}
			int rowindex = jt.getSelectedRow();
			if (rowindex < 0)
				return;
			
			final int rowValueNo = Integer.parseInt(jt.getValueAt(jt.getSelectedRow(), 0).toString());
			if (e.isPopupTrigger() && e.getComponent() instanceof JTable) {
				
				JPopupMenu popup = new JPopupMenu(); 
				popup.add(new JMenuItem(new AbstractAction("수정") {
					public void actionPerformed(ActionEvent e) {
						switch (tnForPopup) {
						case 1:							
							Employee employee = EmployeeService.getInstance().selectOne(rowValueNo);
							btnMemClick(employee);
							break;
						case 2:
							
							break;
						case 3:
		
							break;
						}
					}
				}));
				popup.add(new JMenuItem(new AbstractAction("삭제") {
					public void actionPerformed(ActionEvent e) {
						int jopi = JOptionPane.showConfirmDialog(null,"정말 삭제하시겠습니까?");
						if (jopi == 0) {
							//
						}
					}
				}));
				
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		}
		
	}
	
	private void btnMemClick(Employee employee) {
		
		if (employee != null) {
			int eNo = employee.getEno();
			DecimalFormat df = new DecimalFormat("000");//사번 포멧 변환
			
			int etNum = employee.getTitle();			
			
			int dpNum = employee.getDno();
			Department department = DepartmentService.getInstance().selectOne(dpNum);	
			
			
			((MemberPanel)inputPanel).getTfNum().setText("E017"+df.format(eNo));//사번
			((MemberPanel)inputPanel).getCbTtile().setSelectedIndex(Integer.parseInt(((MemberPanel)inputPanel).getTfMap().get("title")));
			((MemberPanel)inputPanel).getSpSal().setValue(employee.getSalary());
			((MemberPanel)inputPanel).getCbFloor().setSelectedIndex(Integer.parseInt(((MemberPanel)inputPanel).getTfMap().get("dno")));
			
			
			if (employee.isGender()) {//여 true
				//((MemberPanel)inputPanel).getRbM().setSelected(false);
				((MemberPanel)inputPanel).getRbF().setSelected(true);				
			}else {
				((MemberPanel)inputPanel).getRbM().setSelected(true);
				//((MemberPanel)inputPanel).getRbF().setSelected(false);
			}
		}
		
		
		pnInput.add(inputPanel, BorderLayout.CENTER);
		sf.setBounds(100, 220, 700, 750);
		table = new EmployeeTable();
		
	}

}
