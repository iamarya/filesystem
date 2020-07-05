package com.arya.filesystem.model;

import java.util.List;

import javax.validation.constraints.NotEmpty;

public class SearchModel {
	@NotEmpty(message = "Search string can not be empty!")
	private String searchString;
	private List<String> result;

	public String getSearchString() {
		return searchString;
	}

	public void setSearchString(String searchString) {
		this.searchString = searchString;
	}

	public List<String> getResult() {
		return result;
	}

	public void setResult(List<String> result) {
		this.result = result;
	}


}
