package com.dsunsoft.module.business.external;

import java.util.HashMap;

import com.alibaba.fastjson.JSONObject;

/**
 * 乐橙接口调用
 * @author zb
 * @date 创建时间：2019年12月18日 上午10:57:10
 */
public interface LechengManagService {

	/**
	 * 获取token
	 * @param paramMap
	 * @return
	 */
    JSONObject accessToken(HashMap<String, Object> paramMap);
    
    /**
     * 分页获取乐橙app分享给管理员的设备列表
     * @param paramMap
     * @return
     */
    JSONObject deviceList(HashMap<String, Object> paramMap);
    
    /**
     * 分页获取乐橙app分享给管理员的设备列表
     * @param paramMap
     * @return
     */
    JSONObject shareDeviceList(HashMap<String, Object> paramMap);
    /**
     * 分页获取直播列表
     * @param paramMap
     * @return
     */
    JSONObject liveList(HashMap<String, Object> paramMap);

}
