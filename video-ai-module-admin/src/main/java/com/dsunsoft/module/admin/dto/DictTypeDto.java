package com.dsunsoft.module.admin.dto;

import javax.validation.constraints.NotBlank;

import com.dsunsoft.core.entity.BaseEntity;

/**
 * 数据字典Entity
 * @author zd
 */
public class DictTypeDto extends  BaseEntity {
	private static final long serialVersionUID = 1L;
	private String id;
	@NotBlank(message="字典类型不能为空")
	private String type;		// 类型
	@NotBlank(message="字典描述不能为空")
	private String description;		// 描述
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

}