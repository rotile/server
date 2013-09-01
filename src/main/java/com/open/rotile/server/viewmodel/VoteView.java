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

	public boolean hasComment() {
		return comment != null;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof VoteView)) {
			return false;
		}

		VoteView voteView = (VoteView) obj;

		if (voteView.vote != vote) {
			return false;
		}

		if (voteView.hasComment() != this.hasComment()) {
			return false;
		}

		if (hasComment() && !comment.equals(voteView.comment)) {
			return false;
		}

		return true;
	}

	@Override
	public int hashCode() {
		int hashCode = 1;
		hashCode = hashCode * 5 + vote;
		hashCode = hashCode * 13 + comment.hashCode();
		return hashCode;
	}
}
