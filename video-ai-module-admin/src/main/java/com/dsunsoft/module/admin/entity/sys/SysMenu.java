package com.dsunsoft.module.admin.entity.sys;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.dsunsoft.core.entity.BaseEntity;

public class SysMenu extends BaseEntity {
	private static final long serialVersionUID = -7458741729997895358L;

	private String menuId;
	private String menuName;
	private String pid;
	private BigDecimal orderIndex;
	private String icon;
	private String path;
	private Short level;
	private String idPath;
	private String pname;

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

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public BigDecimal getOrderIndex() {
		return orderIndex;
	}

	public void setOrderIndex(BigDecimal orderIndex) {
		this.orderIndex = orderIndex;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public Short getLevel() {
		return level;
	}

	public void setLevel(Short level) {
		this.level = level;
	}

	public String getIdPath() {
		return idPath;
	}

	public void setIdPath(String idPath) {
		this.idPath = idPath;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

}