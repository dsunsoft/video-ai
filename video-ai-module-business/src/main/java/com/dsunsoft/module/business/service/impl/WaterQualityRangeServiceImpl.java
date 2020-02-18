package com.dsunsoft.module.business.service.impl;

import com.dsunsoft.core.service.BaseServiceImpl;
import com.dsunsoft.module.business.dao.WaterQualityRangeMapper;
import com.dsunsoft.module.business.dto.UpdateWarningCountDto;
import com.dsunsoft.module.business.entity.WaterQualityRange;
import com.dsunsoft.module.business.service.WaterQualityRangeService;
import org.springframework.stereotype.Service;

@Service
public class WaterQualityRangeServiceImpl extends BaseServiceImpl<WaterQualityRangeMapper, WaterQualityRange, String> implements WaterQualityRangeService {

    @Override
    public boolean updateWarningCount(UpdateWarningCountDto dto) {
        return mapper.updateWarningCount(dto) > 0;
    }

    @Override
    public Integer getWaterQualityRangeCount(WaterQualityRange waterQualityRange) {
        return mapper.getWaterQualityRangeCount(waterQualityRange);
    }

    @Override
    public Integer getWarningCount(WaterQualityRange waterQualityRange) {
        return mapper.getWarningCount(waterQualityRange);
    }
}