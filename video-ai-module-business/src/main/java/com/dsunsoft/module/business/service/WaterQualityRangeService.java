package com.dsunsoft.module.business.service;

import com.dsunsoft.core.service.BaseService;
import com.dsunsoft.module.business.dto.UpdateWarningCountDto;
import com.dsunsoft.module.business.entity.WaterQualityRange;

public interface WaterQualityRangeService extends BaseService<WaterQualityRange, String> {

     boolean updateWarningCount(UpdateWarningCountDto dto);

     Integer getWarningCount(WaterQualityRange waterQualityRange);

     Integer getWaterQualityRangeCount(WaterQualityRange waterQualityRange);

}