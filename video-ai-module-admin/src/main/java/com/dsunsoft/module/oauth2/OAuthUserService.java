package com.dsunsoft.module.oauth2;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.dsunsoft.common.constant.WebConstants;
import com.dsunsoft.module.admin.entity.sys.SysRole;
import com.dsunsoft.module.admin.entity.sys.SysUser;
import com.dsunsoft.module.admin.service.sys.SysUserService;
import com.dsunsoft.module.oauth2.entity.CustomizeUserDetal;

@Component("userDetailsService")
public class OAuthUserService implements UserDetailsService {
	@Autowired
	private SysUserService sysUserService;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		SysUser sysUser = sysUserService.getByName(username);
		if (null == sysUser) {
			return null;
		}
		List<SysRole> roleList = sysUserService.getRoleByUserId(sysUser.getId());
		List<GrantedAuthority> grantedAuthorityList = new ArrayList<>();
		for (SysRole role : roleList) {
			grantedAuthorityList.add(new SimpleGrantedAuthority(role.getRoleCode()));
		}
		CustomizeUserDetal userDetal = new CustomizeUserDetal();
		// 与jeeplus保持一致,存userid
		userDetal.setUserId(sysUser.getId());
		userDetal.setUserName(sysUser.getId());
		userDetal.setPassword(sysUser.getPassword());
		userDetal.setGrantedAuthorityList(grantedAuthorityList);
		// 是否可登录 1 可以 0 不能
		if (WebConstants.NO_STR.equals(sysUser.getLoginFlag())) {
			userDetal.setIsEnabled(true);
		} else {
			userDetal.setIsEnabled(false);
		}
		return userDetal;
	}

}
