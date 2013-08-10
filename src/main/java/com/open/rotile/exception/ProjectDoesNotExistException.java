package com.open.rotile.exception;

public class ProjectDoesNotExistException extends RotileException {

	private static final long serialVersionUID = 6009453944946801944L;
	protected static final String MESSAGE = "Project %s does not exist.";
	private String projectName;

	public ProjectDoesNotExistException(String projectName) {
		super(String.format(MESSAGE, projectName));
		this.projectName = projectName;
	}

	public String projectName() {
		return projectName;
	}
}
