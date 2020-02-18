package com.dsunsoft.module.admin.entity.sys;

import java.util.ArrayList;

public class SysMenuTree {

	private String label;
	private SysMenu data;
	private String expandedIcon;
	private String collapsedIcon;
	private Boolean expanded;
	private ArrayList<SysMenuTree> children = new ArrayList<SysMenuTree>();

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public SysMenu getData() {
		return data;
	}

	public void setData(SysMenu data) {
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

	public ArrayList<SysMenuTree> getChildren() {
		return children;
	}

	public void setChildren(ArrayList<SysMenuTree> children) {
		this.children = children;
	}

}
