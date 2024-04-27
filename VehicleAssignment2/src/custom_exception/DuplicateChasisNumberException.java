package custom_exception;

@SuppressWarnings("serial")
public class DuplicateChasisNumberException extends Exception {
public DuplicateChasisNumberException(String msg) {
	super(msg);	
}
}
