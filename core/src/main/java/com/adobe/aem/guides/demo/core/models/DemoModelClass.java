/**
 * 
 */
package com.adobe.aem.guides.demo.core.models;

import javax.inject.Inject;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;

/**
 * 
 * @author mkkol
 *
 */


@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class DemoModelClass {
	
	@Inject
	private String text;
	
	private String textarea;

	public String getTextarea() {
		return textarea;
	}

	public String getText() {
		return text;
	}

}
