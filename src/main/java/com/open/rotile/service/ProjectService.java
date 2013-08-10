package com.open.rotile.service;

import java.util.List;

import com.google.inject.Inject;
import com.open.rotile.exception.ProjectDoesNotExistException;
import com.open.rotile.model.Project;
import com.open.rotile.service.persist.IProjectPersistService;

public class ProjectService implements IProjectService {

	private IProjectPersistService projectPersistService;

	@Inject
	public ProjectService(IProjectPersistService projectPersistService) {
		this.projectPersistService = projectPersistService;
	}

	@Override
	public boolean createProject(String name) {
		Project project = new Project(name);
		return projectPersistService.createProject(project);
	}

	@Override
	public void vote(String projectName, int vote)
			throws ProjectDoesNotExistException {
		// Not made transactionnal on purpose
		Project project = projectPersistService.findProject(projectName);
		if (project == null) {
			throw new ProjectDoesNotExistException(projectName);
		}
		project.vote(vote);
		projectPersistService.save(project);
	}

	@Override
	public Project findProject(String name) {
		return projectPersistService.findProject(name);
	}

	@Override
	public List<Project> listProjects() {
		return projectPersistService.listProjects();
	}
}
