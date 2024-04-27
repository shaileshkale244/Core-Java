
package custom_exception;

@SuppressWarnings("serial")
public class PollutionLevelException extends Exception {
	
	public PollutionLevelException(String msg) {
		super(msg);
	}

}
