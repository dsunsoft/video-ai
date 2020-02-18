package com.dsunsoft.module.business.service.impl;

import org.springframework.stereotype.Service;

import com.dsunsoft.core.service.BaseServiceImpl;
import com.dsunsoft.module.business.dao.VideoAccessTokenMapper;
import com.dsunsoft.module.business.entity.VideoAccessToken;
import com.dsunsoft.module.business.service.VideoAccessTokenService;

@Service
public class VideoAccessTokenServiceImpl extends BaseServiceImpl<VideoAccessTokenMapper, VideoAccessToken, String> implements VideoAccessTokenService {

	@Override
	public VideoAccessToken getOne(){
		return mapper.getOne();
	}

}
