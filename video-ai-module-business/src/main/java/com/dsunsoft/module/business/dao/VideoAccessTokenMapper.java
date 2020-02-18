package com.dsunsoft.module.business.dao;

import com.dsunsoft.core.dao.BaseMapper;
import com.dsunsoft.module.business.entity.VideoAccessToken;

public interface VideoAccessTokenMapper extends BaseMapper<VideoAccessToken, String>{

	VideoAccessToken getOne();
	
}
