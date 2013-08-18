package com.open.rotile.service;

import java.util.List;

import com.google.inject.Inject;
import com.open.rotile.exception.ProjectAlreadyExistException;
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
	public void createProject(String name, String description)
			throws ProjectAlreadyExistException {
		Project project = new Project(name, description);
		boolean projectCreated = projectPersistService.createProject(project);
		if (projectCreated == false) {
			throw new ProjectAlreadyExistException(name);
		}
	}

	@Override
	public void vote(String projectName, int vote)
			throws ProjectDoesNotExistException {
		boolean voted = projectPersistService.voteForProject(projectName, vote);
		if (voted == false) {
			throw new ProjectDoesNotExistException(projectName);
		}
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
