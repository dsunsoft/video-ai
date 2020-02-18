package com.dsunsoft.module.admin.entity.sys;

import java.util.ArrayList;

/**
 * @author zb 构造页面左侧菜单数据基类
 */
public class MenuTree {
	// 菜单展示名称
	private String label;
	// 菜单ID
	private String menuId;
	// 字集个数
	private String badge;
	// 菜单样式
	private String badgeStyleClass;
	// 图标
	private String icon;
	// 链接地址
	private String[] routerLink;
	// 子菜单
	private ArrayList<MenuTree> items = new ArrayList<MenuTree>();

	/**
	 * 获取 label
	 * 
	 * @return label label
	 */
	public String getLabel() {
		return label;
	}

	/**
	 * 设置 label
	 * 
	 * @param label
	 *            label
	 */
	public void setLabel(String label) {
		this.label = label;
	}

	/**
	 * 获取 menuId
	 * 
	 * @return menuId menuId
	 */
	public String getMenuId() {
		return menuId;
	}

	/**
	 * 设置 menuId
	 * 
	 * @param menuId
	 *            menuId
	 */
	public void setMenuId(String menuId) {
		this.menuId = menuId;
	}

	/**
	 * 获取 badge
	 * 
	 * @return badge badge
	 */
	public String getBadge() {
		return badge == null ? (this.items.size() != 0 ? String.valueOf(this.items.size()) : badge) : badge;
	}

	/**
	 * 设置 badge
	 * 
	 * @param badge
	 *            badge
	 */
	public void setBadge(String badge) {
		this.badge = badge;
	}

	/**
	 * 获取 badgeStyleClass
	 * 
	 * @return badgeStyleClass badgeStyleClass
	 */
	public String getBadgeStyleClass() {
		return (this.items.size() == 0 ? null : badgeStyleClass);
	}

	/**
	 * 设置 badgeStyleClass
	 * 
	 * @param badgeStyleClass
	 *            badgeStyleClass
	 */
	public void setBadgeStyleClass(String badgeStyleClass) {
		this.badgeStyleClass = badgeStyleClass;
	}

	/**
	 * 获取 icon
	 * 
	 * @return icon icon
	 */
	public String getIcon() {
		return icon;
	}

	/**
	 * 设置 icon
	 * 
	 * @param icon
	 *            icon
	 */
	public void setIcon(String icon) {
		this.icon = icon;
	}

	/**
	 * 获取 routerLink
	 * 
	 * @return routerLink routerLink
	 */
	public String[] getRouterLink() {
		return (this.items.size() != 0 ? null : routerLink);
	}

	/**
	 * 设置 routerLink
	 * 
	 * @param routerLink
	 *            routerLink
	 */
	public void setRouterLink(String[] routerLink) {
		this.routerLink = routerLink;
	}

	/**
	 * 获取 items
	 * 
	 * @return items items
	 */
	public ArrayList<MenuTree> getItems() {
		return items.size() == 0 ? null : items;
	}

	/**
	 * 设置 items
	 * 
	 * @param items
	 *            items
	 */
	public void setItems(ArrayList<MenuTree> items) {
		this.items = items;
	}

}
