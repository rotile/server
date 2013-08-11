package com.open.rotile.service;

import java.util.ArrayList;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

import com.open.rotile.exception.ProjectAlreadyExistException;
import com.open.rotile.exception.ProjectDoesNotExistException;
import com.open.rotile.model.Project;
import com.open.rotile.service.persist.ProjectPersistService;

public class ProjectServiceTest {

	private ProjectPersistService projectPersistService;
	private ProjectService service;
	final String projectName = "my project";
	final int vote = 3;

	@Before
	public void setUp() {
		projectPersistService = Mockito.mock(ProjectPersistService.class);
		service = new ProjectService(projectPersistService);
	}

	@Test
	public void createProject_create_new_project()
			throws ProjectAlreadyExistException {
		// Given
		ArgumentCaptor<Project> argCaptor = ArgumentCaptor
				.forClass(Project.class);
		Mockito.when(projectPersistService.createProject(argCaptor.capture()))
				.thenReturn(true);

		// When
		service.createProject(projectName);

		// Then
		Assertions.assertThat(argCaptor.getValue()).isNotNull();
		Assertions.assertThat(argCaptor.getValue().name()).isEqualTo(
				projectName);
	}

	@Test(expected = ProjectAlreadyExistException.class)
	public void createProject_throws_exception_if_project_already_exist()
			throws ProjectAlreadyExistException {
		// Given
		Mockito.when(
				projectPersistService.createProject(Mockito.any(Project.class)))
				.thenReturn(false);

		// When
		service.createProject(projectName);

		// Then
		// See @Test
	}

	@Test
	public void vote_vote_for_project() throws ProjectDoesNotExistException {
		// Given
		Mockito.when(projectPersistService.voteForProject(projectName, vote))
				.thenReturn(true);

		// When
		service.vote(projectName, vote);

		// Then
		Mockito.verify(projectPersistService).voteForProject(projectName, vote);
	}

	@Test(expected = ProjectDoesNotExistException.class)
	public void vote_throws_exception_if_project_does_not_exist()
			throws ProjectDoesNotExistException {
		// Given
		Mockito.when(projectPersistService.voteForProject(projectName, vote))
				.thenReturn(false);

		// When
		service.vote(projectName, vote);

		// Then
		// See @Test
	}

	@Test
	public void findProject_return_project_if_exists() {
		// Given
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
