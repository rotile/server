package com.open.rotile.service;

import com.open.rotile.model.Project;

public interface IEmailService {

	public void sendCreationEmail(String email, Project project);
}
