/**
 * NoUpperAlphaException Class
 * @author steum
 *
 */
public class NoUpperAlphaException extends Exception{
	/**
	 * Default constructor of NoUpperAlphaException
	 * Assigns appropriate message to print in case exception happens
	 */
	public NoUpperAlphaException() {
		super("The password must contain at least one uppercase alphabetic character");
	}
	
}
