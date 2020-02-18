package com.dsunsoft.module.oauth2;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.oauth2.common.exceptions.InvalidGrantException;
import org.springframework.stereotype.Component;

import com.dsunsoft.common.util.DigestUtils;
import com.dsunsoft.module.oauth2.config.OAuth2Config;
import com.dsunsoft.module.oauth2.entity.CustomizeUserDetal;

@Component
public class CustomizeLoginAuthProvider implements AuthenticationProvider {
	@Autowired
	private UserDetailsService userDetailsService;

	@Autowired
	private OAuth2Config oAuth2Config;

	@Override
	public Authentication authenticate(Authentication authentication) {
		String username = authentication.getName();
		String password = (String) authentication.getCredentials();
		CustomizeUserDetal userDetails = (CustomizeUserDetal) userDetailsService.loadUserByUsername(username);
		if (userDetails == null) {
			throw new InvalidGrantException("用户名不存在");
		}
		if (userDetails.getIsEnabled()) {
			throw new InvalidGrantException("该账号已禁止登录");
		}

		//加密密码 验证用户河长制单点登录用户
		boolean enableEncryption = true;//使用加密
		if(username != null && username.equals("hzz-video-ai")){
			enableEncryption = false;
		}
		// 是否启用加密，根据加密方式加密后对比
		if (oAuth2Config.getEnableEncryption() && enableEncryption) {
			boolean bl = DigestUtils.validatePassword(password, userDetails.getPassword());
			if (!bl) {
				throw new InvalidGrantException("密码错误");
			}
		} else {
			if (!password.equals(userDetails.getPassword())) {
				throw new InvalidGrantException("密码错误");
			}
		}

		Collection<? extends GrantedAuthority> authorities = userDetails.getAuthorities();

		return new UsernamePasswordAuthenticationToken(userDetails, password, authorities);
	}

	@Override
	public boolean supports(Class<?> aClass) {
		return UsernamePasswordAuthenticationToken.class.equals(aClass);
	}
}
