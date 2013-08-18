package com.open.rotile.exception;

public class ProjectDoesNotExistException extends RotileException {

	private static final long serialVersionUID = 6009453944946801944L;
	protected static final String MESSAGE = "Project does not exist.";

	public ProjectDoesNotExistException() {
		super(String.format(MESSAGE));
	}
}
