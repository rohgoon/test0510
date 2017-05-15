package kr.or.dgit.bigdata.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import kr.or.dgit.bigdata.NcsConfig;
import kr.or.dgit.bigdata.jdbc.NcsJdbc;
import kr.or.dgit.bigdata.jdbc.NcsJdbcUtil;


public class NcsDao implements NcsInterDao<NcsDao>{
	private PreparedStatement pstmt;
	private static NcsDao instance = new NcsDao();
	
	public NcsDao() {
		
	}
	
	public static NcsDao getInstance(){
		return instance;
	}

	public void createItem() {
		Connection con = NcsJdbc.getConnection();
		try {
			pstmt = con.prepareStatement("create database "+NcsConfig.DB_NAME);			
			pstmt.execute();
			JOptionPane.showMessageDialog(null, "초기화 완료");
			System.out.println("Create database "+NcsConfig.DB_NAME);
		} catch (SQLException e) {
			if (e.getErrorCode()==1007) {
				System.out.println("데이터베이스가 이미 존재합니다.");
				dropItem();
				createItem();
			}
			
		}finally {
			NcsJdbcUtil.close(pstmt);
		}
	}

	public void dropItem() {
		Connection con = NcsJdbc.getConnection();
		try {
			pstmt = con.prepareStatement("drop database if exists " +NcsConfig.DB_NAME);
			pstmt.execute();
			System.out.println("Drop database if exists " +NcsConfig.DB_NAME);			
		} catch (SQLException e) {
			System.out.println("데이터베이스 생성 실패");
		}finally {
			NcsJdbcUtil.close(pstmt);
			
		}
	}
	public void selectUseDatabase(){
		Connection con = NcsJdbc.getConnection();
		try {
			pstmt = con.prepareStatement("use " +NcsConfig.DB_NAME);
			pstmt.execute();
			System.out.println("use " +NcsConfig.DB_NAME);
		} catch (SQLException e) {
			System.out.printf("%s 데이터베이스를 사용 실패.",NcsConfig.DB_NAME);
			e.printStackTrace();
		}finally {
			NcsJdbcUtil.close(pstmt);
		}
	}
	public void setForeignKeyCheck(int isCheck){
		Connection con = NcsJdbc.getConnection();
		try {
			pstmt = con.prepareStatement("set foreign_key_checks =?");
			pstmt.setInt(1, isCheck);
			pstmt.execute();
			System.out.println("set foreign_key_checks 성공");
		} catch (SQLException e) {			
			e.printStackTrace();
		}finally {
			NcsJdbcUtil.close(pstmt);
		}
	}

	
}


















