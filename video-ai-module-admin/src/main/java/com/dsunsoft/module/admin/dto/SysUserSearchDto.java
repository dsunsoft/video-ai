package com.dsunsoft.module.admin.dto;

import com.dsunsoft.core.entity.BaseSearchDto;
import com.dsunsoft.module.admin.entity.sys.Office;
import com.dsunsoft.module.admin.entity.sys.SysRole;
import com.dsunsoft.module.admin.entity.sys.SysUser;

public class SysUserSearchDto extends BaseSearchDto {
	private static final long serialVersionUID = -4023497677268004323L;

	private SysRole role;
	
	private SysUser currentUser;
	
	private Office company; // 归属公司
	
	private Office office;// 部门
	
	private String loginName;// 登录名
	
    private String name; // 姓名 

    /**
     * 获取 role
     * @return role role
     */
    public SysRole getRole() {
        return role;
    }
    

    /**
     * 设置 role
     * @param role role 
     */
    public void setRole(SysRole role) {
        this.role = role;
    }
    

    /**
     * 获取 currentUser
     * @return currentUser currentUser
     */
    public SysUser getCurrentUser() {
        return currentUser;
    }
    

    /**
     * 设置 currentUser
     * @param currentUser currentUser 
     */
    public void setCurrentUser(SysUser currentUser) {
        this.currentUser = currentUser;
    }
    

    /**
     * 获取 company
     * @return company company
     */
    public Office getCompany() {
        return company;
    }
    

    /**
     * 设置 company
     * @param company company 
     */
    public void setCompany(Office company) {
        this.company = company;
    }
    

    /**
     * 获取 office
     * @return office office
     */
    public Office getOffice() {
        return office;
    }
    

    /**
     * 设置 office
     * @param office office 
     */
    public void setOffice(Office office) {
        this.office = office;
    }
    

    /**
     * 获取 loginName
     * @return loginName loginName
     */
    public String getLoginName() {
        return loginName;
    }
    

    /**
     * 设置 loginName
     * @param loginName loginName 
     */
    public void setLoginName(String loginName) {
        this.loginName = loginName;
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
    
    
    
}
