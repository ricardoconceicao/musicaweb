package com.entrevista.musicaweb.exception;

public class NegocioException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 732370479082044828L;
	
	 public NegocioException(String errorMessage) {
	        super(errorMessage);
	    }

}
