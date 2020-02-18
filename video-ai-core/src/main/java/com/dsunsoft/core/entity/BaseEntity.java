package com.dsunsoft.core.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * BaseEntity
 * 
 * @author ygm
 *
 */
public abstract class BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	/**
	 * 删除标记（0：正常；1：删除；2：审核；）
	 */
	public static final String DEL_FLAG_NORMAL = "0";
	public static final String DEL_FLAG_DELETE = "1";
	public static final String DEL_FLAG_AUDIT = "2";

	protected String remarks; // 备注
	protected String createBy; // 创建者
	protected Date createDate; // 创建日期
	protected String updateBy; // 更新者
	protected Date updateDate; // 更新日期
	protected String delFlag; // 删除标记（0：正常；1：删除；2：审核）

	public BaseEntity() {
		this.delFlag = DEL_FLAG_NORMAL;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getUpdateBy() {
		return updateBy;
	}

	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public String getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(String delFlag) {
		this.delFlag = delFlag;
	}
}