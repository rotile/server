package com.open.rotile.service.persist.transaction;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.mockito.Mockito;

import com.open.rotile.model.Project;
import com.open.rotile.service.persist.IProjectPersistService;

public class CreateProjectTransactionTest {

	@Test
	public void run_persist_project_and_return_true() {
		// Given
		IProjectPersistService projectPersistService = Mockito
				.mock(IProjectPersistService.class);
		final String projectName = "my project";
		Project project = new Project(projectName);
		CreateProjectTransaction transaction = new CreateProjectTransaction(
				projectPersistService, project);

		Mockito.when(projectPersistService.projectExists(projectName))
				.thenReturn(false);

		// When
		boolean created = transaction.run();

		// Then
		Assertions.assertThat(created).isTrue();
		Mockito.verify(projectPersistService).save(project);
	}

	@Test
	public void run_does_nothing_and_return_false_if_project_already_exists() {
		// Given
		IProjectPersistService projectPersistService = Mockito
				.mock(IProjectPersistService.class);
		final String projectName = "my project";
		Project project = new Project(projectName);
		CreateProjectTransaction transaction = new CreateProjectTransaction(
				projectPersistService, project);

		Mockito.when(projectPersistService.projectExists(projectName))
				.thenReturn(true);

		// When
		boolean created = transaction.run();

		// Then
		Assertions.assertThat(created).isFalse();
	}
}
