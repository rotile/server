package com.open.rotile.service.persist.transaction;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.open.rotile.model.Project;
import com.open.rotile.service.persist.IProjectPersistService;

public class CreateProjectTransactionTest {

	private final static String projectName = "my project";
	private final static String projectDescription = "Project description.";
	private Project project;
	private CreateProjectTransaction transaction;
	private IProjectPersistService projectPersistService;

	@Before
	public void setUp() {
		projectPersistService = Mockito.mock(IProjectPersistService.class);
		project = new Project(projectName, projectDescription);
		transaction = new CreateProjectTransaction(projectPersistService,
				project);
	}

	@Test
	public void run_persist_project_and_return_true() {
		// Given

		// When
		transaction.run();

		// Then
		Mockito.verify(projectPersistService).save(project);
	}
}
