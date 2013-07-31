package com.open.rotile.model;

import com.googlecode.objectify.annotation.Entity;

@Entity
public class Vote {

	private int vote;
	
	public Vote(int vote) {
		this.vote = vote;
	}

	public int vote() {
		return this.vote;
	}
	
	@Override
	public String toString() {
		return String.valueOf(vote);
	}
	
	
}
