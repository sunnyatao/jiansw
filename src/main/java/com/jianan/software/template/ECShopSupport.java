package com.jianan.software.template;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FilenameFilter;
import java.io.InputStreamReader;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ApplicationObjectSupport;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.web.context.WebApplicationContext;

import com.jianan.software.util.SpringContextHolder;
@Repository("ecshopSupport")
public class ECShopSupport extends ApplicationObjectSupport{
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ECShopSupport.class);
	
	private static Pattern TRIMP = Pattern.compile("^\\s*['\"](.*)['\"];");
	  
	private static Pattern NAMEP = Pattern.compile("\\[['\"](.*?)['\"]\\]");
	
	
	private String langPath;
	
	private String encoding;
	
	private Map<String,Object> langMap= new HashMap<String,Object>();
	
	private Map<String,String> shopConfigMap= new HashMap<String,String>();
	
	

	public String getLangPath() {
		return langPath;
	}


	public void setLangPath(String langPath) {
		this.langPath = langPath;
	}


	public String getEncoding() {
		return encoding;
	}


	public void setEncoding(String encoding) {
		this.encoding = encoding;
	}


	public Map<String, Object> getLangMap() {
		return langMap;
	}


	public void setLangMap(Map<String, Object> langMap) {
		this.langMap = langMap;
	}


	public Map<String, String> getShopConfigMap() {
		return shopConfigMap;
	}


	public void setShopConfigMap(Map<String, String> shopConfigMap) {
		this.shopConfigMap = shopConfigMap;
	}


	public void loadLangMap(){
		WebApplicationContext appContext= (WebApplicationContext)this.getApplicationContext();
		String langRootPath = appContext.getServletContext().getRealPath(langPath);
		langMap = readLangMap(langRootPath);
		
	}


	public  Map<String,Object> readLangMap(String langRootPath){
		Map<String,Object> tmpLangMap = new HashMap<String,Object>();
		File[] arrLangFiles = new File(langRootPath).listFiles(new FilenameFilter(){
			@Override
			public boolean accept(File dir, String name) {
				if(name.endsWith(".lang")){
					return true;
				}
				return false;
			}
			
		});
		if( arrLangFiles ==null)
			return tmpLangMap;
		
		for(File file :arrLangFiles){
			InputStreamReader fr =null;
			try{
				
				fr = new InputStreamReader(new FileInputStream(file),encoding);
				BufferedReader bufR = new BufferedReader(fr);
				String line =null;
				while( (line = bufR.readLine()) !=null ){
					paseValue2Map(line,tmpLangMap);
				}
				fr.close();
			}catch(Exception ex){
				LOGGER.error(ex.toString(),ex);
			}
		}
		
		return tmpLangMap;
	}


	private void paseValue2Map(String line, Map<String, Object> tmpLangMap) {
		
		int ind = line.indexOf("=") ;
		if( ind== -1){
			return;
		}
		
		String[] arr = new String []{ line.substring(0,ind),line.substring(ind+1)};
		
		Matcher valMatcher = TRIMP.matcher(arr[1]);
		String value =null;
		if( valMatcher.find()){
			value = valMatcher.group(1);
		}else {
			LOGGER.warn("can't assing lang value for line "+line);
			return;
		}

		
		Matcher matcher = NAMEP.matcher(arr[0]);
		ArrayList<String> nameList = new ArrayList();
		while( matcher.find() ){
			nameList.add(matcher.group(1));
		}
		
		if(nameList.size() ==1){
			tmpLangMap.put(nameList.get(0), value);
		}else if( nameList.size() ==2){
			Map<String,String> secondMap = (Map<String,String>)tmpLangMap.get(nameList.get(0));
			if( secondMap ==null){
				secondMap = new HashMap<String,String>();
				tmpLangMap.put(nameList.get(0), secondMap);
			}
			secondMap.put(nameList.get(1), value);
		}else {
			LOGGER.warn("can't assing lang name for line "+line);
		}
	}
	
	
	public void loadShopConfig(){
		final Map<String,String> tcfgMap= new HashMap();
		
		DataSource ds = SpringContextHolder.getBean("dataSource");
		JdbcTemplate jdbcTemplate = new JdbcTemplate(ds);
		
		String sql = "select * from ecs_shop_config";
		
		List<Map<String,String>> retList = jdbcTemplate.query(sql , new RowMapper<Map<String,String>>(){

			@Override
			public Map<String,String> mapRow(ResultSet rs, int num)
					throws SQLException {
				
				String fieldName = rs.getString("code");
				String fieldValue = rs.getString("value");
				
				tcfgMap.put(fieldName, fieldValue);
				
				return null;
			}
		});
		if (tcfgMap.containsKey("shop_domain_name_java")) {
			tcfgMap.put("shop_domain_name", tcfgMap.get("shop_domain_name_java"));
		}
		if (tcfgMap.containsKey("shop_secure_domain_name_java")) {
			tcfgMap.put("shop_secure_domain_name", tcfgMap.get("shop_secure_domain_name_java"));
		}
		if (tcfgMap.containsKey("shop_m_domain_name_java")) {
			tcfgMap.put("shop_m_domain_name", tcfgMap.get("shop_m_domain_name_java"));
		}
		if (tcfgMap.containsKey("shop_secure_m_domain_name_java")) {
			tcfgMap.put("shop_secure_m_domain_name", tcfgMap.get("shop_secure_m_domain_name_java"));
		}
		
		shopConfigMap = tcfgMap;
	}
	
	public int getRemberMaxAge(){
		String remberMaxAge = shopConfigMap.get("rember_max_age");
		if(remberMaxAge==null || remberMaxAge.isEmpty() ){
			return 604800;//7天时间
		}else {
			return Integer.parseInt(remberMaxAge);
		}	
	}
	
	public boolean isRewriteToHtml(){
		
		String rewriteTpHtml = shopConfigMap.get("rewrite_to_html");
		if("1".equals(rewriteTpHtml) || "true".equals(rewriteTpHtml) ){
			return true;
		}else {
			return false;
		}
	}
	
	public String getValue(String key) {
		return this.shopConfigMap.get(key);
	}
}
