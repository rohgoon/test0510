package kr.or.dgit.bigdata.ui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import kr.or.dgit.bigdata.setting.ExportSettingService;
import kr.or.dgit.bigdata.setting.ImportSettingService;
import kr.or.dgit.bigdata.setting.InitSettingService;
import kr.or.dgit.bigdata.setting.ServiceSetting;


public class SettingUI extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JButton btnInit;
	private JButton btnBackup;
	private JButton btnRestore;
	/**
	 * Create the frame.
	 */
	public SettingUI() {
		setTitle("DB관리메뉴");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 114);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(20, 20, 20, 20));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 3, 20, 0));
		
		btnInit = new JButton("초기화");
		btnInit.addActionListener(this);
		contentPane.add(btnInit);
		
		btnBackup = new JButton("백업");
		btnBackup.addActionListener(this);
		contentPane.add(btnBackup);
		
		btnRestore = new JButton("복원");
		btnRestore.addActionListener(this);
		contentPane.add(btnRestore);
	}
	public void actionPerformed(ActionEvent e) {
		ServiceSetting create = null;

		if (e.getSource() == btnRestore) {
			create = new ImportSettingService();
		} else if (e.getSource() == btnBackup) {
			create = new ExportSettingService();
		} else if (e.getSource() == btnInit) {
			create = new InitSettingService();
		}
		create.initSetting();
	}

}
