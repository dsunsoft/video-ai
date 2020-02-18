package com.dsunsoft.module.admin.entity.sys;

import com.dsunsoft.core.entity.BaseEntity;

public class Area extends BaseEntity {
	private static final long serialVersionUID = 7154317854377132372L;
	private String id;
	private String parentId;// 父级编码
	private String parentName;// 父级名称
	private String parentIds; // 所有父级编码
	private String code; // 区域编码
	private String name; // 区域名称
	private Integer sort; // 排序
	private String type; // 区域类型（1：国家；2：省份、直辖市；3：地市；4：区县）
	private String typeName;
	
	

	/**
     * 获取 typeName
     * @return typeName typeName
     */
    public String getTypeName() {
        return typeName;
    }
    

    /**
     * 设置 typeName
     * @param typeName typeName 
     */
    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
    

    public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public String getParentIds() {
		return parentIds;
	}

	public void setParentIds(String parentIds) {
		this.parentIds = parentIds;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}


    /**
     * 获取 parentName
     * @return parentName parentName
     */
    public String getParentName() {
        return parentName;
    }


    /**
     * 设置 parentName
     * @param parentName parentName 
     */
    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

}
