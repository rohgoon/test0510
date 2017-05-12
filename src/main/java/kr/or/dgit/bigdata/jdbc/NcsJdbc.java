package kr.or.dgit.bigdata.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import kr.or.dgit.bigdata.NcsConfig;



public class NcsJdbc {
	private static NcsJdbc instance = new NcsJdbc();
	private static Connection con;
	

	public static NcsJdbc getInstance() {
		return instance;
	}


	public NcsJdbc() {
		try {
			Class.forName(NcsConfig.DRIVER);
			con = DriverManager.getConnection(NcsConfig.URL, NcsConfig.USER,NcsConfig.PWD);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	
	public static Connection getConnection(){
		if (instance == null) {
			new NcsJdbc();
		}
		return NcsJdbc.con;
	}
	public static void closeConnection(){
		if (con != null) {
			try {
				con.close();
				con = null;
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
	}
}
