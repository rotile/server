package com.open.rotile.service.persist;

import java.util.List;

import com.open.rotile.model.Project;

public interface IProjectPersistService {

	public void save(Project project);

	void createProject(Project project);

	boolean voteForProject(String id, final int vote);

	public Project findProject(String id);

	public List<Project> listProjects();

}
