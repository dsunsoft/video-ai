package com.dsunsoft.module.admin.entity.sys;

import com.dsunsoft.core.entity.BaseEntity;

/**
 * 数据字典Entity
 * 
 * @author zd
 */
public class DictValue extends BaseEntity {

	private static final long serialVersionUID = 1L;
	private String id;
	private String label; // 标签名
	private String value; // 键值
	private String sort; // 排序
	private String dictTypeId;// 主键 type 表 id

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

	public DictValue() {

	}

	public DictValue(String id) {
		this.id = id;
	}

}