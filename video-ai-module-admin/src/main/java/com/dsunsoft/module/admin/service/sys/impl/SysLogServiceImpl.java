package com.dsunsoft.module.admin.service.sys.impl;

import org.springframework.stereotype.Service;

import com.dsunsoft.core.service.BaseServiceImpl;
import com.dsunsoft.module.admin.dao.sys.SysLogMapper;
import com.dsunsoft.module.admin.entity.sys.SysLog;
import com.dsunsoft.module.admin.service.sys.SysLogService;

/**
 * 系统日志
 * 
 * @author ygm
 *
 */
@Service
public class SysLogServiceImpl extends BaseServiceImpl<SysLogMapper, SysLog, String>
implements  SysLogService{

	@Override
	public void empty() {
		mapper.empty();
	}


}
