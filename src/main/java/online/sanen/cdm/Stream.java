package online.sanen.cdm;

import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;

import online.sanen.cdm.basic.DataField;
import online.sanen.cdm.basic.StreamConsumer;

/**
 * 
 *
 * @author LazyToShow	<br>
 * Date:	2018年10月16日	<br>
 * Time:	下午3:30:46
 */
public interface Stream {

	void stream(int buffersize, Consumer<List<Map<String, Object>>> consumer);

	void stream(int buffersize, Consumer<List<Map<String, Object>>> consumer, Map<String, String> aliases);
	
	void stream(int bufferSize, Function<List<DataField>,Object> consumer, StreamConsumer datas, Map<String, String> aliases);

}
