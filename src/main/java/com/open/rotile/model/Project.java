package com.open.rotile.model;

import java.util.ArrayList;
import java.util.List;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;

@Entity
public class Project {
	@Id
	private String name;
	private String description;
	protected List<Vote> votes = new ArrayList<Vote>();

	public Project() {
	}

	public Project(String name, String description) {
		this.name = name;
		this.description = description;
	}

	public String name() {
		return name;
	}

	public String description() {
		return description;
	}

	public void vote(int vote) {
		votes.add(new Vote(vote));
	}

	public int nbVotes() {
		return votes.size();
	}

	public int average() {
		int average = 0;
		if (votes.isEmpty()) {
			return average;
		}

		for (Vote vote : votes) {
			average += vote.vote();
		}
		return average / votes.size();
	}

	public List<Integer> voteValues() {
		List<Integer> voteValues = new ArrayList<Integer>();
		for (Vote vote : votes) {
			voteValues.add(vote.vote());
		}
		return voteValues;
	}

	@Override
	public String toString() {
		return name + " - " + votes.toString();
	}
}
