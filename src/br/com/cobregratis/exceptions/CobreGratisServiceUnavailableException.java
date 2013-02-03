package br.com.cobregratis.exceptions;

public class CobreGratisServiceUnavailableException extends CobreGratisException {

	/**
	 *
	 */
	private static final long serialVersionUID = -6402876072377351241L;

	public CobreGratisServiceUnavailableException(String message) {
		super(503, message);
	}

	public CobreGratisServiceUnavailableException() {
		this("The account has reached some of the limits.");
	}


}
