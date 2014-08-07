package com.goeuro;


public class BusinessException extends RuntimeException {

	public BusinessException(Throwable e) {
		super(e);
	}

	private static final long serialVersionUID = -1269654911174219167L;

}
