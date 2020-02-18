package com.dsunsoft.module.admin.dao.sys;

import java.util.List;

import com.dsunsoft.core.dao.BaseMapper;
import com.dsunsoft.module.admin.entity.sys.DictSelectValue;
import com.dsunsoft.module.admin.entity.sys.DictValue;

/**
 * 数据字典MAPPER接口
 * @author zd
 */

public interface DictValueMapper extends BaseMapper<DictValue, String> {
    
    List<DictSelectValue> getDictValues(DictSelectValue dictSelectValue);
    
    int delete(DictValue dictValue);
	
}