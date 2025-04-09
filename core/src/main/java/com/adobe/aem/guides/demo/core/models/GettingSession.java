
/* In sling model we can get the Resorce Resolver by using Inject annotations
    private ResourceResolver resourceResolver;"	 Session session = resourceResolver.adaptTo(Session.class);	"
   
    @Inject: Injects the ResourceResolver automatically into the model. You can then adapt it to a JCR Session.

     resourceResolver.adaptTo(Session.class): This line adapts the ResourceResolver to a JCR session.

     The Session object gives you access to the repository, allowing you to perform CRUD operations on the nodes or properties."
     
     
     Key Points to Remember:
	1. ResourceResolver is the easiest way to obtain the JCR session in Sling Models.
	2. Always handle exceptions and session lifecycle properly.
	3. Make sure that your Sling Model is adaptable from the correct type (e.g., Resource.class).
	4. Avoid long transactions or operations on the JCR session to prevent performance degradation.
	
 * */

package com.adobe.aem.guides.demo.core.models;

//import javax.annotation.Resource;
import javax.inject.Inject;
import javax.jcr.Node;
import javax.jcr.PathNotFoundException;
import javax.jcr.RepositoryException;
import javax.jcr.Session;

import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.api.resource.*;

@Model(adaptables = { Resource.class })
public class GettingSession {

	@Inject
	ResourceResolver resourceresolver;

	public void getJCRSession() {

		String path = "/content";
		Resource resource = resourceresolver.getResource(path);
		Session session = resourceresolver.adaptTo(Session.class);

		if (session.isLive()) {
			try {
				Node pagePath = session.getNode("");
			} catch (PathNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (RepositoryException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
