package com.open.rotile.model;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class ProjectTest {

	@Test
	public void vote_adds_new_vote() {
		// Given
		final int voteValue = 4;
		final String comment = "comment";
		Project project = new Project();

		// When
		project.vote(voteValue, comment);

		// Then
		Assertions.assertThat(project.votes.size()).isEqualTo(1);
		Assertions.assertThat(project.votes.get(0).vote()).isEqualTo(voteValue);
		Assertions.assertThat(project.votes.get(0).comment())
				.isEqualTo(comment);
	}

	@Test
	public void nbvotes_returns_number_of_votes() {
		// Given
		Project project = new Project();
		project.vote(2, null);
		project.vote(4, null);
		project.vote(6, null);
		project.vote(8, null);
		final int expectedNbVotes = 4;

		// When
		int nbVotes = project.nbVotes();

		// Then
		Assertions.assertThat(nbVotes).isEqualTo(expectedNbVotes);
	}

	@Test
	public void average_returns_votes_average() {
		// Given
		Project project = new Project();
		project.vote(2, null);
		project.vote(4, null);
		project.vote(6, null);
		project.vote(8, null);
		final int expectedAverage = 5;

		// When
		int average = project.average();

		// Then
		Assertions.assertThat(average).isEqualTo(expectedAverage);
	}

	@Test
	public void average_returns_0_if_no_votes() {
		// Given
		Project project = new Project();

		// When
		int average = project.average();

		// Then
		Assertions.assertThat(average).isZero();
	}

	@Test
	public void project_id_contains_only_alphanum() {
		// Given
		Project project = new Project();

		// When
		String id = project.id();

		CharSequence alphaNum = "[a-f[0-9]]*";

		// Then
		Assertions.assertThat(id).matches(alphaNum);
	}

	@Test
	public void projects_with_same_name_have_different_id() {
		// Given
		String name = "project name";
		String desc1 = "project 1 description";
		String desc2 = "project 2 description";
		Project project1 = new Project(name, desc1);
		Project project2 = new Project(name, desc2);

		// When
		String id1 = project1.id();
		String id2 = project2.id();

		// Then
		Assertions.assertThat(id1).isNotEqualTo(id2);
	}
}
