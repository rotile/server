package com.open.rotile.service;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.mockito.Mockito;

import com.open.rotile.model.Project;
import com.open.rotile.service.persist.ProjectPersistService;

public class ProjectServiceTest {

	@Test
	public void createProject_persist_project_and_return_true() {
		// Given
		ProjectPersistService projectPersistService = Mockito
				.mock(ProjectPersistService.class);
		ProjectService service = new ProjectService(projectPersistService);
		final String projectName = "my project";

		// When
		boolean created = service.createProject(projectName);

		// Then
		Assertions.assertThat(created).isTrue();
		Mockito.verify(projectPersistService).save(Mockito.any(Project.class));
	}

	@Test
	public void createProject_does_nothing_and_return_false_if_project_already_exist() {
		// Given
		ProjectPersistService projectPersistService = Mockito
				.mock(ProjectPersistService.class);
		ProjectService service = new ProjectService(projectPersistService);
		final String projectName = "my project";

		Mockito.when(projectPersistService.projectExists(projectName))
				.thenReturn(true);

		// When
		boolean created = service.createProject(projectName);

		// Then
		Assertions.assertThat(created).isFalse();
		Mockito.verify(projectPersistService).projectExists(projectName);
		Mockito.verifyNoMoreInteractions(projectPersistService);
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
}
