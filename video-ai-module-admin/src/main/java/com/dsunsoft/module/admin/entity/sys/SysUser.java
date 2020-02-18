package com.dsunsoft.module.admin.entity.sys;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.dsunsoft.core.entity.BaseEntity;
import com.dsunsoft.core.entity.Tree;
import com.google.common.collect.Lists;

public class SysUser extends BaseEntity {
	private static final long serialVersionUID = 1857110856363919623L;
	private String id;
	private String loginName;// 登录名
	private String password;// 密码
	private String no; // 工号
	private String name; // 姓名
	private String email; // 邮箱
	private String phone; // 电话
	private String mobile; // 手机
	private String loginIp; // 最后登陆IP
	private Date loginDate; // 最后登陆日期
	private String loginFlag; // 是否允许登陆
	private String photo; // 头像
	private String qrCode; // 二维码
	private String oldLoginName;// 原登录名
	private String newPassword; // 新密码
	private String sign;// 签名
	private String oldLoginIp; // 上次登陆IP
	private Date oldLoginDate; // 上次登陆日期

	private String roleIdStrings;
	private String roleNames;
	private String roleName;
	
    private Office company; // 归属公司
    private Office office;  // 归属部门
    
    private List<SysUserRole> roleList = Lists.newArrayList(); // 拥有角色列表

	/**
	 * 菜单列表
	 */
	private List<Tree> menuList = new ArrayList<Tree>();

	/**
	 * 菜单列表
	 */
	private List<SysNgalainMenuTree> menuTreeList = new ArrayList<SysNgalainMenuTree>();

	/**
	 * 所有菜单集合
	 */
	private List<Menu> allMenuList = new ArrayList<Menu>();

	/**
	 * 角色ID
	 */
	private List<String> roleIds = new ArrayList<String>();

	/**
	 * 所有角色
	 */
	private List<SysRole> roles = new ArrayList<SysRole>();

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getLoginIp() {
		return loginIp;
	}

	public void setLoginIp(String loginIp) {
		this.loginIp = loginIp;
	}

	public Date getLoginDate() {
		return loginDate;
	}

	public void setLoginDate(Date loginDate) {
		this.loginDate = loginDate;
	}

	public String getLoginFlag() {
		return loginFlag;
	}

	public void setLoginFlag(String loginFlag) {
		this.loginFlag = loginFlag;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getQrCode() {
		return qrCode;
	}

	public void setQrCode(String qrCode) {
		this.qrCode = qrCode;
	}

	public String getOldLoginName() {
		return oldLoginName;
	}

	public void setOldLoginName(String oldLoginName) {
		this.oldLoginName = oldLoginName;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	public String getOldLoginIp() {
		return oldLoginIp;
	}

	public void setOldLoginIp(String oldLoginIp) {
		this.oldLoginIp = oldLoginIp;
	}

	public Date getOldLoginDate() {
		return oldLoginDate;
	}

	public void setOldLoginDate(Date oldLoginDate) {
		this.oldLoginDate = oldLoginDate;
	}


	public List<Tree> getMenuList() {
		return menuList;
	}

	public void setMenuList(List<Tree> menuList) {
		this.menuList = menuList;
	}

	public List<SysNgalainMenuTree> getMenuTreeList() {
		return menuTreeList;
	}

	public void setMenuTreeList(List<SysNgalainMenuTree> menuTreeList) {
		this.menuTreeList = menuTreeList;
	}

	public List<Menu> getAllMenuList() {
		return allMenuList;
	}

	public void setAllMenuList(List<Menu> allMenuList) {
		this.allMenuList = allMenuList;
	}

	public List<SysRole> getRoles() {
		return roles;
	}

	public void setRoles(List<SysRole> roles) {
		this.roles = roles;
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
     * 获取 roleIdStrings
     * @return roleIdStrings roleIdStrings
     */
    public String getRoleIdStrings() {
        return roleIdStrings;
    }

    /**
     * 设置 roleIdStrings
     * @param roleIdStrings roleIdStrings 
     */
    public void setRoleIdStrings(String roleIdStrings) {
        this.roleIdStrings = roleIdStrings;
    }

    /**
     * 获取 roleNames
     * @return roleNames roleNames
     */
    public String getRoleNames() {
        return roleNames;
    }

    /**
     * 设置 roleNames
     * @param roleNames roleNames 
     */
    public void setRoleNames(String roleNames) {
        this.roleNames = roleNames;
    }

    /**
     * 获取 roleName
     * @return roleName roleName
     */
    public String getRoleName() {
        return roleName;
    }

    /**
     * 设置 roleName
     * @param roleName roleName 
     */
    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    /**
     * 获取 roleIds
     * @return roleIds roleIds
     */
    public List<String> getRoleIds() {
        return roleIds;
    }

    /**
     * 设置 roleIds
     * @param roleIds roleIds 
     */
    public void setRoleIds(List<String> roleIds) {
        this.roleIds = roleIds;
    }

    /**
     * 获取 roleList
     * @return roleList roleList
     */
    public List<SysUserRole> getRoleList() {
        return roleList;
    }

    /**
     * 设置 roleList
     * @param roleList roleList 
     */
    public void setRoleList(List<SysUserRole> roleList) {
        this.roleList = roleList;
    }


}
