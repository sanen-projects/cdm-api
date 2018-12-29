package online.sanen.cdm.basic;

/**
 * 
 * @author LazyToShow
 * Date: 2017/12/27
 * Time: 16:15
 */
public enum Sorts {
	
	ASCEND(""),DESC("DESC");
	
	private Sorts(String value) {
		this.value = value;
	}
	
	String value;

	public String getValue() {
		return value;
	}

}
