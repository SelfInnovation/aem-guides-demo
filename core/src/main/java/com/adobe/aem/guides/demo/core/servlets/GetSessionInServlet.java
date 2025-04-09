package com.adobe.aem.guides.demo.core.servlets;

import java.io.IOException;

import javax.jcr.Session;
import javax.servlet.ServletException;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;

public class GetSessionInServlet extends SlingAllMethodsServlet {

	// ResourceResolver resourceResolver;

	@Override
	protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		ResourceResolver resourceResolver = request.getResourceResolver();
		Session session = resourceResolver.adaptTo(Session.class);
		// String stringPath = session.getNode();
		super.doGet(request, response);
	}

	@Override
	protected void doPost(SlingHttpServletRequest request, SlingHttpServletResponse response)
			throws ServletException, IOException {
		ResourceResolver resourceResolver = request.getResourceResolver();
		// TODO Auto-generated method stub
		super.doPost(request, response);
	}
}
