/**
 * 
 */
package com.jianan.resources.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jianan.resources.dao.IResourceDao;
import com.jianan.resources.service.IResourceService;
import com.jianan.software.pojo.CrmAuthResource;
import com.jianan.software.pojo.CrmAuthUserResource;
import com.jianan.software.util.Page;

/**
 * @author haiywang
 *
 */
@Service("resourceService")
public class ResourceServiceImpl implements IResourceService{
	@Autowired
	private IResourceDao resourceDao;

	
	@Override
	public List<CrmAuthResource> getResourceList(Page page) {
		
		return resourceDao.getResourceList(page);
	}

	@Override
	public void saveResource(CrmAuthResource resource) {
		resource.setCreatedOn(new Date());
		CrmAuthResource res = resourceDao.getCrmResource(resource.getResourceId());
		if(res==null){
			resourceDao.createResource(resource);
		}else{
			resourceDao.updateResource(resource);
		}
	}
	@Override
	public void deleteResource(String resourceId) {
		resourceDao.deleteResource(resourceId);
		
	}

	@Override
	public int getResourceCount() {
		
		return resourceDao.getResourceCount();
	}

	@Override
	public void removeUserResources(int userId) {
		resourceDao.removeUserResources(userId);
	}

	@Override
	public void setUserResources(int userId, List<Integer> resourceIds,
			String createdBy) {
		removeUserResources(userId);
		
		List<CrmAuthUserResource> userResources = new ArrayList<>();
		for (Integer resourceId: resourceIds) {
			CrmAuthUserResource userResource = new CrmAuthUserResource();
			userResource.setResourceId(resourceId);
			userResource.setUserId(userId);
			userResource.setCreatedBy(createdBy);
			userResources.add(userResource);
		}
		
		resourceDao.insertUserResources(userResources);
	}

	@Override
	public List<CrmAuthResource> getAllResource() {
		
		return resourceDao.getAllResource();
	}

}
