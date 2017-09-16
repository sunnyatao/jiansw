package com.jianan.software.template;


import java.util.Locale;

import org.lilystudio.smarty4j.Engine;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.core.io.Resource;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.AbstractTemplateViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;


public class Smarty4jViewResolver extends AbstractTemplateViewResolver  implements ApplicationListener{
	
	private static final Logger LOG = LoggerFactory.getLogger(Smarty4jViewResolver.class);
	
	private String prefix;
	private String suffix;
	private String contentType;
	
	private Engine engine;
	
	
	public String getPrefix() {
		return prefix;
	}
	
	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}

	public String getSuffix() {
		return suffix;
	}

	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}


	@Override 
    protected View loadView(String viewName, Locale locale) throws Exception {

		String requestedFilePath = prefix + viewName +suffix;
        
        if( LOG.isDebugEnabled()){
    		LOG.debug("Requested file found: " + requestedFilePath + ", viewName:" + viewName);
    	}
        // 根据视图名，获取相应的 view 对象
        Smarty4jView view = new Smarty4jView(engine,viewName +suffix ,contentType);
        
        view.setApplicationContext(this.getApplicationContext());
        view.setUrl(requestedFilePath); 
       
        return view; 
	}

	@Override
	public void onApplicationEvent(ApplicationEvent event) {
		
		if(event instanceof ContextRefreshedEvent ) { //spring容器启动完成
			WebApplicationContext appContext= (WebApplicationContext)((ContextRefreshedEvent) event).getApplicationContext();
			
			if(appContext.getParent() == null){
				Smarty4jConfigurer configurer =(Smarty4jConfigurer) appContext.getBean("smarty4jConfig");
				String relativePath = configurer.get("relative_template_path");
				configurer.put("template.path", appContext.getServletContext().getRealPath(relativePath));
				configurer.put("context.path", appContext.getServletContext().getContextPath());
		        this.engine = new Engine(configurer);
			}
		}
		
	}

}
