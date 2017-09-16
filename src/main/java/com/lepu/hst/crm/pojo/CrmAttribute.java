/**
 *	Copyright (C) 2014-2015 hst Software. All rights reserved. 
 *
 *	Author: sunny
 *
 *	CreatedAt: 2016年7月28日
 *  
 *	Description: ...
 */
package com.lepu.hst.crm.pojo;

import java.util.Date;

public class CrmAttribute { 
	public static final int TYPE_BASE = 1;	//基本属性
	public static final int TYPE_SHOP = 2;	//购物属性
	public static final int TYPE_RFM = 3;	//RFM属性
	public static final int TYPE_BEHAVIOR = 4;	//行为属性
	
	public static final int INPUT_TYPE_STRING = 1;	//查询条件是字符串
	public static final int INPUT_TYPE_SELECT = 2;	//多选值：如手机号段 移动3G  联通3G  电信3G
	public static final int INPUT_TYPE_TIME = 3;		//时间：付款时间在 2016-06-10 10:12:12~2016-06-12 10:12:12
	public static final int INPUT_TYPE_NUMBER = 4;	//数值：购买数量在 1~10
	public static final int INPUT_TYPE_SPECIAL = 5;	//特殊处理
	public static final int INPUT_TYPE_TIME_GOODS = 6;	//时段内购买某个商品
	public static final int INPUT_TYPE_TIME_PAYTIMES = 7;	//时段内付款次数
	
	private int attributeId;
	private String attributName;
	private int attributType;
	private String query;
	private int inputType;
	private String attrValue;
	private int status;
	private boolean isSupportFuzzySearch;
	private String description;
	private int sortValue;
	private String createdBy;
	private Date createdOn;
	private String inputHtml;
	private String conditionName;
	private String userName;
	private String searchColumnName;
	
	/** 
	 * @return the attributeId
	 */
	public int getAttributeId() {
		return attributeId;
	}
	/**
	 * @param attributeId the attributeId to set
	 */
	public void setAttributeId(int attributeId) {
		this.attributeId = attributeId;
	}
	/**
	 * @return the attributName
	 */
	public String getAttributName() {
		return attributName;
	}
	/**
	 * @param attributName the attributName to set
	 */
	public void setAttributName(String attributName) {
		this.attributName = attributName;
	}
	/**
	 * @return the attributType
	 */
	public int getAttributType() {
		return attributType;
	}
	/**
	 * @param attributType the attributType to set
	 */
	public void setAttributType(int attributType) {
		this.attributType = attributType;
	}
	/**
	 * @return the query
	 */
	public String getQuery() {
		return query;
	}
	/**
	 * @param query the query to set
	 */
	public void setQuery(String query) {
		this.query = query;
	}
	/**
	 * @return the inputType
	 */
	public int getInputType() {
		return inputType;
	}
	/**
	 * @param inputType the inputType to set
	 */
	public void setInputType(int inputType) {
		this.inputType = inputType;
	}
	/**
	 * @return the attrValue
	 */
	public String getAttrValue() {
		return attrValue;
	}
	/**
	 * @param attrValue the attrValue to set
	 */
	public void setAttrValue(String attrValue) {
		this.attrValue = attrValue;
	}
	/**
	 * @return the status
	 */
	public int getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(int status) {
		this.status = status;
	}
	/**
	 * @return the isSupportFuzzySearch
	 */
	public boolean isSupportFuzzySearch() {
		return isSupportFuzzySearch;
	}
	
	public boolean getIsSupportFuzzySearch() {
		return isSupportFuzzySearch;
	}
	
	/**
	 * @param isSupportFuzzySearch the isSupportFuzzySearch to set
	 */
	public void setSupportFuzzySearch(boolean isSupportFuzzySearch) {
		this.isSupportFuzzySearch = isSupportFuzzySearch;
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
	 * @return the inputHtml
	 */
	public String getInputHtml() {
		return inputHtml;
	}
	/**
	 * @param inputHtml the inputHtml to set
	 */
	public void setInputHtml(String inputHtml) {
		this.inputHtml = inputHtml;
	}
	/**
	 * @return the conditionName
	 */
	public String getConditionName() {
		return conditionName;
	}
	/**
	 * @param conditionName the conditionName to set
	 */
	public void setConditionName(String conditionName) {
		this.conditionName = conditionName;
	}
	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	/**
	 * @return the searchColumnName
	 */
	public String getSearchColumnName() {
		return searchColumnName;
	}
	/**
	 * @param searchColumnName the searchColumnName to set
	 */
	public void setSearchColumnName(String searchColumnName) {
		this.searchColumnName = searchColumnName;
	}
}
