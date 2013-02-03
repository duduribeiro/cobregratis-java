package br.com.cobregratis.exceptions;

public class CobreGratisUnprocessibleEntityException extends CobreGratisException{

	private static final long serialVersionUID = -669828224007511505L;

	public CobreGratisUnprocessibleEntityException(String message) {
		super(422, message);
	}

	public CobreGratisUnprocessibleEntityException() {
		this("Unprocessible Entity. Only draft billet can be updated.");
	}


}
