package com.dsunsoft.module.business.dao;

import java.util.List;

import com.dsunsoft.core.dao.BaseMapper;
import com.dsunsoft.module.business.dto.WaterQualitySearchDto;
import com.dsunsoft.module.business.entity.WaterQuality;

public interface WaterQualityMapper extends BaseMapper<WaterQuality, String>{

	List<WaterQuality> getLastDataList(WaterQualitySearchDto dto);
	
}
