package com.open.rotile.server.viewmodel;

import org.codehaus.jackson.annotate.JsonProperty;

public class ProjectCreationData {

	private String name;
	private String description;
	private String email;

	public ProjectCreationData() {

	}

	@JsonProperty
	public String name() {
		return name;
	}

	@JsonProperty
	public String description() {
		return description;
	}

	@JsonProperty
	public String email() {
		return email;
	}
}
