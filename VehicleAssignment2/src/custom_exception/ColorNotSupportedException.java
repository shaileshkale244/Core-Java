package custom_exception;

@SuppressWarnings("serial")
public class ColorNotSupportedException extends Exception{

	public ColorNotSupportedException(String str) {
		super(str);
	}
}
