package online.sanen.cdm;

/**
 * 
 * @author LazyToShow
 * Date: 2018/06/12
 * Time: 09:17
 */
public interface QueryMap {
	
	int insert();

	int delete(String primaryKey);
	
	int delete();

	int updateBy(String primaryKey);
	
	int update();

	QueryMap setFields(String... fields);

	QueryMap setExceptFields(String... fields);

	int create();

	QueryMap setPrimary(String primaryKey);
	
}
