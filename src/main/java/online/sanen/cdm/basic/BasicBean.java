package online.sanen.cdm.basic;

/**
 * 
 * <br>
 * Entity class base interface <br>
 * <br>
 * The entity class that participates in the operation needs to implement the
 * interface.The procedure may call the interface to do some primary key
 * operations such as <strong>query</strong>, <strong>delete</strong>, and
 * <strong>modify</strong>.Subsequent caches may also use this interface as a
 * basis to identify which data needs to be updated<br>
 * 
 * <p>Implement 
 * <br>
 * <code> String primarykey()</code><br>
 * to return the primary key of the entity corresponding table, and if
 * <strong>null</strong> is returned, the primary key is assumed to be called
 * <strong>id</strong>
 * 
 * @author LazyToshow <br>
 * Date: 2017/11/20 <br>
 * Time: pm 8:48:54
 */
public interface BasicBean {

	/**
	 * Gets the primary key name
	 * 
	 * @return - The primary key, if it returns null, <strong>id</strong> to be the
	 *         primary key by default<br>
	 */
	String primarykey();

}
