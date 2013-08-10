package com.open.rotile.service.persist;

import java.util.List;

import com.open.rotile.model.Project;

public interface IProjectPersistService {

	public void save(Project project);

	public boolean projectExists(String projectName);

	public Project findProject(String projectName);

	public List<Project> listProjects();
}
