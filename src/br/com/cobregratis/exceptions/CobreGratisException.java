package br.com.cobregratis.exceptions;

public class CobreGratisException extends Exception{
	/**
	 *
	 */
	private static final long serialVersionUID = -1316578164544677640L;

	private int httpStatusCode;

	public CobreGratisException(int httpStatusCode, String message) {
		super(message);
		this.httpStatusCode = httpStatusCode;
	}

	public int getHttpStatusCode() {
		return httpStatusCode;
	}

}
