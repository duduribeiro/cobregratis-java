package br.com.cobregratis.exceptions;

public class CobreGratisNotFoundException extends CobreGratisException {
	/**
	 *
	 */
	private static final long serialVersionUID = -2123640691902405290L;

	public CobreGratisNotFoundException(String message) {
		super(404, message);
	}

	public CobreGratisNotFoundException() {
		this("The requested resource does not exists.");
	}


}
