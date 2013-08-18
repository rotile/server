package com.open.rotile.service;

import java.util.List;

import com.open.rotile.exception.ProjectAlreadyExistException;
import com.open.rotile.exception.ProjectDoesNotExistException;
import com.open.rotile.model.Project;

public interface IProjectService {

	void createProject(String name, String description)
			throws ProjectAlreadyExistException;

	void vote(String projectName, int vote) throws ProjectDoesNotExistException;

	Project findProject(String name);

	List<Project> listProjects();
}
