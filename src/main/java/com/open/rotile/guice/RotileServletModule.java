package com.open.rotile.guice;

import com.google.inject.servlet.ServletModule;
import com.sun.jersey.api.core.PackagesResourceConfig;
import com.sun.jersey.api.core.ResourceConfig;
import com.sun.jersey.guice.spi.container.servlet.GuiceContainer;

/**
 * Servlet module, register and configure all the servlets of the application.
 * 
 * @author Bastien
 * 
 */
public class RotileServletModule extends ServletModule {

	@Override
	protected void configureServlets() {
		// Bind services
		ResourceConfig rc = new PackagesResourceConfig(
				"com.open.rotile.server", "com.open.rotile.service");
		for (Class<?> resource : rc.getClasses()) {
			bind(resource);
		}

		serve("/*").with(GuiceContainer.class);
	}
}
