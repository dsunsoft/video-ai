package com.dsunsoft.module.admin.dao.sys;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.dsunsoft.common.entity.ng.NgSelect;
import com.dsunsoft.core.dao.BaseMapper;
import com.dsunsoft.module.admin.entity.sys.Menu;
import com.dsunsoft.module.admin.entity.sys.SysRole;
import com.dsunsoft.module.admin.entity.sys.SysUser;

public interface SysUserMapper extends BaseMapper<SysUser, String> {

	SysUser getByName(@Param(value = "userName") String userName);

	List<SysUser> selectRoleByUserId(List<String> userIds);

	List<String> selectUserRole(SysUser sysUser);

	Integer insertUserRole(SysUser arg0);

	Integer deleteUserRole(SysUser arg0);

	Integer selectUserNameCount(SysUser arg0);

	List<Menu> selectMenuByRoleId(String roleId);

	List<SysRole> getRoleByUserId(String userId);
	
	List<NgSelect> getSelectByNonAdmin();
}
