package kr.or.dgit.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import kr.or.dgit.bigdata.NcsConfig;
import kr.or.dgit.bigdata.dao.NcsDao;
import kr.or.dgit.bigdata.dao.TableDao;
import kr.or.dgit.bigdata.jdbc.NcsJdbc;
import kr.or.dgit.bigdata.jdbc.NcsJdbcUtil;
import kr.or.dgit.bigdata.setting.InitSettingService;


public class DataBaseTest {
	private static NcsJdbc ncsJdbc;
	private static TableDao tableDao;
	private PreparedStatement pstmt;
	Connection con = NcsJdbc.getConnection();
	InitSettingService iss = new InitSettingService();
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		ncsJdbc = NcsJdbc.getInstance();
		tableDao = TableDao.getInstance();
		
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		NcsJdbcUtil.close(ncsJdbc.getConnection());
	}

	@Test
	public void aTestDBConnection() {
		
		Assert.assertNotNull(ncsJdbc.getConnection());
	}
	@Test
	public void bTestDBExists() {
		String result ="";
		NcsDao dao = NcsDao.getInstance();
		ResultSet rs = null;
		try {
			pstmt = con.prepareStatement("show databases like '"+NcsConfig.DB_NAME+"'");			
			rs = pstmt.executeQuery();
			if (rs.next()) {
				result = rs.getString(1);
			}
		} catch (SQLException e) {
			e.getStackTrace();		
		}finally {
			NcsJdbcUtil.close(rs,pstmt);
			Assert.assertNotEquals("", result);
		}
	}
	@Test
	public void cTestEmployeeTableExists() {
		iss.initSetting();
		String result = tableDao.showTable("employee");
		System.out.println("테이블명 : " +result);
		Assert.assertNotEquals("", result);
	}
	@Test
	public void dTestDepartmentTableExists() {
		iss.initSetting();
		String result = tableDao.showTable("department");
		System.out.println("테이블명 : " +result);
		Assert.assertNotEquals("", result);
	}
	@Test
	public void eTestTitleTableExists() {
		iss.initSetting();
		String result = tableDao.showTable("title");
		System.out.println("테이블명 : " +result);
		Assert.assertNotEquals("", result);
	}
}
