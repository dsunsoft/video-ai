package com.dsunsoft.module.business.util;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.RequestEntity;
import org.apache.commons.httpclient.methods.StringRequestEntity;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.apache.commons.httpclient.protocol.Protocol;
import org.apache.commons.httpclient.protocol.ProtocolSocketFactory;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.dsunsoft.core.config.LechangeConfig;

/**
 * 乐橙云接口调用
 * @author zb
 * @date 创建时间：2019年12月18日 上午10:46:36
 */
public class HttpSend {
	
	private static Logger log = LoggerFactory.getLogger(HttpSend.class);

    public static JSONObject execute(Map<String, Object> paramsMap, String method, LechangeConfig lechangeConfig) {
        Map<String, Object> map = paramsInit(paramsMap, lechangeConfig);
        JSONObject jsonObj = doPost(lechangeConfig.getHost() + ":" + lechangeConfig.getPort() + "/openapi/" + method, map);
        return jsonObj;

    }

    public static JSONObject doPost(String url, Map<String, Object> map) {
        String json = JSON.toJSONString(map);
        ProtocolSocketFactory factory = new MySecureProtocolSocketFactory();
        Protocol.registerProtocol("https", new Protocol("https", factory, 443));
        HttpClient client = new HttpClient();
        client.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET, "UTF-8");
        PostMethod method = new PostMethod(url);
        log.info(url);
        JSONObject jsonObject = new JSONObject();
        try {
            RequestEntity entity = new StringRequestEntity(json, "application/json", "UTF-8");
            method.setRequestEntity(entity);
            client.executeMethod(method);

            InputStream inputStream = method.getResponseBodyAsStream();
            String result = IOUtils.toString(inputStream, "UTF-8");
            jsonObject = JSONObject.parseObject(result);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            method.releaseConnection();
        }
        return jsonObject;
    }

    protected static Map<String, Object> paramsInit(Map<String, Object> paramsMap, LechangeConfig lechangeConfig) {
        long time = System.currentTimeMillis() / 1000;
        String nonce = UUID.randomUUID().toString();
        String id = UUID.randomUUID().toString();

        StringBuilder paramString = new StringBuilder();
        paramString.append("time:").append(time).append(",");
        paramString.append("nonce:").append(nonce).append(",");
        paramString.append("appSecret:").append(lechangeConfig.getAppSecret());

        String sign = "";
        // 计算MD5得值
        try {
            log.info("传入参数：" + paramString.toString().trim());
            sign = DigestUtils.md5Hex(paramString.toString().trim().getBytes("UTF-8"));
        } catch (Exception e) {
            e.printStackTrace();
        }

        Map<String, Object> systemMap = new HashMap<String, Object>();
        systemMap.put("ver", "1.0");
        systemMap.put("sign", sign);
        systemMap.put("appId", lechangeConfig.getAppId());
        systemMap.put("nonce", nonce);
        systemMap.put("time", time);

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("system", systemMap);
        map.put("params", paramsMap);
        map.put("id", id);
        return map;
    }

}
