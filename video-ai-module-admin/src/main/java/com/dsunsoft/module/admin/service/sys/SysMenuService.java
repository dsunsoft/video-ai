package com.dsunsoft.module.admin.service.sys;

import java.util.List;

import com.dsunsoft.core.entity.NzTree;
import com.dsunsoft.core.entity.Tree;
import com.dsunsoft.core.service.BaseService;
import com.dsunsoft.module.admin.entity.sys.SysMenu;
import com.dsunsoft.module.admin.entity.sys.SysMenuTree; 

public interface SysMenuService extends BaseService<SysMenu,String> {

	List<SysMenuTree> selectListTree(SysMenu sysMenu);
	
	List<Tree> selectTree(SysMenu sysMenu);  
	
	List<NzTree> selectNzTree(SysMenu sysMenu);  
	
}
