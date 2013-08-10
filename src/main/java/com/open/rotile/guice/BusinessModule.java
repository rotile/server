package com.open.rotile.guice;

import com.google.inject.AbstractModule;
import com.open.rotile.service.IProjectService;
import com.open.rotile.service.IVoteService;
import com.open.rotile.service.ProjectService;
import com.open.rotile.service.VoteService;
import com.open.rotile.service.persist.IProjectPersistService;
import com.open.rotile.service.persist.IVotePersistService;
import com.open.rotile.service.persist.ProjectPersistService;
import com.open.rotile.service.persist.VotePersistService;

public class BusinessModule extends AbstractModule {

	@Override
	protected void configure() {
		// TODO Auto-generated method stub
		bind(IProjectService.class).to(ProjectService.class);
		bind(IVoteService.class).to(VoteService.class);
		bind(IVotePersistService.class).to(VotePersistService.class);
		bind(IProjectPersistService.class).to(ProjectPersistService.class);
	}

}
