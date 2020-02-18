package com.dsunsoft.module.admin.dao.sys;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.dsunsoft.core.dao.BaseMapper;
import com.dsunsoft.module.admin.entity.sys.Menu;
import com.dsunsoft.module.admin.entity.sys.SysRole;
import com.dsunsoft.module.admin.entity.sys.SysRoleMenu;
 
public interface SysRoleMapper extends BaseMapper<SysRole, String> {

	void deleteRoleMenuByRoleId(String roleId);

	void insertRoleMenu(SysRoleMenu sysRoleMenu);

	List<Menu> getMenuByRoleId(@Param(value = "ids") List<String> ids);
	
	List<String> selectMenuByRoleId(String roleId);

	List<SysRole> selectRoleList(String userId);

}