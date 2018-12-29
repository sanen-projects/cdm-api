package online.sanen.cdm;

/**
 * 
 *
 * @author LazyToShow <br>
 *         Date: Dec 6, 2018 <br>
 *         Time: 10:21:02 AM
 */
public interface TypeIdentifier {

	/**
	 * Gets a subclass instance type that can be used to analyze the database
	 * structure type after serialization
	 * 
	 * @return
	 */
	default String getType() {
		return this.getClass().getName();
	}

}
