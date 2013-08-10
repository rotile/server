package com.open.rotile.exception;

public class ProjectAlreadyExistException extends RotileException {

	private static final long serialVersionUID = -1791062056283136692L;
	protected static final String MESSAGE = "Project %s already exists.";
	private String projectName;

	public ProjectAlreadyExistException(String projectName) {
		super(String.format(MESSAGE, projectName));
		this.projectName = projectName;
	}

	public String projectName() {
		return projectName;
	}
}
