package com.dsunsoft.core.entity;

import java.util.ArrayList;

/**
 * 描述：树节点的数据类型 树的属性基本类
 */
public class Tree {

	/**
	 * 标签，显示在树上的名
	 */
	private String label;

	/**
	 * 数值，一般存主键
	 */
	private TreeValue data;

	/**
	 * 扩展图标
	 */
	private String expandedIcon;

	/***
	 * 收缩图标
	 */
	private String collapsedIcon;

	/**
	 * 展开属性，true :扩开；false :不展开
	 */
	private Boolean expanded;

	/**
	 * 子节点
	 */
	private ArrayList<Tree> children = new ArrayList<Tree>();

	/**
	 * 标签，显示在树上的名
	 * 
	 * @return label 标签，显示在树上的名
	 */
	public String getLabel() {
		return label;
	}

	/**
	 * 标签，显示在树上的名
	 * 
	 * @param label
	 *            标签，显示在树上的名
	 */
	public void setLabel(String label) {
		this.label = label;
	}

	/**
	 * 数值，一般存主键
	 * 
	 * @return data 数值，一般存主键
	 */
	public TreeValue getData() {
		return data;
	}

	/**
	 * 数值，一般存主键
	 * 
	 * @param data
	 *            数值，一般存主键
	 */
	public void setData(TreeValue data) {
		this.data = data;
	}

	/**
	 * @return the expandedIcon
	 */
	public String getExpandedIcon() {
		return expandedIcon;
	}

	/**
	 * @param expandedIcon
	 *            the expandedIcon to set
	 */
	public void setExpandedIcon(String expandedIcon) {
		this.expandedIcon = expandedIcon;
	}

	/**
	 * @return the collapsedIcon
	 */
	public String getCollapsedIcon() {
		return collapsedIcon;
	}

	/**
	 * @param collapsedIcon
	 *            the collapsedIcon to set
	 */
	public void setCollapsedIcon(String collapsedIcon) {
		this.collapsedIcon = collapsedIcon;
	}

	/**
	 * @return the children
	 */
	public ArrayList<Tree> getChildren() {
		return children;
	}

	/**
	 * @param children
	 *            the children to set
	 */
	public void setChildren(ArrayList<Tree> children) {
		this.children = children;
	}

	public Boolean getExpanded() {
		return expanded;
	}

	public void setExpanded(Boolean expanded) {
		this.expanded = expanded;
	}

}
