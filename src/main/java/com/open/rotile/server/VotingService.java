package com.open.rotile.server;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import com.open.rotile.model.Votes;
import com.open.rotile.service.persist.IVotingService;

@Path("/vote")
public class VotingService {

	IVotingService votingService = new com.open.rotile.service.persist.VotingService();

	@GET
	public Response showVote() {
		Votes votes = votingService.retrieveVotes();
		ResponseBuilder response = Response.ok(votes.toString());
		return response.build();
	}

	@POST
	@Path("/{vote}")
	public void doVote(@PathParam("vote") int vote) {
		votingService.vote(vote);
	}
}
