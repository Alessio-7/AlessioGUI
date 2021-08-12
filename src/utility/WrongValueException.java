package utility;

public class WrongValueException extends Exception {
	private static final long serialVersionUID = -9048508152870964929L;

	public WrongValueException( String errorMessage ) {
		super( errorMessage );
	}
}