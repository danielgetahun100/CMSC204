/**
 *WeakPasswordException Class
 */
public class WeakPasswordException extends Exception{
	/**
	 * Default constructor of WeakPasswordException
	 * Assigns appropriate message to print in case exception happens
	 */
	public WeakPasswordException() {
		super("The password is OK but weak - it contains fewer than 10 characters");
	}
}
