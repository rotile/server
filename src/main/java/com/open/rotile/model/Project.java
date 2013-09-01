package com.open.rotile.model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;

@Entity
public class Project {
	@Id
	private String id;
	private String name;
	private String description;
	protected List<Vote> votes = new ArrayList<Vote>();

	public Project() {
		id = generateId();
	}

	public Project(String name, String description) {
		this.name = name;
		this.description = description;
		id = generateId();
	}

	private String generateId() {
		String generatedId = UUID.randomUUID().toString();
		generatedId = generatedId.replace("-", "");
		return generatedId;
	}

	public String id() {
		return id;
	}

	public String name() {
		return name;
	}

	public String description() {
		return description;
	}

	public void vote(int vote, String comment) {
		votes.add(new Vote(vote, comment));
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

	public List<Vote> votes() {
		return votes;
	}

	@Override
	public String toString() {
		return name + " - " + votes.toString();
	}
}
