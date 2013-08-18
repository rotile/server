package com.open.rotile.service.persist.transaction;

import com.open.rotile.model.Project;
import com.open.rotile.service.persist.IProjectPersistService;

public class CreateProjectTransaction extends AbstractTransaction<Void> {

	private IProjectPersistService projectPersistService;
	private Project project;

	public CreateProjectTransaction(
			IProjectPersistService projectPersistService, Project project) {
		this.projectPersistService = projectPersistService;
		this.project = project;
	}

	@Override
	protected Void doRun() {
		projectPersistService.save(project);
		return null;
	}
}
