package online.sanen.cdm;


import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

import online.sanen.cdm.basic.BasicBean;
import online.sanen.cdm.basic.Sorts;
import online.sanen.cdm.condition.Condition;
import online.sanen.cdm.condition.Condition.Cs;
import online.sanen.cdm.condition.ConditionAble;

/**
 * @author LazyToShow Date: 2017/10/21 Time: 23:19
 */
public interface QueryTable extends ConditionAble, Stream {

	/**
	 * Set the return value entity type, and if the item is set, the result set is
	 * encapsulated, otherwise it will automatically return the result based on the
	 * SQL, possibly a String,int,List,Map
	 * 
	 * @param entry
	 * @return
	 */
	QueryTable addEntry(Class<? extends BasicBean> entry);

	@Override
	public QueryTable addCondition(Condition cond);

	@Override
	public QueryTable addCondition(String fieldName, Cs cs);

	@Override
	public QueryTable addCondition(String fieldName, Cs cs, Object value);

	@Override
	public QueryTable addCondition(Consumer<List<Condition>> conds);

	/**
	 * Sets the fields that participate in the operation, with the <strong>highest
	 * priority</strong> to override the fields of the entity class
	 * 
	 * @param fields
	 * @return
	 */
	QueryTable setFields(String... fields);

	/**
	 * All other fields are involved
	 * 
	 * @param fields
	 * @return
	 */
	QueryTable setExceptFields(String... fields);

	/**
	 * To add sorting
	 * 
	 * @param sorts
	 * @param fields
	 * @return
	 */
	QueryTable sort(Sorts sorts, String... fields);

	/**
	 * Returns a single result;The return type is automatically determined based on
	 * the constructor, and if you want to return an <strong>entity</strong> type,
	 * add before that
	 * 
	 * @return
	 */
	<T> T unique();

	/**
	 * 
	 * <p>If you need to return a result set instead of a single item; The return type
	 * is automatically determined by the constructor. If you want to return an
	 * entity type, add the entity type before the {@link #addEntry(Class)} method
	 * 
	 * <p>The method is equivalent to the integrator of two methods
	 * @see #entities()
	 * @see #maps()
	 * 
	 */
	<T> List<T> list();

	/**
	 * 
	 * @return Returns a collection of entity class mappings.
	 */
	<T extends BasicBean> List<T> entities();

	/**
	 * 
	 * @return Returns the result set key pair.
	 */
	List<Map<String, Object>> maps();

	/**
	 * This is a extraction function <blockquote>limit(0,10)</blockquote> This
	 * method is usually followed by a {@link #maps()} or {@link #list()} method<br>
	 * <br>
	 * Different databases will have different implementations, so refer to the
	 * database functions you're currently using, and if you don't support limit,
	 * you'll default to pulling the corresponding result set from the result set
	 * 
	 * @param args - If you're using <b>MYSQL</b> or <b>ORACLE</b> or <b>SQLITE</b>
	 *             you can go to <b>limit(0,100)</b>, if you're using
	 *             <b>SQLSERVER</b> you'll go to <b>limit(100)</b> and it'll convert
	 *             to <b>top 100</b>
	 * @return {@link QueryTable}
	 */
	QueryTable limit(Integer... args);

	/**
	 * Condition deletion, if no condition, is equivalent to clearing the table.
	 * 
	 * @return
	 */
	int delete();

	/**
	 * Determine whether the table exists.
	 * 
	 * @return
	 */
	boolean isExsites();

	/**
	 * Clear the table
	 * 
	 * @return
	 */
	int clear();

	/**
	 * Delete table
	 * 
	 * @return
	 */
	int drop();

	/**
	 * Modify table name
	 * 
	 * @param newName
	 * @return
	 */
	int updateName(String newName);

	/**
	 * Add fields to the table
	 * 
	 * @param columnName
	 * @param type
	 * @return
	 */
	int addColumn(String columnName, String type);

	/**
	 * 
	 * @param newTableName
	 * @return
	 */
	String createAndInsert(String newTableName);

}
