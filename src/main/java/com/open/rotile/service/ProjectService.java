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
	public void createProject(String name, String description) {
		Project project = new Project(name, description);
		projectPersistService.createProject(project);
	}

	@Override
	public void vote(String id, int vote) throws ProjectDoesNotExistException {
		boolean voted = projectPersistService.voteForProject(id, vote);
		if (voted == false) {
			throw new ProjectDoesNotExistException();
		}
	}

	@Override
	public Project findProject(String id) {
		return projectPersistService.findProject(id);
	}

	@Override
	public List<Project> listProjects() {
		return projectPersistService.listProjects();
	}
}
