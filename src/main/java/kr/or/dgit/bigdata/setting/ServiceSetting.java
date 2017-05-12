package kr.or.dgit.bigdata.setting;

import kr.or.dgit.bigdata.NcsConfig;

public abstract class ServiceSetting {
	protected static String getFilePath(String tableName, boolean isImport) {
        StringBuilder sb = new StringBuilder();
        sb.append(isImport ? NcsConfig.IMPORT_DIR : NcsConfig.MYSQL_EXPORT_PATH).append(tableName).append(".txt");
        return sb.toString().replace("\\", "/");
    }   
	public abstract void initSetting();
}
