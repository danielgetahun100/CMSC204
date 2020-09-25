/**
 * InvalidNotationFormatException class
 * @author steum
 *
 */
public class InvalidNotationFormatException extends Exception{
	/**
	 *  Default constructor of InvalidNotationFormatException
	 * Assigns appropriate message to print in case exception happens
	 */
	InvalidNotationFormatException(){
		super("Notation format is incorrect");
	}

}
