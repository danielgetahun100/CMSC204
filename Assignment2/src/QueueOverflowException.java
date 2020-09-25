/**
 * QueueOverflowException class
 * @author steum
 *
 */
public class QueueOverflowException extends Exception{
	/**
	 *  Default constructor of QueueOverflowException
	 * Assigns appropriate message to print in case exception happens
	 */
	QueueOverflowException(){
		super("Queue is full");
	}
}
