package com.adobe.aem.guides.demo.core.workflows;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.osgi.service.component.annotations.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.adobe.granite.asset.api.Asset;
import com.adobe.granite.workflow.WorkflowException;
import com.adobe.granite.workflow.WorkflowSession;
import com.adobe.granite.workflow.exec.WorkItem;
import com.adobe.granite.workflow.exec.WorkflowProcess;
import com.adobe.granite.workflow.metadata.MetaDataMap;

@Component(service = WorkflowProcess.class, property = {
		"process.label=Asset Moving to locale folders or target folders" }

)

public class AssetRoutingToTargetLocales implements WorkflowProcess {

	public static final Logger LOG = LoggerFactory.getLogger(AssetRoutingToTargetLocales.class);

	@Override

	public void execute(WorkItem item, WorkflowSession wfsession, MetaDataMap metaData) throws WorkflowException {

		String assetPayloadPath = item.getWorkflowData().getPayload().toString();
		LOG.info(" Asset routing worflow triigered for {}", assetPayloadPath + " on this asset");

		if (assetPayloadPath == null || !assetPayloadPath.startsWith("/content/dam/assets-incoming")) {
			LOG.warn("Skipping non-DAM payload {}", assetPayloadPath);
			return;
		}

		ResourceResolver rresolver = wfsession.adaptTo(ResourceResolver.class);

		Resource resource = rresolver.getResource(assetPayloadPath);

		if (resource == null || resource.adaptTo(Asset.class) == null) {

			LOG.warn("Its not a Asset");
			return;
		}

		// Asset asset = resource.adaptTo(Asset.class);

		Resource metadata = resource.getChild("jcr:content/metadata");

		LOG.info("Resource metadata format   {}", metadata);

		if (metadata == null) {

			LOG.warn("meatdata for this {}", assetPayloadPath + "asset not found");
		}

		String filedValue = metadata.getValueMap().get("dc:subject", String.class);
		LOG.info("dc:subject value: {}", filedValue);
	}
}
