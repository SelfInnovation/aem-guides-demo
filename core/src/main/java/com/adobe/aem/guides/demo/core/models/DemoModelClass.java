/**
 * 
 */
package com.adobe.aem.guides.demo.core.models;

import javax.inject.Inject;
import javax.jcr.Session;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.models.annotations.Default;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author
 *
 */

@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class DemoModelClass {

	private static final Logger LOG = LoggerFactory.getLogger(DemoModelClass.class);

	@Inject
	@Default(values = "linkNav")
	private String text;
	@Inject
	private String tarea;

	public String getTarea() {
		// LOG.info("Fetching tarea property: {}", tarea);
		return tarea;
	}

	public String getText() {
		// LOG.info("Fetching text property: {}", text);
		return text;
	}

	@Inject
	Resource resource;

	/*
	 * public Session gettingSession() { if (resource != null) { ResourceResolver
	 * resourceResolver = resource.getResourceResolver(); LOG.info("line 47 " +
	 * "resource path", resource.getPath()); Session session =
	 * resourceResolver.adaptTo(Session.class); if (session != null) {
	 * LOG.info("Successfully obtained JCR session."); LOG.info("line  51" +
	 * "Printing Session: {}", session.toString()); } else { LOG.info("line 53 " +
	 * "Failed to obtain JCR session."); } return session; } LOG.info("line 57" +
	 * "Resource is null, cannot obtain session."); return null; }
	 */
}
