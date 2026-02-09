package com.adobe.aem.guides.demo.core.models;

import java.io.IOException;

import javax.annotation.PostConstruct;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.OSGiService;
import org.osgi.service.component.annotations.Reference;

import com.adobe.aem.guides.demo.interfaces.StudentConfigurationMethodsInterface;

@Model(adaptables = { SlingHttpServletRequest.class }

)
public class ExternalAPIModel {

	String apiresponse;

	@OSGiService
	StudentConfigurationMethodsInterface studentConfigurationMethodsInterface;

	@PostConstruct
	protected void init() throws IOException {
		apiresponse = studentConfigurationMethodsInterface.fetchExternalAPIMethod();
	}

	public String getApiResponse() {
		return apiresponse;
	}
}
