package com.open.rotile.service.persist.transaction;

import com.googlecode.objectify.Work;
import com.open.rotile.model.Project;
import com.open.rotile.service.persist.IProjectPersistService;

public class CreateProjectTransaction implements Work<Boolean> {

	private IProjectPersistService projectPersistService;
	private Project project;

	public CreateProjectTransaction(
			IProjectPersistService projectPersistService, Project project) {
		this.projectPersistService = projectPersistService;
		this.project = project;
	}

	@Override
	public Boolean run() {
		// cannot create the project if it already exists
		if (projectPersistService.projectExists(project.name())) {
			return false;
		}

		projectPersistService.save(project);
		return true;
	}

}
