package com.dsunsoft.module.admin.dto;


import javax.validation.constraints.NotBlank;

import com.dsunsoft.core.entity.BaseEntity;

/**
 * 数据字典Entity
 * @author zd
 */
public class DictValueDto extends  BaseEntity {
	
	private static final long serialVersionUID = 1L;
	private String id;
	@NotBlank(message="标签名不能为空")
	private String label;		// 标签名
	@NotBlank(message="键值不能为空")
	private String value;		// 键值
	@NotBlank(message=" 排序不能为空")
	private String sort;		// 排序
	@NotBlank(message="主键 type 表 id不能为空")
	private String dictTypeId;//主键 type 表 id
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getSort() {
		return sort;
	}
	public void setSort(String sort) {
		this.sort = sort;
	}
	public String getDictTypeId() {
		return dictTypeId;
	}
	public void setDictTypeId(String dictTypeId) {
		this.dictTypeId = dictTypeId;
	}
	
	public DictValueDto(){
		
	}
	  
	public DictValueDto(String id){
		this.id = id;
	}
	
}