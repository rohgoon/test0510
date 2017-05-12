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
	
	/*public void createViewTable() {
		Connection con = NcsJdbc.getConnection();
		String sql = "create view view_v_output as "
				+ "select c.cfCode, c.cfName , s.cfOne, s.cfSell, s.cfMargin, s.cfOne*s.cfSell as salePrice, "
				+ "round(s.cfOne*s.cfSell/11, 0) as addTax, s.cfOne*s.cfSell-round(s.cfOne*s.cfSell/11,0) as supplyPrice, "
				+ "round(((s.cfOne*s.cfSell-round(s.cfOne*s.cfSell/11,0))*(s.cfMargin/100)),0) as marginPrice "
				+ "from pdtcode c , pdtsale s " + "where c.cfCode = s.cfCode " + "order by salePrice ";

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.execute();
			System.out.println("뷰테이블 생성 성공");
		} catch (SQLException e) {
			System.out.println("뷰테이블 생성 실패");
			e.printStackTrace();
		} finally {
			
			NcsJdbcUtil.close(pstmt);
		}

	}

	public List<ViewTable> selectItemByAll1() {
		List<ViewTable> viewList = new ArrayList<ViewTable>();
		String sql = "select (select count(*)+1 from cafeteria.view_v_output as e2 where e1.salePrice < e2.salePrice) as rank, cfCode, cfName, cfOne, cfSell, cfMargin, salePrice, addTax, supplyPrice, marginPrice from cafeteria.view_v_output e1 order by salePrice desc";
		// 확인 요망

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = NcsJdbc.getConnection().prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				viewList.add(getObject(rs));

			}

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			NcsJdbcUtil.close(rs, pstmt);

		}
		return viewList;
	}

	public List<ViewTable> selectItemByAll2() {
		List<ViewTable> viewList = new ArrayList<ViewTable>();
		String sql = "select (select count(*)+1 from cafeteria.view_v_output as e2 where e1.marginPrice < e2.marginPrice) as rank, cfCode, cfName, cfOne, cfSell, cfMargin, salePrice, addTax, supplyPrice, marginPrice from cafeteria.view_v_output e1 order by marginPrice desc";
		// 확인 요망

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = NcsJdbc.getConnection().prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				viewList.add(getObject(rs));

			}

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			NcsJdbcUtil.close(rs, pstmt);

		}
		return viewList;
	}

	public ViewTable getObject(ResultSet rs) throws SQLException {

		int rank = rs.getInt("rank");
		String cfCode = rs.getString("cfCode");
		String cfName = rs.getString("cfName");
		int cfOne = rs.getInt("cfOne");
		int cfSell = rs.getInt("cfSell");
		int cfMargin = rs.getInt("cfMargin");
		int salePrice = rs.getInt("salePrice");
		int addTax = rs.getInt("addTax");
		int supplyPrice = rs.getInt("supplyPrice");
		int marginPrice = rs.getInt("marginPrice");
		return new ViewTable(rank, cfCode, cfName, cfOne, cfSell, cfMargin, salePrice, addTax, supplyPrice,
				marginPrice);
	}*/

}
