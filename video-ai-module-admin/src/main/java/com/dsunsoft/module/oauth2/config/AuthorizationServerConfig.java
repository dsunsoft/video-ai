package com.dsunsoft.module.oauth2.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.builders.InMemoryClientDetailsServiceBuilder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.error.WebResponseExceptionTranslator;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.security.oauth2.provider.token.TokenEnhancerChain;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;

import com.dsunsoft.module.oauth2.filter.CorsFilter;

@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

	@Autowired
	private OAuth2Config oAuth2Properties;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private TokenStore tokenStore;

	@Autowired(required = false)
	private JwtAccessTokenConverter jwtAccessTokenConverter;

	@Autowired(required = false)
	private TokenEnhancer jwtTokenEnhancer;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private WebResponseExceptionTranslator customizeWebResponseExceptionTranslator;

	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
		endpoints.tokenStore(tokenStore).authenticationManager(authenticationManager)
				.accessTokenConverter(jwtAccessTokenConverter);
		// 扩展token返回结果
		if (jwtAccessTokenConverter != null && jwtTokenEnhancer != null) {
			TokenEnhancerChain tokenEnhancerChain = new TokenEnhancerChain();
			List<TokenEnhancer> enhancerList = new ArrayList<TokenEnhancer>();
			enhancerList.add(jwtTokenEnhancer);
			enhancerList.add(jwtAccessTokenConverter);
			tokenEnhancerChain.setTokenEnhancers(enhancerList);
			// jwt
			endpoints.tokenEnhancer(tokenEnhancerChain);
		}
		endpoints.exceptionTranslator(customizeWebResponseExceptionTranslator);
	}

	/**
	 * 配置客户端一些信息
	 *
	 * @param clients
	 * @throws Exception
	 */
	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		InMemoryClientDetailsServiceBuilder build = clients.inMemory();
		build.withClient(oAuth2Properties.getClientId())
				.secret(passwordEncoder.encode(oAuth2Properties.getClientSecret()))
				.accessTokenValiditySeconds(oAuth2Properties.getExpiresIn())
				.refreshTokenValiditySeconds(60 * 60 * 24 * 15)
				.authorizedGrantTypes("refresh_token", "password", "authorization_code")// OAuth2支持的验证模式
				.scopes("all");
	}

	// @Override
	// public void configure(AuthorizationServerSecurityConfigurer oauthServer) {
	// //允许表单认证
	// oauthServer.allowFormAuthenticationForClients();
	// oauthServer.passwordEncoder(passwordEncoder);
	// }

	/**
	 * springSecurity 授权表达式，
	 * 
	 * @param security
	 * @throws Exception
	 */
	@Override
	public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
		security.tokenKeyAccess("permitAll()");
		security.checkTokenAccess("isAuthenticated()").addTokenEndpointAuthenticationFilter(new CorsFilter());
		//security.authenticationEntryPoint(new AuthExceptionEntryPoint());
	}

}