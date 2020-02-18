package com.dsunsoft.module.business.dao;

import com.dsunsoft.core.dao.BaseMapper;
import com.dsunsoft.module.business.entity.VideoStation;

public interface VideoStationMapper extends BaseMapper<VideoStation, String>{

    Integer getVideoStationCount(VideoStation videoStation);

}
