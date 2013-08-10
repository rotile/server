package com.open.rotile.exception;

public class RotileException extends Exception {

	private static final long serialVersionUID = -3862246543740997943L;

	public RotileException(String message) {
		super(message);
	}

	public RotileException(String message, Exception e) {
		super(message, e);
	}
}
