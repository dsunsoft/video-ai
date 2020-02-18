package com.dsunsoft.core.entity;

import java.io.Serializable;

/**
 * 描述:树节点的值对象，除了主键ID以外可能会传一些别的内容过去
 * 
 * @version:1.0.0
 * @创建时间: 2017-05-29 08:43:21
 */
public class TreeValue {

	/**
	 * 树上的主键值
	 */
	private String value;

	private String name;

	/**
	 * 行政区划编码全路径
	 */
	private String addvcdPath;

	/**
	 * 行政区划名称全路径
	 */
	private String addvnmPath;

	/**
	 * 组织机构ID全路径
	 */
	private String orgIdPath;

	/**
	 * 菜单ID全路径
	 */
	private String menuIdPath;

	private Integer level;

	/**
	 * 需要额外传递的别的对象，必须实现Serializable接口
	 */
	private Serializable tag;

	public TreeValue(String value) {
		this.value = value;
	}

	public TreeValue() {
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddvcdPath() {
		return addvcdPath;
	}

	public void setAddvcdPath(String addvcdPath) {
		this.addvcdPath = addvcdPath;
	}

	public String getAddvnmPath() {
		return addvnmPath;
	}

	public void setAddvnmPath(String addvnmPath) {
		this.addvnmPath = addvnmPath;
	}

	public String getOrgIdPath() {
		return orgIdPath;
	}

	public void setOrgIdPath(String orgIdPath) {
		this.orgIdPath = orgIdPath;
	}

	public String getMenuIdPath() {
		return menuIdPath;
	}

	public void setMenuIdPath(String menuIdPath) {
		this.menuIdPath = menuIdPath;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public Serializable getTag() {
		return tag;
	}

	public void setTag(Serializable tag) {
		this.tag = tag;
	}

}
