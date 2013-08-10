package com.open.rotile.service.persist;

import com.open.rotile.model.Votes;

public interface IVotePersistService {

	void vote(int vote);

	Votes retrieveVotes();
}
