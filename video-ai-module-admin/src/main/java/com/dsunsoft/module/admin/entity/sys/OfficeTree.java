package com.dsunsoft.module.admin.entity.sys;

import java.util.ArrayList;

public class OfficeTree {

	private String label;
	private Office data;
	private String expandedIcon;
	private String collapsedIcon;
	private Boolean expanded;
	private ArrayList<OfficeTree> children = new ArrayList<OfficeTree>();

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public Office getData() {
		return data;
	}

	public void setData(Office data) {
		this.data = data;
	}

	public String getExpandedIcon() {
		return expandedIcon;
	}

	public void setExpandedIcon(String expandedIcon) {
		this.expandedIcon = expandedIcon;
	}

	public String getCollapsedIcon() {
		return collapsedIcon;
	}

	public void setCollapsedIcon(String collapsedIcon) {
		this.collapsedIcon = collapsedIcon;
	}

	public Boolean getExpanded() {
		return expanded;
	}

	public void setExpanded(Boolean expanded) {
		this.expanded = expanded;
	}

	public ArrayList<OfficeTree> getChildren() {
		return children;
	}

	public void setChildren(ArrayList<OfficeTree> children) {
		this.children = children;
	}

}
