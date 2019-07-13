package com.dilip.security.entity;

public class SearchInputRequest {

	private int searchId;
	private String searchType;
	private PageInfo pageInfo;

	public int getSearchId() {
		return searchId;
	}

	public void setSearchId(int searchId) {
		this.searchId = searchId;
	}

	public String getSearchType() {
		return searchType;
	}

	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}

	public PageInfo getPageInfo() {
		return pageInfo;
	}

	public void setPageInfo(PageInfo pageInfo) {
		this.pageInfo = pageInfo;
	}

}
