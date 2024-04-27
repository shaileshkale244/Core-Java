package custom_exception;

@SuppressWarnings("serial")
public class InsuranceExpiryDateException extends Exception {
	public InsuranceExpiryDateException(String msg) {
		super(msg);
		
	}

}
