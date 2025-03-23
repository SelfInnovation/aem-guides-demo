package com.adobe.aem.guides.demo.core.schedulers;

import org.apache.sling.commons.scheduler.Scheduler;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.metatype.annotations.Designate;


@Designate(ocd=SimpleScheduledTask.Config.class)
@Component(service = Runnable.class, immediate = true)
public class DemoSchedular implements Runnable{

	
	@Reference
	Scheduler schedular;
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

}
