package com.open.rotile.exception;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class ProjectDoesNotExistExceptionTest {

	@Test
	public void message_is_as_expected() {
		// Given
		final String projectName = "my project";
		final String expectedMessage = "Project my project does not exist.";

		// When
		ProjectDoesNotExistException exception = new ProjectDoesNotExistException(
				projectName);

		// Then
		Assertions.assertThat(exception.getMessage())
				.isEqualTo(expectedMessage);
	}

	@Test
	public void projectName_saved() {
		// Given
		final String projectName = "my project";

		// When
		ProjectDoesNotExistException exception = new ProjectDoesNotExistException(
				projectName);

		// Then
		Assertions.assertThat(exception.projectName()).isEqualTo(projectName);
	}
}
