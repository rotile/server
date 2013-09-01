package com.open.rotile.server.viewmodel;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.googlecode.zohhak.api.TestWith;
import com.googlecode.zohhak.api.runners.ZohhakRunner;

@RunWith(ZohhakRunner.class)
public class VoteViewTest {

	@Test
	public void hasComment_returns_false_if_comment_is_null() {
		// Given
		VoteView vote = new VoteView(3, null);

		// When
		boolean hasComment = vote.hasComment();

		// Then
		Assertions.assertThat(hasComment).isFalse();
	}

	@Test
	public void hasComment_returns_true_if_comment_is_not_null() {
		// Given
		VoteView vote = new VoteView(3, "comment");

		// When
		boolean hasComment = vote.hasComment();

		// Then
		Assertions.assertThat(hasComment).isTrue();
	}

	@Test
	public void equals_returns_false_if_not_VoteViewType() {
		// Given
		VoteView vote = new VoteView();
		final String otherType = "other type";

		// When
		boolean equal = vote.equals(otherType);

		// Then
		Assertions.assertThat(equal).isFalse();
	}

	@Test
	public void equals_returns_true_if_same_attributes() {
		final int vote = 3;
		final String comment = "comment";
		// Given
		VoteView voteView = new VoteView(vote, comment);
		VoteView otherVoteView = new VoteView(vote, comment);

		// When
		boolean equal = voteView.equals(otherVoteView);

		// Then
		Assertions.assertThat(equal).isTrue();
	}

	@TestWith({ "3, comment, 2, comment", "3, comment, 3, comment 2",
			"2, null, 2, comment" })
	public void equals_returns_false_if_different_attribute(int vote1,
			String comment1, int vote2, String comment2) {
		// Given
		VoteView voteView = new VoteView(vote1, comment1);
		VoteView otherVoteView = new VoteView(vote2, comment2);

		// When
		boolean equal = voteView.equals(otherVoteView);

		// Then
		Assertions.assertThat(equal).isFalse();
	}

	@Test
	public void hashCode_returns_same_value_when_invoked_twice() {
		// Given
		VoteView voteView = new VoteView(3, "comment");

		// Then
		Assertions.assertThat(voteView.hashCode()).isEqualTo(
				voteView.hashCode());
	}

	@Test
	public void hashCode_return_true_if_objects_are_equal() {
		final int vote = 3;
		final String comment = "comment";
		// Given
		VoteView voteView = new VoteView(vote, comment);
		VoteView otherVoteView = new VoteView(vote, comment);

		// Then
		Assertions.assertThat(voteView).isEqualTo(otherVoteView);
		Assertions.assertThat(voteView.hashCode()).isEqualTo(
				otherVoteView.hashCode());
	}
}
