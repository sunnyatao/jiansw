/**
 * 
 */
package com.jianan.resources.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jianan.resources.service.IResourceService;
import com.jianan.software.common.ICommonService;
import com.jianan.software.pojo.CrmAuthResource;
import com.jianan.software.util.Page;
import com.jianan.software.util.ResponseUtil;

/**
 * @author haiywang
 *
 */
@Controller
@RequestMapping("/crm/v1/auth/resource")
public class ResourceController {
	private static final Logger LOGGER = LoggerFactory.getLogger(ResourceController.class);
	
	@Autowired
	IResourceService resourceService;
	@Autowired
	ICommonService commomService;
	
	@RequestMapping("/list")
	public ModelAndView getResourceList(HttpServletRequest request, HttpServletResponse response){
		ModelAndView view = new ModelAndView("/admin/resource_list");
		try{
			String pageIndex = request.getParameter("page") == null? "1" : request.getParameter("page");
	        String pageSize = request.getParameter("page_size") == null ? "30" : request.getParameter("page_size");
	        int resourceCount = resourceService.getResourceCount();
	        Page page = new Page(resourceCount, Integer.parseInt(pageSize), Integer.parseInt(pageIndex));
			List<CrmAuthResource> resourceList = resourceService.getResourceList(page);
			view.addObject("resourceList",resourceList);
			view.addObject("page", page);
			commomService.fillCommonView(request, view);
		return view;
		}catch(Exception e){
			LOGGER.error(e.toString(),e);  
			return view;
		}
	}
	//保存资源信息
	@RequestMapping("/ajax/save")
	public void saveResource(HttpServletRequest request, HttpServletResponse response){
		try{
			String resourceId = request.getParameter("resource_id");
			String resourceName = request.getParameter("resource_name");
			String resourcePath = request.getParameter("resource_path");
			String resourceDesc = request.getParameter("resource_desc");
			String resourceType = request.getParameter("resource_type");
			CrmAuthResource resource = new CrmAuthResource();
			resource.setResourceId(Integer.parseInt(resourceId));
			resource.setResourceName(resourceName);
			resource.setResourcePath(resourcePath);
			resource.setResourceDesc(resourceDesc);
			resource.setResourceType(Integer.valueOf(resourceType));
			resourceService.saveResource(resource);
			ResponseUtil.writeResponseSuccess(response);
		} catch (Exception e) {
			LOGGER.error(e.toString(), e);
			ResponseUtil.writeResponseFailure(response);
		}
	}
	@RequestMapping("/ajax/list")
	public void getResources(HttpServletRequest request, HttpServletResponse response){
		try{
			List<CrmAuthResource> resourceList  = resourceService.getAllResource();
			JSONObject msgData = new JSONObject();
			msgData.put("resources", resourceList);		
			ResponseUtil.writeResponseSuccess(response, msgData);
		} catch (Exception e) {
			LOGGER.error(e.toString(), e);
			ResponseUtil.writeResponseFailure(response);
		}
	}
	@RequestMapping("/ajax/delete")
	public void deleteResource(HttpServletRequest request, HttpServletResponse response){
		try{
			String resourceId = request.getParameter("resource_id");
			resourceService.deleteResource(resourceId);
			ResponseUtil.writeResponseSuccess(response);
		} catch (Exception e) {
			LOGGER.error(e.toString(), e);
			ResponseUtil.writeResponseFailure(response);
		}
	}
}
