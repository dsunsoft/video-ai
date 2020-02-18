package com.dsunsoft.module.oauth2.entity;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * CustomizeUserDetal
 * 
 * @author ygm
 *
 */
public class CustomizeUserDetal implements UserDetails {
	private static final long serialVersionUID = 5704717515404066500L;
	private String userId;
	private String userName;
	private String password;
	private Boolean isEnabled;
	private Boolean isLocked;
	private String officeId;
	private List<GrantedAuthority> grantedAuthorityList;

	public CustomizeUserDetal() {

	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Boolean getIsEnabled() {
		return isEnabled;
	}

	public void setIsEnabled(Boolean isEnabled) {
		this.isEnabled = isEnabled;
	}

	public Boolean getIsLocked() {
		return isLocked;
	}

	public void setIsLocked(Boolean isLocked) {
		this.isLocked = isLocked;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<GrantedAuthority> getGrantedAuthorityList() {
		return grantedAuthorityList;
	}

	public void setGrantedAuthorityList(List<GrantedAuthority> grantedAuthorityList) {
		this.grantedAuthorityList = grantedAuthorityList;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return this.grantedAuthorityList;
	}

	@Override
	public String getPassword() {
		return this.password;
	}

	@Override
	public String getUsername() {
		return this.userId;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return this.isLocked;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return this.isEnabled;
	}

	public String getOfficeId() {
		return officeId;
	}

	public void setOfficeId(String officeId) {
		this.officeId = officeId;
	}

}
