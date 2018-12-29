package online.sanen.cdm;

import java.util.List;

import online.sanen.cdm.basic.DataField;

/**
 * 
 * @author LazyToShow <br>
 * Date： 2018年7月18日 <br>
 * Time: 下午3:41:18
 */
public abstract class DataInformation {
	
	protected Bootstrap bootstrap;
	
	public DataInformation(Bootstrap bootstrap) {
		this.bootstrap = bootstrap;
	}

	/**
	 * Gets the name of the library under the current connection
	 * @return
	 */
	public abstract List<String> getDatabases();

	/**
	 * Gets the name of the table under the current connection (library)
	 * @return
	 */
	public abstract List<String> getTableNames();

	/**
	 * Gets the current database connection field
	 * @param tableName
	 * @return
	 */
	public abstract List<DataField> getFields(String tableName);

	/**
	 * Determines whether a table is included in the current connection (table name
	 * are case insensitive)
	 * @param tableName
	 * @return
	 */
	public  boolean containsTable(String tableName) {
		
		List<String> tableNames = getTableNames();
		return tableNames != null
				&& tableNames.stream().anyMatch(it -> it.toUpperCase().equals(tableName.toUpperCase()));
	}

}
