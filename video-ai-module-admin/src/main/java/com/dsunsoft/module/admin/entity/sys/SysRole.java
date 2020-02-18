package com.dsunsoft.module.admin.entity.sys;

import java.util.List;

import com.dsunsoft.core.entity.BaseEntity;

public class SysRole extends BaseEntity {
	private static final long serialVersionUID = -2909828241438265314L;

	private String roleId;
	private String roleName;
	private String roleCode;
	private String roleDesc;
	private Integer roleType;
	private String menuIdString;
	private List<String> menuIds;

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getRoleCode() {
		return roleCode;
	}

	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}

	public String getRoleDesc() {
		return roleDesc;
	}

	public void setRoleDesc(String roleDesc) {
		this.roleDesc = roleDesc;
	}

	public Integer getRoleType() {
		return roleType;
	}

	public void setRoleType(Integer roleType) {
		this.roleType = roleType;
	}

	public String getMenuIdString() {
		return menuIdString;
	}

	public void setMenuIdString(String menuIdString) {
		this.menuIdString = menuIdString;
	}

	public List<String> getMenuIds() {
		return menuIds;
	}

	public void setMenuIds(List<String> menuIds) {
		this.menuIds = menuIds;
	}

}