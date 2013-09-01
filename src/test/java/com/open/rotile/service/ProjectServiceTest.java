package com.open.rotile.service;

import java.util.ArrayList;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.open.rotile.exception.ProjectDoesNotExistException;
import com.open.rotile.model.Project;
import com.open.rotile.server.model.EmailData;
import com.open.rotile.service.persist.IProjectPersistService;

@RunWith(PowerMockRunner.class)
public class ProjectServiceTest {

	private IProjectPersistService projectPersistService;
	private IEmailService emailService;
	private ProjectService service;
	final String projectName = "my project";
	final String projectDescription = "Project description.";
	final int vote = 3;
	final String comment = "vote comment";
	EmailData emailData;

	@Before
	public void setUp() {
		projectPersistService = Mockito.mock(IProjectPersistService.class);
		emailService = Mockito.mock(IEmailService.class);
		service = new ProjectService(projectPersistService, emailService);
		emailData = Mockito.mock(EmailData.class);
		Mockito.when(emailData.hasEmail()).thenReturn(true);
	}

	@Test
	public void createProject_create_new_project_and_return_id() {
		// Given
		ArgumentCaptor<Project> argCaptor = ArgumentCaptor
				.forClass(Project.class);
		Mockito.doNothing().when(projectPersistService)
				.createProject(argCaptor.capture());

		// When
		String projectId = service.createProject(projectName,
				projectDescription, emailData);

		// Then
		Assertions.assertThat(argCaptor.getValue()).isNotNull();
		Assertions.assertThat(argCaptor.getValue().name()).isEqualTo(
				projectName);
		Assertions.assertThat(projectId).isEqualTo(argCaptor.getValue().id());
	}

	@Test
	@PrepareForTest(ProjectService.class)
	public void createProject_send_email_if_given_one() throws Exception {
		// Given
		Project project = Mockito.mock(Project.class);
		PowerMockito.whenNew(Project.class).withAnyArguments()
				.thenReturn(project);

		// When
		service.createProject(projectName, projectDescription, emailData);

		// Then
		Mockito.verify(emailService).sendCreationEmail(emailData, project);
	}

	@Test
	public void vote_vote_for_project() throws ProjectDoesNotExistException {
		// Given
		Mockito.when(
				projectPersistService
						.voteForProject(projectName, vote, comment))
				.thenReturn(true);

		// When
		service.vote(projectName, vote, comment);

		// Then
		Mockito.verify(projectPersistService).voteForProject(projectName, vote,
				comment);
	}

	@Test(expected = ProjectDoesNotExistException.class)
	public void vote_throws_exception_if_project_does_not_exist()
			throws ProjectDoesNotExistException {
		// Given
		Mockito.when(
				projectPersistService
						.voteForProject(projectName, vote, comment))
				.thenReturn(false);

		// When
		service.vote(projectName, vote, comment);

		// Then
		// See @Test
	}

	@Test
	public void findProject_return_project_if_exists() {
		// Given
		Project expectedProject = new Project(projectName, projectDescription);
		Mockito.when(projectPersistService.findProject(projectName))
				.thenReturn(expectedProject);

		// When
		Project project = service.findProject(projectName);

		// Then
		Assertions.assertThat(project).isEqualTo(expectedProject);
	}

	@Test
	public void listProjects_return_all_projects_like() {
		// Given
		List<Project> allProjects = new ArrayList<Project>();
		allProjects.add(new Project("my project", projectDescription));
		allProjects.add(new Project("my project 2", projectDescription));

		Mockito.when(projectPersistService.listProjects()).thenReturn(
				allProjects);

		// When
		List<Project> projects = service.listProjects();

		// Then
		Assertions.assertThat(projects).isEqualTo(allProjects);
	}
}
