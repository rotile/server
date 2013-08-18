package com.open.rotile.service;

import java.util.List;

import com.open.rotile.exception.ProjectDoesNotExistException;
import com.open.rotile.model.Project;

public interface IProjectService {

	String createProject(String name, String description, String email);

	void vote(String id, int vote) throws ProjectDoesNotExistException;

	Project findProject(String id);

	List<Project> listProjects();
}
