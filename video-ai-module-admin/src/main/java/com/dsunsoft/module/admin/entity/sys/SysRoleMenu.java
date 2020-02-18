package com.dsunsoft.module.admin.entity.sys;

import java.util.List;

import com.dsunsoft.core.entity.BaseEntity;

public class SysRoleMenu extends BaseEntity {
	private static final long serialVersionUID = -5553604975807430699L;
	private String id;
	private String roleId;
	private String menuId;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getMenuId() {
		return menuId;
	}

	public void setMenuId(String menuId) {
		this.menuId = menuId;
	}

}
