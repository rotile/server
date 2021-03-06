package com.open.rotile.service;

import java.util.List;

import com.google.inject.Inject;
import com.open.rotile.exception.ProjectDoesNotExistException;
import com.open.rotile.model.Project;
import com.open.rotile.server.model.EmailData;
import com.open.rotile.service.persist.IProjectPersistService;

public class ProjectService implements IProjectService {

	private IProjectPersistService projectPersistService;
	private IEmailService emailService;

	@Inject
	public ProjectService(IProjectPersistService projectPersistService,
			IEmailService emailService) {
		this.projectPersistService = projectPersistService;
		this.emailService = emailService;
	}

	@Override
	public String createProject(String name, String description,
			EmailData emailData) {
		Project project = new Project(name, description);
		projectPersistService.createProject(project);
		if (emailData.hasEmail()) {
			emailService.sendCreationEmail(emailData, project);
		}
		return project.id();
	}

	@Override
	public void vote(String id, int vote, String comment)
			throws ProjectDoesNotExistException {
		boolean voted = projectPersistService.voteForProject(id, vote, comment);
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
