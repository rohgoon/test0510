package kr.or.dgit.bigdata.setting;

import java.io.File;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import kr.or.dgit.bigdata.NcsConfig;
import kr.or.dgit.bigdata.dao.NcsDao;
import kr.or.dgit.bigdata.jdbc.NcsJdbc;
import kr.or.dgit.bigdata.jdbc.NcsJdbcUtil;

public class ExportSettingService extends ServiceSetting {
	private boolean buNot;
	@Override
	public void initSetting() {
		NcsDao dao = NcsDao.getInstance();
		dao.selectUseDatabase();

		checkBackupDir();

		for (String tableName : NcsConfig.TABLE_NAME) {
			executeExportData(getFilePath(tableName, false), tableName); // 확인요망
		}
		if (buNot == false) {
			JOptionPane.showMessageDialog(null, "데이터 백업 완료");
		}
		copyFile();
	}

	private void copyFile() {
		File srcDir = new File(NcsConfig.MYSQL_EXPORT_PATH);
		File destDir = null;
		for (File file : srcDir.listFiles()) {
			destDir = new File(NcsConfig.IMPORT_DIR + file.getName());
			file.renameTo(destDir);
			file.delete(); 
		}

	}

	private void executeExportData(Object filePath, String tableName) {
		String sql = String.format("select * into outfile '%s' " 
				+ "character set 'UTF8' " 
				+ "fields terminated by ',' "
				+ "lines terminated by '\n' from %s", filePath, tableName);
		Statement stmt = null;
		//System.out.println(" 확인 : "+sql);
		Connection con = NcsJdbc.getConnection();
		try {
			stmt = con.createStatement();
			stmt.executeQuery(sql);
			System.out.printf("Export Table(%s) %d Rows Success! %n",tableName, stmt.getUpdateCount());
		} catch (SQLException e) {
			buNot = true;
			System.out.printf("error %d : %s %n", e.getErrorCode(), e.getMessage());
		} finally {
			
			NcsJdbcUtil.close(stmt);
		}

	}

	private void checkBackupDir() {
		File backupDir = new File(NcsConfig.IMPORT_DIR);
		if (backupDir.exists()) {
			for (File file : backupDir.listFiles()) {
				file.delete();
				System.out.println("백업 파일 삭제 완료");
			}

		} else {
			backupDir.mkdir();
			System.out.println("백업 파일 생성 완료");

		}

	}

}
