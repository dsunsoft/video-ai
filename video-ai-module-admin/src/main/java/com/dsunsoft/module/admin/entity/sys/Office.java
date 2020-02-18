package com.dsunsoft.module.admin.entity.sys;

import java.util.List;

import com.dsunsoft.core.entity.BaseEntity;

public class Office extends BaseEntity {
	private static final long serialVersionUID = 7154317854377132372L;
	private String id;     // 主键
	private String parentId;     // 上级机构ID
	private String parentIds;     // 所有机构ID
	private String name;     // 机构名称
	private Integer sort;		// 排序
	private String areaId;     // 归属区域
    private String code;    // 机构编码
    private String type;    // 机构类型（1：公司；2：部门；3：小组）
    private String grade;   // 机构等级（1：一级；2：二级；3：三级；4：四级）
    private String address; // 联系地址
    private String zipCode; // 邮政编码
    private String master;  // 负责人
    private String phone;   // 电话
    private String fax;     // 传真
    private String email;   // 邮箱
    private String useable;//是否可用
    private String primaryPerson;//主负责人
    private String deputyPerson;//副负责人
    private List<String> childDeptList;//快速添加子部门
    
    private String parentName;
    private String areaName;
    private String areaParentIds;
    private String primaryPersonName;
    private String deputyPersonName;
    private String typeLabel;
    private String gradeLabel;
    
    
    
    

    /**
     * 获取 typeLabel
     * @return typeLabel typeLabel
     */
    public String getTypeLabel() {
        return typeLabel;
    }
    



    /**
     * 设置 typeLabel
     * @param typeLabel typeLabel 
     */
    public void setTypeLabel(String typeLabel) {
        this.typeLabel = typeLabel;
    }
    



    /**
     * 获取 gradeLabel
     * @return gradeLabel gradeLabel
     */
    public String getGradeLabel() {
        return gradeLabel;
    }
    



    /**
     * 设置 gradeLabel
     * @param gradeLabel gradeLabel 
     */
    public void setGradeLabel(String gradeLabel) {
        this.gradeLabel = gradeLabel;
    }
    



    /**
     * 获取 areaName
     * @return areaName areaName
     */
    public String getAreaName() {
        return areaName;
    }
    


    /**
     * 设置 areaName
     * @param areaName areaName 
     */
    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }
    


    /**
     * 获取 areaParentIds
     * @return areaParentIds areaParentIds
     */
    public String getAreaParentIds() {
        return areaParentIds;
    }
    


    /**
     * 设置 areaParentIds
     * @param areaParentIds areaParentIds 
     */
    public void setAreaParentIds(String areaParentIds) {
        this.areaParentIds = areaParentIds;
    }
    


    /**
     * 获取 primaryPersonName
     * @return primaryPersonName primaryPersonName
     */
    public String getPrimaryPersonName() {
        return primaryPersonName;
    }
    


    /**
     * 设置 primaryPersonName
     * @param primaryPersonName primaryPersonName 
     */
    public void setPrimaryPersonName(String primaryPersonName) {
        this.primaryPersonName = primaryPersonName;
    }
    


    /**
     * 获取 deputyPersonName
     * @return deputyPersonName deputyPersonName
     */
    public String getDeputyPersonName() {
        return deputyPersonName;
    }
    


    /**
     * 设置 deputyPersonName
     * @param deputyPersonName deputyPersonName 
     */
    public void setDeputyPersonName(String deputyPersonName) {
        this.deputyPersonName = deputyPersonName;
    }
    


    /**
     * 获取 id
     * @return id id
     */
    public String getId() {
        return id;
    }
    

    /**
     * 设置 id
     * @param id id 
     */
    public void setId(String id) {
        this.id = id;
    }
    

    /**
     * 获取 areaId
     * @return areaId areaId
     */
    public String getAreaId() {
        return areaId;
    }
    

    /**
     * 设置 areaId
     * @param areaId areaId 
     */
    public void setAreaId(String areaId) {
        this.areaId = areaId;
    }
    

    /**
     * 获取 code
     * @return code code
     */
    public String getCode() {
        return code;
    }
    

    /**
     * 设置 code
     * @param code code 
     */
    public void setCode(String code) {
        this.code = code;
    }
    

    /**
     * 获取 type
     * @return type type
     */
    public String getType() {
        return type;
    }
    

    /**
     * 设置 type
     * @param type type 
     */
    public void setType(String type) {
        this.type = type;
    }
    

    /**
     * 获取 grade
     * @return grade grade
     */
    public String getGrade() {
        return grade;
    }
    

    /**
     * 设置 grade
     * @param grade grade 
     */
    public void setGrade(String grade) {
        this.grade = grade;
    }
    

    /**
     * 获取 address
     * @return address address
     */
    public String getAddress() {
        return address;
    }
    

    /**
     * 设置 address
     * @param address address 
     */
    public void setAddress(String address) {
        this.address = address;
    }
    

    /**
     * 获取 zipCode
     * @return zipCode zipCode
     */
    public String getZipCode() {
        return zipCode;
    }
    

    /**
     * 设置 zipCode
     * @param zipCode zipCode 
     */
    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }
    

    /**
     * 获取 master
     * @return master master
     */
    public String getMaster() {
        return master;
    }
    

    /**
     * 设置 master
     * @param master master 
     */
    public void setMaster(String master) {
        this.master = master;
    }
    

    /**
     * 获取 phone
     * @return phone phone
     */
    public String getPhone() {
        return phone;
    }
    

    /**
     * 设置 phone
     * @param phone phone 
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }
    

    /**
     * 获取 fax
     * @return fax fax
     */
    public String getFax() {
        return fax;
    }
    

    /**
     * 设置 fax
     * @param fax fax 
     */
    public void setFax(String fax) {
        this.fax = fax;
    }
    

    /**
     * 获取 email
     * @return email email
     */
    public String getEmail() {
        return email;
    }
    

    /**
     * 设置 email
     * @param email email 
     */
    public void setEmail(String email) {
        this.email = email;
    }
    

    /**
     * 获取 useable
     * @return useable useable
     */
    public String getUseable() {
        return useable;
    }
    

    /**
     * 设置 useable
     * @param useable useable 
     */
    public void setUseable(String useable) {
        this.useable = useable;
    }
    

    /**
     * 获取 primaryPerson
     * @return primaryPerson primaryPerson
     */
    public String getPrimaryPerson() {
        return primaryPerson;
    }
    

    /**
     * 设置 primaryPerson
     * @param primaryPerson primaryPerson 
     */
    public void setPrimaryPerson(String primaryPerson) {
        this.primaryPerson = primaryPerson;
    }
    

    /**
     * 获取 deputyPerson
     * @return deputyPerson deputyPerson
     */
    public String getDeputyPerson() {
        return deputyPerson;
    }
    

    /**
     * 设置 deputyPerson
     * @param deputyPerson deputyPerson 
     */
    public void setDeputyPerson(String deputyPerson) {
        this.deputyPerson = deputyPerson;
    }
    

    /**
     * 获取 childDeptList
     * @return childDeptList childDeptList
     */
    public List<String> getChildDeptList() {
        return childDeptList;
    }
    

    /**
     * 设置 childDeptList
     * @param childDeptList childDeptList 
     */
    public void setChildDeptList(List<String> childDeptList) {
        this.childDeptList = childDeptList;
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


    /**
     * 获取 name
     * @return name name
     */
    public String getName() {
        return name;
    }


    /**
     * 设置 name
     * @param name name 
     */
    public void setName(String name) {
        this.name = name;
    }


    /**
     * 获取 parentId
     * @return parentId parentId
     */
    public String getParentId() {
        return parentId;
    }


    /**
     * 设置 parentId
     * @param parentId parentId 
     */
    public void setParentId(String parentId) {
        this.parentId = parentId;
    }


    /**
     * 获取 parentIds
     * @return parentIds parentIds
     */
    public String getParentIds() {
        return parentIds;
    }


    /**
     * 设置 parentIds
     * @param parentIds parentIds 
     */
    public void setParentIds(String parentIds) {
        this.parentIds = parentIds;
    }




	/**
	 * @return the sort
	 */
	public Integer getSort() {
		return sort;
	}




	/**
	 * @param sort the sort to set
	 */
	public void setSort(Integer sort) {
		this.sort = sort;
	}
    
    
    

}
