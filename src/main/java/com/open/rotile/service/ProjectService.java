package com.open.rotile.service;

import java.util.List;

import com.google.inject.Inject;
import com.open.rotile.model.Project;
import com.open.rotile.service.persist.ProjectPersistService;

public class ProjectService implements IProjectService {

	private ProjectPersistService projectPersistService;

	@Inject
	public ProjectService(ProjectPersistService projectPersistService) {
		this.projectPersistService = projectPersistService;
	}

	// TODO: transaction
	public boolean createProject(String name) {
		// cannot create the project if it already exists
		if (projectPersistService.projectExists(name)) {
			return false;
		}

		Project project = new Project(name);
		projectPersistService.save(project);
		return true;
	}

	// TODO: transaction
	public void vote(String projectName, int vote) {
		Project project = projectPersistService.findProject(projectName);
		project.vote(vote);
		projectPersistService.save(project);
	}

	public Project findProject(String name) {
		return projectPersistService.findProject(name);
	}

	public List<Project> listProjects() {
		return projectPersistService.listProjects();
	}
}
