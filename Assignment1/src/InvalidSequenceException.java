/**
 * InvalidSequenceException Class
 * @author steum
 *
 */
public class InvalidSequenceException extends Exception{
	/**
	 * Default constructor of InvalidSequenceException
	 * Assigns appropriate message to print in case exception happens
	 */
	public InvalidSequenceException() {
		super("The password cannot contain more than two of the same character in sequence");
	}
}
