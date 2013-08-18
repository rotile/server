package com.open.rotile.server.viewmodel;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

import com.open.rotile.model.Project;

public class ProjectView {

	private String id;
	private String name;
	private String description;
	private int average;
	private List<Integer> votes;
	private int nbVotes;

	public ProjectView() {

	}

	public ProjectView(Project project) {
		this.id = project.id();
		this.name = project.name();
		this.description = project.description();
		this.average = project.average();
		this.votes = project.voteValues();
		this.nbVotes = project.nbVotes();
	}

	@JsonProperty
	public String id() {
		return id;
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
	public int average() {
		return average;
	}

	@JsonProperty
	public List<Integer> votes() {
		return votes;
	}

	@JsonProperty
	public int nbVotes() {
		return nbVotes;
	}
}
