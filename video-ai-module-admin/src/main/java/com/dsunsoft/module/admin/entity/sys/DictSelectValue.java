package com.dsunsoft.module.admin.entity.sys;

import com.dsunsoft.core.entity.BaseEntity;

/**
 * 数据字典Entity
 * 
 * @author zd
 */
public class DictSelectValue extends BaseEntity {

	private static final long serialVersionUID = 1L;
	private String dictValueId;
	private String dictTypeId;
	private String label;
	private String value;
	private String sort;
	private String type;
	private String description;

	/**
	 * 获取 dictValueId
	 * 
	 * @return dictValueId dictValueId
	 */
	public String getDictValueId() {
		return dictValueId;
	}

	/**
	 * 设置 dictValueId
	 * 
	 * @param dictValueId
	 *            dictValueId
	 */
	public void setDictValueId(String dictValueId) {
		this.dictValueId = dictValueId;
	}

	/**
	 * 获取 dictTypeId
	 * 
	 * @return dictTypeId dictTypeId
	 */
	public String getDictTypeId() {
		return dictTypeId;
	}

	/**
	 * 设置 dictTypeId
	 * 
	 * @param dictTypeId
	 *            dictTypeId
	 */
	public void setDictTypeId(String dictTypeId) {
		this.dictTypeId = dictTypeId;
	}

	/**
	 * 获取 label
	 * 
	 * @return label label
	 */
	public String getLabel() {
		return label;
	}

	/**
	 * 设置 label
	 * 
	 * @param label
	 *            label
	 */
	public void setLabel(String label) {
		this.label = label;
	}

	/**
	 * 获取 value
	 * 
	 * @return value value
	 */
	public String getValue() {
		return value;
	}

	/**
	 * 设置 value
	 * 
	 * @param value
	 *            value
	 */
	public void setValue(String value) {
		this.value = value;
	}

	/**
	 * 获取 sort
	 * 
	 * @return sort sort
	 */
	public String getSort() {
		return sort;
	}

	/**
	 * 设置 sort
	 * 
	 * @param sort
	 *            sort
	 */
	public void setSort(String sort) {
		this.sort = sort;
	}

	/**
	 * 获取 type
	 * 
	 * @return type type
	 */
	public String getType() {
		return type;
	}

	/**
	 * 设置 type
	 * 
	 * @param type
	 *            type
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * 获取 description
	 * 
	 * @return description description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * 设置 description
	 * 
	 * @param description
	 *            description
	 */
	public void setDescription(String description) {
		this.description = description;
	}

}