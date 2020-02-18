package com.dsunsoft.module.business.external.impl;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.dsunsoft.core.config.LechangeConfig;
import com.dsunsoft.module.business.external.LechengManagService;
import com.dsunsoft.module.business.util.HttpSend;

@Service
public class LechengManagServiceImpl implements LechengManagService {
	
	@Autowired
	private LechangeConfig lechangeConfig;

    @Override
    public JSONObject accessToken(HashMap<String, Object> paramMap) {
        return HttpSend.execute(paramMap, "accessToken",lechangeConfig);
    }

	@Override
	public JSONObject shareDeviceList(HashMap<String, Object> paramMap) {
		return HttpSend.execute(paramMap,"shareDeviceList",lechangeConfig);
	}

	@Override
	public JSONObject deviceList(HashMap<String, Object> paramMap) {
		 return HttpSend.execute(paramMap,"deviceList",lechangeConfig);
	}

	@Override
	public JSONObject liveList(HashMap<String, Object> paramMap) {
		return HttpSend.execute(paramMap,"liveList",lechangeConfig);
	}

}
