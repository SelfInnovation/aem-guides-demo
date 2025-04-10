package com.adobe.aem.guides.demo.core.workflows;

import org.apache.sling.api.adapter.Adaptable;
import org.apache.sling.api.resource.ResourceResolver;
import org.osgi.service.component.annotations.Component;

import com.adobe.granite.workflow.WorkflowException;
import com.adobe.granite.workflow.WorkflowSession;
import com.adobe.granite.workflow.exec.WorkItem;
import com.adobe.granite.workflow.exec.WorkflowProcess;
import com.adobe.granite.workflow.metadata.MetaDataMap;
import com.adobe.granite.workflow.model.WorkflowModel;

/*
 * 
 * To create a Custom Workflow Process-
1. Create an OSGi service implementing the interface com.adobe.granite.workflow.exec.WorkflowProcess.
2. Set the property process.label — Name of the workflow that will be listed.
3. Implement the execute(WorkItem, WorkflowSession, MetaDataMap) method with the implementation code(code logic).

The execute() method has three parameters -

1. WorkItem — It contains the WorkflowData. The instances act on and a reference to the WorkflowNode that describes the underlying workflow step.
2. WorkflowSession — This class provides a workflow session to perform/manage WorkflowModels, Workflow instances and their execution.
3. MetaDataMap — A value map for generic access to meta data values via arguments in the dialog.

*/

public class SampleWorkflow implements WorkflowProcess {

	ResourceResolver resourceResolver;
	String path = "/content/";

	@Override
	public void execute(WorkItem workItem, WorkflowSession wfSession, MetaDataMap metaDataMap)
			throws WorkflowException {
			
				
	String path=	workItem.getWorkflowData().getPayload().toString();
	
	

		
		
		
		WorkflowSession workflowsession = resourceResolver.adaptTo(WorkflowSession.class);
		WorkflowModel wfmodel = workflowsession.getModel(path);

	}

}
