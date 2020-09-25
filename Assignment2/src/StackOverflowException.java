/**
 * StackOverflowException class
 * @author steum
 *
 */
public class StackOverflowException extends Exception{
	/**
	 *  Default constructor of StackOverflowException
	 * Assigns appropriate message to print in case exception happens
	 */
	StackOverflowException(){
		super("Stack is full");
	}

}
