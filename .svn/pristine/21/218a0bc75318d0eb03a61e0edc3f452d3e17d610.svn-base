package online.sanen.cdm.component;

import online.sanen.cdm.basic.ProductType;
import online.sanen.cdm.template.JdbcTemplate;

/**
 * Global configuration，So far, it hasn't done its job .
 * 
 * @author LazyToShow <br>
 *         Date: 2017/10/21 <br>
 *         Time: 23:19
 */
public interface Manager {

	void setTemplate(JdbcTemplate template);

	JdbcTemplate getTemplate();

	void setIsShowSql(boolean flag);

	boolean isShowSql();

	ProductType productType();

	String databaseName();

	void setIsCache(boolean isCache);

	boolean isCache();

	void setSqlFormat(boolean isFormat);

	boolean getSqlFormat();

	boolean isLog();

	void setIsLog(boolean isLog);

	String getUrl();

	String getId();

	void setId(Object id);
}
