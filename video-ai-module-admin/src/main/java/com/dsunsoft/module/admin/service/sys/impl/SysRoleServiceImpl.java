package com.dsunsoft.module.admin.service.sys.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dsunsoft.common.constant.WebConstants;
import com.dsunsoft.common.exception.BizException;
import com.dsunsoft.core.service.BaseServiceImpl;
import com.dsunsoft.module.admin.dao.sys.SysRoleMapper;
import com.dsunsoft.module.admin.entity.sys.SysRole;
import com.dsunsoft.module.admin.entity.sys.SysRoleMenu;
import com.dsunsoft.module.admin.service.sys.SysRoleService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class SysRoleServiceImpl extends BaseServiceImpl<SysRoleMapper, SysRole, String> implements SysRoleService {

	@Autowired
	private SysRoleMapper sysRoleDao;

	
	public PageInfo<SysRole> findPageList(Integer pageIndex, Integer pageSize, Object entity) {
        PageHelper.startPage(pageIndex, pageSize);
        List<SysRole> list = sysRoleDao.findList(entity);
        if (list != null) {
            for (SysRole role : list) {
                List<String> listMenuId = sysRoleDao.selectMenuByRoleId(role.getRoleId());
                if (listMenuId != null) {
                    role.setMenuIdString(String.join(",", listMenuId));
                }
            }
        }
        return new PageInfo<SysRole>(list);
    }

	@Transactional(rollbackFor = Exception.class)
	public Boolean delete(SysRole sysRole) throws BizException {
		if (sysRole.getRoleId().equals(WebConstants.ROLE_SUPER_ADMIN)) {
			throw new BizException("超级管理员角色无法删除");
		}
		this.sysRoleDao.deleteById(sysRole.getRoleId());
		sysRoleDao.deleteRoleMenuByRoleId(sysRole.getRoleId());
		return true;
	}

	@Override
	@Transactional
	public Boolean roleMenu(SysRole sysRole) {
		// 先删除再新增
		sysRoleDao.deleteRoleMenuByRoleId(sysRole.getRoleId());
		for (String menuId : sysRole.getMenuIds()) {
			SysRoleMenu sysRoleMenu = new SysRoleMenu();
			sysRoleMenu.setId(UUID.randomUUID().toString());
			sysRoleMenu.setRoleId(sysRole.getRoleId());
			sysRoleMenu.setMenuId(menuId);
			sysRoleDao.insertRoleMenu(sysRoleMenu);
		}
		return true;
	}
}
