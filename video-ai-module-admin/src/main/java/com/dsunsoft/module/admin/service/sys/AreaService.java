package com.dsunsoft.module.admin.service.sys;

import java.util.List;

import com.dsunsoft.common.entity.ng.NgCascader;
import com.dsunsoft.common.entity.ng.NgSelect;
import com.dsunsoft.core.entity.NzTree;
import com.dsunsoft.core.entity.Tree;
import com.dsunsoft.core.service.BaseService;
import com.dsunsoft.module.admin.dto.AreaSearchDto;
import com.dsunsoft.module.admin.entity.sys.Area;
import com.dsunsoft.module.admin.entity.sys.AreaTree;

public interface AreaService extends BaseService<Area, String> {
	
	List<NgCascader> getCascaderList();

	List<Tree> selectTree(Area sysMenu);

	List<AreaTree> selectListTree(Area sysMenu);

	List<NzTree> selectNzTree(Area sysMenu);

	List<NgSelect> getProvinceList();

	List<NgSelect> getData(AreaSearchDto dto);
}
