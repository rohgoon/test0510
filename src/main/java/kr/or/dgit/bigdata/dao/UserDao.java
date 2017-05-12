package kr.or.dgit.bigdata.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import kr.or.dgit.bigdata.NcsConfig;
import kr.or.dgit.bigdata.jdbc.NcsJdbc;
import kr.or.dgit.bigdata.jdbc.NcsJdbcUtil;

public class UserDao implements NcsInterDao<UserDao> {
	private PreparedStatement pstmt;
	private static UserDao instance = new UserDao();

	public UserDao() {
		
	}

	public static UserDao getInstance() {
		return instance;
	}

	public void initUser() {
		createItem();
		grantUser();
	}

	private void grantUser() {
		String sql = "grant select, insert, update, delete on " + NcsConfig.DB_NAME + ".* to ?";
		PreparedStatement pstmt = null;
		
			Connection con = NcsJdbc.getConnection();
			try {
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, NcsConfig.PJT_USER);
				pstmt.executeUpdate();
				System.out.printf("%s가 권한 획득 %n",NcsConfig.PJT_USER);
			} catch (SQLException e) {
				System.out.printf("%s가 권한 획득 실패 %n",NcsConfig.PJT_USER);
				e.printStackTrace();
			} finally {
				NcsJdbcUtil.close(pstmt);
			}
	}

	public void createItem() {
		String sql = "create user ? identified by ?";
		PreparedStatement pstmt = null;
		try {
			Connection con = NcsJdbc.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, NcsConfig.PJT_USER);
			pstmt.setString(2, NcsConfig.PJT_PASSWD);
			pstmt.execute();
			System.out.printf("Create User(%s) Success! %n", NcsConfig.PJT_USER);
		} catch (SQLException e) {
			if (e.getErrorCode()==1396){
				System.err.printf("User(%s) exists!%n", NcsConfig.PJT_USER);
				dropItem();
				createItem();
			}
		} finally {
			NcsJdbcUtil.close(pstmt);
		}

	}

	
	public void dropItem() {
		String sql = "drop user ?";
		PreparedStatement pstmt = null;
		try {
			Connection con = NcsJdbc.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, NcsConfig.PJT_USER);
			pstmt.executeUpdate();
			System.out.printf("Drop User(%s) Success! %n", NcsConfig.PJT_USER);
		} catch (SQLException e) {
			System.err.printf("Drop User(%s) Fail! %n", NcsConfig.PJT_USER);
		} finally {
			NcsJdbcUtil.close(pstmt);
		}

	}

}
