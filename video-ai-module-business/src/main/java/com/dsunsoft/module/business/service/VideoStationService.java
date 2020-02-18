package com.dsunsoft.module.business.service;

import com.dsunsoft.core.service.BaseService;
import com.dsunsoft.module.business.entity.VideoStation;

public interface VideoStationService extends BaseService<VideoStation, String> {

    Integer getVideoStationCount(VideoStation videoStation);

}
