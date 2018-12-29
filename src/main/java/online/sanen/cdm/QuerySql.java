package online.sanen.cdm;

import java.util.List;
import java.util.Map;

import online.sanen.cdm.basic.BasicBean;
import online.sanen.cdm.basic.DataField;

/**
 * <pre>
 * This will operate the SQL statement as you normally would
 * &#64;author LazyToShow
 * Date: 2017/10/21 
 * Time: 23:19
 * </pre>
 */
public interface QuerySql extends Stream {

	/**
	 * Add parameters to your SQL to replace the question mark?This is a more
	 * recommended way to replace string splices
	 * 
	 * @param index
	 * @param paramer
	 * @return
	 */
	QuerySql addParamer(int index, Object paramer);

	/**
	 * Set the return value entity type, and if the item is set, the result set is
	 * encapsulated, otherwise it will automatically return the result based on the
	 * SQL, possibly a String,int,List,Map
	 * 
	 * @param entry
	 * @return
	 */
	QuerySql addEntry(Class<? extends BasicBean> entry);

	int update();

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
	 * The result set encapsulated in the form of {@code List<Map<String,Object>>}<br>
	 * This will be an acceptable way to get the mapping of SQL result sets
	 * 
	 * @return {@link List}{@code <}{@link Map}{@code <}
	 *         {@link String},{@link Object}{@code >}{@code >} 
	 */
	List<Map<String, Object>> maps();
	
	/**
	 The result set encapsulated in the form of {@code Map<String,Object>}<br>
	 * This will be an acceptable way to get the mapping of SQL result sets
	 * 
	 * @return {@link Map}{@code <}
	 *         {@link String},{@link Object}{@code >}
	 */
	Map<String, Object> map();

	/**
	 * Returns a single result;The return type is automatically determined based on
	 * the constructor, and if you want to return an entity type, add before that
	 * 
	 * @return
	 */
	<T> T unique();
	
	

	/**
	 * Gets the columns contained in the query result.
	 * @return
	 */
	List<DataField> getQueryColumns();

	/**
	 * Returns the specified number of results from the SQL statement
	 * @param count
	 */
	List<Map<String,Object>> stream(int count);
	

}
