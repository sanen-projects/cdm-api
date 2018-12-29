package online.sanen.cdm;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import online.sanen.cdm.basic.ProductType;
import online.sanen.cdm.basic.Structure;

/**
 * Pipeline processor
 * 
 * @author LazyToShow Date: 2017/10/21 Time: 23:19
 */
public interface Handel {

	/**
	 * The final product is returned according to the raw material production, and
	 * it is not returned to null to perform the next operation as the production
	 * result
	 * 
	 * @param structure
	 * @param product
	 * @return
	 */
	Object handel(Structure structure, Object product);

	default void initFetchSize(PreparedStatement ps, ProductType productType) throws SQLException {
		if (productType == ProductType.MYSQL) {
			ps.setFetchSize(Integer.MIN_VALUE);
		} else {
			ps.setFetchSize(3000);
		}
	}

}
