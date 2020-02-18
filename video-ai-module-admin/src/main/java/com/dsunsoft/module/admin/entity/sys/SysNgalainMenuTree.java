package com.dsunsoft.module.admin.entity.sys;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * @author zb 构造ngalain页面左侧菜单数据基类
 */
public class SysNgalainMenuTree implements Serializable{
	private static final long serialVersionUID = -7492278107574417052L;
	// 菜单展示名称
	private String text;
	// 菜单ID
	private String menuId;
	// i18n
	private String i18n;
	// 字集个数
	private String badge;
	// 菜单样式
	private Boolean group;
	private Boolean hideInBreadcrumb;
	private Boolean shortcutRoot;
	// 图标
	private String icon;
	// 链接地址
	private String link;
	private String acl;
	// 子菜单
	private ArrayList<SysNgalainMenuTree> children = new ArrayList<SysNgalainMenuTree>();

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getMenuId() {
		return menuId;
	}

	public void setMenuId(String menuId) {
		this.menuId = menuId;
	}

	public String getI18n() {
		return i18n;
	}

	public void setI18n(String i18n) {
		this.i18n = i18n;
	}

	public String getBadge() {
		return badge;
	}

	public void setBadge(String badge) {
		this.badge = badge;
	}

	public Boolean getGroup() {
		return group;
	}

	public void setGroup(Boolean group) {
		this.group = group;
	}

	public Boolean getHideInBreadcrumb() {
		return hideInBreadcrumb;
	}

	public void setHideInBreadcrumb(Boolean hideInBreadcrumb) {
		this.hideInBreadcrumb = hideInBreadcrumb;
	}

	public Boolean getShortcutRoot() {
		return shortcutRoot;
	}

	public void setShortcutRoot(Boolean shortcutRoot) {
		this.shortcutRoot = shortcutRoot;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getAcl() {
		return acl;
	}

	public void setAcl(String acl) {
		this.acl = acl;
	}

	public ArrayList<SysNgalainMenuTree> getChildren() {
		return children;
	}

	public void setChildren(ArrayList<SysNgalainMenuTree> children) {
		this.children = children;
	}

}
