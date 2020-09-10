/**
 * LengthException Class
 * @author steum
 *
 */
public class LengthException extends Exception {
	/**
	 *  Default constructor of LengthException
	 * Assigns appropriate message to print in case exception happens
	 */
	public LengthException() {	
		super("The password must be at least 6 characters long");
	}
	
}
