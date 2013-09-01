package com.open.rotile.server.viewmodel;

import java.util.ArrayList;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import com.open.rotile.model.Project;

public class ProjectViewTest {

	@Test
	public void project_contains_expected_votes() {
		// Given
		final String comment1 = "comment 1";
		final int vote1 = 3;
		final String comment2 = "comment 2";
		final int vote2 = 2;
		final String comment3 = "comment 3";
		int vote3 = 4;
		Project project = new Project();
		project.vote(vote1, comment1);
		project.vote(vote2, comment2);
		project.vote(vote3, comment3);
		List<VoteView> expectedVotes = new ArrayList<VoteView>();
		expectedVotes.add(new VoteView(vote1, comment1));
		expectedVotes.add(new VoteView(vote2, comment2));
		expectedVotes.add(new VoteView(vote3, comment3));

		// When
		ProjectView projectView = new ProjectView(project);

		// Then
		Assertions.assertThat(projectView.votes()).isEqualTo(expectedVotes);
	}
}
