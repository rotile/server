package com.open.rotile.exception;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class ProjectAlreadyExistExceptionTest {

	@Test
	public void message_is_as_expected() {
		// Given
		final String projectName = "my project";
		final String expectedMessage = "Project my project already exists.";

		// When
		ProjectAlreadyExistException exception = new ProjectAlreadyExistException(
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
		ProjectAlreadyExistException exception = new ProjectAlreadyExistException(
				projectName);

		// Then
		Assertions.assertThat(exception.projectName()).isEqualTo(projectName);
	}
}
