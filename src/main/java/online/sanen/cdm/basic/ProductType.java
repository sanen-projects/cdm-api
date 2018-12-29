package online.sanen.cdm.basic;

import java.sql.Connection;
import java.util.HashSet;

import online.sanen.cdm.template.JdbcTemplate;
import online.sanen.cdm.template.SqlRowSet;

/**
 * Database of different manufacturers enumeration, at the same time because of
 * different manufacturers caused differences, also try to resolve in this type
 * 
 * @author LazyToShow <br>
 *         Date： 2018年8月20日 <br>
 *         Time: 上午11:09:31
 */
public enum ProductType {

	MYSQL, SQLITE, MICROSOFT_SQL_SERVER, ORACLE;

	/**
	 * In SQL queries, if the table name contains a special symbol that needs to be
	 * wrapped in a layer of modifiers, different database vendor modifiers will be
	 * different, and this method is designed to provide uniformly, and by default,
	 * return an empty string
	 * 
	 * @param productType
	 * @return
	 */
	public static String applyTableModifier(ProductType productType) {

		if (productType == ProductType.MYSQL) {
			return "`";
		} else if (productType == ProductType.SQLITE || productType == ProductType.ORACLE) {
			return "\"";
		} else {
			return "";
		}

	}

	/**
	 * 
	 * @param productType
	 * @param tableName
	 * @param newName
	 * @return
	 */
	public static String updateTableNameSQL(ProductType productType, String tableName, String newName) {
		
		String modifier = ProductType.applyTableModifier(productType);

		if (productType == ProductType.MICROSOFT_SQL_SERVER)
			return "EXEC sp_rename "+modifier + tableName + modifier+", '" + newName + "';";
		else
			return "ALTER TABLE "+modifier + tableName +modifier+ " RENAME TO \"" + newName+"\"";
	}

	/**
	 * 
	 * @param productType
	 * @param template
	 * @param tableName
	 * @return
	 */
	public static HashSet<String> getColumnsFromTableName(ProductType productType, JdbcTemplate template,
			String tableName)  {

		SqlRowSet rs = null;
		
		switch (productType) {

		case MYSQL:
			try (Connection conn = template.getDataSource().getConnection()) {
				
				rs = template.queryForRowSet(
						"SELECT COLUMN_NAME FROM INFORMATION_SCHEMA.COLUMNS WHERE TABLE_NAME = ? AND TABLE_SCHEMA = ?;",
						tableName, conn.getCatalog());
				
			}catch (Exception e) {
				throw new CdmQueryException(e);
			}

			break;

		case SQLITE:
			rs = template.queryForRowSet("PRAGMA table_info('" + tableName + "')");
			break;

		case MICROSOFT_SQL_SERVER:
			rs = template.queryForRowSet("SELECT column_name FROM INFORMATION_SCHEMA.columns WHERE TABLE_NAME=? ",
					tableName);
			break;

		case ORACLE:
			if(tableName.contains("."))
				tableName = tableName.split("\\.")[1];
			rs = template.queryForRowSet("SELECT t.COLUMN_NAME FROM ALL_TAB_COLUMNS t where t.TABLE_NAME=?",tableName);
			break;

		default:
			throw new RuntimeException("You may not support the current connection database:" + productType
					+ " type, but you can use the createSQL interface to continue the operation.");
		}

		HashSet<String> columns = new HashSet<>();

		while (rs.next()) {

			if (productType.equals(ProductType.SQLITE))
				columns.add(rs.getString(2));
			else
				columns.add(rs.getString(1));
		}
		
		if(columns.isEmpty())
			throw new CdmQueryException("Table '"+tableName+"' or view has no fields or insufficient current user permissions.");

		return columns;
	}

	/**
	 * 
	 * @param productType
	 * @param sql
	 * @param limit
	 * @return
	 */
	public static boolean processLimit(ProductType productType, StringBuilder sql, Integer[] limit) {

		if (productType == null || sql == null || limit == null || limit[0] == null)
			return false;

		switch (productType) {
		case MYSQL:
			proceessCommonLimit(sql, limit);
			return true;

		case SQLITE:
			proceessCommonLimit(sql, limit);
			return true;

		case MICROSOFT_SQL_SERVER:
			proceessSqlServerLimit(sql, limit);
			return true;
			
		case ORACLE:
			proceessOracleLimit(sql, limit);
			return true;

		default:
			return false;
		}
	}


	private static void proceessOracleLimit(StringBuilder sql, Integer[] limit) {
		
		String[] split = sql.toString().split("from");
		String preffix = "select * from (" + split[0]+",rownum rn from "+split[1]+") v where v.rn";
		if(limit.length == 1)
			preffix+="<="+limit[0];
		
		if(limit.length == 2)
			preffix+=">"+limit[0]+" and v.rn<="+(limit[0]+limit[1]);
		
		
		sql.setLength(0);
		sql.append(preffix);
		
	}

	private static void proceessCommonLimit(StringBuilder sql, Integer[] limit) {

		sql.append(" limit " + limit[0]);
		if (limit.length > 1 && limit[1] != null && limit[1] > 0)
			sql.append("," + limit[1]);

	}

	private static void proceessSqlServerLimit(StringBuilder sql, Integer[] limit) {

		sql.replace(0, 6, "select top " + limit[0]).toString();
	}

}
