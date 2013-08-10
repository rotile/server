package com.open.rotile.service;

import java.util.ArrayList;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

import com.open.rotile.model.Project;
import com.open.rotile.service.persist.ProjectPersistService;

public class ProjectServiceTest {

	@Test
	public void createProject_create_new_project() {
		// Given
		ProjectPersistService projectPersistService = Mockito
				.mock(ProjectPersistService.class);
		ProjectService service = new ProjectService(projectPersistService);
		final String projectName = "my project";

		// When
		ArgumentCaptor<Project> argCaptor = ArgumentCaptor
				.forClass(Project.class);
		Mockito.when(projectPersistService.createProject(argCaptor.capture()))
				.thenReturn(true);
		service.createProject(projectName);

		// Then
		Assertions.assertThat(argCaptor.getValue()).isNotNull();
		Assertions.assertThat(argCaptor.getValue().name()).isEqualTo(
				projectName);
	}

	@Test
	public void vote_add_new_vote_to_project_if_project_exist() {
		// Given
		ProjectPersistService projectPersistService = Mockito
				.mock(ProjectPersistService.class);
		ProjectService service = new ProjectService(projectPersistService);
		final String projectName = "my project";
		final int vote = 3;

		Project project = new Project(projectName);
		Mockito.when(projectPersistService.findProject(projectName))
				.thenReturn(project);

		// When
		service.vote(projectName, vote);

		// Then
		Assertions.assertThat(project.nbVotes()).isEqualTo(1);
		Assertions.assertThat(project.average()).isEqualTo(vote);
		Mockito.verify(projectPersistService).save(project);
	}

	@Test
	public void findProject_return_project_if_exists() {
		// Given
		ProjectPersistService projectPersistService = Mockito
				.mock(ProjectPersistService.class);
		ProjectService service = new ProjectService(projectPersistService);
		final String projectName = "my project";
		Project expectedProject = new Project(projectName);
		Mockito.when(projectPersistService.findProject(projectName))
				.thenReturn(expectedProject);

		// When
		Project project = service.findProject(projectName);

		// Then
		Assertions.assertThat(project).isEqualTo(expectedProject);
	}

	@Test
	public void listProjects_return_all_projects_like() {
		// Given
		ProjectPersistService projectPersistService = Mockito
				.mock(ProjectPersistService.class);
		ProjectService service = new ProjectService(projectPersistService);
		List<Project> allProjects = new ArrayList<Project>();
		allProjects.add(new Project("my project"));
		allProjects.add(new Project("my project 2"));

		Mockito.when(projectPersistService.listProjects()).thenReturn(
				allProjects);

		// When
		List<Project> projects = service.listProjects();

		// Then
		Assertions.assertThat(projects).isEqualTo(allProjects);
	}
}
