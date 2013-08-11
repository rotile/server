package com.open.rotile.service.persist;

import static com.open.rotile.service.persist.OfyService.ofy;

import java.util.List;

import com.open.rotile.model.Project;
import com.open.rotile.service.persist.transaction.CreateProjectTransaction;

public class ProjectPersistService implements IProjectPersistService {

	@Override
	public void save(Project project) {
		ofy().save().entity(project).now();
	}

	@Override
	public boolean projectExists(String projectName) {
		return findProject(projectName) != null;
	}

	@Override
	public boolean createProject(final Project project) {
		boolean projectCreated = ofy().transact(
				new CreateProjectTransaction(this, project));
		return projectCreated;
	}

	@Override
	public Project findProject(String projectName) {
		// Key<Project> key = Key.create(Project.class, projectName);
		Project project = ofy().load().type(Project.class).id(projectName)
				.now();
		return project;
	}

	@Override
	public List<Project> listProjects() {
		return ofy().load().type(Project.class).list();
	}
}
