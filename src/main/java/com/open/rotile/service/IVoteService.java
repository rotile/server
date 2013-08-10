package com.open.rotile.service;

import com.open.rotile.model.Votes;

public interface IVoteService {

	void vote(int vote);

	Votes retrieveVotes();
}
