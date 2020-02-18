package com.dsunsoft.module.admin.service.sys;

import java.util.List;

import com.dsunsoft.core.entity.NzTree;
import com.dsunsoft.core.entity.Tree;
import com.dsunsoft.core.service.BaseService;
import com.dsunsoft.module.admin.entity.sys.Office;
import com.dsunsoft.module.admin.entity.sys.OfficeTree;

public interface OfficeService extends BaseService<Office, String> {
	
    List<Tree> selectTree(Office sysMenu);
    
    List<OfficeTree> selectListTree(Office sysMenu);
    
    List<NzTree> selectNzTree(Office sysMenu);  
}

