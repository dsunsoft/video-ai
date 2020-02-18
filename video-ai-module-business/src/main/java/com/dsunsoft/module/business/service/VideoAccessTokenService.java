package com.dsunsoft.module.business.service;

import com.dsunsoft.core.service.BaseService;
import com.dsunsoft.module.business.entity.VideoAccessToken;

public interface VideoAccessTokenService extends BaseService<VideoAccessToken, String> {

	public VideoAccessToken getOne();
}
