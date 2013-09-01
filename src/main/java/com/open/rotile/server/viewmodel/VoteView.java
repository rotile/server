package com.open.rotile.server.viewmodel;

import org.codehaus.jackson.annotate.JsonProperty;

public class VoteView {

	private int vote;
	private String comment;

	public VoteView() {

	}

	public VoteView(int vote, String comment) {
		this.vote = vote;
		this.comment = comment;
	}

	@JsonProperty
	public int vote() {
		return vote;
	}

	@JsonProperty
	public String comment() {
		return comment;
	}
}
