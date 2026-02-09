package com.adobe.aem.guides.demo.core.models;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Exporter;

@Model(adaptables = Resource.class, resourceType = "demo/components/featurelist", defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)

@Exporter(name = "jackson", extensions = "json")

public class MultiFieldComponent {

	@ValueMapValue
	private String title;

	@ChildResource(name = "features")
	private Resource features;

	private List<String> featureList;

	@PostConstruct
	protected void init() {

		featureList = new ArrayList<>();

		if (features != null) {
			for (Resource item : features.getChildren()) {

				String feature = item.getValueMap().get("feature", String.class);

				if (feature != null) {
					featureList.add(feature);

				}

			}

		}
	}

	public String getTitle() {
		return title;
	}

	public List<String> getFeatureList() {
		return featureList;
	}

}