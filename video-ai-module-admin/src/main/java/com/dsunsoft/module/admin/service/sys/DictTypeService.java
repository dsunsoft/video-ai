package com.dsunsoft.module.admin.service.sys;

import com.dsunsoft.core.service.BaseService;
import com.dsunsoft.module.admin.dto.DictTypeDto;
import com.dsunsoft.module.admin.entity.sys.DictType;

public interface DictTypeService extends BaseService<DictType, String> {
	
	void save(DictTypeDto dictTypeDto ) throws Exception;
	
	void delete(DictType dictType) throws Exception;

}
