package com.open.rotile.service;

import com.open.rotile.model.Project;
import com.open.rotile.server.model.EmailData;

public interface IEmailService {

	void sendCreationEmail(EmailData emailData, Project project);
}
