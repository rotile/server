package com.open.rotile.model;

import java.util.ArrayList;
import java.util.List;

public class Votes {

	private List<Vote> votes = new ArrayList<Vote>();

	public Votes() {

	}

	public Votes(List<Vote> votes) {
		this.votes = votes;
	}

	public void vote(int vote) {
		votes.add(new Vote(vote));
	}

	@Override
	public String toString() {
		return votes.toString();
	}
}
