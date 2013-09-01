package com.open.rotile.server.viewmodel;

import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

import com.open.rotile.model.Project;
import com.open.rotile.model.Vote;

public class ProjectView {

	private String id;
	private String name;
	private String description;
	private int average;
	private List<VoteView> votes;
	private int nbVotes;

	public ProjectView() {

	}

	public ProjectView(Project project) {
		this.id = project.id();
		this.name = project.name();
		this.description = project.description();
		this.average = project.average();
		this.votes = new ArrayList<VoteView>();
		for (Vote vote : project.votes()) {
			this.votes.add(new VoteView(vote.vote(), vote.comment()));
		}
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
	public List<VoteView> votes() {
		return votes;
	}

	@JsonProperty
	public int nbVotes() {
		return nbVotes;
	}
}
