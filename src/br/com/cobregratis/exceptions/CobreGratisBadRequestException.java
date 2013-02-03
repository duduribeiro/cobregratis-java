package br.com.cobregratis.exceptions;

public class CobreGratisBadRequestException extends CobreGratisException {
	/**
	 *
	 */
	private static final long serialVersionUID = -5991687954996681417L;

	public CobreGratisBadRequestException(String message) {
		super(400, message);
	}

	public CobreGratisBadRequestException() {
		this("Invalid request. Probably the content of the request is malformed.");
	}


}
