/**
 * NoLowerAlphaException Class
 * @author steum
 *
 */
public class NoLowerAlphaException extends Exception{
	/**
	 * Default constructor of NoLowerAlphaException
	 * Assigns appropriate message to print in case exception happens
	 */
	public NoLowerAlphaException() {
		super("The password must contain at least one lowercase alphabetic character");
	}
}
