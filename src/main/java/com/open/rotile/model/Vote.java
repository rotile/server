package com.open.rotile.model;

import java.util.ArrayList;
import java.util.List;

public class Vote {

	private List<Integer> votes = new ArrayList<Integer>();

	public void vote(int vote) {
		votes.add(vote);
	}

	@Override
	public String toString() {
		return votes.toString();
	}
}
