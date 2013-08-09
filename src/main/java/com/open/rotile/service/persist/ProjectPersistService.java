package com.open.rotile.service.persist;

import static com.open.rotile.service.persist.OfyService.ofy;

import java.util.List;

import com.open.rotile.model.Project;

public class ProjectPersistService {

	public void save(Project project) {
		ofy().save().entity(project);
	}

	public boolean projectExists(String projectName) {
		return findProject(projectName) != null;
	}

	public Project findProject(String projectName) {
		Project project = ofy().load().type(Project.class)
				.filterKey("name", projectName).first().now();
		return project;
	}

	public List<Project> listProjects() {
		return ofy().load().type(Project.class).list();
	}
}
