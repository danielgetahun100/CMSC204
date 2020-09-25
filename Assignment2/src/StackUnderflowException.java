/**
 * StackUnderflowException class
 * @author steum
 *
 */
public class StackUnderflowException extends Exception{
	/**
	 *  Default constructor of StackUnderflowException
	 * Assigns appropriate message to print in case exception happens
	 */
	StackUnderflowException(){
		super("Stack is empty");
	}
}
