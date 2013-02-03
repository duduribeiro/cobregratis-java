package br.com.cobregratis.exceptions;

public class CobreGratisTooManyRequestsException extends CobreGratisException{

	private static final long serialVersionUID = 2562075122267037549L;

	public CobreGratisTooManyRequestsException(String message) {
		super(429, message);
	}

	public CobreGratisTooManyRequestsException() {
		this("Too many requests. You reached the maximum of requests, retry in the next hour.");
	}

}
