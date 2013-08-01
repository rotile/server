package com.open.rotile.service;

import com.open.rotile.model.Votes;

public interface IVotingService {

	void vote(int vote);

	Votes retrieveVotes();
}
