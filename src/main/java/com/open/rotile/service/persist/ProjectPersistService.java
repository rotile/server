package com.open.rotile.service.persist;

import static com.open.rotile.service.persist.OfyService.ofy;

import java.util.List;

import com.open.rotile.model.Project;
import com.open.rotile.service.persist.transaction.CreateProjectTransaction;
import com.open.rotile.service.persist.transaction.VoteForProjectTransaction;

public class ProjectPersistService implements IProjectPersistService {

	@Override
	public void save(Project project) {
		ofy().save().entity(project).now();
	}

	@Override
	public void createProject(final Project project) {
		ofy().transact(new CreateProjectTransaction(this, project));
	}

	@Override
	public boolean voteForProject(String id, final int vote, String comment) {
		return ofy().transact(new VoteForProjectTransaction(this, id, vote, comment));
	}

	@Override
	public Project findProject(String id) {
		return ofy().transactionless().load().type(Project.class).id(id).now();
	}

	@Override
	public List<Project> listProjects() {
		return ofy().load().type(Project.class).list();
	}
}
