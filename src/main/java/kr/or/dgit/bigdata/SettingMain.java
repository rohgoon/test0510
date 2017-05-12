package kr.or.dgit.bigdata;

import java.awt.EventQueue;

import kr.or.dgit.bigdata.ui.SettingUI;

public class SettingMain {
	public static void main(String[] args) {
		settingMng();
	}
	
	private static void settingMng(){
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SettingUI frame = new SettingUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
