package com.dsunsoft.module.business.service.impl;

import org.springframework.stereotype.Service;

import com.dsunsoft.core.service.BaseServiceImpl;
import com.dsunsoft.module.business.dao.VideoStationMapper;
import com.dsunsoft.module.business.entity.VideoStation;
import com.dsunsoft.module.business.service.VideoStationService;

@Service
public class VideoStationServiceImpl extends BaseServiceImpl<VideoStationMapper, VideoStation, String> implements VideoStationService {

    @Override
    public Integer getVideoStationCount(VideoStation videoStation) {
        return mapper.getVideoStationCount(videoStation);
    }
}
