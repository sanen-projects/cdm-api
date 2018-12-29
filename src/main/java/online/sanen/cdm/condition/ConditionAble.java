package online.sanen.cdm.condition;

import java.util.List;
import java.util.function.Consumer;

import online.sanen.cdm.condition.Condition.Cs;

/**
 * 
 *
 * @author LazyToShow <br>
 *         Date: Oct 26, 2018 <br>
 *         Time: 10:24:15 AM
 */
public interface ConditionAble {

	/**
	 * Add the query condition, which does not <strong>require</strong> value, <br>
	 * eg: {@code name is not null} <blockquote>addCondition("name",
	 * Conditions.IS_NOT_NULL)</blockquote>
	 * 
	 * @param cond
	 * @return
	 */
	Object addCondition(Condition cond);

	/**
	 * Add the query condition, which does not <strong>require</strong> value, <br>
	 * eg: {@code name is not null} <blockquote>addCondition("name",
	 * Conditions.IS_NOT_NULL)</blockquote>
	 * 
	 * @param fieldName
	 * @param cs - - coditions
	 * @return
	 */
	Object addCondition(String fieldName, Cs cs);

	/**
	 * Add conditions for the table fields <blockquote>addCondition("name",
	 * Conditions.EQUALS,"zhangsan")</blockquote>
	 * 
	 * @param fieldName
	 * @param cs - coditions
	 * @param value
	 * @return
	 */
	Object addCondition(String fieldName, Cs cs, Object value);

	/**
	 * 
	 * @param conds - conditions
	 * @return
	 */
	Object addCondition(Consumer<List<Condition>> conds);

}
