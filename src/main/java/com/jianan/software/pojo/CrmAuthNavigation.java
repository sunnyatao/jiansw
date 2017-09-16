/**
 *	Copyright (C) 2014-2015 hst Software. All rights reserved. 
 *
 *	Author: sunny
 *
 *	CreatedAt: 2016年8月16日
 *  
 *	Description: ...
 */
package com.jianan.software.pojo;

import java.util.Date;

public class CrmAuthNavigation {
	
	public static final int NAVLEVEL_TOP = 1;	//1级导航
	public static final int NAVLEVEL_SECOND = 2;	//2级菜单
	public static final int NAVLEVEL_THREE = 3;		//3级不展示

	private int navId;
	
	private String navName;
	
	private int parentId;
	
	private int resourceId;
	
	private CrmAuthResource authResource;
	
	private String createdBy;
	
	private Date createdOn;
	
	private int sortValue;
	
	private int navLevel;
	
	private String active = "";
	
	private int relateResourceId;

	/**
	 * @return the navId
	 */
	public int getNavId() {
		return navId;
	}

	/**
	 * @param navId the navId to set
	 */
	public void setNavId(int navId) {
		this.navId = navId;
	}

	/**
	 * @return the navName
	 */
	public String getNavName() {
		return navName;
	}

	/**
	 * @param navName the navName to set
	 */
	public void setNavName(String navName) {
		this.navName = navName;
	}

	/**
	 * @return the parentId
	 */
	public int getParentId() {
		return parentId;
	}

	/**
	 * @param parentId the parentId to set
	 */
	public void setParentId(int parentId) {
		this.parentId = parentId;
	}

	/**
	 * @return the resourceId
	 */
	public int getResourceId() {
		return resourceId;
	}

	/**
	 * @param resourceId the resourceId to set
	 */
	public void setResourceId(int resourceId) {
		this.resourceId = resourceId;
	}

	/**
	 * @return the authResource
	 */
	public CrmAuthResource getAuthResource() {
		return authResource;
	}

	/**
	 * @param authResource the authResource to set
	 */
	public void setAuthResource(CrmAuthResource authResource) {
		this.authResource = authResource;
	}

	/**
	 * @return the createdBy
	 */
	public String getCreatedBy() {
		return createdBy;
	}

	/**
	 * @param createdBy the createdBy to set
	 */
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	/**
	 * @return the createdOn
	 */
	public Date getCreatedOn() {
		return createdOn;
	}

	/**
	 * @param createdOn the createdOn to set
	 */
	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	/**
	 * @return the sortValue
	 */
	public int getSortValue() {
		return sortValue;
	}

	/**
	 * @param sortValue the sortValue to set
	 */
	public void setSortValue(int sortValue) {
		this.sortValue = sortValue;
	}

	/**
	 * @return the navLevel
	 */
	public int getNavLevel() {
		return navLevel;
	}

	/**
	 * @param navLevel the navLevel to set
	 */
	public void setNavLevel(int navLevel) {
		this.navLevel = navLevel;
	}

	/**
	 * @return the active
	 */
	public String getActive() {
		return active;
	}

	/**
	 * @param active the active to set
	 */
	public void setActive(String active) {
		this.active = active;
	}

	/**
	 * @return the relateResourceId
	 */
	public int getRelateResourceId() {
		return relateResourceId;
	}

	/**
	 * @param relateResourceId the relateResourceId to set
	 */
	public void setRelateResourceId(int relateResourceId) {
		this.relateResourceId = relateResourceId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + navId;
		result = prime * result + ((navName == null) ? 0 : navName.hashCode());
		result = prime * result + parentId;
		result = prime * result + relateResourceId;
		result = prime * result + resourceId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CrmAuthNavigation other = (CrmAuthNavigation) obj;
		if (navId != other.navId)
			return false;
		if (navName == null) {
			if (other.navName != null)
				return false;
		} else if (!navName.equals(other.navName))
			return false;
		if (parentId != other.parentId)
			return false;
		if (relateResourceId != other.relateResourceId)
			return false;
		if (resourceId != other.resourceId)
			return false;
		return true;
	}
}
