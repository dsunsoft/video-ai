package com.dsunsoft.module.admin.service.sys;

import java.util.List;

import com.dsunsoft.common.entity.ng.NgSelect;
import com.dsunsoft.common.exception.BizException;
import com.dsunsoft.core.service.BaseService;
import com.dsunsoft.module.admin.entity.sys.SysRole;
import com.dsunsoft.module.admin.entity.sys.SysUser;

public interface SysUserService extends BaseService<SysUser, String> {

	SysUser getUserMenu(String userId);

	SysUser getByName(String userName);

	Boolean updateRole(SysUser arg0);

	SysUser loadRoles(SysUser sysUser);

	List<SysRole> getRoleByUserId(String id);

	Boolean checkLoginName(String oldLoginName, String loginName);

	Boolean save(SysUser sysUser) throws BizException;

	String entryptPassword(String plainPassword);

	boolean validatePassword(String plainPassword, String password);

	List<NgSelect> getSelectByNonAdmin();
}
