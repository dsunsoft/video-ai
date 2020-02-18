package com.dsunsoft.module.business.external;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.dsunsoft.common.util.IdWorker;
import com.dsunsoft.module.business.dto.JobJson;
import com.dsunsoft.module.business.dto.StreamJson;
import com.dsunsoft.module.business.dto.VideoStationJsonDto;
import com.dsunsoft.module.business.dto.VideoStationSearchDto;
import com.dsunsoft.module.business.entity.VideoAccessToken;
import com.dsunsoft.module.business.entity.VideoStation;
import com.dsunsoft.module.business.service.VideoAccessTokenService;
import com.dsunsoft.module.business.service.VideoStationService;


/**
 * @author zb
 * 视屏直播地址同步接口调用
 */
@Component
public class VideoStationInterface {
	private static Logger log = LoggerFactory.getLogger(VideoStationInterface.class); 
	
	private static final int PAGE_SIZE = 100;
	
	@Autowired
	private VideoStationService videoStationService;
	
	@Autowired
	private VideoAccessTokenService videoAccessTokenService;
	
	@Autowired
	private LechengManagService lechengManagService;
	
	
	/**
	 * 每天调用这个方法进行数据同步
	 */
	public void syncData(){
		//1、获取accessToken
		log.info("1、获取乐橙云accessToken信息......");
		String accessToken = getAccessToken();
		List<VideoStation> videoStationAllList = new ArrayList<>();
		// 通过accessToken获取乐橙云直播信息列表
		Integer pageStart = 0;
		JSONObject liveAddressListJSON = new JSONObject();
		List<VideoStation> videoStationList = null;
		do {
			liveAddressListJSON =  getLiveAddressList(accessToken,pageStart,PAGE_SIZE);
			videoStationList = parseArrayList(liveAddressListJSON);
			if(videoStationList != null && videoStationList.size() > 0){
				videoStationAllList.addAll(videoStationList);
			}
			else{
				videoStationList = new ArrayList<>();
			}
			pageStart++;
		}while(videoStationList.size() == PAGE_SIZE);
		// 将数据保存到数据库
		log.info("2、开始保存......");
		saveData(videoStationAllList);
	}
	
	private void saveData(List<VideoStation> videoStationAllList) {
		// 获取数据库所有的数据
		List<VideoStation> findList = videoStationService.findList(new VideoStationSearchDto());
		for (VideoStation videoStation : videoStationAllList) {
			List<VideoStation> filterList = findList.stream().filter(item->
			item.getDeviceId().equals(videoStation.getDeviceId())
			&& item.getChannelId().equals(videoStation.getChannelId()))
			.collect(Collectors.toList());
			if(filterList != null && filterList.size()>0) {
				videoStation.setId(filterList.get(0).getId());
				videoStationService.update(videoStation);
			}
			else {
				videoStationService.insert(videoStation);
			}
		}
	}

	private List<VideoStation> parseArrayList(JSONObject jsonData) {
		List<VideoStation> videoStationList = new ArrayList<>();
		Object livesJson = jsonData.get("lives");
		if(livesJson != null){
			List<VideoStationJsonDto>  videoStationJsonList = JSON.parseArray(livesJson.toString(),VideoStationJsonDto.class);
		    if(videoStationJsonList != null && videoStationJsonList.size()>0) {
		    	for (VideoStationJsonDto videoStationJsonDto : videoStationJsonList) {
		    		VideoStation videoStation = new VideoStation();
		    		videoStation.setId(IdWorker.getUuid());
		    		videoStation.setCreateDate(new Date());
		    		videoStation.setCreateBy("1");
		    		videoStation.setDeviceId(videoStationJsonDto.getDeviceId());
		    		videoStation.setChannelId(videoStationJsonDto.getChannelId());
		    		videoStation.setLiveMode(videoStationJsonDto.getLiveMode());
		    		videoStation.setLiveStatus(videoStationJsonDto.getLiveStatus());
		    		videoStation.setLiveType(videoStationJsonDto.getLiveType());
		    		videoStation.setLiveToken(videoStationJsonDto.getLiveToken());
		    		videoStation.setCoverUpdate(videoStationJsonDto.getCoverUpdate());
		    		List<StreamJson> streams = videoStationJsonDto.getStreams();
		    		List<JobJson> job = videoStationJsonDto.getJob();
		    		if(streams != null && streams.size()>0) {
		    			videoStation.setHls(streams.get(0).getHls());
		    			videoStation.setCoverUrl(streams.get(0).getCoverUrl());
		    			videoStation.setStreamId(streams.get(0).getStreamId());
		    		}
		    		if(job != null && job.size()>0) {
	                    videoStation.setStatus(job.get(0).getStatus().toString());
		    		    videoStation.setPeriod(job.get(0).getPeriod());
		    		}
		    		videoStationList.add(videoStation);
				}
		    }
		}
		return videoStationList;
	}

	
	/**
	 * 获取直播列表
	 * @param accessToken
	 * @return
	 */
	public JSONObject getLiveAddressList(String accessToken,Integer pageStart,Integer pageSize){
		HashMap<String, Object> paramsMap = new HashMap<String, Object>();
        paramsMap.put("token", accessToken);
        String queryRange = ((pageStart *  pageSize) + 1) + "-" + ((pageStart + 1)* pageSize);
        paramsMap.put("queryRange", queryRange);
        JSONObject json = lechengManagService.liveList(paramsMap);
        JSONObject jsonResult = json.getJSONObject("result");
        JSONObject jsonData = jsonResult.getJSONObject("data");
        String code = jsonResult.get("code").toString();
        return "0".equals(code)?jsonData:new JSONObject();
	}
	
	
	
	/**
	 * 获取accessToken
	 * @return
	 */
	public String getAccessToken(){
		String accessToken = "";
		// 获取一条 accessToken（数据库只有一条）
		VideoAccessToken videoAccess = videoAccessTokenService.getOne();
		// 不存在 从乐橙云获取
		if(videoAccess == null){
			HashMap<String, Object> paramsMap = new HashMap<String, Object>();
	        JSONObject json = lechengManagService.accessToken(paramsMap);
	        JSONObject jsonResult = json.getJSONObject("result");
	        JSONObject jsonData = jsonResult.getJSONObject("data");
	        String expireTime = jsonData.getString("expireTime");
	        accessToken = jsonData.getString("accessToken");//At_f67da1182032463fb20a65687c88cc7d
			VideoAccessToken  videoAccessToken = new VideoAccessToken();
			videoAccessToken.setId(IdWorker.getUuid());
			videoAccessToken.setAccessToken(accessToken);
			videoAccessToken.setExpireTime(Long.valueOf(expireTime));
			videoAccessToken.setCreateDate(new Date());
			videoAccessToken.setCreateBy("1");
			// 获取accessToken保存到数据库
		    videoAccessTokenService.insert(videoAccessToken);
		}
		else{
			//数据库存在判断有没有过期
			if((videoAccess.getCreateDate().getTime() + videoAccess.getExpireTime()*1000 > new Date().getTime())){
				accessToken = videoAccess.getAccessToken();
			}
			else{
				//重新获取
				HashMap<String, Object> paramsMap = new HashMap<String, Object>();
		        JSONObject json = lechengManagService.accessToken(paramsMap);
		        JSONObject jsonResult = json.getJSONObject("result");
		        JSONObject jsonData = jsonResult.getJSONObject("data");
		        String expireTime = jsonData.getString("expireTime");
		        accessToken = jsonData.getString("accessToken");//At_f67da1182032463fb20a65687c88cc7d
				VideoAccessToken  videoAccessToken = new VideoAccessToken();
				videoAccessToken.setId(videoAccess.getId());
				videoAccessToken.setAccessToken(accessToken);
				videoAccessToken.setExpireTime(Long.valueOf(expireTime));
				videoAccessToken.setCreateDate(new Date());
				videoAccessToken.setCreateBy("1");
				videoAccessToken.setUpdateDate(new Date());
				videoAccessToken.setUpdateBy("1");
				// 获取accessToken保存更新到数据库
			    videoAccessTokenService.update(videoAccessToken);
			}
		}
		return accessToken;
	}
	
}
