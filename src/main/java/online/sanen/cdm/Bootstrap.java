package online.sanen.cdm;

import java.util.Collection;
import java.util.Map;

import online.sanen.cdm.basic.BasicBean;
import online.sanen.cdm.component.Manager;
import online.sanen.cdm.template.transaction.TransactionFactory;

/***
 * <b>Boot device</b>,There are several patterns
 * 
 * <pre>
 * {@link QuerySql} ：Write the Sql statement directly
 * {@link QueryEntity} ：Operation object instance for addition/deletion/modification (batch operation)
 * {@link QueryPK} ： Operation entity type for primary key operation
 * {@link QueryTable} ：Direct operation table for query/delete/modification
 * </pre>
 * 
 * @see <a href="http://www.sanen.online">SANEN.ONLINE</a>
 * 
 * @author lazyToShow <br>
 *         Date: 2017/10/21 <br>
 *         Time: 23:19
 */
public interface Bootstrap {

	/**
	 * Customize Sql operations
	 */
	QuerySql createSQL(String sql);

	/**
	 * Customize Sql operations
	 * 
	 * @param sql      - Usage of parameters in SQL<strong> ? </strong>Take the
	 *                 place of
	 * @param paramers - Parameters (ordered) are not required
	 */
	QuerySql createSQL(String sql, Object... paramers);

	/**
	 * Object operation: Insert (Insert), modify (Update), delete (Remove)
	 * 
	 * @param entry - In the entity class, you need to implement the
	 *              {@link BasicBean} interface and return the corresponding table
	 *              primary key name. <br>
	 *              (for example, returning null is the default id as the primary
	 *              key)
	 */
	QueryEntity query(BasicBean entry);

	/**
	 * If you don't want to generate entity classes, another option is to manipulate
	 * the map instance, {@link QueryMap} provides Add and delete operations are
	 * provided.
	 * 
	 * @param tableName
	 * @param map
	 * @return
	 */
	QueryMap query(String tableName, Map<String, Object> map);

	/**
	 * * If you don't want to generate entity classes, another option is to
	 * manipulate the map instance, {@link QueryMap} provides Add and delete
	 * operations are provided.
	 * 
	 * @param tableName
	 * @param maps
	 * @return
	 */
	QueryMap query(String tableName, Collection<Map<String, Object>> maps);

	/**
	 * Batch operation: Insert (Insert), modify (Update), delete (Remove)
	 * 
	 * @param entrys - For the entity class collection, you need to implement the
	 *               {@link BasicBean} interface and return the corresponding table
	 *               primary key name.<br>
	 *               (for example, returning null is the default id as the primary
	 *               key)
	 */
	QueryEntity query(Collection<? extends BasicBean> entrys);

	/**
	 * Primary key operation, Remove (Remove), query single case (find)
	 * 
	 * @param entry    - Entity class
	 * @param keyValue - The primary key value can be an int or String type
	 */
	<BacicBean extends BasicBean> QueryPK<BacicBean> query(Class<BacicBean> entry, Object keyValue);

	/**
	 * Custom table operation, delete query (List, UniqResult)
	 * 
	 * @param tableName - The name of the table
	 */
	QueryTable query(String tableName);

	/**
	 * Replace the table name with the class name
	 * 
	 * @param cls - Entity class type
	 * @see #query(String)
	 * @return {@link QueryTable}
	 */
	<T extends BasicBean> QueryTable query(Class<T> cls);

	/**
	 * Get the {@link DataInformation},Through this interface you can get some
	 * connection information, such as database name, table name, and field details
	 * @return
	 */
	DataInformation dataInformation();

	/**
	 * Gets the current link information.
	 * 
	 * @return
	 */
	Manager manager();

	/**
	 * Bind global transactions
	 * 
	 * @param factory
	 */
	void bindTransaction(TransactionFactory factory);
}
