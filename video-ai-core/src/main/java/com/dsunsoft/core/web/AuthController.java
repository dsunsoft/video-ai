package com.dsunsoft.core.web;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dsunsoft.common.util.HttpClientUtils;
import com.dsunsoft.common.util.JsonUtils;
import com.dsunsoft.common.util.StringUtils;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 测试【开发环境可见】
 * 
 * @author ygm
 *
 */
@Api("auth")
@Profile("dev")
@RestController
@RequestMapping("/auth")
public class AuthController {

	@Value("${server.port}")
	private String port;

	@GetMapping(value = "/token/get")
	@ApiOperation(value = "获取授权码", notes = "获取授权码")
	public String get(String username, String password) throws Exception {
		if (StringUtils.isBlank(username) || StringUtils.isBlank(password)) {
			return "用户名或密码不能为空";
		}
		String url = String.format("http://localhost:%s/api/oauth/token", port);
		Map<String, String> header = new HashMap<>();
		header.put("Content-Type", HttpClientUtils.CONTENT_TYPE_FORM);
		header.put("Authorization", "Basic ZHN1bnNvZnQ6ZHN1bnNvZnQ=");
		Map<String, String> params = new HashMap<>();
		params.put("username", username);
		params.put("password", password);
		params.put("grant_type", "password");
		String token = "";
		String response = HttpClientUtils.doPostForUrl(url, header, params);
		if (StringUtils.contains(response, "access_token")) {
			Map<String, Object> map = JsonUtils.parseMap(response);
			if (map.containsKey("access_token")) {
				token = "Bearer " + map.get("access_token");
			}
		} else {
			token = response;
		}
		return token;
	}
}
