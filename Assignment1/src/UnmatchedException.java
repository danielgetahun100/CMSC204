/**
 * UnmatchedException Class
 * @author steum
 *
 */
public class UnmatchedException extends Exception {
	/**
	 * Default constructor of UnmatchedException
	 * Assigns appropriate message to print in case exception happens
	 */
	public UnmatchedException() {
		super("The passwords do not match");
	}
}
