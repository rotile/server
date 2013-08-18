package com.open.rotile.server.model;

import javax.servlet.http.HttpServletRequest;

public class EmailData {

	private static final String LOCALE_HEADER = "Accept-Language";

	private String email;
	private String serverName;
	private String locale;

	public EmailData(String email, HttpServletRequest httpRequest) {
		this.email = email;
		locale = httpRequest.getHeader(LOCALE_HEADER);
		serverName = buildServerName(httpRequest);
	}

	private String buildServerName(HttpServletRequest httpRequest) {
		StringBuilder builder = new StringBuilder();
		builder.append(httpRequest.getScheme());
		builder.append("://");
		builder.append(httpRequest.getServerName());
		int serverPort = httpRequest.getServerPort();
		if (serverPort != -1) {
			builder.append(":");
			builder.append(serverPort);
		}
		builder.append("/");
		return builder.toString();
	}

	public String email() {
		return email;
	}

	public boolean hasEmail() {
		return email != null;
	}

	public String locale() {
		return locale;
	}

	public String serverName() {
		return serverName;
	}

}
