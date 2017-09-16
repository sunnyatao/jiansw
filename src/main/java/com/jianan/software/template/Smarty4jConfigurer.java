package com.jianan.software.template;

import java.util.HashMap;
import java.util.Map;

public class Smarty4jConfigurer extends HashMap<String,String> {

	private static final long serialVersionUID = 2134124L;

	public void setTemplatePath(String templatePath) {
		this.put("relative_template_path", templatePath);
	}


	public void setDefaultEncoding(String defaultEncoding) {
		this.put("encoding", defaultEncoding);
	}

	public void setSettings(Map<String,String> settings) {
		this.putAll(settings);
	}
}
