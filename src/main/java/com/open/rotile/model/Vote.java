package com.open.rotile.model;

import com.googlecode.objectify.annotation.Embed;

@Embed
public class Vote {

	private int vote;
	private String comment;

	public Vote() {

	}

	public Vote(int vote, String comment) {
		this.vote = vote;
		this.comment = comment;
	}

	public int vote() {
		return this.vote;
	}

	public String comment() {
		return comment;
	}

	@Override
	public String toString() {
		return String.valueOf(vote);
	}
}
