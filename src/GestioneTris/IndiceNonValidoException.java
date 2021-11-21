package GestioneTris;

public class IndiceNonValidoException extends Exception{

	private static final long serialVersionUID = 1L;

	public IndiceNonValidoException() {
		super();
	}

	public IndiceNonValidoException(String messaggio) {
		super(messaggio);
	}
}
