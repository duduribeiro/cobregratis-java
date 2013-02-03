package br.com.cobregratis.exceptions;

public class CobreGratisUnauthorizedException extends CobreGratisException {
	/**
	 *
	 */
	private static final long serialVersionUID = -5991687954996681417L;

	public CobreGratisUnauthorizedException(String message) {
		super(401, message);
	}

	public CobreGratisUnauthorizedException() {
		this("The authentication token is invalid.");
	}


}
