package com.open.rotile.service.persist.transaction;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.open.rotile.model.Project;
import com.open.rotile.service.persist.IProjectPersistService;

public class CreateProjectTransactionTest {

	private final static String projectName = "my project";
	private Project project;
	private CreateProjectTransaction transaction;
	private IProjectPersistService projectPersistService;

	@Before
	public void setUp() {
		projectPersistService = Mockito.mock(IProjectPersistService.class);
		project = new Project(projectName);
		transaction = new CreateProjectTransaction(projectPersistService,
				project);
	}

	@Test
	public void run_persist_project_and_return_true() {
		// Given
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
		Mockito.when(projectPersistService.projectExists(projectName))
				.thenReturn(true);

		// When
		boolean created = transaction.run();

		// Then
		Assertions.assertThat(created).isFalse();
	}
}
