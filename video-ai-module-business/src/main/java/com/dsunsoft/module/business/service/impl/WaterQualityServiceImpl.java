package com.dsunsoft.module.business.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dsunsoft.core.service.BaseServiceImpl;
import com.dsunsoft.module.business.dao.WaterQualityMapper;
import com.dsunsoft.module.business.dto.WaterQualitySearchDto;
import com.dsunsoft.module.business.entity.WaterQuality;
import com.dsunsoft.module.business.service.WaterQualityService;

@Service
public class WaterQualityServiceImpl extends BaseServiceImpl<WaterQualityMapper, WaterQuality, String> implements WaterQualityService {

	@Override
	public List<WaterQuality> getLastDataList(WaterQualitySearchDto dto) {
		return mapper.getLastDataList(dto);
	}

}
