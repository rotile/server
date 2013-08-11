package com.open.rotile.service.persist.transaction;

import com.googlecode.objectify.Work;
import com.open.rotile.model.Project;
import com.open.rotile.service.persist.IProjectPersistService;

public class VoteForProjectTransaction implements Work<Boolean> {

	private IProjectPersistService projectPersistService;
	private String projectName;
	private int vote;

	public VoteForProjectTransaction(
			IProjectPersistService projectPersistService, String projectName,
			int vote) {
		this.projectPersistService = projectPersistService;
		this.projectName = projectName;
		this.vote = vote;
	}

	@Override
	public Boolean run() {

		Project project = projectPersistService.findProject(projectName);
		// Return false if project does not exist
		if (project == null) {
			return false;
		}

		project.vote(vote);
		projectPersistService.save(project);
		return true;
	}
}