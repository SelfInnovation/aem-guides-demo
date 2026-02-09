package com.adobe.aem.guides.demo.core.models;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)

public class HeroBannerModel {

	@ValueMapValue
	private String heading;
	@ValueMapValue
	private String description;
	@ValueMapValue
	private String image;
	@ValueMapValue
	private String ctaText;
	@ValueMapValue
	private String ctaLink;
	@ValueMapValue
	private String variation;
	
	
	

	public String getHeading() {
		return heading;
	}

	public String getDescription() {
		return description;
	}

	public String getImage() {
		return image;
	}

	public String getCtaText() {
		return ctaText;
	}

	public String getCtaLink() {
		return ctaLink;
	}

	public String getVariation() {
		return variation;
	}
	
	
	public boolean isLeft() {
		return "left".equalsIgnoreCase(variation);
	}
	
		public boolean isRight() {
			return "right".equalsIgnoreCase(variation);
		}
		
		public boolean isCenter() {
			return "center".equalsIgnoreCase(variation);
		}
		


	protected void init() {

		if (variation == null || variation.isBlank() || variation.isEmpty()) {
			variation = "left";
		}
	}

}
