package br.com.cobregratis.exceptions;

public class CobreGratisInternalServerErrorException extends CobreGratisException {
	/**
	 *
	 */
	private static final long serialVersionUID = -5991687954996681417L;

	public CobreGratisInternalServerErrorException(String message) {
		super(500, message);
	}

	public CobreGratisInternalServerErrorException() {
		this("There was an internal server error while processing the request.");
	}


}
