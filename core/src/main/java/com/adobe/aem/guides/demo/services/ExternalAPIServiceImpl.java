package com.adobe.aem.guides.demo.services;

import java.io.IOException;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Modified;
import org.osgi.service.metatype.annotations.Designate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.adobe.aem.guides.demo.core.runtimeconfig.UpdatingExternalAPIOSGIRunTimeConfig;
import com.adobe.aem.guides.demo.interfaces.StudentConfigurationMethodsInterface;

@Component(service = StudentConfigurationMethodsInterface.class)
@Designate(ocd=UpdatingExternalAPIOSGIRunTimeConfig.class)
public class ExternalAPIServiceImpl implements StudentConfigurationMethodsInterface{

	private String endpoint;
	
	private static final Logger LOG = LoggerFactory.getLogger(ExternalAPIServiceImpl.class);
	
	
	@Activate
	@Modified
	protected void activate(UpdatingExternalAPIOSGIRunTimeConfig config) {
		this.endpoint = config.externalAPIURL();
		LOG.info("Service activated with end point -- {}", config.externalAPIURL());
		
	}
		
	// 🔹 Business method exposed to servlet / sling model
    @Override
    public String fetchExternalAPIMethod() throws IOException{

        LOG.debug("Calling external API: {}", endpoint);

        try (CloseableHttpClient client = HttpClients.createDefault()) {

            HttpGet httpGet = new HttpGet(endpoint);

            try (CloseableHttpResponse response = client.execute(httpGet)) {
                return EntityUtils.toString(response.getEntity());
            }
        }
    }
}