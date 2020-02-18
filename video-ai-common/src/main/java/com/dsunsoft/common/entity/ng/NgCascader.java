package com.dsunsoft.common.entity.ng;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * ng-alain级联选择实体
 * 
 * @author ygm
 *
 */
public class NgCascader implements Serializable {
	private static final long serialVersionUID = 6477385711684918060L;

	/**
	 * label
	 */
	private String label;
	/**
	 * value
	 */
	private String value;
	/**
	 * 是否最后一个节点
	 */
	private Boolean isLeaf;
	/**
	 * 子节点
	 */
	private List<NgCascader> children = new ArrayList<NgCascader>();

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

	public Boolean getIsLeaf() {
		return isLeaf;
	}

	public void setIsLeaf(Boolean isLeaf) {
		this.isLeaf = isLeaf;
	}

	public List<NgCascader> getChildren() {
		return children;
	}

	public void setChildren(List<NgCascader> children) {
		this.children = children;
	}

}
