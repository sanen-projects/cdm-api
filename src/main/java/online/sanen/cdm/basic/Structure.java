package online.sanen.cdm.basic;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import com.mhdt.analyse.Validate;
import com.mhdt.toolkit.Reflect;

import online.sanen.cdm.component.Manager;
import online.sanen.cdm.component.ManagerBridge;
import online.sanen.cdm.condition.Condition;
import online.sanen.cdm.condition.SimpleCondition;

/**
 * <pre>
 * The intermediate products of the construction process are stored on the entity object.	
 * &#64;author LazyToShow
 * Date: 2017/10/21 
 * Time: 23:19
 * </pre>
 */
public class Structure extends ManagerBridge {

	public Structure(Manager manager) {
		super(manager);
	}

	Class<?> cls;

	String tableName;

	StringBuilder sql = new StringBuilder();

	List<Condition> conditions;

	Set<String> fields;

	Set<String> exceptes;

	BasicBean entry;

	Map<String, Object> enMap;

	Class<? extends BasicBean> entry_class;

	Map<Integer, Object> paramers = new TreeMap<>();

	public String getTableName() {

		if (!Validate.isNullOrEmpty(tableName))
			return tableName;

		Class<? extends BasicBean> entryClass = getEntry_class();

		if (entryClass != null)
			tableName = Cdm.table(entryClass);

		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public StringBuilder getSql() {
		return sql;
	}

	public void setSql(String sql) {
		this.sql.setLength(0);
		this.sql.append(sql);
	}

	public List<Condition> getConditions() {
		if (conditions == null)
			conditions = new ArrayList<>();
		return conditions;
	}

	public void setConditions(List<Condition> conditions) {
		this.conditions = conditions;
	}

	public Set<String> getFields() {
		return fields;
	}

	public void setFields(Set<String> fields) {
		this.fields = fields;
	}

	public Set<String> getExceptes() {
		return exceptes;
	}

	public void setExceptes(Set<String> exceptes) {
		this.exceptes = exceptes;
	}

	public Class<? extends BasicBean> getEntry_class() {
		if (entry_class != null)
			return entry_class;

		if (entry != null)
			return entry_class = entry.getClass();

		if (entrys != null && entrys.size() > 0)
			return entrys.stream().findFirst().get().getClass();

		return null;
	}

	public void setEntry_class(Class<? extends BasicBean> entry_class) {
		this.entry_class = entry_class;
	}

	public void addParamer(int index, Object paramer) {

		paramers.put(index, paramer);
	}

	public BasicBean getEntry() {

		if (entry == null && getEntry_class() != null) {

			try {
				Class<?> cls = getEntry_class();
				entry = (BasicBean) Reflect.newInstance(cls.getName());
			} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
				e.printStackTrace();
			}

		}

		return entry;
	}

	public void setEntry(BasicBean entry) {
		this.entry = entry;
	}

	public Map<Integer, Object> getParamers() {
		return paramers;
	}

	public void setParamers(Map<Integer, Object> paramers) {
		this.paramers = paramers;
	}

	ResultType resultType;

	public ResultType getResultType() {
		return resultType;
	}

	public void setResultType(ResultType resultType) {
		this.resultType = resultType;
	}

	QueryType queryType;

	public QueryType getQueryType() {
		return queryType;
	}

	public void setQueryType(QueryType queryType) {
		this.queryType = queryType;
	}

	Set<String> commonFilds;

	public Set<String> getCommonFields() {
		return commonFilds;
	}

	public void setCommonFields(Set<String> tableFields) {
		this.commonFilds = tableFields;
	}

	/**
	 * 
	 * If the type of value is an <b>Array</b> or {@link Collection}, it will be
	 * broken down and added one by one.<br>
	 * <br>
	 * 
	 * An <b>Array</b>/{@link Collection} is valid when using a function like
	 * <b>BETWEEN</b> because it requires multiple arguments, and then an
	 * <b>Array</b>/{@link Collection} class is required . to wrap it
	 * 
	 * @param value
	 */
	public void addParamer(Object value) {
		
		if (value != null && value.getClass().isArray()) {
			Object[] array = (Object[]) value;
			for (Object it : array)
				this.addParamer(it);
		} else if (value != null && value instanceof Collection) {
			@SuppressWarnings("unchecked")
			Collection<Object> cc = (Collection<Object>) value;
			cc.forEach(this::addParamer);
		} else {
			paramers.put(paramers.size() + 1, value);
		}

	}

	public void addParamer(SimpleCondition condition) {

		Object value = condition.getValue();

		if (value == null) {
			paramers.put(paramers.size() + 1, value);
			return;
		}

		if (value.getClass().isArray()) {
			Object[] array = (Object[]) value;
			for (Object it : array)
				this.addParamer(it);
		} else if (value instanceof Collection) {
			@SuppressWarnings("unchecked")
			Collection<Object> cc = (Collection<Object>) value;
			cc.forEach(this::addParamer);
		} else {
			paramers.put(paramers.size() + 1, value);
		}

	}

	public void addCondition(Condition condition) {
		if (conditions == null)
			conditions = new ArrayList<Condition>();

		conditions.add(condition);
	}

	String primaryKey;

	public String getPrimaryKey() {
		

		if (primaryKey != null)
			return primaryKey;

		// Get From Entry
		BasicBean basicBean = getEntry();
		if (basicBean != null)
			primaryKey = basicBean.primarykey() == null ? "id" : basicBean.primarykey();

		return primaryKey;
	}

	public void setPrimaryKey(String primaryKey) {
		this.primaryKey = primaryKey;
	}

	/** primary value */
	Object primaryValue;

	public Object getPrimaryValue() {

		if (primaryValue == null && getEntry() != null)
			primaryValue = Reflect.getInject(getEntry(), getPrimaryKey());

		return primaryValue;
	}

	public void setPrimaryValue(Object primaryValue) {
		this.primaryValue = primaryValue;
	}

	Integer[] limit;

	public void setLimit(Integer[] args) {
		this.limit = args;
	}

	public Integer[] getLimit() {
		return limit;
	}

	Collection<BasicBean> entrys;

	public void setEntrys(Collection<BasicBean> entrys) {
		this.entrys = entrys;
	}

	public Collection<BasicBean> getEntrys() {
		return entrys;
	}

	/**
	 * Whether the current version supports limit operations in the current database
	 * .
	 */
	boolean isSupportLimit;

	public boolean isSupportLimit(boolean flag) {
		return isSupportLimit = flag;
	}

	public boolean isSupportLimitAble() {
		return isSupportLimit;
	}

	/**
	 * The limit operation is set
	 */
	boolean hasLimit;

	public boolean hasLimitAble() {
		return hasLimit;
	}

	public void setHasLimitAble(boolean flag) {
		hasLimit = flag;
	}

	public Map<String, Object> getEnMap() {
		return enMap;
	}

	public void setEnMap(Map<String, Object> enMap) {
		this.enMap = enMap;
	}

	SortSupport sortSupport;

	private Collection<Map<String, Object>> enMaps;

	public interface SortSupport {

		public String toString();

	}

	public SortSupport getSortSupport() {
		return sortSupport;
	}

	public void setSortSupport(SortSupport sortSupport) {
		this.sortSupport = sortSupport;
	}

	public void setEnMaps(Collection<Map<String, Object>> maps) {
		this.enMaps = maps;
	}

	public Collection<Map<String, Object>> getEnMaps() {
		return enMaps;
	}

	public Class<?> getCls() {
		return cls;
	}

	public void setCls(Class<?> cls) {
		this.cls = cls;
	}

}
