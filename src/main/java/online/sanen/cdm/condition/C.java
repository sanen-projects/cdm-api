package online.sanen.cdm.condition;

import static online.sanen.cdm.condition.Condition.Cs.*;

import java.util.function.Consumer;

import online.sanen.cdm.condition.Condition.Associated;
import online.sanen.cdm.condition.Condition.Cs;

/**
 * Condition build
 * 
 * @author LazyToShow
 * Date: 2018/06/12
 * Time: 09:17
 */
public class C{
	
	/**
	 * @param fieldName
	 * @param cs - {@link Cs}
	 * @return
	 */
	public static SimpleCondition buid(String fieldName, Cs cs) {
		return new SimpleCondition(fieldName, cs);
	}
	
	/**
	 * @param fieldName
	 * @param cs
	 * @param value
	 * @return
	 */
	public static SimpleCondition buid(String fieldName, Cs cs, Object value) {
		return new SimpleCondition(fieldName, cs, value);
	}

	/**
	 * @param fieldName
	 * @param conditions - {@link Cs}
	 * @param value
	 * @param associated - {@link Associated}
	 * @return
	 */
	public static SimpleCondition buid(String fieldName, Cs conditions, Object value, Associated associated) {
		return new SimpleCondition(fieldName, conditions, value, associated);
	}


	/**
	 * @param fieldName
	 * @param conditions - {@link Cs}
	 * @param associated - {@link Associated}
	 * @return
	 */
	public static SimpleCondition buid(String fieldName, Cs conditions, Associated associated) {
		return new SimpleCondition(fieldName, conditions, associated);
	}
	
	/**
	 * @param composite
	 * @return
	 */
	public static CompositeCondition buid(Consumer<CompositeCondition> composite) {
		CompositeCondition compositeCondition = new CompositeCondition();
		composite.accept(compositeCondition);
		
		return compositeCondition;
	}
	
	
	/**
	 * @param fieldName
	 * @return
	 */
	public static SimpleCondition buid(String fieldName) {
		SimpleCondition condition = new SimpleCondition();
		condition.setFieldName(fieldName);
		return condition;
	}

	public static SimpleCondition eq(String fieldName,Object value) {
		return buid(fieldName).eq(value);
	}

	public static SimpleCondition neq(String fieldName,Object value) {
		return buid(fieldName).neq(value);
	}

	public static SimpleCondition gt(String fieldName,Object value) {
		return buid(fieldName).gt(value);
	}

	public static SimpleCondition egt(String fieldName,Object value) {
		return buid(fieldName).egt(value);
	}

	public static SimpleCondition lt(String fieldName,Object value) {
		return buid(fieldName).lt(value);
	}

	public static SimpleCondition elt(String fieldName,Object value) {
		return buid(fieldName).egt(value);
	}

	public static SimpleCondition isNull(String fieldName) {
		return buid(fieldName).isNull();
	}

	public static SimpleCondition isNotNull(String fieldName) {
		return buid(fieldName).isNotNull();
	}

	public static SimpleCondition isEmpty(String fieldName) {
		return buid(fieldName).isEmpty();
	}

	public static SimpleCondition isNotEmpty(String fieldName) {
		return buid(fieldName).isNotEmpty();
	}

	public static SimpleCondition startWith(String fieldName,Object value) {
		return buid(fieldName).startWith(value);
	}

	public static SimpleCondition endWith(String fieldName,Object value) {
		return buid(fieldName).endWith(value);
	}

	public SimpleCondition contains(String fieldName,Object value) {
		return buid(fieldName).contains(value);
	}

	public SimpleCondition noContains(String fieldName,Object value) {
		return buid(fieldName).noContains(value);
	}

	public SimpleCondition in(String fieldName,String[] value) {
		return buid(fieldName).in(value);
	}

	public SimpleCondition in(String fieldName,int[] value) {
		return buid(fieldName).in(value);
	}

	public SimpleCondition in(String fieldName,double[] value) {
		return buid(fieldName).in(value);
	}

	public SimpleCondition notIn(String fieldName,String[] value) {
		return buid(fieldName).notIn(value);
	}

	public SimpleCondition notIn(String fieldName,int[] value) {
		return buid(fieldName).notIn(value);
	}

	public SimpleCondition notIn(String fieldName,double[] value) {
		return buid(fieldName).notIn(value);
	}

	public SimpleCondition between(String fieldName,int start, int end) {
		return buid(fieldName).between(start, end);
	}

	public SimpleCondition between(String fieldName,String start, String end) {
		return buid(fieldName).between(start, end);
	}
	
	public SimpleCondition contains(String fieldName,String value) {
		return buid(fieldName, CONTAINS, value);
	}
	
}
