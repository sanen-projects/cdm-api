package online.sanen.cdm;

import online.sanen.cdm.basic.BasicBean;

/**
 * The primary key operation
 * 
 * @author LazyToShow <br>
 * Date: 2017/11/23 <br>
 * Time: 9:33
 */
public interface QueryPK<T extends BasicBean> {

	/** The primary key to find */
	T find();

	/** The primary key to remove */
	int delete();

}
