package com.adobe.aem.guides.demo.services;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.metatype.annotations.Designate;

import com.adobe.aem.guides.demo.core.runtimeconfig.UpdatingExternalAPIOSGIRunTimeConfig;
import com.adobe.aem.guides.demo.interfaces.StudentConfigurationMethodsInterface;

@Component(service = StudentConfigurationMethodsInterface.class)
@Designate(ocd=UpdatingExternalAPIOSGIRunTimeConfig.class)
public class ExternalAPIServiceImpl implements StudentConfigurationMethodsInterface{

	@Override
	public String fetchExternalAPIMethod() {
		return null;
		
	}

}
