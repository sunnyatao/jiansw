/**
 * 
 */
package com.jianan.software.pojo;

import java.util.Date;

/**
 * @author weiwzhou
 *
 */
public class CrmauthRoleResource {
	private int roleResourceId;
	private int roleId;
	private int resourceId;
	private Date createdOn;
	private String createdBy;
	/**
	 * @return the roleResourceId
	 */
	public int getRoleResourceId() {
		return roleResourceId;
	}
	/**
	 * @param roleResourceId the roleResourceId to set
	 */
	public void setRoleResourceId(int roleResourceId) {
		this.roleResourceId = roleResourceId;
	}
	/**
	 * @return the roleId
	 */
	public int getRoleId() {
		return roleId;
	}
	/**
	 * @param roleId the roleId to set
	 */
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	/**
	 * @return the resourceid
	 */
	public int getResourceId() {
		return resourceId;
	}
	/**
	 * @param resourceid the resourceid to set
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
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CrmauthRoleResource [roleResourceId=" + roleResourceId + ", roleId=" + roleId + ", resourceId="
				+ resourceId + ", createdOn=" + createdOn + ", createdBy=" + createdBy + "]";
	}
	
	
}

