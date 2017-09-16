/**
 * 
 */
package com.jianan.resources.service;

import java.util.List;

import com.jianan.software.pojo.CrmAuthResource;
import com.jianan.software.util.Page;

/**
 * @author haiywang
 *
 */
public interface IResourceService {


	List<CrmAuthResource> getResourceList(Page page);

	
	void saveResource(CrmAuthResource resource);

	void deleteResource(String resourceId);

	int getResourceCount();

	void removeUserResources(int userId);
	
	void setUserResources(int userId, List<Integer> resourceIds, String createdBy);
	
	List<CrmAuthResource> getAllResource();
}
