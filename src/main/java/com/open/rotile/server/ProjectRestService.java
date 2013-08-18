package com.open.rotile.server;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.inject.Inject;
import com.open.rotile.exception.ProjectDoesNotExistException;
import com.open.rotile.model.Project;
import com.open.rotile.server.viewmodel.ProjectView;
import com.open.rotile.service.IProjectService;

@Path("/projects")
public class ProjectRestService {

	private IProjectService projectService;

	@Inject
	public ProjectRestService(IProjectService projectService) {
		this.projectService = projectService;
	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createProject(ProjectView projectView) {
		projectService.createProject(projectView.name(),
				projectView.description());
		return Response.ok().build();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<ProjectView> listProjects() {
		List<Project> projectList = projectService.listProjects();
		List<ProjectView> projectViews = new ArrayList<ProjectView>();
		for (Project project : projectList) {
			projectViews.add(new ProjectView(project));
		}
		return projectViews;
	}

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public ProjectView getProject(@PathParam("id") String projectId) {
		Project project = projectService.findProject(projectId);
		return new ProjectView(project);
	}

	@POST
	@Path("/{id}/{vote}")
	public Response vote(@PathParam("id") String id, @PathParam("vote") int vote) {
		try {
			projectService.vote(id, vote);
			return Response.ok().build();
		} catch (ProjectDoesNotExistException e) {
			return Response.serverError().build();
		}
	}
}
