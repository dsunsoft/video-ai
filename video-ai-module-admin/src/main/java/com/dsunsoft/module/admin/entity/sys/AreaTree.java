package com.dsunsoft.module.admin.entity.sys;

import java.util.ArrayList;

public class AreaTree {

	private String label;
	private Area data;
	private String expandedIcon;
	private String collapsedIcon;
	private Boolean expanded;
	private ArrayList<AreaTree> children = new ArrayList<AreaTree>();

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public Area getData() {
		return data;
	}

	public void setData(Area data) {
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

	public ArrayList<AreaTree> getChildren() {
		return children;
	}

	public void setChildren(ArrayList<AreaTree> children) {
		this.children = children;
	}

}
