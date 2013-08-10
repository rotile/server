package com.open.rotile.service;

import java.util.List;

import com.open.rotile.exception.ProjectDoesNotExistException;
import com.open.rotile.model.Project;

public interface IProjectService {

	boolean createProject(String name);

	void vote(String projectName, int vote) throws ProjectDoesNotExistException;

	Project findProject(String name);

	List<Project> listProjects();
}
