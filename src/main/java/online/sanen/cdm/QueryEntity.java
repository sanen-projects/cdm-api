package online.sanen.cdm;

import java.util.List;
import java.util.function.Consumer;

import com.mhdt.annotation.Table;

import online.sanen.cdm.condition.Condition;
import online.sanen.cdm.condition.Condition.Cs;
import online.sanen.cdm.condition.ConditionAble;

/**
 * <pre>
 * Custom table operations
 * @author LazyToShow
 * Date: 2017/10/21 
 * Time: 23:19
 *  </pre>
 */
public interface QueryEntity extends ConditionAble{

	/**
	 * Set the table name, which has the highest priority to override the bean name
	 * and {@link Table} annotation
	 * 
	 * @param tableName
	 * @return
	 */
	QueryEntity setTableName(String tableName);

	/**
	 * Sets the fields that participate in the operation, with the highest priority
	 * to override the fields of the entity class
	 * 
	 * @param fields
	 * @return
	 */
	QueryEntity setFields(String... fields);

	/**
	 * All other fields are involved
	 * 
	 * @param fields
	 * @return
	 */
	QueryEntity setExceptFields(String... fields);
	
	@Override
	public QueryUpdate addCondition(Condition cond);

	@Override
	public QueryUpdate addCondition(String fieldName, Cs cs);

	@Override
	public QueryUpdate addCondition(String fieldName, Cs cs, Object value);
	
	@Override
	public QueryUpdate addCondition(Consumer<List<Condition>> conds);

	int insert();

	int delete();

	int update();

	int create();

}
