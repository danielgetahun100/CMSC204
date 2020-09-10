/**
 * NoSpecialCharacterException
 * @author steum
 *
 */
public class NoSpecialCharacterException extends Exception{
	/**
	 * Default constructor of NoSpecialCharacterException
	 * Assigns appropriate message to print in case exception happens
	 */
	public NoSpecialCharacterException() {
		super("The password must contain at least one special character");
	}
}
