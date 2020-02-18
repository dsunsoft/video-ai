package com.dsunsoft.module.business.service;

import java.util.List;

import com.dsunsoft.core.service.BaseService;
import com.dsunsoft.module.business.dto.WaterQualitySearchDto;
import com.dsunsoft.module.business.entity.WaterQuality;

public interface WaterQualityService extends BaseService<WaterQuality, String> {

	List<WaterQuality> getLastDataList(WaterQualitySearchDto dto);
	
}
