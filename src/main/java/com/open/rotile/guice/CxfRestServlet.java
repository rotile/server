package com.open.rotile.guice;

import org.apache.cxf.jaxrs.servlet.CXFNonSpringJaxrsServlet;

import com.google.inject.Singleton;

/**
 * Subclassed {@link CXFNonSpringJaxrsServlet} for Guice integration (servlet
 * has to be a singleton).
 * 
 * @author Bastien
 * 
 */
@Singleton
public class CxfRestServlet extends CXFNonSpringJaxrsServlet {

}
