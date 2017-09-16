/**
 *	Copyright (C) 2014-2015 hst Software. All rights reserved. 
 *
 *	Author: weiwzhou
 *
 *	CreatedAt: 2016年7月26日
 *  
 *	Description: ...
 */
package com.jianan.software.util;
public class Page {
	private int totalCount;
	private int totalPage;
	private int pageSize;
	private int currentPage;
	private int start;
	private boolean next;
	private boolean pre;
	
	public Page(int totalCount,int pageSize,int currentPage) {
		this.totalCount = totalCount;
		this.pageSize = pageSize;
		this.currentPage =  currentPage;
		totalPage = (totalCount-1) / pageSize+1;
		if(currentPage >= this.totalPage){
			this.currentPage = totalPage;
		}
		if(currentPage < this.totalPage) {
			next = true;
		}
		if (currentPage > 1) {
			pre = true;
		}
	}
	/**
	 * @return the next
	 */
	public boolean isNext() {
		return next;
	}
	
	public boolean getNext() {
		return next;
	}
	
	public boolean isLastPage(){
		if(currentPage == totalPage){
			return true;
		}
		return false;
	}

	/**
	 * @param next the next to set
	 */
	public void setNext(boolean next) {
		this.next = next;
	}

	/**
	 * @return the pre
	 */
	public boolean isPre() {
		return pre;
	}
	
	public boolean getPre() {
		return pre;
	}

	/**
	 * @param pre the pre to set
	 */
	public void setPre(boolean pre) {
		this.pre = pre;
	}

	public boolean hasNext() {
		if(currentPage>=this.totalPage) {
			return false;
		}
		return true;
	}
	
	public boolean hasPre() {
		if(currentPage <= 1) {
			currentPage = 1;
			return false;
		}
		return true;
	}

	/**
	 * @return the totalCount
	 */
	public int getTotalCount() {
		return totalCount;
	}

	/**
	 * @param totalCount the totalCount to set
	 */
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	/**
	 * @return the totalPage
	 */
	public int getTotalPage() {
		return totalPage;
	}

	/**
	 * @param totalPage the totalPage to set
	 */
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	/**
	 * @return the pageSize
	 */
	public int getPageSize() {
		return pageSize;
	}

	/**
	 * @param pageSize the pageSize to set
	 */
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	/**
	 * @return the currentPage
	 */
	public int getCurrentPage() {
		return currentPage;
	}

	/**
	 * @param currentPage the currentPage to set
	 */
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	/**
	 * @return the start
	 */
	public int getStart() {
		return (this.currentPage - 1) * this.pageSize;
	}

	/**
	 * @param start the start to set
	 */
	public void setStart(int start) {
		this.start = start;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Page [totalCount=" + totalCount + ", totalPage=" + totalPage + ", pageSize=" + pageSize
				+ ", currentPage=" + currentPage + ", start=" + start + "]";
	}
	
	

}
