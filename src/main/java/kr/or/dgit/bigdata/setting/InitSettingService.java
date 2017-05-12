package kr.or.dgit.bigdata.setting;

import java.util.HashMap;
import java.util.Map;

import kr.or.dgit.bigdata.NcsConfig;
import kr.or.dgit.bigdata.dao.NcsDao;
import kr.or.dgit.bigdata.dao.TableDao;
import kr.or.dgit.bigdata.dao.UserDao;

public class InitSettingService extends ServiceSetting {
	private Map<String, String> TABLE_SQL = new HashMap<String, String>();

	@Override
	public void initSetting() {
		creatSql();
		creatDatabase();
		createTable();
		creatUser();
	}

	private void creatUser() {
		UserDao.getInstance().initUser();
	}

	private void createTable() {
		TableDao dao = TableDao.getInstance();
		for (int i = 0; i < NcsConfig.TABLE_NAME.length; i++) {
			dao.createItem(TABLE_SQL.get(NcsConfig.TABLE_NAME[i]));
		}
		//dao.createViewTable();
	}

	private void creatDatabase() {
		NcsDao dao = NcsDao.getInstance();
		dao.createItem();
		dao.selectUseDatabase();

	}

	private void creatSql() {
		TABLE_SQL.put("title", 
				"create table title (tcode INT(11) NOT NULL, tname VARCHAR(10) NULL, primary key(tcode))");
		TABLE_SQL.put("department", 
				"create table department (dcode INT(11) NOT NULL, dname CHAR(10) NOT NULL,"
				+ "floor INT(11) NULL, primary key(dcode))");
		TABLE_SQL.put("employee",
				"create table employee (eno INT(11) NOT NULL,"
				+ "ename VARCHAR(20) NOT NULL,"
				+ "salary INT(11) NULL,"
				+ "dno INT(11) NULL,"
				+ "gender TINYINT(1) NULL,"
				+ "joindate DATE NULL,"
				+ "title INT(11) NULL,"
				+ "primary key (eno),"
				+ "foreign key (title) references title(tcode),"
				+ "foreign key (dno) references department(dcode))");

	}

}
