package com.open.rotile.service.persist.transaction;

import com.open.rotile.model.Project;
import com.open.rotile.service.persist.IProjectPersistService;

public class CreateProjectTransaction extends AbstractTransaction<Boolean> {

	private IProjectPersistService projectPersistService;
	private Project project;

	public CreateProjectTransaction(
			IProjectPersistService projectPersistService, Project project) {
		this.projectPersistService = projectPersistService;
		this.project = project;
	}

	@Override
	protected Boolean doRun() {
		// cannot create the project if it already exists
		if (projectPersistService.projectExists(project.name())) {
			return false;
		}

		projectPersistService.save(project);
		return true;
	}
}
