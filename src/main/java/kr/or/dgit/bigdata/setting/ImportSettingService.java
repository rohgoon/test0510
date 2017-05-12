package kr.or.dgit.bigdata.setting;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import kr.or.dgit.bigdata.NcsConfig;
import kr.or.dgit.bigdata.dao.NcsDao;
import kr.or.dgit.bigdata.jdbc.NcsJdbc;
import kr.or.dgit.bigdata.jdbc.NcsJdbcUtil;

public class ImportSettingService extends ServiceSetting {
	private boolean buNot;
	@Override
	public void initSetting() {
		NcsDao dao = NcsDao.getInstance();
		dao.selectUseDatabase();
		
		dao.setForeignKeyCheck(0);
		for (String t : NcsConfig.TABLE_NAME) {
			executeImportDate(getFilePath(t, true), t);
		}
		if (buNot == false) {
			JOptionPane.showMessageDialog(null, "데이터 복원 완료");
		}
		dao.setForeignKeyCheck(1);
	}

	private void executeImportDate(String tablePath, String tableName) {
		String sql = String.format("LOAD DATA LOCAL INFILE '%s' INTO TABLE %s character set 'UTF8' fields TERMINATED by ','",
				tablePath, tableName);
		//System.out.println("복원용 sql : " + sql+"%n");
		Statement stmt = null;
		try {
			Connection con = NcsJdbc.getConnection();
			stmt = con.createStatement();
			stmt.execute(sql);
			System.out.printf("Import Table(%s) %d Rows Success! %n",tableName, stmt.getUpdateCount());
		} catch (SQLException e) {
			buNot = true;
			System.out.printf("error %d : %s %n", e.getErrorCode(), e.getMessage());
			if (e.getErrorCode() == 1062) {
				System.err.println("중복데이터 존재");
			}
		} finally {
			NcsJdbcUtil.close(stmt);
		}

	}

}
