package com.open.rotile.server;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import com.open.rotile.model.Vote;

@Path("/vote")
public class VotingService {

	private Vote vote = new Vote();

	@GET
	public Response showVote() {
		ResponseBuilder response = Response.ok(vote.toString());
		return response.build();
	}

	@POST
	@Path("/{vote}")
	public void doVote(@PathParam("vote") int vote) {
		this.vote.vote(vote);
	}
}
