package com.jianan.software.template;

import java.io.StringWriter;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.lilystudio.smarty4j.Context;
import org.lilystudio.smarty4j.Engine;
import org.lilystudio.smarty4j.Template;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.view.AbstractTemplateView;

public class Smarty4jView extends AbstractTemplateView {
	private Engine engine;
	private String viewName;
	private String contentType;


	public Smarty4jView(Engine engine, String viewName,String contentType) {
		this.engine=engine;
		this.viewName= viewName;
		this.contentType = contentType;
	}

	@Override
	protected void renderMergedTemplateModel(Map<String, Object> model,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
        Template template = engine.getTemplate(viewName);
        Context context = new Context();
        context.putAll(model);
        String userAgent = request.getHeader("user-agent");
		if (userAgent.indexOf("MicroMessenger") == -1) {
			context.set("browser", "touch");
        }
		
        String contextPath = ((WebApplicationContext)this.getApplicationContext()).getServletContext().getContextPath();
        context.set("context_path", contextPath);
        
        ECShopSupport ecshopSupport = (ECShopSupport)getApplicationContext().getBean("ecshopSupport");
        context.set("lang", ecshopSupport.getLangMap());
        context.set("cfg", ecshopSupport.getShopConfigMap());
        
        response.setContentType(contentType);
        template.merge(context, response.getWriter());
        response.getWriter().flush();	
	}
	
	public String fetchView(Map<String, Object> model)
			throws Exception {
		
        Template template = engine.getTemplate(viewName);
        Context context = new Context();
        context.putAll(model);
        
        String contextPath = ((WebApplicationContext)this.getApplicationContext()).getServletContext().getContextPath();
        context.set("context_path", contextPath);
        
        ECShopSupport ecshopSupport = (ECShopSupport)getApplicationContext().getBean("ecshopSupport");
        context.set("lang", ecshopSupport.getLangMap());
        context.set("cfg", ecshopSupport.getShopConfigMap());
        StringWriter strW = new StringWriter();
       
        template.merge(context, strW);
        return strW.toString();	
	}

	public String getViewRealPath() {
		return engine.getTemplatePath()+viewName;
	}
}
