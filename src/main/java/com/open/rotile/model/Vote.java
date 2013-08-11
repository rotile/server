package com.open.rotile.model;

import com.googlecode.objectify.annotation.Embed;
import com.googlecode.objectify.annotation.Id;

@Embed
public class Vote {

	@Id
	private Long id;
	private int vote;
	
	public Vote() {
		
	}

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
