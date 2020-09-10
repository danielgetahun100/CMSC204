/**
 * NoDigitException
 * @author steum
 *
 */
public class NoDigitException extends Exception{
	/**
	 * Default constructor of NoDigitException
	 * Assigns appropriate message to print in case exception happens
	 */
	public NoDigitException() {
	super("The password must contain at least one digit");
	}
}
