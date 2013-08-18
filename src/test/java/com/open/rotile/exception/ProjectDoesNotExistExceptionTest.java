package com.open.rotile.exception;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class ProjectDoesNotExistExceptionTest {

	@Test
	public void message_is_as_expected() {
		// Given
		final String expectedMessage = "Project does not exist.";

		// When
		ProjectDoesNotExistException exception = new ProjectDoesNotExistException();

		// Then
		Assertions.assertThat(exception.getMessage())
				.isEqualTo(expectedMessage);
	}
}
