package online.sanen.cdm.basic;

import online.sanen.cdm.template.transaction.TransactionFactory;

/**
 * Abstract configuration instance objects, in addition to the <strong> Driver,
 * Url, Username, Password</strong>, are initialized with the default values
 * 
 * @author LazyToShow <br>
 *         Date: 2018/1/29 <br>
 *         Time: 11:36
 *
 */
public class Obstract {

	public enum DataSouseType {
		Dbcp, Druid
	}

	DataSouseType dataSouseType;

	public Obstract() {
		this(DataSouseType.Dbcp);
	}

	public Obstract(DataSouseType type) {
		this.dataSouseType = type;
	}

	String url;

	String username = "";

	String password = "";

	String driver;

	boolean isLog = false;

	boolean isFormat = true;

	boolean isCache = false;

	boolean isShowSql = true;

	TransactionFactory transactionFactory;

	public DataSouseType getDataSouseType() {
		return dataSouseType;
	}

	public void setDataSouseType(DataSouseType dataSouseType) {
		this.dataSouseType = dataSouseType;
	}

	public String getUrl() {
		return url;
	}

	/**
	 * Set the JDBC connection url
	 * 
	 * @param url
	 *            - Enumerate the different database connections:
	 * 
	 *            <pre>
	 * 				<code>
	 *            jdbc:oracle:thin:@//127.0.0.1:1521/orcl
	 *            jdbc:mysql://127.0.0.1:3306/test?useSSL=false
	 *            jdbc:sqlite:tmp/data/test.sqlite
	 *            jdbc:sqlserver://127.0.0.1:1433;DatabaseName=test
	 *        		 </code>
	 *            </pre>
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isLog() {
		return isLog;
	}

	public void setLog(boolean isLog) {
		this.isLog = isLog;
	}

	public boolean isFormat() {
		return isFormat;
	}

	public void setFormat(boolean isFormat) {
		this.isFormat = isFormat;
	}

	public boolean isCache() {
		return isCache;
	}

	public void setCache(boolean isCache) {
		this.isCache = isCache;
	}

	public boolean isShowSql() {
		return isShowSql;
	}

	public void setShowSql(boolean isShowSql) {
		this.isShowSql = isShowSql;
	}

	public String getDriver() {
		return driver;
	}

	public void setDriver(Driven driven) {
		setDriver(driven.getValue());
	}

	public void setDriver(String driver) {
		this.driver = driver;
	}

	public TransactionFactory getTransactionFactory() {
		return transactionFactory;
	}

	public void setTransactionFactory(TransactionFactory transactionFactory) {
		this.transactionFactory = transactionFactory;
	}

}
