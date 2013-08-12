package com.open.rotile.service.persist.transaction;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class AbstractTransactionTest {

	private class ConcreteTransaction extends AbstractTransaction<Boolean> {

		private int doRunCalls = 0;

		@Override
		protected Boolean doRun() {
			++doRunCalls;
			throw new RuntimeException();
		}

		public int doRunCalls() {
			return doRunCalls;
		}
	}

	@Test
	public void run_retries_3_times_if_doRun_fails() {
		// Given
		ConcreteTransaction transaction = new ConcreteTransaction();
		int expectedNbCalls = 3;

		// When
		try {
			transaction.run();
		} catch (Exception e) {
			// Ignored
		}

		// Then
		Assertions.assertThat(transaction.doRunCalls()).isEqualTo(
				expectedNbCalls);
	}
}
