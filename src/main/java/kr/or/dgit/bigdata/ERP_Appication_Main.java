package kr.or.dgit.bigdata;

import java.awt.EventQueue;

import kr.or.dgit.bigdata.ui.ERP_Application;


public class ERP_Appication_Main {

	public static void main(String[] args) {
		ea();
	}
	private static void ea(){
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ERP_Application frame = new ERP_Application();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
