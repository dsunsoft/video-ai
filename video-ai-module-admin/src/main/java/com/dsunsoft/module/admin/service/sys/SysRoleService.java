package com.dsunsoft.module.admin.service.sys;

import com.dsunsoft.common.exception.BizException;
import com.dsunsoft.core.service.BaseService;
import com.dsunsoft.module.admin.entity.sys.SysRole;

public interface SysRoleService extends BaseService<SysRole, String> {
 
	Boolean delete(SysRole sysRole) throws BizException;

	Boolean roleMenu(SysRole sysRole);
	
}
