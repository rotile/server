package com.open.rotile.guice;

import java.util.HashMap;
import java.util.Map;

import com.google.inject.servlet.ServletModule;

/**
 * Servlet module, register and configure all the servlets of the application.
 * 
 * @author Bastien
 * 
 */
public class RotileServletModule extends ServletModule {

	@Override
	protected void configureServlets() {
		// Configure CXF servlet
		Map<String, String> initParams = new HashMap<String, String>();
		initParams
				.put("jaxrs.serviceClasses",
						"com.open.rotile.server.VoteRestService, com.open.rotile.server.ProjectRestService");
		serve("/*").with(CxfRestServlet.class, initParams);
	}
}
