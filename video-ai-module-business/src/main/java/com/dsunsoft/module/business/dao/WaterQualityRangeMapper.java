package com.dsunsoft.module.business.dao;

import com.dsunsoft.core.dao.BaseMapper;
import com.dsunsoft.module.business.dto.UpdateWarningCountDto;
import com.dsunsoft.module.business.entity.WaterQualityRange;

public interface WaterQualityRangeMapper extends BaseMapper<WaterQualityRange, String>{

    int updateWarningCount(UpdateWarningCountDto dto);

    Integer getWarningCount(WaterQualityRange waterQualityRange);

    Integer getWaterQualityRangeCount(WaterQualityRange waterQualityRange);

}