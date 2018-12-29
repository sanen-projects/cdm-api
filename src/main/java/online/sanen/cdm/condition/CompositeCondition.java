package online.sanen.cdm.condition;

import java.util.ArrayList;
import java.util.List;

import online.sanen.cdm.TypeIdentifier;

/**
 * 
 * @author LazyToShow <br>
 *         Date: 2018/06/12 <br>
 *         Time: 09:17
 */
public class CompositeCondition implements Condition,TypeIdentifier {

	/**
	 * @see Associated
	 */
	private Associated associated = Associated.AND;

	List<Condition> conditions = new ArrayList<>();
	
	public List<Condition> getConditions() {
		return conditions;
	}

	public void setConditions(List<Condition> conditions) {
		
		
		this.conditions = conditions;
	}

	public void add(Condition condition) {
		conditions.add(condition);
	}

	public CompositeCondition setAssociated(Associated associated) {
		this.associated = associated;
		return this;
	}

	@Override
	public Associated getAssociated() {
		return associated;
	}
	
	@Override
	public String toString() {
		return "CompositeCondition [associated=" + associated + ", conditions=" + conditions + "]";
	}
	
	

}
