package com.open.rotile.guice;

import org.codehaus.jackson.jaxrs.JacksonJsonProvider;

import com.google.inject.Scopes;
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
		// Bind REST services
		ResourceConfig rc = new PackagesResourceConfig("com.open.rotile.server");
		for (Class<?> resource : rc.getClasses()) {
			bind(resource);
		}

		bind(JacksonJsonProvider.class).in(Scopes.SINGLETON);

		serve("/services/*").with(GuiceContainer.class);
	}
}
