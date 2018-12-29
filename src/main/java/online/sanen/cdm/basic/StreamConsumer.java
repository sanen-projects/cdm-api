package online.sanen.cdm.basic;

import java.util.List;
import java.util.Map;

public interface StreamConsumer {
	
	/**
	 * 
	 * @param beforeCallback
	 * @param datas
	 */
	 void accept(Object beforeCallback,List<Map<String,Object>> datas);

}
