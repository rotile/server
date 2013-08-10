package com.open.rotile.guice;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.servlet.GuiceServletContextListener;

/**
 * Google guice servlet context listener, in charge of creating the Guice
 * injector.
 * 
 * @author Bastien
 * 
 */
public class RotileGuiceServletContextListener extends
		GuiceServletContextListener {

	@Override
	protected Injector getInjector() {
		return Guice.createInjector(new RotileServletModule());
	}
}
