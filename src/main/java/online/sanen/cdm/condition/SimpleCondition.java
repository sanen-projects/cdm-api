package online.sanen.cdm.condition;

import online.sanen.cdm.TypeIdentifier;
import online.sanen.cdm.basic.CdmConditionException;
import static online.sanen.cdm.condition.Condition.Cs.*;
import static online.sanen.cdm.condition.Condition.Associated.*;

/**
 * Query conditions Instance , In the form of objects embedded in the query
 * method . <br>
 * <br>
 * <strong>fieldName - </strong>In the name of the field operation .<br>
 * <strong>value - </strong>The value Of the field .<br>
 * <strong>conditions - </strong>The relationship between the field and value
 * .<br>
 * <br>
 * For example :
 * 
 * <pre>
 * 	<code>
 * 	new SimpleCondition('name',Cs.EQUALS,'zhangsan');
 * 	</code>
 * </pre>
 * 
 * 
 * @author LazyToshow <br>
 *         Date: 2016/07/25 <br>
 *         Time: 14:56
 */
public class SimpleCondition implements Condition, TypeIdentifier, Comparable<SimpleCondition> {

	/**
	 * The field name in the condition
	 */
	private String fieldName;

	/**
	 * Concrete conditions, enumerated types
	 */
	private Cs cs;

	/**
	 * The achieved value of the condition
	 */
	private Object value;

	/**
	 * @see Associated
	 */
	private Associated associated = AND;

	/**
	 * By default, no arguments constructor is recommended, but you can refer to
	 * others
	 */
	public SimpleCondition() {

	}

	/**
	 * Construct a condition that has no value option
	 * @param fieldName
	 * @param cs
	 * @throws CdmConditionException
	 */
	public SimpleCondition(String fieldName, Cs cs) throws CdmConditionException {
		this(fieldName, cs, null);
	}

	/**
	 * <p>
	 * Construct a condition that has no value option but contains connection mode
	 * 
	 * <p>
	 * If this condition is not need value ( for example select id from tableName
	 * where name is not null, like this field : 'name' , because it's not neet
	 * value for itself )
	 * @param fieldName
	 * @param cs
	 * @param associated
	 * @throws CdmConditionException
	 */
	public SimpleCondition(String fieldName, Cs cs, Associated associated) throws CdmConditionException {

		if (!cs.equals(IS_EMPTY) && !cs.equals(IS_NOT_EMPTY) && !cs.equals(IS_NULL) && !cs.equals(IS_NOT_NULL))
			throw new CdmConditionException("this option : '" + cs
					+ "' must match value. \r\n you can try to use @Condition(String fieldName,Object value,Options option)");

		if (associated != null)
			this.associated = associated;
		this.fieldName = fieldName;
		this.cs = cs;
	}

	/**
	 * Construct a conditional instance with a value option
	 * 
	 * @param fieldName
	 * @param cs
	 * @param value
	 */
	public SimpleCondition(String fieldName, Cs cs, Object value) {
		this(fieldName, cs, value, null);
	}

	/**
	 * if the field is need value With the corresponding
	 * 
	 * @param fieldName
	 * @param cs
	 * @param value
	 * @param associated
	 */
	public SimpleCondition(String fieldName, Cs cs, Object value, Associated associated) {
		if (associated != null)
			this.associated = associated;
		this.fieldName = fieldName;
		this.value = value;
		this.cs = cs;
	}

	public Cs getCondition() {
		return cs;
	}

	public void setCondition(String condition) {
		this.cs = Cs.valueOf(condition);
	}

	public void setCondition(Cs condition) {
		this.cs = condition;
	}

	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}

	public Associated getAssociated() {
		return associated;
	}

	public void setAssociated(Associated associated) {
		this.associated = associated;
	}

	public SimpleCondition eq(Object value) {
		setCondition(EQUALS);
		setValue(value);
		return this;
	}

	public SimpleCondition neq(Object value) {
		setValue(value);
		setCondition(NO_EQUALS);
		return this;
	}

	public SimpleCondition gt(Object value) {
		setValue(value);
		setCondition(GT);
		return this;
	}

	public SimpleCondition egt(Object value) {
		setValue(value);
		setCondition(GT_EQUALS);
		return this;
	}

	public SimpleCondition lt(Object value) {
		setValue(value);
		setCondition(LT);
		return this;
	}

	public SimpleCondition elt(Object value) {
		setValue(value);
		setCondition(lT_EQUALS);
		return this;
	}

	public SimpleCondition isNull() {
		setCondition(IS_NULL);
		return this;
	}

	public SimpleCondition isNotNull() {
		setCondition(IS_NOT_NULL);
		return this;
	}

	public SimpleCondition isEmpty() {
		setCondition(IS_EMPTY);
		return this;
	}

	public SimpleCondition isNotEmpty() {
		setCondition(IS_NOT_EMPTY);
		return this;
	}

	public SimpleCondition startWith(Object value) {
		setValue(value);
		setCondition(START_WITH);
		return this;
	}

	public SimpleCondition endWith(Object value) {
		setValue(value);
		setCondition(END_WITH);
		return this;
	}

	public SimpleCondition contains(Object value) {
		setValue(value);
		setCondition(CONTAINS);
		return this;
	}

	public SimpleCondition noContains(Object value) {
		setValue(value);
		setCondition(NO_CONTAINS);
		return this;
	}

	public SimpleCondition in(String[] value) {
		setValue(value);
		setCondition(IN);
		return this;
	}

	public SimpleCondition in(int[] value) {
		setValue(value);
		setCondition(IN);
		return this;
	}

	public SimpleCondition in(double[] value) {
		setValue(value);
		setCondition(IN);
		return this;
	}

	public SimpleCondition notIn(String[] value) {
		setValue(value);
		setCondition(NOT_IN);
		return this;
	}

	public SimpleCondition notIn(int[] value) {
		setValue(value);
		setCondition(NOT_IN);
		return this;
	}

	public SimpleCondition notIn(double[] value) {
		setValue(value);
		setCondition(NOT_IN);
		return this;
	}

	public SimpleCondition between(int start, int end) {
		setValue(new int[] { start, end });
		setCondition(BETWEEN);
		return this;
	}

	public SimpleCondition between(String start, String end) {
		setValue(new String[] { start, end });
		setCondition(BETWEEN);
		return this;
	}

	public SimpleCondition and() {
		setAssociated(AND);
		return this;
	}

	public SimpleCondition or() {
		setAssociated(OR);
		return this;
	}

	@Override
	public int compareTo(SimpleCondition o) {
		return getFieldName().compareToIgnoreCase(o.getFieldName());
	}

	@Override
	public String toString() {
		return "SimpleCondition [fieldName=" + fieldName + ", cs=" + cs + ", value=" + value + ", associated="
				+ associated + "]";
	}

}
