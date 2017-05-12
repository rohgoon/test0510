package kr.or.dgit.bigdata.ui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import kr.or.dgit.bigdata.ui.panel.MemberPanel;
import kr.or.dgit.bigdata.ui.panel.TeamPanel;
import kr.or.dgit.bigdata.ui.panel.TitlePanel;


public class ERP_Application extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JButton btnMem;
	private JButton btnTeam;
	private JButton btnTitle;
	/**
	 * Create the frame.
	 */
	private SubFrame sf;
	private JPanel pnInput;
	private JPanel pnBtn;
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
	}
	public void actionPerformed(ActionEvent e) {
		pnInput.removeAll();
		pnInput.add(pnBtn, BorderLayout.SOUTH);
		JPanel memberp = new MemberPanel();
		JPanel teamp = new TeamPanel();
		JPanel titlep = new TitlePanel();
		if (e.getSource() == btnMem) {				
			pnInput.add(memberp, BorderLayout.CENTER);
			sf.setBounds(100, 220, 700, 750);			
		} else if (e.getSource() == btnTeam) {
			pnInput.add(teamp, BorderLayout.CENTER);
			sf.setBounds(100, 220, 700, 380);
		} else if (e.getSource() == btnTitle) {
			pnInput.add(titlep, BorderLayout.CENTER);
			sf.setBounds(100, 220, 700, 290);
		}		
		sf.setVisible(true);
	}

}
