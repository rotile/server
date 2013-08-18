package com.open.rotile.server.model;

import javax.servlet.http.HttpServletRequest;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.mockito.Mockito;

public class EmailDataTest {

	@Test
	public void has_email() {
		// Given
		String email = "email@mail.com";
		HttpServletRequest httpRequest = Mockito.mock(HttpServletRequest.class);

		// When
		EmailData emailData = new EmailData(email, httpRequest);

		// Then
		Assertions.assertThat(emailData.hasEmail()).isTrue();
	}

	@Test
	public void has_no_email() {
		// Given
		HttpServletRequest httpRequest = Mockito.mock(HttpServletRequest.class);

		// When
		EmailData emailData = new EmailData(null, httpRequest);

		// Then
		Assertions.assertThat(emailData.hasEmail()).isFalse();
	}

	@Test
	public void locales_are_read_from_accept_language_header() {
		// Given
		final String email = null;
		final String expectedLocale = "fr,en,us";
		HttpServletRequest httpRequest = Mockito.mock(HttpServletRequest.class);
		Mockito.when(httpRequest.getHeader("Accept-Language")).thenReturn(
				expectedLocale);

		// When
		EmailData emailData = new EmailData(email, httpRequest);

		// Then
		Assertions.assertThat(emailData.locale()).isEqualTo(expectedLocale);
	}

	@Test
	public void serverName_should_have_scheme_host_and_port() {
		// Given
		final String expectedServerName = "http://hostname:45/";
		final String email = null;
		HttpServletRequest httpRequest = Mockito.mock(HttpServletRequest.class);
		Mockito.when(httpRequest.getScheme()).thenReturn("http");
		Mockito.when(httpRequest.getServerName()).thenReturn("hostname");
		Mockito.when(httpRequest.getServerPort()).thenReturn(45);

		// When
		EmailData emailData = new EmailData(email, httpRequest);

		// Then
		Assertions.assertThat(emailData.serverName()).isEqualTo(
				expectedServerName);
	}

	@Test
	public void serverName_with_no_port() {
		// Given
		final String expectedServerName = "https://hostname/";
		final String email = null;
		HttpServletRequest httpRequest = Mockito.mock(HttpServletRequest.class);
		Mockito.when(httpRequest.getScheme()).thenReturn("https");
		Mockito.when(httpRequest.getServerName()).thenReturn("hostname");
		Mockito.when(httpRequest.getServerPort()).thenReturn(-1);

		// When
		EmailData emailData = new EmailData(email, httpRequest);

		// Then
		Assertions.assertThat(emailData.serverName()).isEqualTo(
				expectedServerName);
	}
}
