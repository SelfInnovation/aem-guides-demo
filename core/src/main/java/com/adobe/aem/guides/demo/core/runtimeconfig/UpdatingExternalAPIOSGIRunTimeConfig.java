package com.adobe.aem.guides.demo.core.runtimeconfig;

import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.AttributeType;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;

@ObjectClassDefinition(
		name		= "Configurations for updating the External API",
		description = "Update the External API")
public @interface UpdatingExternalAPIOSGIRunTimeConfig {

	
	@AttributeDefinition(
			name  = "External API",
			type  = AttributeType.STRING,
					description = "Kinldy update the external API URL here")
	
	
	public String externalAPIURL() default "Enter External API URL";
	
	
}
