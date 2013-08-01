package com.open.rotile.service;

import static com.open.rotile.service.OfyService.ofy;

import com.open.rotile.model.Vote;
import com.open.rotile.model.Votes;

public class VotingService implements IVotingService {

	public void vote(int vote) {
		Vote voteEntity = new Vote(vote);
		ofy().save().entity(voteEntity);
	}

	public Votes retrieveVotes() {
		Votes votes = new Votes(ofy().load().type(Vote.class).list());
		return votes;
	}

}
