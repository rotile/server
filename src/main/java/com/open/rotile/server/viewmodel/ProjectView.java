package com.open.rotile.server.viewmodel;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

import com.open.rotile.model.Project;

public class ProjectView {

	private String name;
	private int average;
	private List<Integer> votes;

	public ProjectView(Project project) {

	}

	@JsonProperty
	public String name() {
		return name;
	}

	@JsonProperty
	public int average() {
		return average;
	}

	@JsonProperty
	public List<Integer> votes() {
		return votes;
	}
}
