package com.open.rotile.server;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import com.google.inject.Inject;
import com.open.rotile.model.Votes;
import com.open.rotile.service.IVoteService;

@Path("/vote")
public class VoteRestService {

	private IVoteService voteService;

	@Inject
	public VoteRestService(IVoteService voteService) {
		this.voteService = voteService;
	}

	@GET
	public Response showVote() {
		Votes votes = voteService.retrieveVotes();
		ResponseBuilder response = Response.ok(votes.toString());
		return response.build();
	}

	@POST
	@Path("/{vote}")
	public void doVote(@PathParam("vote") int vote) {
		voteService.vote(vote);
	}
}
