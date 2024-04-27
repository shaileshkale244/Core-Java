package custom_exception;

@SuppressWarnings("serial")
public class ManufactureDateException extends Exception {
public ManufactureDateException(String msg) {
	super(msg);
}
}
