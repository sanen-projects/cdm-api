package online.sanen.cdm.basic;

import com.mhdt.analyse.Validate;
import com.mhdt.annotation.Table;
import com.mhdt.toolkit.Assert;
import com.mhdt.toolkit.Reflect;

/**
 * 
 * @author LazyToShow Date: 2018/06/12 Time: 09:17
 */
public class Cdm {

	public static String table(Class<? extends BasicBean> entryClass) {

		String tableName = null;

		if (Reflect.hasAnnotation(entryClass, Table.class)) {
			tableName = Reflect.getTableNameValue(entryClass);
		} else {
			tableName = entryClass.getSimpleName();
		}

		return tableName;
	}

	/**
	 * Process library name/namespace (Oracle). Table name
	 * 
	 * @param tableName
	 * @param productType
	 * @return
	 */
	public static String processTableName(String tableName, ProductType productType) {

		String modifer = ProductType.applyTableModifier(productType);

		if (!tableName.contains(".")) {

			tableName = modifer + tableName + modifer;

		} else {

			String[] split = tableName.split("\\.");
			tableName = split[0] + "." + modifer + split[1] + modifer;

		}

		return tableName;
	}

	public static String getPrimaryKey(BasicBean basicBean) {
		
		Assert.notNull(basicBean, "Basic bean is null");
		String name = Validate.isNullOrEmpty(basicBean.primarykey()) ? "id" : basicBean.primarykey();
		
		Assert.state(Validate.hasField(basicBean, name),
				"Unrecognized field '" + name + "' from basicBean class " + basicBean.getClass());
		
		return name;
	}

}
