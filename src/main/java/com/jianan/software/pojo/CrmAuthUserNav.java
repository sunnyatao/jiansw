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

public class CrmAuthUserNav {

	private int unavId;
	
	private int userId;
	
	private int navId;
	
	private Date createdOn;
	
	private String createdBy;
	
	private CrmAuthNavigation navigation;

	/**
	 * @return the unavId
	 */
	public int getUnavId() {
		return unavId;
	}

	/**
	 * @param unavId the unavId to set
	 */
	public void setUnavId(int unavId) {
		this.unavId = unavId;
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
	 * @return the navigation
	 */
	public CrmAuthNavigation getNavigation() {
		return navigation;
	}

	/**
	 * @param navigation the navigation to set
	 */
	public void setNavigation(CrmAuthNavigation navigation) {
		this.navigation = navigation;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + navId;
		result = prime * result + unavId;
		result = prime * result + userId;
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
		CrmAuthUserNav other = (CrmAuthUserNav) obj;
		if (navId != other.navId)
			return false;
		if (unavId != other.unavId)
			return false;
		if (userId != other.userId)
			return false;
		return true;
	}

	
}
