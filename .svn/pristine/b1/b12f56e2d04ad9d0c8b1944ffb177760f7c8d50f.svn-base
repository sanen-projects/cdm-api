package online.sanen.cdm.component;

import online.sanen.cdm.basic.ProductType;
import online.sanen.cdm.template.JdbcTemplate;

/**
 * 
 * @author LazyToShow
 * Date: 2017/10/21
 * Time: 23:19
 */
public class ManagerBridge implements Manager{
	
	Manager manager;
	
	public ManagerBridge(Manager manager) {
		this.manager = manager;
	}

	@Override
	public JdbcTemplate getTemplate() {
		return manager.getTemplate();
	}

	@Override
	public void setTemplate(JdbcTemplate template) {
		 manager.setTemplate(template);
	}

	
	public ProductType productType(){
		try {
			return manager.productType();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void setIsCache(boolean isCache) {
		manager.setIsCache(isCache);
	}

	@Override
	public boolean isCache() {
		return manager.isCache();
	}

	@Override
	public void setSqlFormat(boolean isFormat) {
		manager.setSqlFormat(isFormat);
	}

	@Override
	public boolean getSqlFormat() {
		return manager.getSqlFormat();
	}
	
	public boolean isFormatSql() {
		return manager.getSqlFormat();
	}

	@Override
	public void setIsShowSql(boolean flag) {
		manager.setIsShowSql(flag);
	}

	@Override
	public boolean isShowSql() {
		return manager.isShowSql();
	}
	
	@Override
	public boolean isLog() {
		return manager.isLog();
	}

	@Override
	public void setIsLog(boolean isLog) {
		manager.setIsLog(isLog);
	}

	@Override
	public String databaseName() {
		return manager.databaseName();
	}

	@Override
	public String getUrl(){
		return manager.getUrl();
	}

	@Override
	public String getId() {
		return manager.getId();
	}

	@Override
	public void setId(Object id) {
		manager.setId(id);
	}
}
