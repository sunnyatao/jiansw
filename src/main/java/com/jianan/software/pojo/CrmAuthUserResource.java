/**
 *	Copyright (C) 2014-2015 hst Software. All rights reserved. 
 *
 *	Author: sunny
 *
 *	CreatedAt: 2016年8月15日
 *  
 *	Description: ...
 */
package com.jianan.software.pojo;

import java.util.Date;

public class CrmAuthUserResource {
	private int userResourceId;
	
	private int userId;
	
	private int resourceId;
	
	private Date createdOn;
	
	private String createdBy;
	
	private CrmAuthResource authResource;

	/**
	 * @return the userResourceId
	 */
	public int getUserResourceId() {
		return userResourceId;
	}

	/**
	 * @param userResourceId the userResourceId to set
	 */
	public void setUserResourceId(int userResourceId) {
		this.userResourceId = userResourceId;
	}

	/**
	 * @return the userId
	 */
	public int getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(int userId) {
		this.userId = userId;
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
}
