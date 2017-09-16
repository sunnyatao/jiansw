/**
 * 
 */
package com.jianan.resources.dao;

import java.util.List;

import com.jianan.software.pojo.CrmAuthResource;
import com.jianan.software.pojo.CrmAuthUserResource;
import com.jianan.software.util.Page;


/**
 * @author haiywang
 *
 */
public interface IResourceDao {

	
	List<CrmAuthResource> getResourceList(Page page);

	CrmAuthResource getCrmResource(int resourceId);
	
	void createResource(CrmAuthResource resource);

	void updateResource(CrmAuthResource resource);


	void deleteResource(String resourceId);
	
	int getResourceCount();

	/**
	 * @param userId
	 */
	void removeUserResources(int userId);

	/**
	 * @param userResources
	 */
	void insertUserResources(List<CrmAuthUserResource> userResources);

	List<CrmAuthResource> getAllResource();

}
