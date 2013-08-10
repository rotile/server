package com.open.rotile.service.persist;

import static com.open.rotile.service.persist.OfyService.ofy;

import java.util.List;

import com.open.rotile.model.Project;

public class ProjectPersistService implements IProjectPersistService {

	@Override
	public void save(Project project) {
		ofy().save().entity(project);
	}

	@Override
	public boolean projectExists(String projectName) {
		return findProject(projectName) != null;
	}

	@Override
	public Project findProject(String projectName) {
		Project project = ofy().load().type(Project.class)
				.filterKey("name", projectName).first().now();
		return project;
	}

	@Override
	public List<Project> listProjects() {
		return ofy().load().type(Project.class).list();
	}
}
