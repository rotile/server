package com.open.rotile.service;

import com.google.inject.Inject;
import com.open.rotile.model.Votes;
import com.open.rotile.service.persist.IVotePersistService;

public class VoteService implements IVoteService {

	private IVotePersistService votePersistService;

	@Inject
	public VoteService(IVotePersistService votePersistService) {
		this.votePersistService = votePersistService;
	}

	@Override
	public void vote(int vote) {
		votePersistService.vote(vote);
	}

	@Override
	public Votes retrieveVotes() {
		return votePersistService.retrieveVotes();
	}

}
