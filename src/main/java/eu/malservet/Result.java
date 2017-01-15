package eu.malservet;

/**
 * store a result for a requirement after check operation
 * 
 * @author nicol
 *
 */
public class Result {

	/**
	 * true if the requirement is passed
	 */
	public boolean passed;

	/**
	 * message to explain
	 */
	public String message;

	/**
	 * the requirement checked.
	 */
	public Requirement requirement;

	/**
	 * 
	 * @param passed
	 * @param message
	 * @param requirement
	 */
	public Result(boolean passed, String message, Requirement requirement) {
		this.passed = passed;
		this.message = message;
		this.requirement = requirement;
	}

}
