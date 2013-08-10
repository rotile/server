package com.open.rotile.server;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import com.google.inject.Inject;
import com.open.rotile.model.Project;
import com.open.rotile.service.IProjectService;

@Path("/projects")
public class ProjectRestService {

	@Inject
	private IProjectService projectService;

	public ProjectRestService() {
	}

	@GET
	public Response listProjects() {
		List<Project> projectList = projectService.listProjects();
		ResponseBuilder response = Response.ok(projectList.toString());
		return response.build();
	}

	@POST
	@Path("/{projectName}/{vote}")
	public void vote(@PathParam("projectName") String projectName,
			@PathParam("vote") int vote) {
		projectService.vote(projectName, vote);
	}
}