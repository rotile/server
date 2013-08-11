package com.open.rotile.service.persist.transaction;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.open.rotile.model.Project;
import com.open.rotile.service.persist.IProjectPersistService;

public class VoteForProjectTransactionTest {

	private IProjectPersistService projectPersistService;
	private final String projectName = "my project";
	private final int vote = 3;
	private VoteForProjectTransaction transaction;

	@Before
	public void setUp() {
		projectPersistService = Mockito.mock(IProjectPersistService.class);
		transaction = new VoteForProjectTransaction(projectPersistService,
				projectName, vote);
	}

	@Test
	public void run_does_nothing_and_return_false_if_project_does_not_exist() {
		// Given
		Mockito.when(projectPersistService.findProject(projectName))
				.thenReturn(null);

		// When
		boolean voted = transaction.run();

		// Then
		Assertions.assertThat(voted).isFalse();
	}

	@Test
	public void run_finds_and_saves_project_with_new_vote() {
		// Given
		Project project = new Project(projectName);
		Mockito.when(projectPersistService.findProject(projectName))
				.thenReturn(project);

		// When
		boolean voted = transaction.run();

		// Then
		Assertions.assertThat(voted).isTrue();
		Mockito.verify(projectPersistService).save(project);
		Assertions.assertThat(project.average()).isEqualTo(vote);
	}
}
