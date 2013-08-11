package com.open.rotile.server;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import com.google.inject.Inject;
import com.open.rotile.exception.ProjectAlreadyExistException;
import com.open.rotile.exception.ProjectDoesNotExistException;
import com.open.rotile.model.Project;
import com.open.rotile.service.IProjectService;

@Path("/projects")
public class ProjectRestService {

	private IProjectService projectService;

	@Inject
	public ProjectRestService(IProjectService projectService) {
		this.projectService = projectService;
	}

	@PUT
	@Path("/{projectName}")
	public Response createProject(@PathParam("projectName") String projectName) {
		try {
			projectService.createProject(projectName);
			return Response.ok().build();
		} catch (ProjectAlreadyExistException e) {
			return Response.serverError().build();
		}
	}

	@GET
	public Response listProjects() {
		List<Project> projectList = projectService.listProjects();
		ResponseBuilder response = Response.ok(projectList.toString());
		return response.build();
	}

	@POST
	@Path("/{projectName}/{vote}")
	public Response vote(@PathParam("projectName") String projectName,
			@PathParam("vote") int vote) {
		try {
			projectService.vote(projectName, vote);
			return Response.ok().build();
		} catch (ProjectDoesNotExistException e) {
			return Response.serverError().build();
		}
	}
}
