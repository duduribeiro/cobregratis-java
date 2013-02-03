package br.com.cobregratis.exceptions;

public class CobreGratisForbiddenException extends CobreGratisException {
	/**
	 *
	 */
	private static final long serialVersionUID = -5991687954996681417L;

	public CobreGratisForbiddenException(String message) {
		super(403, message);
	}

	public CobreGratisForbiddenException() {
		this("The contracted plan does not allow access to the API.");
	}


}
