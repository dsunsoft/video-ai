package com.dsunsoft.module.admin.dao.sys;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.dsunsoft.core.dao.BaseMapper;
import com.dsunsoft.module.admin.entity.sys.SysUserSeller;

public interface SysUserSellerMapper extends BaseMapper<SysUserSeller, Integer> {
	List<SysUserSeller> getAll();

	Integer checkByUserId(@Param(value = "userId") String userId,
			@Param(value = "sysUserSellerId") Integer sysUserSellerId);
}
