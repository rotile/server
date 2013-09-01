package com.open.rotile.service.persist.transaction;

import com.open.rotile.model.Project;
import com.open.rotile.service.persist.IProjectPersistService;

public class VoteForProjectTransaction extends AbstractTransaction<Boolean> {

	private IProjectPersistService projectPersistService;
	private String id;
	private int vote;
	private String comment;

	public VoteForProjectTransaction(
			IProjectPersistService projectPersistService, String id, int vote,
			String comment) {
		this.projectPersistService = projectPersistService;
		this.id = id;
		this.vote = vote;
		this.comment = comment;
	}

	@Override
	protected Boolean doRun() {

		Project project = projectPersistService.findProject(id);
		// Return false if project does not exist
		if (project == null) {
			return false;
		}

		project.vote(vote, comment);
		projectPersistService.save(project);
		return true;
	}
}
