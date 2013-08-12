package com.open.rotile.service.persist.transaction;

import com.googlecode.objectify.Work;

public abstract class AbstractTransaction<T> implements Work<T> {

	private static final int NB_RETRY = 3;

	@Override
	final public T run() {
		int nbRetry = NB_RETRY;
		RuntimeException toBeThrown = null;
		while (nbRetry-- > 0) {
			try {
				return doRun();
			} catch (RuntimeException e) {
				toBeThrown = e;
			}
		}
		throw toBeThrown;
	}

	protected abstract T doRun();
}
