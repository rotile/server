package com.open.rotile.guice;

import com.google.inject.AbstractModule;
import com.open.rotile.service.IProjectService;
import com.open.rotile.service.ProjectService;

public class BusinessModule extends AbstractModule {

	@Override
	protected void configure() {
		// TODO Auto-generated method stub
		bind(IProjectService.class).to(ProjectService.class);
	}

}
