package kr.or.dgit.bigdata.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import kr.or.dgit.bigdata.jdbc.NcsJdbc;
import kr.or.dgit.bigdata.jdbc.NcsJdbcUtil;

public class TableDao {
	private PreparedStatement pstmt;
	private static TableDao instance = new TableDao();

	public TableDao() {

	}

	public static TableDao getInstance() {
		return instance;
	}

	public void createItem(String sql) {
		Connection con = NcsJdbc.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.execute();
			System.out.println("테이블 생성 성공");
		} catch (SQLException e) {

			System.out.println("테이블 생성 실패.");
			e.printStackTrace();

		} finally {
			NcsJdbcUtil.close(pstmt);
		}

	}
	
	public String showTable(String str){
		String result ="";
		String sql = "show tables in ncs_erp_rcg like '"+str+"'";
		ResultSet rs = null;
		try {
			pstmt = NcsJdbc.getConnection().prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				result = rs.getString(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			NcsJdbcUtil.close(rs,pstmt);
		}

		return result;
	}
	
	
}
