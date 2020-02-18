package com.dsunsoft.module.admin.service.sys;

import java.util.List;

import com.dsunsoft.core.service.BaseService;
import com.dsunsoft.module.admin.dto.DictValueDto;
import com.dsunsoft.module.admin.entity.sys.DictSelectValue;
import com.dsunsoft.module.admin.entity.sys.DictValue;

public interface DictValueService extends BaseService<DictValue, String> {

	void delete(DictValue dictValue);

	void deleteByLogic(DictValue dictValue) throws Exception;

	void save(DictValueDto dictValueDto) throws Exception;

	List<DictSelectValue> getDictValues(DictSelectValue dictSelectValue);

}
