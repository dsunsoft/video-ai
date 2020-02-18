package com.dsunsoft.module.admin.entity.sys;

import com.dsunsoft.core.entity.BaseEntity;

public class SysUserRole extends BaseEntity {
	private static final long serialVersionUID = 4644449969655372128L;

	private String userRoleId;
	private String userId;
	private String roleId;

	public String getUserRoleId() {
		return userRoleId;
	}

	public void setUserRoleId(String userRoleId) {
		this.userRoleId = userRoleId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

}