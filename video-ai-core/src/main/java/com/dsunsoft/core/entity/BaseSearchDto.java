package com.dsunsoft.core.entity;

import java.io.Serializable;
import java.util.Date;

import com.dsunsoft.common.constant.WebConstants;

import io.swagger.annotations.ApiModelProperty;

/**
 * BaseSearchDto
 * 
 * @author ygm
 *
 */
public class BaseSearchDto implements Serializable {
	private static final long serialVersionUID = 45524537532074116L;
	/**
	 * 删除标记（0：正常；1：删除；2：审核；）
	 */
	public static final String DEL_FLAG_NORMAL = "0";
	public static final String DEL_FLAG_DELETE = "1";
	public static final String DEL_FLAG_AUDIT = "2";

	@ApiModelProperty(value = "分页页数", required = true)
	protected Integer pageIndex;
	@ApiModelProperty(value = "分页大小", required = true)
	protected Integer pageSize;
	@ApiModelProperty(value = "排序字段")
	protected String orderBy;
	@ApiModelProperty(value = "删除标记")
	protected String delFlag; // （0：正常；1：删除；2：审核）

	public BaseSearchDto() {
		// this.delFlag = DEL_FLAG_NORMAL; 2019-09-17 注释
		this.pageIndex = WebConstants.PAGE_INDEX;
		this.pageSize = WebConstants.PAGE_SIZE;
	}

	public Integer getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(Integer pageIndex) {
		this.pageIndex = pageIndex;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public String getOrderBy() {
		return orderBy;
	}

	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}

	public String getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(String delFlag) {
		this.delFlag = delFlag;
	}

}
