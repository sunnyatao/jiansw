package com.jianan.software.component.start;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

public class StartScheduler  implements ApplicationListener{
	
	private static final Logger LOG = LoggerFactory.getLogger(StartScheduler.class);
	
	List<JobMethod> jobDetails;
	
	
	public List<JobMethod> getJobDetails() {
		return jobDetails;
	}


	public void setJobDetails(List<JobMethod> jobDetails) {
		this.jobDetails = jobDetails;
	}

	
	private void start(){
		if( jobDetails ==null){
			LOG.warn("no start job details");
			return;
		}
		
		for(JobMethod jobMethod : jobDetails){

				Method method;
				try {
					method = jobMethod.getTargetObject().getClass().getMethod(jobMethod.getTargetMethod());
					method.invoke(jobMethod.getTargetObject(), null);
				} catch (NoSuchMethodException | SecurityException | IllegalAccessException | 
						IllegalArgumentException | InvocationTargetException e) {
					LOG.error(e.toString(),e);
				}
				
			
		}
		
	}
	

	@Override
	public void onApplicationEvent(ApplicationEvent event) {
		
		if(event instanceof ContextRefreshedEvent && 
				((ContextRefreshedEvent) event).getApplicationContext().getParent() == null ) { //spring容器启动完成
			start();	
		}
	}
}
