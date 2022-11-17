package lt.viko.eif.vytzab.restws.exceptions;

/**
 * @author Vytautas
 *
 *         Class for the <ResourceNotFoundException> exception implementation.
 */
public class ResourceNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public ResourceNotFoundException(String message) {
		super(message);
	}
}