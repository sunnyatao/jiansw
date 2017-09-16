
package com.jianan.software.pojo;

import java.util.Date;
import java.util.List;

/**
 * @author weiwzhou
 *
 */
public class CrmAuthRole {
	private int roleId;
	private String roleName;
	private String description;
	private Date createdOn;
	private String createdBy;
	
	private List<CrmauthRoleResource> roleResources;
	
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
	 * @return the roleName
	 */
	public String getRoleName() {
		return roleName;
	}
	/**
	 * @param roleName the roleName to set
	 */
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
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
	 * @return the roleResources
	 */
	public List<CrmauthRoleResource> getRoleResources() {
		return roleResources;
	}
	/**
	 * @param roleResources the roleResources to set
	 */
	public void setRoleResources(List<CrmauthRoleResource> roleResources) {
		this.roleResources = roleResources;
	}
	@Override
	public String toString() {
		return "CrmAuthRole [roleId=" + roleId + ", roleName=" + roleName + ", description=" + description
				+ ", createdOn=" + createdOn + ", createdBy=" + createdBy + "]";
	}
	

}

