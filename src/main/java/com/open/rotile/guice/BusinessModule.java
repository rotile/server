package com.open.rotile.guice;

import com.google.inject.AbstractModule;
import com.open.rotile.service.IProjectService;
import com.open.rotile.service.ProjectService;
import com.open.rotile.service.persist.IProjectPersistService;
import com.open.rotile.service.persist.ProjectPersistService;

public class BusinessModule extends AbstractModule {

	@Override
	protected void configure() {
		// Bind all business services
		bind(IProjectService.class).to(ProjectService.class);
		bind(IProjectPersistService.class).to(ProjectPersistService.class);
	}
}
