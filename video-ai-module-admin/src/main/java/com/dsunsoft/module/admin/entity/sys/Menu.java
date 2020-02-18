package com.dsunsoft.module.admin.entity.sys;

import com.dsunsoft.core.entity.BaseEntity;

public class Menu extends BaseEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7589806606467835284L;

	/**
	 * 菜单ID
	 */
	private String menuId;

	/**
	 * 菜单名称
	 */
	private String menuName;

	/**
	 * 菜单链接地址
	 */
	private String path;

	/**
	 * 菜单父节点ID
	 */
	private String pid;

	/**
	 * 层级
	 */
	private String level;

	/***
	 * 图标
	 */
	private String icon;

	public String getMenuId() {
		return menuId;
	}

	public void setMenuId(String menuId) {
		this.menuId = menuId;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

}
