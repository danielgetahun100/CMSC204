/**
 * QueueUnderflowException class
 * @author steum
 *
 */
public class QueueUnderflowException extends Exception{
	/**
	 *  Default constructor of QueueUnderflowException
	 * Assigns appropriate message to print in case exception happens
	 */
	QueueUnderflowException(){
		super("Queue is empty");
	}

}
